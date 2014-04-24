package team.account;

import team.subwaycommnunity.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewAccountActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){ 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newaccount);
		
		findViewById(R.id.tmpNewAccountSuccessBtn).setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finishActivity(10011);
				finish();
		
			}
		});
	}

}
