<?php



$host="mysql.tuars.com"; //localhost

$username="u468445736_root"; //root 
$password="clavebardroid"; // "" 
$db_name="u468445736_bard"; //bardroid
 
  
// Opción crear cuenta
//Must be admin
if($_GET['opt']=="create"){
	$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
	mysql_select_db("$db_name")or die("cannot select DB");
	
	
	if(!empty($_POST)){
		$no = $_POST['nombre'];
		$ma = $_POST['mail'];
		$pa = $_POST['pass'];
			$sql = 'INSERT INTO bares (nombre, mail, pass, es_config) VALUES ("'.$no.'", "'.$ma.'", "'.$pa.'", 0)';
							echo $sql;
			$result = mysql_query($sql);
			$idbar = mysql_insert_id();
			$sqlcon = 'INSERT INTO config (idbar) VALUES ('.$idbar.')';
			mysql_query($sqlcon);
			$json = array();
			if(!$result) {
			$json['success']=0;
			$json['message']="SQL error";
			header('Content-type: application/json');
			echo json_encode($json);
			}
			else{
				$json['success']=1;
				$json['idbar']= $idbar;
				mysql_close($con);
				header('Content-type: application/json');
				echo json_encode($json);
			}
	} else die("ERROR POST VACIO");
}

//Opción eliminar cuenta
//Must be admin
if($_GET['opt']=="del"){
	$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
	mysql_select_db("$db_name")or die("cannot select DB");
	
	if(!empty($_POST)){
		
			$json = array();
			$id = $_POST['id'];
			$sql = 'DELETE FROM bares WHERE idbar='.$id.'';
			$result= mysql_query($sql);
			$sql2 = 'DELETE FROM caja WHERE idbar='.$id.'';
			$result2= mysql_query($sql2);
			$sql3 = 'DELETE FROM categorias WHERE idbar='.$id.'';
			$result3= mysql_query($sql3);
			$sql4 = 'DELETE FROM config WHERE idbar='.$id.'';
			$result4= mysql_query($sql4);
			$sql5 = 'DELETE FROM productos WHERE idbar='.$id.'';
			$result5= mysql_query($sql5);
			$sql6 = 'DELETE FROM sala WHERE idbar='.$id.'';
			$result6= mysql_query($sql6);
			
			
			if(!$result) die("ERROR INFERNAL SQL" . mysql_error());
				else{
					$json['result']=$result;
					$json['result2']=$result2;
					$json['result3']=$result3;
					$json['result4']=$result4;
					$json['result5']=$result5;
					$json['result6']=$result6;
					mysql_close($con);
					header('Content-type: application/json');
					die(json_encode($json));
				}
		}else die("ERROR POST VACIO");
}


