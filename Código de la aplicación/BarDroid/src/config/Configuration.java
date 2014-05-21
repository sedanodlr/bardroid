package config;

import in.MainActivity;
import android.content.SharedPreferences;

public class Configuration {

	
	
	static SharedPreferences prefs;
	SharedPreferences.Editor editor;
	
	 public int ID_bar; 
	 public boolean es_config;
	 public boolean arriba;
	 public boolean abajo;
	 public boolean izquierda;
	 public boolean derecha;
	 public int mes0; 
	 public int mes1; 
	 public int mes2;
	 public int mes3;
	 public int mes4; 
	 public int mes5; 
	 public int mes6; 
	 public int mes7; 
	 public int mes8;
	 public int mes9; 
	 public int mes10; 
	 public int mes11;
	 public int mes12;
	 public int mes13;
	 public int mes14; 
	 public int mes15; 
	 public int mes16; 
	 public int mes17; 
	 public int mes18; 
	 public int mes19; 
	 public int mes20; 
	 public int mes21;
	 public int mes22;
	 public int mes23; 
	 public int mes24;
	 boolean alone;
	 boolean wifi;
	 public boolean admin;
	
	Configuration(){
		
		prefs = MainActivity.prefs;
		this.ID_bar = prefs.getInt("ID_bar", 0);
		this.es_config = prefs.getBoolean("es_config", false);
		this.arriba = prefs.getBoolean("arriba", false);
		this.abajo = prefs.getBoolean("abajo", false);
		this.izquierda = prefs.getBoolean("izquierda", false);
		this.derecha = prefs.getBoolean("derecha", false);
		this.mes0 = prefs.getInt("mes0", 0);
		this.mes1 = prefs.getInt("mes1", 0);
		this.mes2 = prefs.getInt("mes2", 0);
		this.mes3 = prefs.getInt("mes3", 0);
		this.mes4 = prefs.getInt("mes4", 0);
		this.mes5 = prefs.getInt("mes5", 0);
		this.mes6 = prefs.getInt("mes6", 0);
		this.mes7 = prefs.getInt("mes7", 0);
		this.mes8 = prefs.getInt("mes8", 0);
		this.mes9 = prefs.getInt("mes9", 0);
		this.mes10 = prefs.getInt("mes10", 0);
		this.mes11 = prefs.getInt("mes11", 0);
		this.mes12 = prefs.getInt("mes12", 0);
		this.mes13 = prefs.getInt("mes13", 0);
		this.mes14 = prefs.getInt("mes14", 0);
		this.mes15 = prefs.getInt("mes15", 0);
		this.mes16 = prefs.getInt("mes16", 0);
		this.mes17 = prefs.getInt("mes17", 0);
		this.mes18 = prefs.getInt("mes18", 0);
		this.mes19 = prefs.getInt("mes19", 0);
		this.mes20 = prefs.getInt("mes20", 0);
		this.mes21 = prefs.getInt("mes21", 0);
		this.mes22 = prefs.getInt("mes22", 0);
		this.mes23 = prefs.getInt("mes23", 0);
		this.mes24 = prefs.getInt("mes24", 0);
		this.alone = prefs.getBoolean("alone", false);
		this.wifi = prefs.getBoolean("wifi", false);
		this.admin = prefs.getBoolean("admin", true);
		
	}

	public Configuration(boolean join){
		
		this.ID_bar = 0;
		this.es_config = false;
		this.arriba = false;
		this.abajo = false;
		this.izquierda = false;
		this.derecha = false;
		this.mes0 = 0;
		this.mes1 = 0;
		this.mes2 = 0;
		this.mes3 = 0;
		this.mes4 = 0;
		this.mes5 = 0;
		this.mes6 = 0;
		this.mes7 = 0;
		this.mes8 = 0;
		this.mes9 = 0;
		this.mes10 = 0;
		this.mes11 = 0;
		this.mes12 = 0;
		this.mes13 = 0;
		this.mes14 = 0;
		this.mes15 = 0;
		this.mes16 = 0;
		this.mes17 = 0;
		this.mes18 = 0;
		this.mes19 = 0;
		this.mes20 = 0;
		this.mes21 = 0;
		this.mes22 = 0;
		this.mes23 = 0;
		this.mes24 = 0;
		this.alone = false;
		this.wifi = false;
		this.admin = false;
		
	}

	public void setConfigToLocale(Configuration c) {
		// TODO Auto-generated method stub
		prefs = MainActivity.prefs;
		editor = prefs.edit();
		
		editor.putInt("ID_bar", c.ID_bar);
		editor.putBoolean("arriba",c.arriba);
		editor.putBoolean("abajo",c.abajo);
		editor.putBoolean("izquierda",c.izquierda);
		editor.putBoolean("derecha",c.derecha);
		editor.putInt("mes0",c.mes0);
		editor.putInt("mes1",c.mes1);
		editor.putInt("mes2",c.mes2);
		editor.putInt("mes3",c.mes3);
		editor.putInt("mes4",c.mes4);
		editor.putInt("mes5",c.mes5);
		editor.putInt("mes6",c.mes6);
		editor.putInt("mes7",c.mes7);
		editor.putInt("mes8",c.mes8);
		editor.putInt("mes9",c.mes9);
		editor.putInt("mes10",c.mes10);
		editor.putInt("mes11",c.mes11);
		editor.putInt("mes12",c.mes12);
		editor.putInt("mes13",c.mes13);
		editor.putInt("mes14",c.mes14);
		editor.putInt("mes15",c.mes15);
		editor.putInt("mes16",c.mes16);
		editor.putInt("mes17",c.mes17);
		editor.putInt("mes18",c.mes18);
		editor.putInt("mes19",c.mes19);
		editor.putInt("mes20",c.mes20);
		editor.putInt("mes21",c.mes21);
		editor.putInt("mes22",c.mes22);
		editor.putInt("mes23",c.mes23);
		editor.putInt("mes24",c.mes24);
		editor.putBoolean("admin", c.admin);
		
		editor.commit();
		
	}

	
}
