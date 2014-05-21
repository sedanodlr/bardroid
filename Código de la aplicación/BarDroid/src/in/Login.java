package in;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import bardroid.core.R;
import bardroid.core.Salon;

import com.Turmae;

import config.Config0;
import config.Cons;
import data.BO;
import data.Categoria;
import data.Producto;

@SuppressLint("NewApi")
public class Login extends Activity implements OnClickListener {
	
	boolean es_config = false;
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	EditText edit1, edit2;
	static Cons cons = new Cons();
	public static Context c;
	public static ArrayList<Categoria> categos = new ArrayList<Categoria>();
	public static ArrayList<Producto> prods = new ArrayList<Producto>();
	public static boolean correcto = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.login);
		c = this.getApplicationContext();	
		
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		
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

				if(!Create.isValidEmail(edit1.getText().toString())){
					edit1.setError("Introduzca una direccion de correo electronico valido");
					 break;
				}
				
				
				
				BO bo = new BO();
				bo.setMail(edit1.getText().toString());
				bo.setPass(edit2.getText().toString());
				
				Object[] par = new Object[2];
				par[0] = "login";
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
				
				
				if(correcto){
				
					
					
					if(!Cons.config){
					Intent startconf = new Intent(this, Config0.class);
					startActivity(startconf);
					}else{
						MainActivity.k.admin = true;
						Intent sal = new Intent(this, Salon.class);
						startActivity(sal);
								
					}
				
				}
				finish();
				break;
	
			case R.id.button3:
				finish();
				break;
		}
		
	}

}
