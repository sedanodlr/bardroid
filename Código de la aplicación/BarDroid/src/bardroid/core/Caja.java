package bardroid.core;

import in.MainActivity;

import java.util.Calendar;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.ListView;
import android.widget.TextView;

import com.Classis;

import config.Cons;

public class Caja extends Activity implements OnClickListener, OnDateChangeListener{

	static CalendarView cal;
	static TextView total_hoy;
	static Button b, bu;
	static ListView list;
	static String fechatitulada;
	public static HashMap<String, Double> history = new HashMap<String, Double>();
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.caja);
		cal = (CalendarView)findViewById(R.id.calendarView1);
		cal.setOnDateChangeListener(this);
		total_hoy=(TextView)findViewById(R.id.textView2);
		

		
		bu = (Button)findViewById(R.id.buttonresumen);

	    if(MainActivity.k.admin){
		bu = (Button)findViewById(R.id.buttonresumen);
		bu.setOnClickListener(this);
	    } else{
	    	bu.setEnabled(false);
	    }
		
		//Ajustes del formato de la fecha para corresponder con yyyymmdd
		int ddia, mmes;
		String diast="";
		String messt="";
		ddia = Calendar.getInstance().get(Calendar.DATE);
		if(ddia<10){
			diast = "0"+ddia;
		} else diast = String.valueOf(ddia);
	    
	    mmes = Calendar.getInstance().get(Calendar.MONTH)+1;
	    if(mmes<10){
	    	messt = "0"+mmes;
	    } else messt = String.valueOf(mmes);
	    
		fechatitulada = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))+messt+diast;
		
		history.put(fechatitulada, 0.00);
		
		total_hoy.setText(String.valueOf(history.get(fechatitulada)));	
		
	}

	@Override
	public void onSelectedDayChange(CalendarView view, int year, int month,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		
		
		//Ajustes del formato de la fecha para corresponder con yyyymmdd
		int mes = month+1;
		String mess ="";
		 if(mes<10){
			 mess = "0"+mes;
		 } else mess = String.valueOf(mes);
		 
		 int dia = dayOfMonth;
			String diaa ="";
			 if(dia<10){
				 diaa = "0"+dia;
			 } else diaa = String.valueOf(dia);
		
		
		fechatitulada = String.valueOf(year)+mess+diaa;
		
		//Paso de parametros a la clase que se comunica con el servidor
		Classis caj = new Classis();
		Object[] par = new Object[3];
		par[0]="get_caja";
		par[1]=Cons.idbar;
		par[2] = fechatitulada;
		caj.execute(par);
		
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
		String tehto = String.valueOf(history.get(fechatitulada));
		
		if(tehto==null){
			tehto="0.0";
		}
		total_hoy.setText(tehto);

		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			switch(arg0.getId()){
			
			    case R.id.buttonresumen:
			    	Intent res = new Intent(this, Resumen.class);
			    	startActivity(res);
			    	
			    	break;
			
				
			}
			
	}

	
		
		
		
	}

	
	
	
	
	

	
	
	


