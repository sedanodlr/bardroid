package data;

import in.MainActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import bardroid.core.R;

public class AddCat  extends Activity implements OnClickListener {

	
	Button savebutton, discardbutton;
	EditText name;
	String nombre;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcat);
        
         savebutton = (Button)findViewById(R.id.save_button);
		savebutton.setOnClickListener(this);
		 discardbutton = (Button)findViewById(R.id.cancel_button);
		discardbutton.setOnClickListener(this);
		 
		

		
		
        
	}
	
	public void onClick(View v){
		
		
		switch(v.getId()){
		case R.id.cancel_button:
			finish();
			break;
			
			
		case R.id.save_button:
			name = (EditText) findViewById(R.id.editname);
			nombre = name.getText().toString();
			Categoria c = new Categoria();
			c.setNombre(nombre);
			MainActivity.res.getCatlist().add(c);
			c.setIdcat((MainActivity.res.getCatlist().indexOf(c))+1);


			
			finish();
			
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


}
