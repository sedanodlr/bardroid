package data;

import in.MainActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import bardroid.core.R;


public class DelProd extends VerProd implements OnClickListener {
	
static int clicked_id;
private static int array[] = new int[100] ;
private static int cuantos;
	
	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delprod);
		cuantos = 0;
		

		ListView lista = (ListView)findViewById(android.R.id.list);
		Button elim = (Button) findViewById(R.id.elim);
		Button cancel = (Button) findViewById(R.id.cancel1);
		elim.setOnClickListener(this);
		cancel.setOnClickListener(this);
		ArrayAdapter<Producto> adapter = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_multiple_choice, MainActivity.res.getProdlist());
		lista.setAdapter(adapter);
		lista.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
		
		//Coger la lista de productos de login
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
				for(Producto p : MainActivity.res.getProdlist()){
					if(p.getId()==clicked_id+1){
						MainActivity.res.getProdlist().remove(p);
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
