package config;
import in.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;

import com.Legio;

import data.AddProd;
import data.DelProd;
import data.ModProd;
import data.Producto;
import data.VerProd;

public class Config4Alone  extends Activity implements OnClickListener {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_4_prod);
		
		
		Button view = (Button)findViewById(R.id.button5);
		view.setOnClickListener(this);
		Button add = (Button)findViewById(R.id.Button02);
		add.setOnClickListener(this);
		Button mod = (Button)findViewById(R.id.button4);
		mod.setOnClickListener(this);
		Button del = (Button)findViewById(R.id.Button05);
		del.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
			case R.id.Button02:
				Intent a = new Intent(this, AddProd.class);
				startActivity(a);
				break;
			case R.id.button5:
				Intent w = new Intent(this, VerProd.class);
				startActivity(w);
				break;
			case R.id.button4:
				Intent m = new Intent(this, ModProd.class);
				startActivity(m);
				break;
			case R.id.Button05:
				Intent d = new Intent(this, DelProd.class);
				startActivity(d);
				break;
	
		
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menuresume, menu);
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.sisi:
	    	//Enviar el array de productos a Legio
	    	Legio legiopro = new Legio();
	    	Object[] par = new Object[3];
	    	par[0]="update_prods";
	    	par[1]=Cons.idbar;
	    	JSONObject containerprods = new JSONObject();
	    	JSONArray arpro = new JSONArray();

	    	for(Producto paco : MainActivity.res.getProdlist()){
	    		paco.setID_bar(Cons.idbar);
	    		try {
	    	    	JSONObject prodmap = new JSONObject();

					prodmap.put("idproducto", paco.getId());
					prodmap.put("nombre", paco.getNombreProd());
					prodmap.put("precio", paco.getPrecioProd());
					prodmap.put("idcat", paco.getCatego());
					prodmap.put("idbar", paco.getID_bar());
					arpro.put(prodmap);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    		
	    		try {
					containerprods.put("productos", arpro);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	
	    	par[2]= containerprods.toString();
	    	legiopro.execute(par);
	    	finish();
			break;
			
	    case R.id.nono:
	    	finish();
	    	break;
	    }
		return false;
	
	    }

	

}