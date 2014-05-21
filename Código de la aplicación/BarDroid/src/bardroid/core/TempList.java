package bardroid.core;

import in.MainActivity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.ArrayAdapter;
import data.Producto;
public class TempList extends ArrayList<Producto>{
	
	private int id_lista;
	public JSONObject objetojson;
	private ArrayAdapter<Producto> parrad;
	/**
	 * 
	 */
	
	public TempList(int[] prods){
		
		ArrayList<Producto> prodsmesa = new ArrayList<Producto>();
		
		for(int i = 0; i<prods.length; i++){
			
			for(Producto pro : MainActivity.res.getProdlist()){
				
				if(pro.getId()==prods[i]){
					
					prodsmesa.add(pro);
				}
				
				
			}
			
		}
		
	}
	
	
	TempList(int id, ArrayAdapter<Producto> adap){
		
		this.id_lista = id;
		//anadir los productos del adapter
		int i=0;
		
		objetojson = new JSONObject();
		JSONArray jurl = new JSONArray();
		
		for(i=0;i<adap.getCount();i++){
			this.add((Producto) adap.getItem(i));
			try {
				
				JSONObject val = new JSONObject();
				val.put("idmesa", String.valueOf(this.id_lista));
				val.put("idproducto", String.valueOf(((Producto)adap.getItem(i)).getId()));
				jurl.put(val);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//Aqui hay que rellenar el json
			
			try {
				objetojson.put("clave", jurl);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
	}
	
	
	
	

}
