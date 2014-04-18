package team.menuactivities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import team.subwaycommnunity.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JasonTest extends Activity {

	Button jsonBtn;
	TextView jsonText;

	final String jsonString = "[{\"id\":\"오유석\",\"tel\":\"010-1111-2222\"},"
			+ "{\"id\":\"오유석2\",\"tel\":\"010-3333-4444\"},"
			+ "{\"id\":\"오유석3\",\"tel\":\"010-5555-6666\"}]";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jason_test);

		jsonBtn = (Button) findViewById(R.id.jasonTestButton);
		jsonText = (TextView) findViewById(R.id.jasonTestTextView);
		jsonBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				String resultStr = "";

				try {
					JSONArray jArr = new JSONArray(jsonString);

					for (int i = 0; i < jArr.length(); i++) {
						JSONObject jObj = jArr.getJSONObject(i);

						resultStr += String.format("아이디 : %s   전화번호 : %s\n",
								jObj.getString("id"), jObj.getString("tel"));
					}
					jsonText.setText(resultStr);
				} catch (JSONException e) {
					Toast.makeText(JasonTest.this, e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
		});
//jkljkljk
	}//

}
