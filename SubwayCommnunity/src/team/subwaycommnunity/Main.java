package team.subwaycommnunity;

import team.serverdata.JSONsfromServer;
import team.serverdata.JSONsfromServer.SubWayLine;
import team.serverdata.JSONsfromServer.SubWayRegion;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main extends ActionBarActivity {

	static ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Async().execute();
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if(SubWayLine.mLine == null){
					Toast.makeText(getApplicationContext(), "네트워크 문제입니다....", Toast.LENGTH_SHORT).show();
					finish();
				}
				if(SubWayRegion.mRegionName == null){
					Toast.makeText(getApplicationContext(), "네트워크 문제입니다....", Toast.LENGTH_SHORT).show();
					finish();
				}
				
			}
		}, 2000);
		
		
		setActionTab(savedInstanceState);

	}
	
	
	class Async extends AsyncTask<String, String, String>{
		@Override
		protected String doInBackground(String... params) {
			
			new JSONsfromServer();
			return null;
		}
		
	}
	
	

	void setActionTab(Bundle savedInstanceState) {
		actionBar = getSupportActionBar();
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
						new ActionBarTabListener<FragmentWeb>(this, "event",
								FragmentWeb.class)));
		actionBar.addTab(actionBar
				.newTab()
				.setText("이지트위터")
				.setTabListener(
						new ActionBarTabListener<FragmentWeb>(this, "easy",
								FragmentWeb.class)));
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
			startActivity(new Intent(this,
					team.menuactivities.MenuSetting.class));
			return true;
		case R.id.menuHelp:

			return true;

		}

		return super.onOptionsItemSelected(item);
	}

	boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce
				|| getSupportFragmentManager().getBackStackEntryCount() != 0) {
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면, 앱이 종료됩니다", Toast.LENGTH_SHORT)
				.show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

}
