package team.menuactivities;

import team.subwaycommnunity.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MenuSetting extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.activity_setting);
	}

}
