package data;

import in.MainActivity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import bardroid.core.R;

public class VerCat  extends ListActivity {


	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vercat);
		
		ListView lista = (ListView)findViewById(android.R.id.list);
		ArrayList<String> nomcat = new ArrayList<String>();
		for(Categoria c : MainActivity.res.getCatlist()){
			nomcat.add(c.getNombre());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), 
				android.R.layout.simple_list_item_1, nomcat);
			lista.setAdapter(adapter);
	}
	
	
	public void onResume(Bundle savedInstanceState) {
		this.onCreate(savedInstanceState);
	}
	


}
