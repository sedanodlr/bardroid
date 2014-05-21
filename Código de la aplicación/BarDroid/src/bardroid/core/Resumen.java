package bardroid.core;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

import com.Classis;

import config.Cons;

public class Resumen extends Activity implements OnClickListener, OnDateChangedListener {
	
	static DatePicker inicio;
	static DatePicker fin;
	static Button si, no;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.resumen);
	
		inicio = (DatePicker)findViewById(R.id.datePicker1);
		inicio.setCalendarViewShown(false);
		fin = (DatePicker)findViewById(R.id.datePicker2);
		fin.setCalendarViewShown(false);
		si = (Button)findViewById(R.id.button1);
		si.setOnClickListener(this);
		no = (Button)findViewById(R.id.button2);
		no.setOnClickListener(this);
	
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
			case R.id.button1:
				
				Classis resu = new Classis();
				Object[] par = new Object[3];
				par[0]="resumen";
				par[1]=Cons.idbar;
				
				int mesinicio = inicio.getMonth()+1;
				String mesiniciol ="";
				 if(mesinicio<10){
					 mesiniciol = "0"+mesinicio;
				 } else mesiniciol = String.valueOf(mesinicio);
				 
				 int diainicio = inicio.getDayOfMonth();
					String diainiciol ="";
					 if(diainicio<10){
						 diainiciol = "0"+diainicio;
					 } else diainiciol = String.valueOf(diainicio);
					 
					 int mesfinal = fin.getMonth()+1;
						String mesfinall ="";
						 if(mesfinal<10){
							 mesfinall = "0"+mesinicio;
						 } else mesfinall = String.valueOf(mesfinal);
						 
						 int diafinal = fin.getDayOfMonth();
							String diafinall ="";
							 if(diafinal<10){
								 diafinall = "0"+mesinicio;
							 } else diafinall = String.valueOf(diafinal);
				 
				
				String fechai=inicio.getYear()+mesiniciol+diainiciol;
				String fechaf=fin.getYear()+mesfinall+diafinall;
				JSONObject jurr = new JSONObject();
			try {
				jurr.put("fechafin", fechaf);
				jurr.put("fechaini", fechai);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				par[2] = jurr.toString();
				resu.execute(par);
				//profit
				Toast.makeText(getApplicationContext(), "Se ha enviado el resumen solicitado", Toast.LENGTH_SHORT).show();
				finish();
				break;
		
			case R.id.button2:
				finish();
				break;
			
			default:
				break;
		}
		
	}



	@Override
	public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

}
