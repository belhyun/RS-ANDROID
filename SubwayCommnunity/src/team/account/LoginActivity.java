package team.account;

import team.subwaycommnunity.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		findViewById(R.id.tmpLoginBtn).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View v) {
						finish();
			
					}
				});
		
		
		findViewById(R.id.tmpNewAccountBtn).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View v) {
						startActivity(new Intent(LoginActivity.this, NewAccountActivity.class));
					}
				});
	}

}
