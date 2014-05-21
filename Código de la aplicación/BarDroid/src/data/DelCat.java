package data;

import in.MainActivity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import bardroid.core.R;

public class DelCat extends VerCat implements OnClickListener {
	
static int clicked_id;
private static int array[] = new int[100] ;
private static int cuantos;
	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delcat);
		cuantos = 0;
		

		ListView lista = (ListView)findViewById(android.R.id.list);
		Button elim = (Button) findViewById(R.id.elim);
		Button cancel = (Button) findViewById(R.id.cancel1);
		elim.setOnClickListener(this);
		cancel.setOnClickListener(this);
		ArrayList<String> noca = new ArrayList<String>();
		for(Categoria c: MainActivity.res.getCatlist()){
			noca.add(c.getNombre());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, noca);
		lista.setAdapter(adapter);
		lista.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		
		array[cuantos] = position;
		cuantos++;
		
		
		
		
	}
	
	
	public void onClick(View v){
		
		switch(v.getId()){
		
		case R.id.elim:
			
			for(int i = 0; i<cuantos;i++){
				clicked_id = array[i];
				for(Categoria c : MainActivity.res.getCatlist()){
					if(c.getIdcat()==clicked_id+1){
						for(Producto pp : MainActivity.res.getProdlist()){
							if(pp.getCatego()==c.getIdcat()){
								MainActivity.res.getProdlist().remove(pp);
							}
						}
						MainActivity.res.getCatlist().remove(c);
					}
				}
			}
			
			finish();
			
		case R.id.cancel1:
			finish();
			break;
		
		}
		
	}
}
