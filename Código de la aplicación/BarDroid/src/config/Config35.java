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
import android.widget.RadioButton;
import android.widget.Toast;
import bardroid.core.R;

public class Config35 extends Activity {
	
	static boolean a = false;
	static boolean b = false;
	static boolean c = false;
	SharedPreferences.Editor editor;
	Intent serverIntent;
	

	
	
	
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.askcon);
		
		
		
		
		 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		
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
	    	
	    	if(!a&&!b){
	    		
	    		Toast.makeText(getBaseContext(), "Seleccione una de las opciones", Toast.LENGTH_SHORT).show();
	    		break;
	    	}
	    	else{
	    		if(a){
	    			editor.putBoolean("alone", true);
	    		}
	    		if(b){
	    			editor.putBoolean("wifi", true);
	    		}
	    		
	    		
	    		editor.commit();
	    		Intent next = new Intent(this, Config5.class);
				startActivity(next);
	    	}
			break;
			
	    case R.id.pre:
	    	finish();
	    	break;
	    }
		return false;
	
	    }
	
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radioButton1:
	            if (checked){
	            	a = true;
	            	b = false;
	            	c = false;
	            }
	            break;
	        case R.id.radioButton2:
	            if (checked){
	            	a = false;
	 	            b = true;
	 	            c = false;
	            	
	            }
	            break;
	            
	        
	    }
	}

	
}
