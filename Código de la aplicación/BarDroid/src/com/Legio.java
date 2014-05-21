package com;

import in.Init_admin;
import in.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import data.Categoria;
import data.Producto;


public class Legio extends AsyncTask<Object, Void, String> {
	
	//Clase que se dedica a la comunicacion con el servidor en tanto a cambios 
	//en la configuracion del bar, sus productos  o categorias
	
	
	static boolean flag_update_mesas = false;
	static boolean flag_update_barra = false;
	static boolean flag_update_prods = false;
	static boolean flag_update_cats = false;
	

	ArrayList<HashMap<String, String>> productsList = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> categoList = new ArrayList<HashMap<String, String>>();
	String jsonResult;
	ProgressDialog progress;
	InputStream is;
	StringBuilder answer;
	Producto p;
	Categoria c;
	static boolean flag_configurate;



	@Override
	protected String doInBackground(Object... params) {
		// TODO Auto-generated method stub
		try {

			String url="";
		    
		    List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
		    
		    
		    
		     if((String)params[0]=="update_mesas"){
		    	//Cambiar Flags y url
		    	flag_update_mesas = true;
		    	flag_update_barra = false;
		    	flag_update_prods = false;
		    	flag_update_cats = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=upd_mes";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("mesas", (String)params[2]));
		    }
		    
		    else if((String)params[0]=="update_barra"){
		    	//Cambiar Flags y url
		    	flag_update_mesas = false;
		    	flag_update_barra = true;
		    	flag_update_prods = false;
		    	flag_update_cats = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=upd_bar";
		    	int i = (Integer)params[1];
		    	String barra = (String)params[2];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("barra", barra));
		    }
		    
		    
		    else if((String)params[0]=="update_prods"){
		    	//Cambiar Flags y url
		    	flag_update_mesas = false;
		    	flag_update_barra = false;
		    	flag_update_prods = true;
		    	flag_update_cats = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=upd_pro";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("id", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("productos", (String)params[2]));
		    	
		    	
		    }
		    
		    else if((String)params[0]=="update_cats"){
		    	//Cambiar Flags y url
		    	flag_update_mesas = false;
		    	flag_update_barra = false;
		    	flag_update_prods = false;
		    	flag_update_cats = true;
		    	url="http://bardroid.tuars.com/operational.php?opt=upd_cat";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("id", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("categorias", (String)params[2]));

		    }
		    
		    else if((String)params[0]=="configurated"){
		    	flag_update_mesas = false;
		    	flag_update_barra = false;
		    	flag_update_prods = false;
		    	flag_update_cats = false;
		    	flag_configurate = true;
		    	url="http://bardroid.tuars.com/operational.php?opt=configurated";
		    	int i = (Integer)params[1];
		    	boolean configurated = (Boolean)params[2];
		    	parameters.add(new BasicNameValuePair("id", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("es_config", Boolean.toString(configurated)));
		    }
		     
		    
		    
		    
		    UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
		    
		    try{
		    HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(sendentity);
	        
		    HttpResponse response = new DefaultHttpClient().execute(httpPost);
		    
		    
		    if(response!=null){
				
				
				
				if(flag_update_mesas){
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);


			 
				}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
				
				if(flag_update_barra){
					try {
						HttpEntity entity = response.getEntity();
					    is = entity.getContent();
					     answer = inputStreamToString(is);



				 
					}catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
						} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			
				
				
			if(flag_update_prods){
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);



			 
				}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					
			}
			if(flag_update_cats){
				
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);


				    

			 
				}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
			}
			
			if(flag_configurate){
				
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);

					    flag_configurate = false;
				    

			 
				}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
			}
			}else Toast.makeText(Init_admin.c, "ERROR", Toast.LENGTH_LONG).show();
			
		
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    } catch (ClientProtocolException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	private StringBuilder inputStreamToString(InputStream is) {
		   String rLine = "";
		   StringBuilder answer = new StringBuilder();
		   BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		 
		   try {
		    while ((rLine = rd.readLine()) != null) {
		     answer.append(rLine);
		    }
		   }
		 
		   catch (IOException e) {
		     e.printStackTrace();
		    
		   }
		   return answer;
		  }
	
	protected void onProgressUpdate(){
		progress  = new ProgressDialog(Login.c);
		progress.setTitle("Iniciando sesion");
		progress.setMessage("Por favor espere");
		progress.show();
	}
	
	
	protected void onPostExecute(HttpResponse response){
		progress.dismiss();
	}



	

		
		
		
		

}
	


	

