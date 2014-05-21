package config;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import bardroid.core.R;

import com.Legio;

public class Config1Alone extends Activity implements OnClickListener {
	
	
	SharedPreferences.Editor editor;
	static int a = 0;
	static int b = 0;
	static int c = 0;
	static int d = 0;
	static SharedPreferences prefs;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_1_barra);
		 
	
		 
		
		View barratop = findViewById(R.id.barraarriba); 
        barratop.setOnClickListener(this);
        View barrabot = findViewById(R.id.barraabajo); 
        barrabot.setOnClickListener(this);
        View barraleft = findViewById(R.id.barraizq); 
        barraleft.setOnClickListener(this);
        View barraright = findViewById(R.id.barrader); 
        barraright.setOnClickListener(this);
		
		
		
		   prefs = PreferenceManager.getDefaultSharedPreferences(this);
		  
			editor=prefs.edit();

		if(prefs.getBoolean("arriba", false)){
			barratop.setBackgroundResource(R.drawable.barra1);
			a=1;
			b=c=d=0;
		}
		if(prefs.getBoolean("abajo", false)){
			barrabot.setBackgroundResource(R.drawable.barra2);
			b=1;
			a=c=d=0;

		}
		if(prefs.getBoolean("izquierda", false)){
			barraleft.setBackgroundResource(R.drawable.barra3);
			c=1;
			b=a=d=0;

		}
		if(prefs.getBoolean("derecha", false)){
			barraright.setBackgroundResource(R.drawable.barra4);
			d=1;
			b=c=a=0;
			

		}
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.barraarriba:
			v.setBackgroundResource(R.drawable.barra1);
			this.findViewById(R.id.barraabajo).setBackgroundResource(R.drawable.transhor_conf);
			this.findViewById(R.id.barraizq).setBackgroundResource(R.drawable.transvert_conf);
			this.findViewById(R.id.barrader).setBackgroundResource(R.drawable.transvert_conf);
			a = 1;
			b = c = d = 0; 
			
			break;
		case R.id.barraabajo:
				this.findViewById(R.id.barraarriba).setBackgroundResource(R.drawable.transhor_conf);
				v.setBackgroundResource(R.drawable.barra2);
				this.findViewById(R.id.barraizq).setBackgroundResource(R.drawable.transvert_conf);
				this.findViewById(R.id.barrader).setBackgroundResource(R.drawable.transvert_conf);
				b = 1;
				a = c = d = 0;
				

			break;
		case R.id.barraizq:
				this.findViewById(R.id.barraarriba).setBackgroundResource(R.drawable.transhor_conf);
				this.findViewById(R.id.barraabajo).setBackgroundResource(R.drawable.transhor_conf);
				v.setBackgroundResource(R.drawable.barra3);
				this.findViewById(R.id.barrader).setBackgroundResource(R.drawable.transvert_conf);	
				c = 1;
				b = a = d = 0;	
				
			break;
		case R.id.barrader:
			this.findViewById(R.id.barraarriba).setBackgroundResource(R.drawable.transhor_conf);
			this.findViewById(R.id.barraabajo).setBackgroundResource(R.drawable.transhor_conf);
			this.findViewById(R.id.barraizq).setBackgroundResource(R.drawable.transvert_conf);
			v.setBackgroundResource(R.drawable.barra4);
			d = 1;
			b = c = a = 0;	
			

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
	    	Legio legiobar = new Legio();
			Object[] par = new Object[3];
			par[0] = "update_barra";
			par[1] = Cons.idbar;
	    	if(a==1){
				editor.putBoolean("arriba", true);
				editor.putBoolean("abajo", false);
				editor.putBoolean("izquierda", false);
				editor.putBoolean("derecha", false);
				par[2]="arriba";
			} else if(b==1){
				editor.putBoolean("arriba", false);
				editor.putBoolean("abajo", true);
				editor.putBoolean("izquierda", false);
				editor.putBoolean("derecha", false);
				par[2]="abajo";

				} else if(c==1){
					editor.putBoolean("arriba", false);
					editor.putBoolean("abajo", false);
					editor.putBoolean("izquierda", true);
					editor.putBoolean("derecha", false);
					par[2]="izquierda";

					} else if(d==1){
						editor.putBoolean("arriba", false);
						editor.putBoolean("abajo", false);
						editor.putBoolean("izquierda", false);
						editor.putBoolean("derecha", true);
						par[2]="derecha";

						}
			
			editor.commit();
			legiobar.execute(par);
			
			finish();
			break;
			
	    case R.id.nono:
	    	finish();
	    	break;
	    }
		return false;
	
	    }

	

}
