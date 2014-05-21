package in;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import bardroid.core.R;
import config.Config0;

public class Init_admin extends Activity implements OnClickListener {
	
	SharedPreferences.Editor editor;
	static boolean es_config = false;
	SharedPreferences prefs;
	public static Context c;
	public static boolean try_login = false;
	public static boolean success_login= false;

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.init_admin);
		c = getApplicationContext();
		
		
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(this);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor edit;
		edit = prefs.edit();
		edit.putBoolean("admin", true);
		if(prefs.contains("es_config")){
			es_config=true;
		}
	}
	@Override
	protected void onResume(){
		super.onResume();
		if(try_login==true){
		if(success_login){
			Intent c0 = new Intent(this, Config0.class);
			startActivity(c0);
		} else Toast.makeText(this, "ERROR login", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.button1:
				Intent create = new Intent(this, Create.class);
				startActivity(create);
				break;
			case R.id.button3:
				//Constantes.set_offline(false);
				Intent login = new Intent(this, Login.class);
				startActivity(login);
				break;
			
		}
	}

}
