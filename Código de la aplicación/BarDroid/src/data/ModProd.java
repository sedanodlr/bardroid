package data;

import in.MainActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import bardroid.core.R;

public class ModProd extends VerProd {
	

public static int id_clicked;
	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modprod);
		
		
	//Coger la lista de productos del main

		ListView lista = (ListView)findViewById(android.R.id.list);
		ArrayAdapter<Producto> adapter = new ArrayAdapter<Producto>(getApplicationContext(), 
				android.R.layout.simple_list_item_2, android.R.id.text1, MainActivity.res.getProdlist()) {
			  @Override
			  public View getView(int position, View convertView, ViewGroup parent) {
			    View view = super.getView(position, convertView, parent);
			    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
			    TextView text2 = (TextView) view.findViewById(android.R.id.text2);

			    text1.setText(MainActivity.res.getProdlist().get(position).getNombreProd());
			    text2.setText(MainActivity.res.getProdlist().get(position).getPrecioProd()+"E");
			    return view;
			  }
			};
			lista.setAdapter(adapter);
		
	}
	
	
	protected void onListItemClick(ListView l, View v, int position, long id){
		
			id_clicked = (int)id;
			
			Intent ed = new Intent(this, EditProd.class);
			startActivity(ed);
			finish();
	}
	
	public void onResume(Bundle savedInstanceState) {
		this.onCreate(savedInstanceState);
	}
	

}
