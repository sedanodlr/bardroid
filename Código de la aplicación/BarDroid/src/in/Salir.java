package in;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;
public class Salir extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.salir);
	
	Button si = (Button)findViewById(R.id.si);
	si.setOnClickListener(this);
	Button no = (Button)findViewById(R.id.no);
	no.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.si:
				MainActivity.setSaliendo(true);
				finish();
				break;
		
			case R.id.no:
				finish();
				break;
		}
	}

}
