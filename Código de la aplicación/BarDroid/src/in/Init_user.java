package in;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bardroid.core.R;

public class Init_user extends Activity implements OnClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.init_user);
		
		
		
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.button2:
				//WiFi
				Intent join = new Intent(this, Join.class);
				startActivity(join);
				break;
		
				
		}
	}

}

