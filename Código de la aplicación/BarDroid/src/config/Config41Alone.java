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

import data.AddCat;
import data.Categoria;
import data.DelCat;
import data.ModCat;
import data.VerCat;

public class Config41Alone  extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_4_cat);
		
		
		
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
				Intent a = new Intent(this, AddCat.class);
				startActivity(a);
				break;
			case R.id.button5:
				Intent w = new Intent(this, VerCat.class);
				startActivity(w);
				break;
			case R.id.button4:
				Intent m = new Intent(this, ModCat.class);
				startActivity(m);
				break;
			case R.id.Button05:
				Intent d = new Intent(this, DelCat.class);
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
	    	//Enviar el array de categorias a Legio
	    	Legio legiocat = new Legio();
	    	Object[] par = new Object[3];
	    	par[0]="update_cats";
	    	par[1]=Cons.idbar;
	    	JSONObject containercats = new JSONObject();
	    	JSONArray arcat = new JSONArray();

	    	for(Categoria kata : MainActivity.res.getCatlist()){
	    		kata.setIdbar(Cons.idbar);
	    		try {
	    	    	JSONObject catmap = new JSONObject();
					catmap.put("idcat", kata.getIdcat());
					catmap.put("nombre", kata.getNombre());
					catmap.put("idbar", kata.getIdbar());
					arcat.put(catmap);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    		try {
					containercats.put("categorias", arcat);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	
	    	par[2]= containercats.toString();
	    	legiocat.execute(par);
	    	finish();
			break;
			
	    case R.id.nono:
	    	finish();
	    	break;
	    }
		return false;
	
	    }
	
	
}