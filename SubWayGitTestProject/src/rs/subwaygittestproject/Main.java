package rs.subwaygittestproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.testlayout);

		findViewById(R.id.button1).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Toast.makeText(getBaseContext(), "!!",
								Toast.LENGTH_SHORT).show();

					}
				});

	}
}