// Opción login 
//Must be admin
if($_GET['opt']=="log_ad"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
 
 
	if(!empty($_POST)){ 
		$ma = $_POST['mail'];
		$pa = $_POST['pass'];

		
		$sql1 = 'SELECT idbar FROM bares WHERE mail="'.$ma.'" AND pass="'.$pa.'"';
		$result1= mysql_query($sql1);
		
		
		
		
		if($result1==false){
		header('Content-type: application/json');
                    $json['success']=0;
					$json['message']="No existe el bar";
					header('Content-type: application/json');
					die(json_encode($json));
		}else{ //El bar existe
		
		$idbar = mysql_result($result1, 0);
		$sqlcheckfirst = 'SELECT es_config FROM bares WHERE idbar='.$idbar.'';
		$resultfirst = mysql_query($sqlcheckfirst);
		$variable = mysql_result($resultfirst, 0);
		if($variable==0){
		$first=true;
		$r = false;
		}else {
		$first = false;
		$r = true;
		}
		
			if(!$first){ //Si no es la primera vez que iniciamos sesion, esto es, existe una config
				
				//Obtain config
				
				$sqlconfig = 'SELECT * FROM config WHERE idbar='.$idbar.'';
				$resultconfig= mysql_query($sqlconfig) or die ("ERROR" . mysql_error());
				
				while($rowk= mysql_fetch_array($resultconfig)){
					$config = array();
					$config['idbar']=$rowk['idbar'];
					$config['barra']=$rowk['barra'];
					$config['mes0']=$rowk['mes0'];
					$config['mes1']=$rowk['mes1'];
					$config['mes2']=$rowk['mes2'];
					$config['mes3']=$rowk['mes3'];
					$config['mes4']=$rowk['mes4'];
					$config['mes5']=$rowk['mes5'];
					$config['mes6']=$rowk['mes6'];
					$config['mes7']=$rowk['mes7'];
					$config['mes8']=$rowk['mes8'];
					$config['mes9']=$rowk['mes9'];
					$config['mes10']=$rowk['mes10'];
					$config['mes11']=$rowk['mes11'];
					$config['mes12']=$rowk['mes12'];
					$config['mes13']=$rowk['mes13'];
					$config['mes14']=$rowk['mes14'];
					$config['mes15']=$rowk['mes15'];
					$config['mes16']=$rowk['mes16'];
					$config['mes17']=$rowk['mes17'];
					$config['mes18']=$rowk['mes18'];
					$config['mes19']=$rowk['mes19'];
					$config['mes20']=$rowk['mes20'];
					$config['mes21']=$rowk['mes21'];
					$config['mes22']=$rowk['mes22'];
					$config['mes23']=$rowk['mes23'];
					$config['mes24']=$rowk['mes24'];
				}
				$json['config']=$config;
				
			
				//Obtain prods
				$sqlprod='SELECT * FROM productos WHERE idbar='.$idbar.'';
				$resultprod=mysql_query($sqlprod) or die ("ERROR" . mysql_error());
				$json['prods']=array();
				
				while ($row2 = mysql_fetch_array($resultprod)){
					$prod =array();
					$prod['idproducto']=$row2['idproducto'];
					$prod['nombre']=$row2['nombre'];
					$prod['precio']=$row2['precio'];
					$prod['idcat']=$row2['idcat'];
					$prod['idbar']=$row2['idbar'];
					
					array_push($json['prods'], $prod);
						
				}
				
				//Obtain cats
				$sqlcat='SELECT * FROM categorias WHERE idbar='.$idbar.'';
					$resultcat=mysql_query($sqlcat) or die ("Error ".mysql_error());
					$json['cats']=array();
				while ($row = mysql_fetch_assoc($resultcat)) {
					$cat = array();
					$cat['idcat']=$row['idcat'];
					$cat['nombre']=$row['nombre'];
					$cat['idbar']=$row['idbar'];
					
					array_push($json['cats'], $cat);
				}
				
				header('Content-type: application/json');
				$json['success']=1;
				$json['idbar'] = $idbar;
				$json['es_config'] = $r;
				echo json_encode($json);
				
				mysql_close($con);
			}else if($first){ //Si es la primera vez que iniciamos, obtenemos productos y categorias por defecto
				//DO COSAS
					
					//Obtener categorías predefinidas
					$sqlcat='SELECT * FROM categorias WHERE idbar=-1';
					$resultcat=mysql_query($sqlcat) or die ("Error ".mysql_error());
					$json['cats']=array();
				while ($row = mysql_fetch_assoc($resultcat)) {
					$cat = array();
					$cat['idcat']=$row['idcat'];
					$cat['nombre']=$row['nombre'];
					$cat['idbar']=$row['idbar'];
					
					array_push($json['cats'], $cat);
				}
				
				
					
					//Obtener productos predefinidos
				
				$sqlprod='SELECT * FROM productos WHERE idbar=-1';
				$resultprod=mysql_query($sqlprod) or die ("ERROR" . mysql_error());
				$json['prods']=array();
				
				while ($row2 = mysql_fetch_array($resultprod)){
					$prod =array();
					$prod['idproducto']=$row2['idproducto'];
					$prod['nombre']=$row2['nombre'];
					$prod['precio']=$row2['precio'];
					$prod['idcat']=$row2['idcat'];
					$prod['idbar']=$row2['idbar'];
					
					array_push($json['prods'], $prod);
						
				}
				header('Content-type: application/json');
				$json['success']=1;
				$json['idbar'] = $idbar;
				$json['es_config'] = $r;
				echo json_encode($json);

				}
		}
		
	} else die ("ERROR post VACIO");		
}		



