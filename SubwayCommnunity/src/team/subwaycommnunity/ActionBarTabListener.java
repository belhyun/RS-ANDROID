package team.subwaycommnunity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;

public class ActionBarTabListener<T extends Fragment> extends FragmentActivity
		implements ActionBar.TabListener {
	private final FragmentActivity mActivity;
	private final String mTag;
	private final Class<T> mClass;
	private Fragment mFragment;
	

	public ActionBarTabListener(FragmentActivity activity, String tag,
			Class<T> clz) {
		mActivity = activity;
		mTag = tag;
		mClass = clz;

		mFragment = mActivity.getSupportFragmentManager().findFragmentByTag(
				mTag);
		
		if (mFragment != null && !mFragment.isDetached()) {
			FragmentTransaction fragmentTransaction = mActivity
					.getSupportFragmentManager().beginTransaction();
			fragmentTransaction.detach(mFragment);
			fragmentTransaction.commit();
		}

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {

		// 여기도 해줘야겠습니다. 아직 미구현~_~
		
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
		if (mFragment == null) {
			mFragment = Fragment.instantiate(mActivity, mClass.getName(), null);
			fragmentTransaction.add(android.R.id.content, mFragment, mTag);
		} else {
			fragmentTransaction.attach(mFragment);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
		if (mFragment != null){
			fragmentTransaction.detach(mFragment);
		}
	}
}
