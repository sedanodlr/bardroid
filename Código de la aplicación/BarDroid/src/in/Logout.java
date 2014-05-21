package in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;

public class Logout extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.logout_dialog);
	
		Button si = (Button)findViewById(R.id.si);
		si.setOnClickListener(this);
		Button no = (Button)findViewById(R.id.no);
		no.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.si:
			Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
			break;
		
		case R.id.no:
			finish();
			break;
		
		}
		
	}
		
		
	

	

}
