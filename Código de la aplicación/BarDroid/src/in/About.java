package in;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import bardroid.core.R;


	public class About extends Activity implements OnClickListener {
		@Override
		protected void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState); 
			setContentView(R.layout.about);
			
			View returnButton = findViewById(R.id.return_button);	
			returnButton.setOnClickListener(this);
		}
		
		
		
		public void onClick(View v) {	
			
			switch (v.getId()) { 
			
				case R.id.return_button:
					//Volver al menu principal?
					finish();
					break;
			}
		}
	}


