package data;

import in.Login;
import in.MainActivity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import bardroid.core.R;
public class EditProd extends AddProd implements OnClickListener{
	
	
	
	Producto p;
	Button savebutton, discardbutton;
	EditText name, price;
	Spinner cat;
	String nombre, precio;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprod);
        
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
		
		
		name = (EditText)findViewById(R.id.editname);
		price = (EditText)findViewById(R.id.editprecio);

		
		
		p = new Producto();
//seleccionar el producto marcado antes en la otra lista (ModProd)
		for(Producto p : MainActivity.res.getProdlist()){
			
			if(p.getCatego()==ModProd.id_clicked+1){
				name.setText(p.getNombreProd());
				price.setText(String.valueOf(p.getPrecioProd()));
			}
		}
		

		
		
		//HACER UN GET SINGLE PROD PARA PRECARGAR LOS DATOS Y SABER LO QUE ESTAMOS MODIFICANDO
		
        
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.cancel_button:
			finish();
			break;
		case R.id.save_button:
			nombre = name.getText().toString();
			precio = price.getText().toString();
			p.setNombreProd(nombre);
			p.setPrecioProd(Float.parseFloat(precio));
			p.setCatego(idcat);
			Login.prods.add(p);
			p.setId(MainActivity.res.getProdlist().indexOf(p)+1);
			finish();
			break;
		}
		
	}

}
