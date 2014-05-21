package config;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import bardroid.core.R;
import bardroid.core.Salon;

import com.Legio;

public class Config5  extends Activity implements OnClickListener {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_5_end);

		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.navigator, menu);
	    
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.nex:
	    	 SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
				SharedPreferences.Editor editor = prefs.edit();
				
				
				//Enviar un valor flag a Legio para que modifique el es_config en la
				//base de datos
				Legio legiocon = new Legio();
				Object[] par = new Object[3];
				par[0]="configurated";
				par[1]=Cons.idbar;
				par[2]=true;
				legiocon.execute(par);
				editor.putBoolean("es_config", true);
				editor.putInt("ID_bar", Cons.idbar);
				editor.commit();
				Configuration c = new Configuration();
				
				
				
				
				Intent end = new Intent(this, Salon.class);
				startActivity(end);
			break;
			
	    case R.id.pre:
	    	finish();
	    	break;
	    }
		return false;
	
	    }
	
	
}