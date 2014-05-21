package bardroid.core;
import in.DeleteAccount;
import in.Logout;
import in.MainActivity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;

import com.Classis;

import config.Config1Alone;
import config.Config2Alone;
import config.Config41Alone;
import config.Config4Alone;
import config.Cons;

public class Salon extends Activity implements OnClickListener, OnMenuItemClickListener{
	public static Context con;
	static View barra, barrano1,barrano2,barrano3;
	static View vistaparaocupar;
	static int id_clicked;
	static int nummesas;
	private static int barr=0;
	static Map<String,TempList> maps;
	static SharedPreferences prefs;
    private static boolean de_config = false;
    static boolean p = true;
static int a;
	static ImageView mesa0, mesa1, mesa2, mesa3, mesa4, mesa5, mesa6, mesa7, 
		mesa8, mesa9, mesa10, mesa11, mesa12, mesa13, mesa14, mesa15, mesa16,
		mesa17, mesa18, mesa19, mesa20, mesa21, mesa22, mesa23, mesa24;
	
	
	
 

    
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.salon);
		

		
		
		con = getApplicationContext();
		
		
		maps = new HashMap<String,TempList>();
		
		 prefs = PreferenceManager.getDefaultSharedPreferences(this);
		 
		 
		 
		 if(MainActivity.estado!=null){
			 maps.putAll(MainActivity.estado);
			 p = false;
		 }
		 
		 
		
		 configureView();
		 
		 p = false;
		 
		 if(!MainActivity.k.admin){
			 //Pide estado sala al server
		 }
		 
		 Classis q = new Classis();
			Object[] par = new Object[2];
			par[0]="get_sala";
			par[1]=Cons.idbar;
			q.execute(par);		
	}
	
	
	@Override
	protected void onResume(){
		super.onResume();
		Classis q = new Classis();
		Object[] par = new Object[2];
		par[0]="get_sala";
		par[1]=Cons.idbar;
		q.execute(par);		
		
		configureView();
		//Pide estado sala al server
		
	}
	



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==barra.getId()){
			de_config=false;
			//Listabarra
			id_clicked = barra.getId();
			if(Lista.i==null){
				Intent lb = new Intent(this, Lista.class);
				
				startActivity(lb);
			}
			else startActivity(Lista.i);

		}else if(arg0.isClickable()){
			de_config=false;
			id_clicked = arg0.getId();
			vistaparaocupar = findViewById(id_clicked); 
			Intent lm = new Intent(this, Lista.class);
			startActivity(lm);
			
		}
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    
	    if(MainActivity.k.admin){
		    inflater.inflate(R.menu.menusalon, menu);
	    }
	    else inflater.inflate(R.menu.menusalonuser, menu);

	    
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.item_salir:
	            Intent jander = new Intent(this, Logout.class);
	            startActivity(jander);
	            return true;
	        case R.id.item_salir2:
	            Intent ontent = new Intent(this, Logout.class);
	            startActivity(ontent);
	            return true;
	        case R.id.item_config:
	        	showPopup(findViewById(R.id.item_config));
	            return true;
	        case R.id.item_info:
	        	Intent info = new Intent(this, Info.class);
				startActivity(info);
	        	return true;
	        case R.id.delete:
	        	Intent delete = new Intent(this, DeleteAccount.class);
	        	startActivity(delete);
	        	return true;
	        case R.id.item_caja:
	        	Intent caja = new Intent(this, Caja.class);
	        	startActivity(caja);
	        	return true;
	        case R.id.item_caja2:
	        	Intent coja = new Intent(this, Caja.class);
		        startActivity(coja);
		        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	
	public void showPopup(View v) {
	    PopupMenu popup = new PopupMenu(this, v);
	    popup.setOnMenuItemClickListener(this);
	    MenuInflater inflater = popup.getMenuInflater();
	    inflater.inflate(R.menu.actions, popup.getMenu());
	    popup.show();
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.item_productos:
			de_config=true;
			Intent pro = new Intent(this, Config4Alone.class);
			startActivity(pro);
			return true;
		case R.id.item_mesas:
			de_config=true;
			Intent me = new Intent(this, Config2Alone.class);
			startActivity(me);
			return true;
		case R.id.item_barra:
			de_config=true;
			Intent bar = new Intent(this, Config1Alone.class);
			startActivity(bar);
			return true;
		case R.id.item_catego:
			de_config=true;
			Intent cato = new Intent(this, Config41Alone.class);
			startActivity(cato);
			return true;
		
		}
		return false;
	}

	public static void changeToBusy(int id){
		vistaparaocupar.setBackgroundResource(R.drawable.mesaocu);
	}
	
	public static void changeToFree(int id){
		vistaparaocupar.setBackgroundResource(R.drawable.mesa);
	}
	
	
	
	public void configureView(){
		
		
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);

		mesa0 = (ImageView)findViewById(R.id.mesa0);
		mesa0.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa0.getId(),0);
		mesa1 = (ImageView)findViewById(R.id.mesa1);
		mesa1.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa1.getId(),1);
		
		mesa2 = (ImageView)findViewById(R.id.mesa2);
		mesa2.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa2.getId(),2);
		
		mesa3 = (ImageView)findViewById(R.id.mesa3);
		mesa3.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa3.getId(),3);
		
		mesa4 = (ImageView)findViewById(R.id.mesa4);
		mesa4.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa4.getId(),4);
		
		mesa5 = (ImageView)findViewById(R.id.mesa5);
		mesa5.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa5.getId(),5);
		
		mesa6 = (ImageView)findViewById(R.id.mesa6);
		mesa6.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa6.getId(),6);
		
		mesa7 = (ImageView)findViewById(R.id.mesa7);
		mesa7.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa7.getId(),7);
		
		mesa8 = (ImageView)findViewById(R.id.mesa8);
		mesa8.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa8.getId(),8);
		
		mesa9 = (ImageView)findViewById(R.id.mesa9);
		mesa9.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa9.getId(),9);
		
		mesa10 = (ImageView)findViewById(R.id.mesa10);
		mesa10.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa10.getId(),10);
		mesa11 = (ImageView)findViewById(R.id.mesa11);
		mesa11.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa11.getId(),11);
		mesa12 = (ImageView)findViewById(R.id.mesa12);
		mesa12.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa12.getId(),12);
		mesa13 = (ImageView)findViewById(R.id.mesa13);
		mesa13.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa13.getId(),13);
		mesa14 = (ImageView)findViewById(R.id.mesa14);
		mesa14.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa14.getId(),14);
		mesa15 = (ImageView)findViewById(R.id.mesa15);
		mesa15.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa15.getId(),15);
		mesa16 = (ImageView)findViewById(R.id.mesa16);
		mesa16.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa16.getId(),16);
		mesa17 = (ImageView)findViewById(R.id.mesa17);
		mesa17.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa17.getId(),17);
		mesa18 = (ImageView)findViewById(R.id.mesa18);
		mesa18.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa18.getId(),18);
		mesa19 = (ImageView)findViewById(R.id.mesa19);
		mesa19.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa19.getId(),19);
		mesa20 = (ImageView)findViewById(R.id.mesa20);
		mesa20.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa20.getId(),20);
		mesa21 = (ImageView)findViewById(R.id.mesa21);
		mesa21.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa21.getId(), 21);
		mesa22 = (ImageView)findViewById(R.id.mesa22);
		mesa22.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa22.getId(), 22);
		mesa23 = (ImageView)findViewById(R.id.mesa23);
		mesa23.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa23.getId(), 23);
		mesa24 = (ImageView)findViewById(R.id.mesa24);
		mesa24.setBackgroundResource(R.drawable.trans);
        MainActivity.mapeomesas.append(mesa24.getId(), 24);

		
		
		if(prefs.getInt("mes0", 0)==0){
			mesa0.setClickable(false);
		} else{
			mesa0.setBackgroundResource(R.drawable.mesa);
			mesa0.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa0.getId()), null);
			}
			}
		
		if(prefs.getInt("mes1", 0)==0){
			mesa1.setClickable(false);
		} else{
			mesa1.setBackgroundResource(R.drawable.mesa);
			mesa1.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa1.getId()), null);
			}
			}
		
		if(prefs.getInt("mes2", 0)==0){
			mesa2.setClickable(false);
		} else{
			
			mesa2.setBackgroundResource(R.drawable.mesa);
			mesa2.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa2.getId()), null);
			}
			}
		
		if(prefs.getInt("mes3", 0)==0){
			mesa3.setClickable(false);
		} else{
			mesa3.setBackgroundResource(R.drawable.mesa);
			mesa3.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa3.getId()), null);
			}
		}
		
		if(prefs.getInt("mes4", 0)==0){
			mesa4.setClickable(false);
		} else{
			mesa4.setBackgroundResource(R.drawable.mesa);
			mesa4.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa4.getId()), null);
			}
			}
		
		if(prefs.getInt("mes5", 0)==0){
			mesa5.setClickable(false);
		} else{
			mesa5.setBackgroundResource(R.drawable.mesa);
			mesa5.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa5.getId()), null);
			}
			}
		
		if(prefs.getInt("mes6", 0)==0){
			mesa6.setClickable(false);
		} else{
			mesa6.setBackgroundResource(R.drawable.mesa);
			mesa6.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa6.getId()), null);
			}
			}
		
		if(prefs.getInt("mes7", 0)==0){
			mesa7.setClickable(false);
		} else{
			mesa7.setBackgroundResource(R.drawable.mesa);
			mesa7.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa7.getId()), null);
			}
			}
		
		if(prefs.getInt("mes8", 0)==0){
			mesa8.setClickable(false);
		} else{
			mesa8.setBackgroundResource(R.drawable.mesa);
			mesa8.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa8.getId()), null);
			}
			}
		
		if(prefs.getInt("mes9", 0)==0){
			mesa9.setClickable(false);
		} else{
			mesa9.setBackgroundResource(R.drawable.mesa);
			mesa9.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa9.getId()), null);
			}
			}
		
		if(prefs.getInt("mes10", 0)==0){
			mesa10.setClickable(false);
		} else{
			mesa10.setBackgroundResource(R.drawable.mesa);
			mesa10.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa10.getId()), null);
			}
			}
		
		if(prefs.getInt("mes11", 0)==0){
			mesa11.setClickable(false);
		} else{
			mesa11.setBackgroundResource(R.drawable.mesa);
			mesa11.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa11.getId()), null);
			}
			}
		
		if(prefs.getInt("mes12", 0)==0){
			mesa12.setClickable(false);
		} else{
			mesa12.setBackgroundResource(R.drawable.mesa);
			mesa12.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa12.getId()), null);
			}
			}
		
		if(prefs.getInt("mes13", 0)==0){
			mesa13.setClickable(false);
		} else{
			mesa13.setBackgroundResource(R.drawable.mesa);
			mesa13.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa13.getId()), null);
			}
			}
		
		if(prefs.getInt("mes14", 0)==0){
			mesa14.setClickable(false);
		} else{
			mesa14.setBackgroundResource(R.drawable.mesa);
			mesa14.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa14.getId()), null);
			}
			}
		
		if(prefs.getInt("mes15", 0)==0){
			mesa15.setClickable(false);
		} else{
			mesa15.setBackgroundResource(R.drawable.mesa);
			mesa15.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa15.getId()), null);
			}
			}
		
		if(prefs.getInt("mes16", 0)==0){
			mesa16.setClickable(false);
		} else{
			mesa16.setBackgroundResource(R.drawable.mesa);
			mesa16.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa16.getId()), null);
			}
			}
		
		if(prefs.getInt("mes17", 0)==0){
			mesa17.setClickable(false);
		} else{
			mesa17.setBackgroundResource(R.drawable.mesa);
			mesa17.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa17.getId()), null);
			}
			}
		
		if(prefs.getInt("mes18", 0)==0){
			mesa18.setClickable(false);
		} else{
			mesa18.setBackgroundResource(R.drawable.mesa);
			mesa18.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa18.getId()), null);
			}
			}
		
		if(prefs.getInt("mes19", 0)==0){
			mesa19.setClickable(false);
		} else{
			mesa19.setBackgroundResource(R.drawable.mesa);
			mesa19.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa19.getId()), null);
			}
			}
		
		if(prefs.getInt("mes20", 0)==0){
			mesa20.setClickable(false);
		} else{
			mesa20.setBackgroundResource(R.drawable.mesa);
			mesa20.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa20.getId()), null);
			}
			}
		
		if(prefs.getInt("mes21", 0)==0){
			mesa21.setClickable(false);
		} else{
			mesa21.setBackgroundResource(R.drawable.mesa);
			mesa21.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa21.getId()), null);
			}
			}
		
		if(prefs.getInt("mes22", 0)==0){
			mesa22.setClickable(false);
		} else{
			mesa22.setBackgroundResource(R.drawable.mesa);
			mesa22.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa22.getId()), null);
			}
			}
		
		if(prefs.getInt("mes23", 0)==0){
			mesa23.setClickable(false);
		} else{
			mesa23.setBackgroundResource(R.drawable.mesa);
			mesa23.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa23.getId()), null);
			}
			}
		
		if(prefs.getInt("mes24", 0)==0){
			mesa24.setClickable(false);
		} else{
			mesa24.setBackgroundResource(R.drawable.mesa);
			mesa24.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(mesa24.getId()), null);
			}
			}
		
		barra = findViewById(R.id.barraarriba);
		barrano1 = findViewById(R.id.barraabajo);
		barrano2 = findViewById(R.id.barraizq);
		barrano3 = findViewById(R.id.barrader);
		
		barra.setClickable(false);
		barrano1.setClickable(false);
		barrano2.setClickable(false);
		barrano3.setClickable(false);
		
		barra.setBackgroundResource(R.drawable.transhor);
		barrano1.setBackgroundResource(R.drawable.transhor);
		barrano2.setBackgroundResource(R.drawable.transvert);
		barrano3.setBackgroundResource(R.drawable.transvert);
		
		
		if(prefs.getBoolean("arriba",false)){
			barra = findViewById(R.id.barraarriba);
			barra.setClickable(true);
			barra.setBackgroundResource(R.drawable.barra1);
			barra.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(barra.getId()), null);
			}
		}
		
		if(prefs.getBoolean("abajo",false)){
			barra = findViewById(R.id.barraabajo);
			barra.setClickable(true);
			barra.setBackgroundResource(R.drawable.barra2);
			barra.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(barra.getId()), null);
			}

		}
		
		if(prefs.getBoolean("izquierda",false)){
			barra = findViewById(R.id.barraizq);
			barra.setClickable(true);
			barra.setBackgroundResource(R.drawable.barra3);
			barra.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(barra.getId()), null);
			}

		}
		
		if(prefs.getBoolean("derecha",false)){
			barra = findViewById(R.id.barrader);
			barra.setClickable(true);
			barra.setBackgroundResource(R.drawable.barra4);
			barra.setOnClickListener(this);
			if(p){
				maps.put(String.valueOf(barra.getId()), null);
			}

		}
		
		
        MainActivity.mapeomesas.append(barra.getId(), 30);

		
		
		
		
		
	}
	
	
	
	

	
	
	
	
}
