package bardroid.core;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Info extends Activity implements OnClickListener{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.info);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		TextView t2 = (TextView)findViewById(R.id.info2);
		t2.setText(prefs.getString("nombre", "nombre"));
		TextView t4 = (TextView)findViewById(R.id.info4);
		t4.setText(prefs.getString("mail", "mail"));
		ToggleButton t = (ToggleButton)findViewById(R.id.info_button);
		t.setTextOn(prefs.getString("pass", "Password"));
		Button exit = (Button)findViewById(R.id.exit_info);
		exit.setOnClickListener(this);


	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.exit_info:
			finish();
			break;
		}
		
	}
	
	

}
