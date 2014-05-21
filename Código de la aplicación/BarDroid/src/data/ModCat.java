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

public class ModCat extends VerCat {
	

public static int id_clicked;
	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modcat);
		
		
	//Coger la lista de productos del login

		ListView lista = (ListView)findViewById(android.R.id.list);
		ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(getApplicationContext(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, MainActivity.res.getCatlist()) {
			  @Override
			  public View getView(int position, View convertView, ViewGroup parent) {
			    View view = super.getView(position, convertView, parent);
			    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

			    text1.setText(MainActivity.res.getCatlist().get(position).getNombre());
			    return view;
			  }
			};
			lista.setAdapter(adapter);
		
	}
	
	
	protected void onListItemClick(ListView l, View v, int position, long id){
		
			id_clicked = position;
			
			Intent ed = new Intent(this, EditCat.class);
			startActivity(ed);
			finish();
	}
	
	public void onResume(Bundle savedInstanceState) {
		this.onCreate(savedInstanceState);
	}
	

}