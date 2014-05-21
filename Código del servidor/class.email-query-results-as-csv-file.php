<?php
/*
Email MySQL Query Results as a CSV File Attachment
Author:  Stephen R. Owens  (www.Studio-Owens.com)
Version: 2.1.3 [December 11, 2013]

Sends an email with a CSV file attachment that contains the results of a MySQL query.
Copyright (C) 2009-2013 Stephen R. Owens

LICENSE:
This software is licensed under the GNU GPL version 3.0 or later.
http://www.gnu.org/licenses/gpl-3.0-standalone.html

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

class EmailQueryResultsAsCsv {

  // MySQL Server
  private $mySQL_server = '';

  // MySQL Database Name
  private $mySQL_database = '';

  // MySQL Username
  private $mySQL_user = '';

  // MySQL Password
  private $mySQL_password = '';

  // MySQL Query
  // something like "SELECT * FROM table_name"
  private $mySQL_query = '';

  // CSV File Name
  // filename for the attached file, use something like "mysql_results.csv"
  private $csv_file_name = '';
  
  // Multiple File Data array
  // File Name & reuseable elements + mySQL_query
  private $arr_file_data = array();
  
  // CSV file reuseable elements
  private $csv_contain = '';
  private $csv_separate = '';
  private $csv_end_row = '';

  // Email Message
  // This is an HTML formatted message
  private $email_html_msg = "<h1>MySQL Query Results as CSV Attachment</h1>
  <p>This attachment can be opened with OpenOffice.org Calc, Google Docs, or Microsoft Excel.</p>";
  
  // used to output success messages to the screen
  private $debugFlag = False;

  /* 
  -------------------------------------- 
  --------------------------------------
   FUNCTIONS NO NEED TO EDIT BELOW HERE
  -------------------------------------- 
  -------------------------------------- 
  */
  
  // constructor
  public function __construct($s, $d, $u, $p) {
    $this->setDBinfo($s, $d, $u, $p);
    $this->setCSVinfo();
    $this->setCSVname();
  }
  
  // destructor
  public function __destruct() {
    /*$this->mySQL_server = null;
    $this->mySQL_database = null;
    $this->mySQL_user = null;
    $this->mySQL_password = null;
    $this->mySQL_query = null;
    $this->csv_file_name = null;
    $this->csv_contain = null;
    $this->csv_separate = null;
    $this->csv_end_row = null;
    $this->email_html_msg = null;
    $this->debugFlag = null;
    $this->arr_file_data = array();*/
    unset($this->mySQL_server);
    unset($this->mySQL_database);
    unset($this->mySQL_user);
    unset($this->mySQL_password);
    unset($this->mySQL_query);
    unset($this->csv_file_name);
    unset($this->csv_contain);
    unset($this->csv_separate);
    unset($this->csv_end_row);
    unset($this->email_html_msg);
    unset($this->debugFlag);
    unset($this->arr_file_data);
  }
  
  public function setDBinfo($s, $d, $u, $p) {
    $this->mySQL_server = $s;
    $this->mySQL_database = $d;
    $this->mySQL_user = $u;
    $this->mySQL_password = $p;
  }
  
  public function setQuery($sql) {
    $this->mySQL_query = $sql;
  }
  
  public function setEmailMessage($msg) {
    $this->email_html_msg = $msg;
  }
  
  public function setCSVname($fn = "mysql_results.csv") {
    $this->csv_file_name = $fn;
  }
  
  public function setCSVinfo($c = '"', $s = ",", $er = "\n") {
    $this->csv_contain = $c;
    $this->csv_separate = $s;
    $this->csv_end_row = $er;
  }
  
  public function setMultiFile($fn, $sql) {
    $this->arr_file_data[] = array("csv_file_name" => $fn, 
      "mySQL_query" => $sql,
      "csv_contain" => $this->csv_contain,
      "csv_separate" => $this->csv_separate,
      "csv_end_row" => $this->csv_end_row);
  }
  
  public function debugMode($bool) {
    $this->debugFlag = $bool;
  }
  
  public function sendEmail($email_from, $email_to, $email_subject) {
    // check to see if the array for file info and queries has data if not add the single file data
    if(!isset($this->arr_file_data[0]["csv_file_name"])) {
      $this->arr_file_data[0] = array("csv_file_name" => $this->csv_file_name, 
        "mySQL_query" => $this->mySQL_query,
        "csv_contain" => $this->csv_contain,
        "csv_separate" => $this->csv_separate,
        "csv_end_row" => $this->csv_end_row);
    }
    /*
    -------------------------------------- 
        CONNECT TO MYSQL DATABASE
    */
    $link = mysql_connect($this->mySQL_server, $this->mySQL_user, $this->mySQL_password);
    if (!$link) {
      die('ERROR: Could not connect to MySQL server: ' . mysql_error());
    }
    if ($this->debugFlag) {
      echo "Step 1: Connected to MySQL server successfully. \n\n";
    }

    // use a specific database on the server
    $db_selected = mysql_select_db($this->mySQL_database, $link);
    if (!$db_selected) {
      die ("ERROR: Cannot use the selected database: " . $mySQL_database . " \n MySQL error: " . mysql_error());
    }
    if ($this->debugFlag) {
      echo "Step 2: MySQL database successfully selected. \n\n";
    }
    
    /*
    -------------------------------------- 
        SEND EMAIL WITH ATTACHMENT
        Below you will notice I'm using complex variable parsing {curly braces surrounding variable}
          For more information see: "PHP: Complex Variables in Strings" at Tinsology.net
          http://tinsology.net/2009/06/php-complex-variables-in-strings/
    */

    // start setting up the email header
    $headers = "From: ".$email_from;

    // create boundary string
    // boundary string must be unique using MD5 to generate a pseudo random hash
    $random_hash = md5(date('r', time())); 
    $mime_boundary = "==Multipart_Boundary_x{$random_hash}x";

    // set email header as a multipart/mixed message
    // this allows the sending of an attachment combined with the HTML message
    $headers .= "\nMIME-Version: 1.0\n" .
    "Content-Type: multipart/mixed;\n" .
    " boundary=\"{$mime_boundary}\"";

    // multipart boundary for the HTML message
    $email_message = "This is a multi-part message in MIME format.\n\n" .
    "--{$mime_boundary}\n" .
    "Content-Type:text/html; charset=\"UTF-8\"\n" .
    "Content-Transfer-Encoding: 7bit\n\n" .
    $this->email_html_msg . "\n\n";
    
    // count how many files were created
    $files_attached_cnt = 0;
    // mime_loop is used to apply the proper mime_boundary as needed
    $mime_loop = 0;
    foreach ($this->arr_file_data AS $file) {
      
      if ($this->debugFlag) {
        // print the file attachment array
        //print_r($file);
      }
      
      // build the CSV file
      $csv_file = $this->buildCSV($file);
      
      if ($csv_file != "") {
        $files_attached_cnt += 1;
      
        // encode CSV file with MIME base64
        // required for sending it as an email attachment
        $data = chunk_split(base64_encode($csv_file)); 
        
        // multipart boundary for the email attachment
        $email_message .= "--{$mime_boundary}\n";
        
        // attach the file
        $email_message .= "Content-Type: application/octet-stream;\n" .
        " name=\"{$file["csv_file_name"]}\"\n" .
        "Content-Disposition: attachment;\n" .
        " filename=\"{$file["csv_file_name"]}\"\n" .
        "Content-Transfer-Encoding: base64\n\n" .
        $data . "\n\n";
      }
    }
    // end the multipart message with this mime boundry, notice the ending --
    $email_message .= "--{$mime_boundary}--\n";
    
    if ($files_attached_cnt > 0) {
      // try to send the email and verify the results
      $sendit = @mail($email_to, $email_subject, $email_message, $headers);
      if(!$sendit) {
        die("ERROR: The Email could not be sent.");
      }
      if ($this->debugFlag) {
        echo "Step 5: Email sent with attachment. \n\n";
      }
    } else {
      if ($this->debugFlag) {
        echo "Step 5: No data found for query. Email NOT sent. \n\n";
      }
    }

    // close the link to the MySQL database
    mysql_close($link);
    
    // reset the attachment array so the object can be used anew
    $this->arr_file_data = array();

    if ($this->debugFlag) {
      echo "FINISHED.";
    }
  }
  
  private function buildCSV($file) {
    // container to hold the CSV file as it's built
    $csv_file = "";
    
    // run the MySQL query and check to see if results were returned
    $result = mysql_query($file["mySQL_query"]);
    if (!$result) {
      die("ERROR: Invalid query \n MySQL error: " . mysql_error() . "\n Your query: " . $this->mySQL_query);
    }
    
    // only return a non blank data set with query returns at least one record
    $num_of_rows = mysql_num_rows($result);
    if ($num_of_rows > 0) {
      if ($this->debugFlag) {
        echo "Step 3 (repeats for each attachment): MySQL query ran successfully. \n\n";
      }

      // store the number of columns from the results
      $columns = mysql_num_fields($result);

      // Build a header row using the mysql field names
      $header_row = '';
      for ($i = 0; $i < $columns; $i++) {
        $column_title = $file["csv_contain"] . stripslashes(mysql_field_name($result, $i)) . $file["csv_contain"];
        $column_title .= ($i < $columns-1) ? $file["csv_separate"] : '';
        $header_row .= $column_title;
      }
      $csv_file .= $header_row . $file["csv_end_row"]; // add header row to CSV file

      // Build the data rows by walking through the results array one row at a time
      $data_rows = '';
      while ($row = mysql_fetch_array($result)) {
        for ($i = 0; $i < $columns; $i++) {
          // clean up the data; strip slashes; replace double quotes with two single quotes
          $data_rows .= $file["csv_contain"] . preg_replace('/'.$file["csv_contain"].'/', $file["csv_contain"].$file["csv_contain"], stripslashes($row[$i])) . $file["csv_contain"];
          $data_rows .= ($i < $columns-1) ? $file["csv_separate"] : '';
        }
        $data_rows .= $this->csv_end_row; // add data row to CSV file
      }
      $csv_file .= $data_rows; // add the data rows to CSV file
      
      if ($this->debugFlag) {
        echo "Step 4 (repeats for each attachment): CSV file built. \n\n";
      }
    }  else {
       echo "Step 3 (repeats for each attachment): MySQL query ran successfully \n\n";
       echo "Step 4 (repeats for each attachment): NO results were returned for this query. No file will be sent for the following query: \n " . $this->mySQL_query ." \n\n";
    }
    
    // Return the completed file
    return $csv_file;
  }
}
?>