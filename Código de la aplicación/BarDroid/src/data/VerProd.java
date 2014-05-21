package data;

import in.MainActivity;
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import bardroid.core.R;

@SuppressLint("ParserError")
public class VerProd extends ListActivity {


	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verprod);
		
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
	
	
	public void onResume(Bundle savedInstanceState) {
		this.onCreate(savedInstanceState);
	}
	


}
