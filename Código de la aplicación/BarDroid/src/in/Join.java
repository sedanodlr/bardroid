package in;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import bardroid.core.R;
import bardroid.core.Salon;

import com.Turmae;

import data.BO;
public class Join extends Activity implements OnClickListener {
	
	EditText edit1, edit2;
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	public static boolean joincorrecto=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.join);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		editor.clear();
		
		editor.commit();
		editor.putBoolean("admin", false);
		editor.commit();

		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(this);
		 edit1 = (EditText)findViewById(R.id.editText1);
		 edit2 = (EditText)findViewById(R.id.editText2);
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.button2:
				
				BO bo = new BO();
				bo.setNombre(edit1.getText().toString());
				bo.setPass(edit2.getText().toString());
				Object[] par = new Object[2];
				par[0] = "join";
				par[1] = bo;
				
				Init_admin.try_login = true;
				
				Turmae t = new Turmae();
				t.execute(par);
				
				Thread closeActivity = new Thread(new Runnable() {
					  @Override
					  public void run() {
					    try {
					      Thread.sleep(3000);
					      // Do some stuff
					    } catch (Exception e) {
					      e.getLocalizedMessage();
					    }
					  }
					});
				closeActivity.run();
				
				if(joincorrecto){
				Intent salon = new Intent(this, Salon.class);
				startActivity(salon);
				}
				else Toast.makeText(getApplicationContext(), "Error al iniciar sesion, compruebe los datos introducidos", 
						Toast.LENGTH_LONG).show();
				break;
	
			case R.id.button3:
				finish();
				break;
		}
		
	}

}
