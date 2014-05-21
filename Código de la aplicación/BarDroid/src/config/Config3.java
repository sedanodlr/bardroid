package config;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;

public class Config3  extends Activity implements OnClickListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.config_3_ask);
		
		
		
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(this);
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.button3:
			Intent custom = new Intent(this, Config4.class);
			startActivity(custom);
			break;
			
		case R.id.button1:
			Intent customcat = new Intent(this, Config41.class);
			startActivity(customcat);
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.navigator, menu);
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.nex:
	    	Intent next = new Intent(this, Config35.class);
			startActivity(next);
			break;
			
	    case R.id.pre:
	    	finish();
	    	break;
	    }
		return false;
	
	    }

}