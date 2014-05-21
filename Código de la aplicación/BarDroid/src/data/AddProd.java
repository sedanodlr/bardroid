package data;

import in.MainActivity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import bardroid.core.R;
public class AddProd extends Activity implements OnClickListener, OnItemSelectedListener {

	
	Button savebutton, discardbutton;
	EditText name, price;
	String nombre, precio;
	int idcat;
	Spinner cat;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addprod);
        
         savebutton = (Button)findViewById(R.id.save_button);
		savebutton.setOnClickListener(this);
		 discardbutton = (Button)findViewById(R.id.cancel_button);
		discardbutton.setOnClickListener(this);
		cat = (Spinner)findViewById(R.id.spinner1);
		
		ArrayList<String> nomcats = new ArrayList<String>();
		for(Categoria c : MainActivity.res.getCatlist()){
			nomcats.add(c.getNombre());
		}
		
		
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), 
				android.R.layout.simple_list_item_1, nomcats);
	
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cat.setAdapter(adapter);

		
		
        
	}
	
	
	
	
	public void onNothingSelected(AdapterView<?> parent) {
        this.idcat=-1;
    }
	
	public void onClick(View v){
		
		
		switch(v.getId()){
		case R.id.cancel_button:
			finish();
			break;
			
			
		case R.id.save_button:
			
			if(idcat==-1){
				Toast.makeText(this, "Debe seleccionar una categoria", Toast.LENGTH_SHORT).show();
				break;
			}else{
			
			name = (EditText) findViewById(R.id.editname);
			price = (EditText) findViewById(R.id.editprecio);
			nombre = name.getText().toString();
			precio = price.getText().toString();
			Producto p = new Producto();
			p.setNombreProd(nombre);
			p.setPrecioProd(Float.parseFloat(precio));
			String nomca = (String)cat.getSelectedItem();
			for(Categoria c : MainActivity.res.getCatlist()){
				if(c.getNombre().equalsIgnoreCase(nomca)){
					idcat = c.getIdcat();
				}
			}
			p.setCatego(idcat);
			MainActivity.res.getProdlist().add(p);			
			finish();
			}
			break;
		
		}
		
	}
	
	
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		this.idcat = arg2+1;
		
	}


}