// Opción login
if($_GET['opt']=="log_us"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
 
	
 
	if(!empty($_POST)){ 
		$no = $_POST['nombre'];
		$pa = $_POST['pass'];

		
		$sql1 = 'SELECT idbar FROM bares WHERE nombre="'.$no.'" AND pass="'.$pa.'"';
		$result1= mysql_query($sql1);
		
		
		
		
		if($result1==false){
		header('Content-type: application/json');
                    $json['success']=0;
					$json['message']="No existe el bar";
					header('Content-type: application/json');
					mysql_close($con);
					die(json_encode($json));
		}else{
		 //El bar existe
		
		$idbar = mysql_result($result1, 0);
		
		
				//Obtain config
				
				$sqlconfig = 'SELECT * FROM config WHERE idbar='.$idbar.'';
				$resultconfig= mysql_query($sqlconfig) or die ("ERROR" . mysql_error());
				$json['config']=array();
				while($rowk= mysql_fetch_array($resultconfig)){
					$config = array();
					$config['idbar']=$rowk['idbar'];
					$config['barra']=$rowk['barra'];
					$config['mes0']=$rowk['mes0'];
					$config['mes1']=$rowk['mes1'];
					$config['mes2']=$rowk['mes2'];
					$config['mes3']=$rowk['mes3'];
					$config['mes4']=$rowk['mes4'];
					$config['mes5']=$rowk['mes5'];
					$config['mes6']=$rowk['mes6'];
					$config['mes7']=$rowk['mes7'];
					$config['mes8']=$rowk['mes8'];
					$config['mes9']=$rowk['mes9'];
					$config['mes10']=$rowk['mes10'];
					$config['mes11']=$rowk['mes11'];
					$config['mes12']=$rowk['mes12'];
					$config['mes13']=$rowk['mes13'];
					$config['mes14']=$rowk['mes14'];
					$config['mes15']=$rowk['mes15'];
					$config['mes16']=$rowk['mes16'];
					$config['mes17']=$rowk['mes17'];
					$config['mes18']=$rowk['mes18'];
					$config['mes19']=$rowk['mes19'];
					$config['mes20']=$rowk['mes20'];
					$config['mes21']=$rowk['mes21'];
					$config['mes22']=$rowk['mes22'];
					$config['mes23']=$rowk['mes23'];
					$config['mes24']=$rowk['mes24'];
					array_push($json['config'], $config);
				}
				
				
				
			
				//Obtain prods
				$sqlprod='SELECT * FROM productos WHERE idbar='.$idbar.'';
				$resultprod=mysql_query($sqlprod) or die ("ERROR" . mysql_error());
				$json['prods']=array();
				
				while ($row2 = mysql_fetch_array($resultprod)){
					$prod =array();
					$prod['idproducto']=$row2['idproducto'];
					$prod['nombre']=$row2['nombre'];
					$prod['precio']=$row2['precio'];
					$prod['idcat']=$row2['idcat'];
					$prod['idbar']=$row2['idbar'];
					
					array_push($json['prods'], $prod);
						
				}
				
				//Obtain cats
				$sqlcat='SELECT * FROM categorias WHERE idbar='.$idbar.'';
					$resultcat=mysql_query($sqlcat) or die ("Error ".mysql_error());
					$json['cats']=array();
				while ($row = mysql_fetch_assoc($resultcat)) {
					$cat = array();
					$cat['idcat']=$row['idcat'];
					$cat['nombre']=$row['nombre'];
					$cat['idbar']=$row['idbar'];
					
					array_push($json['cats'], $cat);
				}
				
				header('Content-type: application/json');
				$json['success']=1;
				$json['idbar'] = $idbar;
				$json['es_config'] = true;
				echo json_encode($json);
				
				mysql_close($con);

}
}
}




