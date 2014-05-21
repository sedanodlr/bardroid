package in;



import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;
import bardroid.core.TempList;
import config.Configuration;
import data.Respuesta;

public class MainActivity extends Activity implements OnClickListener{

	private static boolean saliendo = false; 
	public static SharedPreferences prefs;
	public static Respuesta res;
	public static Configuration k;
	public static SparseIntArray mapeomesas;
	public static Map<String,TempList> estado;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mapeomesas = new SparseIntArray();
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		k = new Configuration(true);
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.button1:
				
				Intent admin = new Intent(this, Init_admin.class);
				startActivity(admin);
				break;
			case R.id.button2:
				
				Intent user = new Intent(this, Init_user.class);
				
				startActivity(user);
				break;
			
		}
		
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    	case R.id.menu_about:
	    		//About
	    		Intent about = new Intent(this, About.class); 
	    		startActivity(about); 
	    		break;
	    	case R.id.menu_quit:
	    		//Salir
	    		Intent quit = new Intent(this, Salir.class);
	    		startActivity(quit);
	    		break;
	    	default:
	            return super.onOptionsItemSelected(item);
	    }
		return false;
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		if(saliendo){
    		finish();
    		} 
	}

	public static boolean isSaliendo() {
		return saliendo;
	}

	public static void setSaliendo(boolean saliendo) {
		MainActivity.saliendo = saliendo;
	}
	
}
