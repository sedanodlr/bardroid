package bardroid.core;

import in.MainActivity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.Classis;
import com.Printer;

import config.Cons;
import data.Categoria;
import data.Producto;


public class Lista extends Activity implements OnClickListener{

	static private Lista barra = null;
	int id;
	float precio_final;
	protected ImageButton add, sub, move, close;
	protected ListView lista, lista2;
	protected TextView tex;
	protected ArrayAdapter<Producto> adapter;
	protected ArrayAdapter<Producto> adapter2;
	public static Intent i = null;
	double total = 0;
	
	static public Lista getListaBarra(){
		if(Lista.barra==null) Lista.barra = new Lista();
		return Lista.barra;
		
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.lista);
	
		Spinner cat;
		
		i = getIntent();
		
		tex = (TextView)findViewById(R.id.texttotalticket);
		
		add = (ImageButton)findViewById(R.id.addtolista);
		add.setOnClickListener(this);
		sub = (ImageButton)findViewById(R.id.subfromlista);
		sub.setOnClickListener(this);
		move = (ImageButton)findViewById(R.id.movetomesa);
		move.setOnClickListener(this);
		close = (ImageButton)findViewById(R.id.closelista);
		close.setOnClickListener(this);
		
		cat =(Spinner)findViewById(R.id.spinner1);
		
		
		
		ArrayList<String> nomcats = new ArrayList<String>();
		
		for(Categoria c : MainActivity.res.getCatlist()){
			nomcats.add(c.getNombre());
		}
		
		
		
		
	
		ArrayAdapter<String> adapters = new ArrayAdapter<String>(getApplicationContext(), 
				android.R.layout.simple_list_item_1, nomcats);
	
		adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cat.setAdapter(adapters);


		lista2 = (ListView)findViewById(R.id.listaactuala);
		lista = (ListView)findViewById(R.id.listaprodss);

		
		
		
		
		
		
		
		
		if(Salon.maps.get(String.valueOf(Salon.id_clicked))!=null){
			adapter2 = new ArrayAdapter<Producto>(this,
					android.R.layout.simple_list_item_multiple_choice,
					Salon.maps.get(String.valueOf(Salon.id_clicked)));
		}else{
			adapter2 = new ArrayAdapter<Producto>(this,
					android.R.layout.simple_list_item_multiple_choice,
					new ArrayList<Producto>());
		}
		lista2.setAdapter(adapter2);
		
		ArrayList<Producto> pro1 = new ArrayList<Producto>();
		for(Producto jar : MainActivity.res.getProdlist()){
			if(jar.getCatego()==1){
				pro1.add(jar);
			}
		}
		
		adapter = new ArrayAdapter<Producto>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, pro1);
		lista.setAdapter(adapter);
		
		this.total = 0.0;
		
		
		cat.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				

				
				ArrayList<Producto> prodcatego = new ArrayList<Producto>();
				int dis_id = arg2+1;
				for(Producto p1 : MainActivity.res.getProdlist()){
					if(p1.getCatego()==dis_id){
						prodcatego.add(p1);
					}
				
					
					
				}
				adapter = new ArrayAdapter<Producto>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, prodcatego);
				lista.setAdapter(adapter);
				adapter.notifyDataSetChanged();

				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			});
		
		
	}
	
	

    
	
	public void onListItemClick(ListView parent, View view, int position,
			long id) {

		if (parent.getId() == R.id.listaprodss) {
			// Lista de productos, enable el annadir, disable los otros
			this.add.setClickable(true);
			this.sub.setClickable(false);
			this.move.setClickable(false);
			this.close.setClickable(false);

		}
		else if (parent.getId() == R.id.listaactuala) {
			// Lista actual, enable los otros 3, disable annadir
			this.add.setClickable(false);
			this.sub.setClickable(true);
			this.move.setClickable(true);
			this.close.setClickable(true);

			// Save id's again, somewhere else
		}
	}
	
	public void onClick(View v) {
		int len;
		SparseBooleanArray checked;
		switch (v.getId()) {
			case R.id.addtolista:
				len = lista.getCount();
				checked = lista.getCheckedItemPositions();
				for (int i = 0; i < len; i++){
					if (checked.get(i)) {
						Producto p = (Producto) lista.getItemAtPosition(i);
						adapter2.add(p);
						this.total += p.getPrecioProd();
					}
					
				}
				uncheckList(lista);
				uncheckList(lista2);
				adapter2.notifyDataSetChanged();
				
				this.tex.setText(String.format("%.2f", total));
				
				break;
			case R.id.subfromlista:
				len = lista2.getCount();
				checked = lista2.getCheckedItemPositions();
				for (int i = 0; i < len; i++){
					if (checked.get(i)) {
						Producto p = adapter2.getItem(i);
						adapter2.remove(p);
						this.total -= p.getPrecioProd();
					}
				}
				uncheckList(lista2);
				adapter2.notifyDataSetChanged();
				this.tex.setText(String.format("%.2f", total));

				break;
			case R.id.movetomesa:
	
				break;
			case R.id.closelista:
				//El comportamiento por defecto de este boton es crear un ticket con toda la
				//lista y vaciarla
				if(adapter2.isEmpty()){
					
					break;
				}
				
				
				
				Ticket t = new Ticket(Salon.id_clicked, adapter2);
				
				adapter2.clear();
				
				
				
				uncheckList(lista2);
				adapter2.notifyDataSetChanged();
				this.total = 0;
				this.tex.setText(String.format("%.2f", total));

				Printer p = new Printer();
				p.execute(t);
				break;
			}

	}

	private void uncheckList(ListView lista) {
		for(int i=0;i<lista.getCount();i++){
			lista.setItemChecked(i, false);
		}
	}
	
	@Override
	public void onPause(){
		if((Salon.id_clicked!=Salon.barra.getId())){
			if(adapter2.isEmpty()){
				Salon.changeToFree(Salon.id_clicked);
			}
			else{
				Salon.changeToBusy(Salon.id_clicked);
			}
		}
		TempList t = new TempList(Salon.id_clicked, adapter2);
		Salon.maps.put(String.valueOf(Salon.id_clicked), t);
		
		
		
		
		super.onPause();
	}
	
	@Override
	public void onStop(){
		if((Salon.id_clicked!=Salon.barra.getId())){
			if(adapter2.isEmpty()){
				Salon.changeToFree(Salon.id_clicked);
			}
			else{
				Salon.changeToBusy(Salon.id_clicked);
			}
		}
		TempList t = new TempList(Salon.id_clicked, adapter2);
		Salon.maps.put(String.valueOf(Salon.id_clicked), t);
		
		
		
		
		super.onStop();
	}
	
	
	@Override
	public void onBackPressed(){
		if((Salon.id_clicked!=Salon.barra.getId())){
			if(adapter2.isEmpty()){
				Salon.changeToFree(Salon.id_clicked);
			}
			else{
				Salon.changeToBusy(Salon.id_clicked);
				
			}
		}
		
		TempList t = new TempList(Salon.id_clicked, adapter2);
		Salon.maps.put(String.valueOf(Salon.id_clicked), t);
		
		
		
		//Esta es la llamada al servidor con el objeto JSON 
		//que se ha rellenado en templist
		
		Classis ins = new Classis();
		Object[] par = new Object[4];
		par[0]="update_sala";
		par[1]=Cons.idbar;
		par[2]=Salon.id_clicked;
		par[3]= t.objetojson.toString();
		ins.execute(par);
		
		
		
		super.onBackPressed();
		
	}

	

	
	
}