// Opción update productos
//Must be admin
if($_GET['opt']=="upd_pro"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
$productos = array();
$productos = json_decode($_POST['productos'], true);
//La información viene en JSON en el post
$producto = array();
$producto = $productos['productos'];
$idbar = $_POST['id'];
$consulta = 'select * from productos where idbar="'.$idbar.'"';
$resultado = mysql_query($consulta);
if (mysql_num_rows($resultado)>0){
mysql_query('DELETE FROM productos where idbar = "'.$idbar.'"');
}
for ($i=0; $i<count($producto);$i++){
	
	$resultado = array();
	$resultado=$producto[$i];
	mysql_query('INSERT INTO productos (nombre, precio, idcat, idbar) values ("'.$resultado['nombre'].'", "'.$resultado['precio'].'", "'.$resultado['idcat'].'", "'.$idbar.'")') or die (mysql_error());
}


//La información viene en JSON en el post

$json = array();
$json['message']="mensaje pro";
echo json_encode($json);
}

// Opción update categorias
//Must be admin
if($_GET['opt']=="upd_cat"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
$categorias = array();
$idbar = $_POST['id'];
$categorias = json_decode($_POST['categorias'], true);
//La información viene en JSON en el post
$categoria = array();
$categoria = $categorias['categorias'];
$consulta = 'select * from categorias where idbar="'.$idbar.'"';
$resultado = mysql_query($consulta);
if (mysql_num_rows($resultado)>0){
mysql_query('DELETE FROM categorias where idbar = "'.$idbar.'"');
}
for ($i=0; $i<count($categoria);$i++){
	$resultado = array();
	$resultado=$categoria[$i];
	mysql_query('INSERT INTO categorias (nombre, idbar) values ("'.$resultado['nombre'].'", "'.$resultado['idbar'].'")');
}

$json = array();
$json['message']="mensaje ca";
echo json_encode($json);

}

