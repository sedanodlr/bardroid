package in;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;

import com.Turmae;

import config.Cons;
import data.BO;

public class DeleteAccount extends Activity implements OnClickListener {

	SharedPreferences.Editor editor;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.delete_dialog);
	
		Button si = (Button)findViewById(R.id.si);
		si.setOnClickListener(this);
		Button no = (Button)findViewById(R.id.no);
		no.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.si:
			//Llamada a Turmae con los parametros para eliminar el bar 
			
			BO b = new BO();
			
			//Habria que poner el id de verdad del bar, probamos con 7 
			b.setID(Cons.idbar);
			Object[] par = new Object[2];
			par[0] = "delete";
			par[1] = b;
			
			Init_admin.try_login = true;
			
			Turmae t = new Turmae();
			t.execute(par);
			
			
			Intent intent = new Intent(this, MainActivity.class);
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			editor = prefs.edit();
			editor.clear();
			
			editor.commit();
			
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
			break;
		
		case R.id.no:
			finish();
			break;
		
		}
		
	}
		
		
	

	

}
