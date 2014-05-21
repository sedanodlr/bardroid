package com;

import in.Init_admin;
import in.Join;
import in.Login;
import in.MainActivity;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import config.Configuration;
import config.Cons;
import data.BO;
import data.Categoria;
import data.Producto;
import data.Respuesta;


public class Turmae extends AsyncTask<Object, Void, String> {
	static boolean flag_create = false;
	static boolean flag_login = false;
	static boolean flag_join = false;
	static boolean flag_delete = false;

	ArrayList<HashMap<String, String>> productsList = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> categoList = new ArrayList<HashMap<String, String>>();
	String jsonResult;
	ProgressDialog progress;
	InputStream is;
	StringBuilder answer;
	Producto p;
	Categoria c;



	@Override
	protected String doInBackground(Object... params) {
		// TODO Auto-generated method stub
		try {

			String url="";
		     
		    List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
		    
		    
		    if((String)params[0]=="create"){
		    	flag_create = true;
		    	flag_login=false;
		    	flag_delete=false;
		    	flag_join = false;
		    url="http://bardroid.tuars.com/operational.php?opt=create";
		    parameters.add(new BasicNameValuePair("nombre", ((BO)params[1]).getNombre()));  
		    parameters.add(new BasicNameValuePair("mail", ((BO)params[1]).getMail()));
		    parameters.add(new BasicNameValuePair("pass", ((BO)params[1]).getPass()));
		   
		    }
		    else if((String)params[0]=="login"){
		    	flag_create=false;
		    	flag_login=true;
		    	flag_delete=false;
		    	flag_join = false;

			    url="http://bardroid.tuars.com/operational.php?opt=log_ad";
			    parameters.add(new BasicNameValuePair("mail", ((BO)params[1]).getMail()));
			    parameters.add(new BasicNameValuePair("pass", ((BO)params[1]).getPass()));
			   
		    
		    }
		    else if((String)params[0]=="join"){
		    	flag_login=false;
		    	flag_create=false;
		    	flag_delete =false;
		    	flag_join = true;
		    	url="http://bardroid.tuars.com/operational.php?opt=log_us";
		    	parameters.add(new BasicNameValuePair("nombre", ((BO)params[1]).getNombre()));  
			    parameters.add(new BasicNameValuePair("pass", ((BO)params[1]).getPass()));
		    }
		    
		    else if((String)params[0]=="delete"){
		    	flag_login=false;
		    	flag_create=false;
		    	flag_delete =true;
		    	flag_join = false;

		    	url="http://bardroid.tuars.com/operational.php?opt=del";
		    	int i = ((BO)params[1]).getID();
		    	parameters.add(new BasicNameValuePair("id", Integer.toString(i)));
		    }
		    
		   
		    
		    UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
		    
		    try{
		    HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(sendentity);
	        
		    HttpResponse response = new DefaultHttpClient().execute(httpPost);
		    
		    
		    if(response!=null){
				
				if(flag_delete){
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);
				}
				
				if(flag_create){
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
			
				
				
			if(flag_login){
				try {

					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				    String answer1 = inputStreamToString(is).toString();
				    
				    
				    JSONObject json = new JSONObject(answer1);
		            int k = json.getInt("success");
		            if(k==1){
		            	Login.correcto=true;
		            }
		            Cons.idbar=json.getInt("idbar");
		            Cons.config = json.getBoolean("es_config");
		            if(Cons.config){
			            Configuration c = new Configuration(true);

		            	JSONObject yasuo = json.getJSONObject("config");
			            c.ID_bar=yasuo.getInt("idbar");
			            if(yasuo.getString("barra").equalsIgnoreCase("arriba")){
			            	c.arriba=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("abajo")){
			            	c.abajo=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("izquierda")){
			            	c.izquierda=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("derecha")){
			            	c.derecha=true;
			            }
			            c.mes0=yasuo.getInt("mes0");
			            c.mes1=yasuo.getInt("mes1");
			            c.mes2=yasuo.getInt("mes2");
			            c.mes3=yasuo.getInt("mes3");
			            c.mes4=yasuo.getInt("mes4");
			            c.mes5=yasuo.getInt("mes5");
			            c.mes6=yasuo.getInt("mes6");
			            c.mes7=yasuo.getInt("mes7");
			            c.mes8=yasuo.getInt("mes8");
			            c.mes9=yasuo.getInt("mes9");
			            c.mes10=yasuo.getInt("mes10");
			            c.mes11=yasuo.getInt("mes11");
			            c.mes12=yasuo.getInt("mes12");
			            c.mes13=yasuo.getInt("mes13");
			            c.mes14=yasuo.getInt("mes14");
			            c.mes15=yasuo.getInt("mes15");
			            c.mes16=yasuo.getInt("mes16");
			            c.mes17=yasuo.getInt("mes17");
			            c.mes18=yasuo.getInt("mes18");
			            c.mes19=yasuo.getInt("mes19");
			            c.mes20=yasuo.getInt("mes20");
			            c.mes21=yasuo.getInt("mes21");
			            c.mes22=yasuo.getInt("mes22");
			            c.mes23=yasuo.getInt("mes23");
			            c.mes24=yasuo.getInt("mes24");
			            c.admin = true;
			            
			            c.setConfigToLocale(c);
		            }
				    JSONArray jArraycat = json.getJSONArray("cats");
				    JSONArray jArrayprod = json.getJSONArray("prods");
				    ArrayList<Categoria> catsparsed= new ArrayList<Categoria>();
				    ArrayList<Producto> prodsparsed = new ArrayList<Producto>();
				    
				    for(int i=0;i<jArraycat.length();i++){
				    	Categoria ca = new Categoria();
				    	JSONObject e = jArraycat.getJSONObject(i);
				    	
				    	ca.setIdcat(e.getInt("idcat"));
				    	ca.setNombre(e.getString("nombre"));
				    	ca.setIdcat(e.getInt("idbar"));
				    	
				    	catsparsed.add(ca);
				    	
				    }
				    for(int i=0;i<jArrayprod.length();i++){
				    	Producto pr = new Producto();
				    	JSONObject eh = jArrayprod.getJSONObject(i);
				    	
				    	pr.setId(eh.getInt("idproducto"));
				    	pr.setNombreProd(eh.getString("nombre"));
				    	pr.setPrecioProd(eh.getDouble("precio"));
				    	pr.setCatego(eh.getInt("idcat"));
				    	pr.setID_bar(eh.getInt("idbar"));
				    	
				    	prodsparsed.add(pr);
				    	
				    }
					Respuesta respuesta = new Respuesta();

					respuesta.setCatlist(catsparsed);
					respuesta.setProdlist(prodsparsed);
					
					MainActivity.k.admin=true;
					MainActivity.res = new Respuesta();
					MainActivity.res.setCatlist(catsparsed);
					MainActivity.res.setProdlist(prodsparsed);
						
					
				} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//					
					
			}
			if(flag_join){
				
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				    String answer1 = inputStreamToString(is).toString();
				    
				    
				    JSONObject json = new JSONObject(answer1);
		            int k = json.getInt("success");
		            if(k==1){
		            	Join.joincorrecto=true;
		            }
		            Cons.idbar=json.getInt("idbar");
		            
		            Configuration c = new Configuration(true);
		             
		            JSONArray yao = json.getJSONArray("config");
		            
		            for(int u = 0; u<yao.length(); u++){
		            
		            	JSONObject yasuo = yao.getJSONObject(u);
		            
		            
		            	c.mes0=yasuo.getInt("mes0");
			            c.mes1=yasuo.getInt("mes1");
			            c.mes2=yasuo.getInt("mes2");
			            c.mes3=yasuo.getInt("mes3");
			            c.mes4=yasuo.getInt("mes4");
			            c.mes5=yasuo.getInt("mes5");
			            c.mes6=yasuo.getInt("mes6");
			            c.mes7=yasuo.getInt("mes7");
			            c.mes8=yasuo.getInt("mes8");
			            c.mes9=yasuo.getInt("mes9");
			            c.mes10=yasuo.getInt("mes10");
			            c.mes11=yasuo.getInt("mes11");
			            c.mes12=yasuo.getInt("mes12");
			            c.mes13=yasuo.getInt("mes13");
			            c.mes14=yasuo.getInt("mes14");
			            c.mes15=yasuo.getInt("mes15");
			            c.mes16=yasuo.getInt("mes16");
			            c.mes17=yasuo.getInt("mes17");
			            c.mes18=yasuo.getInt("mes18");
			            c.mes19=yasuo.getInt("mes19");
			            c.mes20=yasuo.getInt("mes20");
			            c.mes21=yasuo.getInt("mes21");
			            c.mes22=yasuo.getInt("mes22");
			            c.mes23=yasuo.getInt("mes23");
			            c.mes24=yasuo.getInt("mes24");
			            c.admin = false;
		            
		            c.ID_bar=yasuo.getInt("idbar");
			            if(yasuo.getString("barra").equalsIgnoreCase("arriba")){
			            	c.arriba=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("abajo")){
			            	c.abajo=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("izquierda")){
			            	c.izquierda=true;
			            } else if(yasuo.getString("barra").equalsIgnoreCase("derecha")){
			            	c.derecha=true;
			            }
			            c.setConfigToLocale(c);
			            
		            }
		            
				
		            MainActivity.k= new Configuration(false);
		            
				    JSONArray jArraycat = json.getJSONArray("cats");
				    JSONArray jArrayprod = json.getJSONArray("prods");
				    ArrayList<Categoria> catsparsed= new ArrayList<Categoria>();
				    ArrayList<Producto> prodsparsed = new ArrayList<Producto>();
				    
				    for(int i=0;i<jArraycat.length();i++){
				    	Categoria ca = new Categoria();
				    	JSONObject e = jArraycat.getJSONObject(i);
				    	
				    	ca.setIdcat(e.getInt("idcat"));
				    	ca.setNombre(e.getString("nombre"));
				    	ca.setIdcat(e.getInt("idbar"));
				    	
				    	catsparsed.add(ca);
				    	
				    }
				    for(int i=0;i<jArrayprod.length();i++){
				    	Producto pr = new Producto();
				    	JSONObject eh = jArrayprod.getJSONObject(i);
				    	
				    	pr.setId(eh.getInt("idproducto"));
				    	pr.setNombreProd(eh.getString("nombre"));
				    	pr.setPrecioProd(eh.getDouble("precio"));
				    	pr.setCatego(eh.getInt("idcat"));
				    	pr.setID_bar(eh.getInt("idbar"));
				    	
				    	prodsparsed.add(pr);
				    	
				    }
					Respuesta respuesta = new Respuesta();

					respuesta.setCatlist(catsparsed);
					respuesta.setProdlist(prodsparsed);
					
					MainActivity.k = c;
					MainActivity.k.admin = false;
					MainActivity.k.setConfigToLocale(c);
					MainActivity.res = new Respuesta();
					MainActivity.res.setCatlist(catsparsed);
					MainActivity.res.setProdlist(prodsparsed);
						
					
				} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
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
	


	

