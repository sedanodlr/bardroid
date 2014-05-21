package data;

import in.MainActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import bardroid.core.R;

public class EditCat extends AddCat implements OnClickListener{
	
	
	
	Categoria c;
	Button savebutton, discardbutton;
	EditText name;
	String nombre;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcat);
        
         savebutton = (Button)findViewById(R.id.save_button);
		savebutton.setOnClickListener(this);
		 discardbutton = (Button)findViewById(R.id.cancel_button);
		discardbutton.setOnClickListener(this);
		
		
		
		name = (EditText)findViewById(R.id.editname);

		
		
		c = new Categoria();
		for(Categoria c : MainActivity.res.getCatlist()){
			if(c.getIdcat()==ModCat.id_clicked+1){
				name.setText(c.getNombre());
			}
		}
//seleccionar el producto marcado antes en la otra lista (ModProd)

		
		
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
			for(Categoria c: MainActivity.res.getCatlist()){
			if(c.getIdcat()==ModCat.id_clicked+1){
				c.setNombre(nombre);
			}
			}finish();
			break;
		}
		
	}

}
