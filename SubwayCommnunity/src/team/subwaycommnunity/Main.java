package team.subwaycommnunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar
				.newTab()
				.setText("Home")
				.setTabListener(
						new ActionBarTabListener<FragmentHome>(this, "home",
								FragmentHome.class)));
		actionBar.addTab(actionBar
				.newTab()
				.setText("Commnunity")
				.setTabListener(
						new ActionBarTabListener<FragmentCommunity>(this,
								"commnunity", FragmentCommunity.class)));
		actionBar.addTab(actionBar
				.newTab()
				.setText("이벤트웹")
				.setTabListener(
						new ActionBarTabListener<FragmentEventWeb>(this,
								"event", FragmentEventWeb.class)));
		actionBar.addTab(actionBar
				.newTab()
				.setText("이지트위터")
				.setTabListener(
						new ActionBarTabListener<FragmentEasyWeb>(this, "easy",
								FragmentEasyWeb.class)));
		actionBar.addTab(actionBar
				.newTab()
				.setText("바로가기")
				.setTabListener(
						new ActionBarTabListener<FragmentDeviceApp>(this,
								"deviceapp", FragmentDeviceApp.class)));
		if (savedInstanceState != null) {
			actionBar.setSelectedNavigationItem(savedInstanceState.getInt(
					"selectedTab", 0));
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("selectedTab", getSupportActionBar()
				.getSelectedNavigationIndex());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menuHistory:
			startActivity(new Intent(this, team.menuactivities.JasonTest.class));
			return true;
		case R.id.menuSetting:
			startActivity(new Intent(this, team.menuactivities.MenuSetting.class));
			return true;
		case R.id.menuHelp:
			
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

}
