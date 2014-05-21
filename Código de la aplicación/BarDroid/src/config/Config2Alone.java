package config;
import in.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import bardroid.core.R;

import com.Legio;

public class Config2Alone extends Activity implements OnClickListener {
	
	static int num_mesas=0;
	static String tag1 = "trans";
	static String tag2 = "notrans";
	static ImageView mes0, mes1, mes2, mes3, mes4, mes5, mes6, mes7, mes8, mes9, mes10,
		mes11, mes12, mes13, mes14, mes15, mes16, mes17, mes18, mes19, mes20, 
		mes21, mes22, mes23, mes24;
	
	SharedPreferences.Editor editor;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_2_mesas);
		
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		editor = prefs.edit();
		
		mes0 = (ImageView) findViewById(R.id.mesa0);
		mes0.setOnClickListener(this);
		if(prefs.getInt("mes0", 0)==0){
		mes0.setTag(tag1);
		} else {
			mes0.setTag(tag2);
			mes0.setBackgroundResource(R.drawable.mesa);
		}
		
		mes1 =  (ImageView)findViewById(R.id.mesa1);
		mes1.setOnClickListener(this);
		if(prefs.getInt("mes1", 0)==0){
		mes1.setTag(tag1);
		} else {
			mes1.setTag(tag2);
			mes1.setBackgroundResource(R.drawable.mesa);
		}
		
		mes2 = (ImageView)findViewById(R.id.mesa2);
		mes2.setOnClickListener(this);
		if(prefs.getInt("mes2", 0)==0){
mes2.setTag(tag1);
		} else {
			mes2.setTag(tag2);
			mes2.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes3 =  (ImageView)findViewById(R.id.mesa3);
		mes3.setOnClickListener(this);
		if(prefs.getInt("mes3", 0)==0){
mes3.setTag(tag1);
		} else {
			mes3.setTag(tag2);
			mes3.setBackgroundResource(R.drawable.mesa);
		}


		
		mes4 = (ImageView)findViewById(R.id.mesa4);
		mes4.setOnClickListener(this);
		if(prefs.getInt("mes4", 0)==0){
mes4.setTag(tag1);
		} else {
			mes4.setTag(tag2);
			mes4.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes5 = (ImageView)findViewById(R.id.mesa5);
		mes5.setOnClickListener(this);
		if(prefs.getInt("mes5", 0)==0){
mes5.setTag(tag1);
		} else {
			mes5.setTag(tag2);
			mes5.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes6 = (ImageView)findViewById(R.id.mesa6);
		mes6.setOnClickListener(this);
		if(prefs.getInt("mes6", 0)==0){
mes6.setTag(tag1);
		} else {
			mes6.setTag(tag2);
			mes6.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes7 = (ImageView)findViewById(R.id.mesa7);
		mes7.setOnClickListener(this);
		if(prefs.getInt("mes7", 0)==0){
mes7.setTag(tag1);
		} else {
			mes7.setTag(tag2);
			mes7.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes8 = (ImageView)findViewById(R.id.mesa8);
		mes8.setOnClickListener(this);
		if(prefs.getInt("mes8", 0)==0){
mes8.setTag(tag1);
		} else {
			mes8.setTag(tag2);
			mes8.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes9 = (ImageView)findViewById(R.id.mesa9);
		mes9.setOnClickListener(this);
		if(prefs.getInt("mes9", 0)==0){
mes9.setTag(tag1);
		} else {
			mes9.setTag(tag2);
			mes9.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes10 =(ImageView)findViewById(R.id.mesa10);
		mes10.setOnClickListener(this);
		if(prefs.getInt("mes10", 0)==0){
mes10.setTag(tag1);
		} else {
			mes10.setTag(tag2);
			mes10.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes11 = (ImageView)findViewById(R.id.mesa11);
		mes11.setOnClickListener(this);
		if(prefs.getInt("mes11", 0)==0){
mes11.setTag(tag1);
		} else {
			mes11.setTag(tag2);
			mes11.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes12 = (ImageView)findViewById(R.id.mesa12);
		mes12.setOnClickListener(this);
		if(prefs.getInt("mes12", 0)==0){
mes12.setTag(tag1);
		} else {
			mes12.setTag(tag2);
			mes12.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes13 = (ImageView)findViewById(R.id.mesa13);
		mes13.setOnClickListener(this);
		if(prefs.getInt("mes13", 0)==0){
mes13.setTag(tag1);
		} else {
			mes13.setTag(tag2);
			mes13.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes14 = (ImageView)findViewById(R.id.mesa14);
		mes14.setOnClickListener(this);
		if(prefs.getInt("mes14", 0)==0){
mes14.setTag(tag1);
		} else {
			mes14.setTag(tag2);
			mes14.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes15 = (ImageView)findViewById(R.id.mesa15);
		mes15.setOnClickListener(this);
		if(prefs.getInt("mes15", 0)==0){
mes15.setTag(tag1);
		} else {
			mes15.setTag(tag2);
			mes15.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes16 = (ImageView)findViewById(R.id.mesa16);
		mes16.setOnClickListener(this);
		if(prefs.getInt("mes16", 0)==0){
mes16.setTag(tag1);
		} else {
			mes16.setTag(tag2);
			mes16.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes17 = (ImageView)findViewById(R.id.mesa17);
		mes17.setOnClickListener(this);
		if(prefs.getInt("mes17", 0)==0){
			mes17.setTag(tag1);
		} else {
			mes17.setTag(tag2);
			mes17.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes18 = (ImageView)findViewById(R.id.mesa18); 				
		mes18.setOnClickListener(this);
		if(prefs.getInt("mes18", 0)==0){
			mes18.setTag(tag1);
		} else {
			mes18.setTag(tag2);
			mes18.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes19 = (ImageView)findViewById(R.id.mesa19);
		mes19.setOnClickListener(this);
		if(prefs.getInt("mes19", 0)==0){
mes19.setTag(tag1);
		} else {
			mes19.setTag(tag2);
			mes19.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes20 = (ImageView)findViewById(R.id.mesa20);
		mes20.setOnClickListener(this);
		if(prefs.getInt("mes20", 0)==0){
mes20.setTag(tag1);
		} else {
			mes20.setTag(tag2);
			mes20.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes21 = (ImageView)findViewById(R.id.mesa21);
		mes21.setOnClickListener(this);
		if(prefs.getInt("mes21", 0)==0){
mes21.setTag(tag1);
		} else {
			mes21.setTag(tag2);
			mes21.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes22 = (ImageView)findViewById(R.id.mesa22);
		mes22.setOnClickListener(this);
		if(prefs.getInt("mes22", 0)==0){
mes22.setTag(tag1);
		} else {
			mes22.setTag(tag2);
			mes22.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes23 =(ImageView)findViewById(R.id.mesa23); 				
		mes23.setOnClickListener(this);
		if(prefs.getInt("mes23", 0)==0){
mes23.setTag(tag1);
		} else {
			mes23.setTag(tag2);
			mes23.setBackgroundResource(R.drawable.mesa);
		}
		
		
		mes24 =(ImageView)findViewById(R.id.mesa24);
		mes24.setOnClickListener(this);
		if(prefs.getInt("mes24", 0)==0){
			mes24.setTag(tag1);
		} else {
			mes24.setTag(tag2);
			mes24.setBackgroundResource(R.drawable.mesa);
		}
		
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		

		default:
			if(v.getTag()==tag1){
			v.setBackgroundResource(R.drawable.mesa);
				num_mesas++;
				v.setTag(tag2);
				
				
				
			}
			else{ 
				v.setBackgroundResource(R.drawable.trans_conf);
				num_mesas--;
				v.setTag(tag1);
			}
			
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
	    	Legio legiomes = new Legio();
			Object[] par = new Object[3];
			par[0] = "update_mesas";
			par[1] = Cons.idbar;
JSONObject containermesas = new JSONObject();
	    	
try{
	if(mes0.getTag()==tag2){
		editor.putInt("mes0", 1);
		containermesas.put("mes0", true);
		MainActivity.mapeomesas.put(mes0.getId(), 0 );
		
	} else {
		editor.putInt("mes0", 0);
		containermesas.put("mes0", false);
	}
	
	if(mes1.getTag()==tag2){
		editor.putInt("mes1", 1);
		containermesas.put("mes1", true);
		MainActivity.mapeomesas.put( mes1.getId(), 1);


	} else {
		editor.putInt("mes1", 0);
		containermesas.put("mes1", false);
	}
	
	if(mes2.getTag()==tag2){
		editor.putInt("mes2", 1);
		containermesas.put("mes2", true);
		MainActivity.mapeomesas.put(mes2.getId(), 2);


	} else {
		editor.putInt("mes2", 0);
		containermesas.put("mes2", false);
	}
	
	if(mes3.getTag()==tag2){
		editor.putInt("mes3", 1);
		containermesas.put("mes3", true);
		MainActivity.mapeomesas.put(mes3.getId(), 3);


	} else {
		editor.putInt("mes3", 0);
		containermesas.put("mes3", false);
	}
	
	if(mes4.getTag()==tag2){
		editor.putInt("mes4", 1);
		containermesas.put("mes4", true);
		MainActivity.mapeomesas.put(mes4.getId(), 4);


	} else {
		editor.putInt("mes4", 0);
		containermesas.put("mes4", false);
	}
	
	if(mes5.getTag()==tag2){
		editor.putInt("mes5", 1);
		containermesas.put("mes5", true);
		MainActivity.mapeomesas.put(mes5.getId(), 5);


	} else {
		editor.putInt("mes5", 0);
		containermesas.put("mes5", false);
	}
	
	if(mes6.getTag()==tag2){
		editor.putInt("mes6", 1);
		containermesas.put("mes6", true);		
		MainActivity.mapeomesas.put(mes6.getId(), 6);


	} else {
		editor.putInt("mes6", 0);
		containermesas.put("mes6", false);
	}
	
	if(mes7.getTag()==tag2){
		editor.putInt("mes7", 1);
		containermesas.put("mes7", true);
		MainActivity.mapeomesas.put(mes7.getId(), 7);


	} else {
		editor.putInt("mes7", 0);
		containermesas.put("mes7", false);
	}
	
	if(mes8.getTag()==tag2){
		editor.putInt("mes8", 1);
		containermesas.put("mes8", true);
		MainActivity.mapeomesas.put(mes8.getId(), 8);


	} else {
		editor.putInt("mes8", 0);
		containermesas.put("mes8", false);
	}
	
	if(mes9.getTag()==tag2){
		editor.putInt("mes9", 1);
		containermesas.put("mes9", true);
		MainActivity.mapeomesas.put(mes9.getId(), 9);


	} else {
		editor.putInt("mes9", 0);
		containermesas.put("mes9", false);
	}
	
	if(mes10.getTag()==tag2){
		editor.putInt("mes10", 1);
		containermesas.put("mes10", true);
		MainActivity.mapeomesas.put(mes10.getId(), 10);


	} else {
		editor.putInt("mes10", 0);
		containermesas.put("mes10", false);
	}
	
	if(mes11.getTag()==tag2){
		editor.putInt("mes11", 1);
		containermesas.put("mes11", true);
		MainActivity.mapeomesas.put(mes11.getId(), 11);


	} else {
		editor.putInt("mes11", 0);
		containermesas.put("mes11", false);
	}
	
	if(mes12.getTag()==tag2){
		editor.putInt("mes12", 1);
		containermesas.put("mes12", true);
		MainActivity.mapeomesas.put(mes12.getId(), 12);


	} else {
		editor.putInt("mes12", 0);
		containermesas.put("mes12", false);
	}
	
	if(mes13.getTag()==tag2){
		editor.putInt("mes13", 1);
		containermesas.put("mes13", true);
		MainActivity.mapeomesas.put(mes13.getId(), 13);


	} else {
		editor.putInt("mes13", 0);
		containermesas.put("mes13", false);
	}
	
	if(mes14.getTag()==tag2){
		editor.putInt("mes14", 1);
		containermesas.put("mes14", true);
		MainActivity.mapeomesas.put(mes14.getId(), 14);


	} else {
		editor.putInt("mes14", 0);
		containermesas.put("mes14", false);
	}
	
	if(mes15.getTag()==tag2){
		editor.putInt("mes15", 1);
		containermesas.put("mes15", true);
		MainActivity.mapeomesas.put(mes15.getId(), 15);


	} else {
		editor.putInt("mes15", 0);
		containermesas.put("mes15", false);
	}
	
	if(mes16.getTag()==tag2){
		editor.putInt("mes16", 1);
		containermesas.put("mes16", true);
		MainActivity.mapeomesas.put(mes16.getId(), 16);


	} else {
		editor.putInt("mes16", 0);
		containermesas.put("mes16", false);
	}
	
	if(mes17.getTag()==tag2){
		editor.putInt("mes17", 1);
		containermesas.put("mes17", true);
		MainActivity.mapeomesas.put(mes17.getId(), 17);


	} else {
		editor.putInt("mes17", 0);
		containermesas.put("mes17", false);
	}
	
	if(mes18.getTag()==tag2){
		editor.putInt("mes18", 1);
		containermesas.put("mes18", true);
		MainActivity.mapeomesas.put(mes18.getId(), 18);


	} else {
		editor.putInt("mes18", 0);
		containermesas.put("mes18", false);
	}
	
	if(mes19.getTag()==tag2){
		editor.putInt("mes19", 1);
		containermesas.put("mes19", true);
		MainActivity.mapeomesas.put(mes19.getId(), 19);


	} else {
		editor.putInt("mes19", 0);
		containermesas.put("mes19", false);
	}
	
	if(mes20.getTag()==tag2){
		editor.putInt("mes20", 1);
		containermesas.put("mes20", true);
		MainActivity.mapeomesas.put(mes20.getId(), 20);


	} else {
		editor.putInt("mes20", 0);
		containermesas.put("mes20", false);
	}
	
	if(mes21.getTag()==tag2){
		editor.putInt("mes21", 1);
		containermesas.put("mes21", true);
		MainActivity.mapeomesas.put(mes21.getId(), 21);


	} else {
		editor.putInt("mes21", 0);
		containermesas.put("mes21", false);
	}
	
	if(mes22.getTag()==tag2){
		editor.putInt("mes22", 1);
		containermesas.put("mes22", true);
		MainActivity.mapeomesas.put(mes22.getId(), 22);


	} else {
		editor.putInt("mes22", 0);
		containermesas.put("mes22", false);
	}
	
	if(mes23.getTag()==tag2){
		editor.putInt("mes23", 1);
		containermesas.put("mes23", true);
		MainActivity.mapeomesas.put(mes23.getId(), 23);

	} else{
		editor.putInt("mes23", 0);
		containermesas.put("mes23", false);

	}
	
	if(mes24.getTag()==tag2){
		editor.putInt("mes24", 1);
		containermesas.put("mes24", true);
		MainActivity.mapeomesas.put(mes24.getId(), 24);


	} else {
		editor.putInt("mes24", 0);
		containermesas.put("mes24", false);
	}
	}catch (JSONException e) {
		// TODO: handle exception
	}
	
	par[2] = containermesas.toString();
	
	legiomes.execute(par);
			
			editor.putInt("numeromesas", num_mesas);
			editor.commit();	
			finish();
			break;
			
	    case R.id.nono:
	    	finish();
	    	break;
	    }
		return false;
	
	    }

}