package bardroid.core;

import java.util.Calendar;

import android.widget.ArrayAdapter;

import com.Classis;

import config.Cons;
import data.Producto;

public class Ticket extends TempList{

	public String titulo;
	private double total=0;
	Calendar rightNow = Calendar.getInstance();

	@SuppressWarnings("deprecation")
	Ticket(int id, ArrayAdapter<Producto> adap) {
		super(id, adap);
		// TODO Auto-generated constructor stub
		this.titulo = String.valueOf(rightNow.get(Calendar.DATE)) +"/"+ 
		String.valueOf(rightNow.get(Calendar.MONTH)) +"/"
		+ String.valueOf(rightNow.get(Calendar.YEAR)) +"-"
		+String.valueOf(rightNow.get(Calendar.HOUR))+":"+
		String.valueOf(rightNow.get(Calendar.MINUTE))+":"+
		String.valueOf(rightNow.get(Calendar.SECOND));
		
	
		Classis inso = new Classis();
		Object[] par = new Object[4];
		par[0]="update_caja";
		par[1]=Cons.idbar;
		par[2] = id;
		inso.execute(par);		
	}
	
	private void setTotal(double total) {
		this.total=total;
	}

	@Override
	public String toString(){
		return titulo;
	}

	public double getTotal() {
		return total;
	}

	

}
