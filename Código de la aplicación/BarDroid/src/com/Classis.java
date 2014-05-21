package com;

import in.Init_admin;
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
import android.util.Log;
import android.widget.Toast;
import bardroid.core.Caja;
import bardroid.core.TempList;
import data.Categoria;
import data.Producto;

public class Classis extends AsyncTask<Object, Void, String> {
	
	//Clase que se dedica a la comunicacion con el servidor en tanto a cambios 
	//en la configuracion del bar, sus productos  o categorias
	
	
	static boolean flag_resumen = false;
	static boolean flag_update_sala = false;
	static boolean flag_update_caja = false;
	static boolean flag_get_caja = false;
	static boolean flag_sala = false;

	ArrayList<HashMap<String, String>> productsList = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> categoList = new ArrayList<HashMap<String, String>>();
	String jsonResult;
	ProgressDialog progress;
	InputStream is;
	StringBuilder answer;
	Producto p;
	Categoria c;
	static boolean flag_configurate;
	public static String fechaini = "";
	public static String fechafin = "";
	static String fecha ="";

	@Override
	protected String doInBackground(Object... params) {
		// TODO Auto-generated method stub
		try {
			String url="";
		    
		    List <NameValuePair> parameters = new ArrayList <NameValuePair>();  
		    
		    
		    
		     if((String)params[0]=="resumen"){
		    	  	 flag_resumen = true;
		    		 flag_update_sala = false;
		    		 flag_update_caja = false;
		    		 flag_get_caja = false;
		    		 flag_sala = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=resumen";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("fechas", (String)params[2]));
		    	
		    	
		    }
		    
		    else if((String)params[0]=="update_sala"){
		    	 flag_resumen = false;
	    		 flag_update_sala = true;
	    		 flag_update_caja = false;
	    		 flag_get_caja = false;
	    		 flag_sala = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=update";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("idmesa", Integer.toString((Integer) params[2])));
		    	parameters.add(new BasicNameValuePair("mesas", params[3].toString()));
		    	
		    }
		    
		    
		    else if((String)params[0]=="update_caja"){
		    	 flag_resumen = false;
	    		 flag_update_sala = false;
	    		 flag_update_caja = true;
	    		 flag_get_caja = false;
	    		 flag_sala = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=ticket";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	parameters.add(new BasicNameValuePair("idmesa", Integer.toString((Integer) params[2])));
		    }
		    else if((String)params[0]=="get_caja"){
		    	 flag_resumen = false;
	    		 flag_update_sala = false;
	    		 flag_update_caja = false;
		    	flag_get_caja = true;
		    	flag_sala = false;
		    	url="http://bardroid.tuars.com/operational.php?opt=get_caja";
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("id", Integer.toString(i)));
		    	fecha = (String)params[2];
		    	parameters.add(new BasicNameValuePair("fecha", fecha));
		    }
		    
		    else if((String)params[0]=="get_sala"){
		    	 flag_resumen = false;
	    		 flag_update_sala = false;
	    		 flag_update_caja = false;
		    	flag_get_caja = false;
		    	flag_sala = true;
		    	url="http://bardroid.tuars.com/operational.php?opt=sala";
		    	
		    	int i = (Integer)params[1];
		    	parameters.add(new BasicNameValuePair("idbar", Integer.toString(i)));
		    	
		    }
		     
		    
		    
		    
		    UrlEncodedFormEntity sendentity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
		    
		    try{
		    HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(sendentity);
	        
		    HttpResponse response = new DefaultHttpClient().execute(httpPost);
		    
		    
		    if(response!=null){
				
				if(flag_sala){
					try {
						HttpEntity entity = response.getEntity();
					    is = entity.getContent();
					     answer = inputStreamToString(is);

					    Log.e("aqui entra ", answer.toString());
					    
					    JSONObject json = new JSONObject(answer.toString());
			            int k = json.getInt("success");
			            if(k==1){
			            	MainActivity.estado = new HashMap<String, TempList>();
						    JSONArray jArraySala = json.getJSONArray("sala");
					    	int[] prods = new int[100];

						    String anterior=(jArraySala.getJSONObject(0)).getString("idmesa");
						    for(int l=0; l<jArraySala.length();l++){
						    
						    	JSONObject linea = jArraySala.getJSONObject(l);
						    	String ahora =linea.getString("idmesa");
						    	while(ahora.equals(anterior)){
						    		int m = Integer.valueOf(linea.getString("idprod"));
						    		prods[l]=m;
						    	} 
						    	TempList tempus = new TempList(prods);
						    	MainActivity.estado.put(anterior, tempus);
			            	anterior = linea.getString("idmesa");
						    }
			            }


				 
					}catch (ParseException e) {
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
				
				if(flag_resumen){
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
				
				if(flag_update_sala){
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
			
				
				
			if(flag_update_caja){
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
			
			if(flag_get_caja){
				try {
					HttpEntity entity = response.getEntity();
				    is = entity.getContent();
				     answer = inputStreamToString(is);
				     
				    
				    JSONObject json = new JSONObject(answer.toString());
				    double valor = json.getDouble("total");
				    Caja.history.put(fecha, valor);
				    Log.e("para la fecha "+fecha, " el total es "+valor);
			 
				}catch (ParseException e) {
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
	


	

