package in;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import bardroid.core.R;

import com.Turmae;

import data.BO;

public class Create extends Activity implements OnClickListener {
	
	SharedPreferences.Editor editor;
	public static EditText edit1, edit2, edit3, edit4;
	public static String resultatum="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.create_account);
		
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(this);
		 edit1 = (EditText)findViewById(R.id.editText1);
		 
		 edit2 = (EditText)findViewById(R.id.editText2);
		 edit2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
		 edit3 = (EditText)findViewById(R.id.editText3);
		 
		 edit4 = (EditText)findViewById(R.id.editText4);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		editor.clear();
		
		editor.commit();
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.button2:
				if(edit1.getText().toString()==""){
					 edit1.setError("Introduzca el nombre del bar");
					 break;
				}
				
				
				if(!isValidEmail(edit2.getText().toString())){
					edit2.setError("Introduzca una direccion de correo electronico valido");
					 break;
				}
				
				if(edit3.getText().toString()==null){
					 edit3.setError("Introduzca una contrasenia");
					 break;
				}
				
				if(!edit3.getText().toString().equals(edit4.getText().toString()) || edit4.getText().toString()==null){
					edit4.setError("Las contrasenias deben coincidir");
					break;
				}
				
				
				if(edit3.getText().toString().equals(edit4.getText().toString())){
					
					
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
					editor = prefs.edit();
					editor.putString("nombre", edit1.getText().toString());
					editor.putString("mail", edit2.getText().toString());
					editor.putString("pass", edit3.getText().toString());
					editor.commit();
					
					BO bo = new BO();
					bo.setNombre(edit1.getText().toString());
					bo.setMail(edit2.getText().toString());
					bo.setPass(edit3.getText().toString());
					
					Object[] par = new Object[2];
					par[0] = "create";
					par[1] = bo;
					
					Turmae t = new Turmae();
					t.execute(par);
					
					

				
				
				}
				finish();
				break;
	
			case R.id.button3:
				finish();
				break;
		}
		
	}

	
	
	public final static boolean isValidEmail(CharSequence target) {
	    if (target == null) {
	        return false;
	    } else {
	        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
	    }
	}
	
	

}