// Opción update distribución mesas
//Must be admin
if($_GET['opt']=="upd_mes"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
$mesas = array();
$idbar = $_POST['idbar'];
$mesas = json_decode($_POST['mesas'], true);
//La información viene en JSON en el post
mysql_query('UPDATE config SET mes0 = "'.$mesas['mes0'].'",
	mes1 = "'.$mesas['mes1'].'", mes2 = "'.$mesas['mes2'].'", mes3 = "'.$mesas['mes3'].'", mes4 = "'.$mesas['mes4'].'", 
	mes5 = "'.$mesas['mes5'].'", mes6 = "'.$mesas['mes6'].'", mes7 = "'.$mesas['mes7'].'", mes8 = "'.$mesas['mes8'].'", 
	mes9 = "'.$mesas['mes9'].'", mes10 = "'.$mesas['mes10'].'", mes11 = "'.$mesas['mes11'].'", mes12 = "'.$mesas['mes12'].'", 
	mes13 = "'.$mesas['mes13'].'", mes14 = "'.$mesas['mes14'].'", mes15 = "'.$mesas['mes15'].'", mes16 = "'.$mesas['mes16'].'", 
	mes17 = "'.$mesas['mes17'].'", mes18 = "'.$mesas['mes18'].'", mes19 = "'.$mesas['mes19'].'", mes20 = "'.$mesas['mes20'].'", 
	mes21 = "'.$mesas['mes21'].'", mes22 = "'.$mesas['mes22'].'", mes23 = "'.$mesas['mes23'].'", mes24 = "'.$mesas['mes24'].'" 
	WHERE idbar = "'.$idbar.'"');



$json = array();
$json['message']="mensaje me";
echo json_encode($json);




}

// Opción update distribución barra
//Must be admin
if($_GET['opt']=="upd_bar"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$idbar = $_POST['idbar'];
$barras = $_POST['barra'];
$querybarra = 'UPDATE config SET barra ="'.$barras.'" WHERE idbar='.$idbar.'';
$upbar=mysql_query($querybarra) or die("Error ".mysql_error());
//Update config where idbar values barra
$json = array();
$json['message']="mensaje bar";
$json['success']=$upbar;
echo json_encode($json);

}

// Opción update estado sala
if($_GET['opt']=="update"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

//La información viene en JSON en el post

$idbar = $_POST['idbar'];
$idmesa = $_POST['idmesa'];
$mesas = array();
$mesas = json_decode($_POST['mesas'], true);
$mesa = array();
$mesa = $mesas['clave'];
mysql_query('Delete from sala where idmesa = "'.$idmesa.'" and idbar = "'.$idbar.'"');	

for ($i=0; $i<count($mesa);$i++){
	$productos = array();
	$productos=$mesa[$i];
	$idproducto = $productos['idproducto'];

	mysql_query('INSERT INTO sala (idbar, idmesa, idproducto) values ("'.$idbar.'", "'.$idmesa.'", "'.$idproducto.'")');
	
}
}
// Getsala

if ($_GET['opt'] == "sala"){

$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$idbar = $_POST['idbar'];
$result = mysql_query ('Select * from sala where idbar = "'.$idbar.'"');
$mesa = array();
$json['sala'] = array();
$json['success'] = 0;
while ($row = mysql_fetch_array($result)){
	$mesa['idmesa'] = $row['idmesa'];
	$mesa['idprod'] = $row['idproducto'];
	array_push($json['sala'], $mesa);
	$json['success']=1;
}
echo json_encode($json);


}



// Opción ticket
if($_GET['opt']=="ticket"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$idbar = $_POST['idbar'];
$idmesa = $_POST['idmesa'];

$result = mysql_query('select idsala, idproducto from sala where idbar = "'.$idbar.'" and idmesa = "'.$idmesa.'"');
while ($row = mysql_fetch_array($result)){
	mysql_query('INSERT into caja (idbar, idproducto, fecha) values ("'.$idbar.'", "'.$row['idproducto'].'", sysdate())');
	mysql_query('delete from sala where idsala = "'.$row['idsala'].'"');
}


}

if($_GET['opt']=="configurated"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
$idbar = $_POST['id'];
$es_config = $_POST['es_config'];

$sqlupdatestat = 'UPDATE bares SET es_config=true WHERE idbar="'.$idbar.'"';
$u = mysql_query($sqlupdatestat) or die(mysql_error());

//UPDATE EN TABLA BARES
$json = array();
$json['success'] = $u;
$json['message']="mensaje conf";
echo json_encode($json);

}


 //opcion get caja
 if($_GET['opt']=="get_caja"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");
$idbar = $_POST['id'];
$fecha = $_POST['fecha'];


$querysuma = 'SELECT SUM(p.precio) FROM productos p, caja c WHERE c.idbar="'.$idbar.'" AND c.idbar=p.idbar AND c.idproducto=p.idproducto AND c.fecha="'.$fecha.'"';
$resu = mysql_query($querysuma);

$totaldia = mysql_result($resu, 0);
$json = array();
$json['total']=$totaldia;
echo json_encode($json);
}

// Opción resumen 
if($_GET['opt']=="resumen"){
$con=mysql_connect("$host", "$username", "$password")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

$idbar = $_POST['idbar'];
$fechas = array();
$fechas = json_decode($_POST['fechas'], true);


$fecha_ini = $fechas['fechaini'];
$fecha_fin = $fechas['fechafin'];


$emailq = mysql_query('SELECT mail FROM bares WHERE idbar='.$idbar.'');
$email = mysql_result($emailq, 0);
echo $email;

require('class.email-query-results-as-csv-file.php');
$emailCSV = new
EmailQueryResultsAsCsv("$host","$db_name","$username","$password");
$emailCSV->setQuery('SELECT c.idbar, c.idproducto, p.nombre, fecha, precio FROM caja c, 
productos p WHERE c.idbar = "'.$idbar.'" and c.fecha between "'.$fecha_ini.'" and "'.$fecha_fin.'" group by c.idcaja');
$emailCSV->sendEmail("bardroide@gmail.com","$email","MySQL
Query Results as CSV Attachment");



$json['message']="mensaje resumen";
echo json_encode($json);

}
?> 	