package team.subwaycommnunity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FragmentCommunity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_community_container,
				container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.add(R.id.communityContainer, new FragmentFravorites());
		transaction.commit();

	}
	// 다른 탭 갔다가 다시 오면 기존 레이아웃 중복 생성 되는 문제 있음.
	

	public static class FragmentFravorites extends Fragment {

		LinearLayout mLinearLayout;
		int mCount;
		Button[] mFavoriteButtons;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_community_favorites,
					container, false);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			mLinearLayout = (LinearLayout) getView().findViewById(
					R.id.communityFavorites);
			mCount = 8;
			setFavoritesBtns(getActivity(), mLinearLayout, mCount);
			Button lmAddBtn = new Button(getActivity());
			lmAddBtn.setText("+");
			lmAddBtn.setGravity(Gravity.CENTER);
			lmAddBtn.setOnClickListener(AddOCL);
			mLinearLayout.addView(lmAddBtn);
		}

		void setFavoritesBtns(FragmentActivity fAct, LinearLayout layout,
				int count) {
			mFavoriteButtons = new Button[count];
			for (int i = 0; i < count; i++) {
				mFavoriteButtons[i] = new Button(fAct);
				mFavoriteButtons[i].setText("즐겨찾기" + (i + 1));
				mFavoriteButtons[i].setGravity(Gravity.CENTER);
				layout.addView(mFavoriteButtons[i]);
				mFavoriteButtons[i].setOnClickListener(OCL);
				mFavoriteButtons[i].setOnLongClickListener(LOCL);
			}

		}

		private OnClickListener AddOCL = new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.replace(R.id.communityContainer,
						new FragmentRegion());
				transaction.addToBackStack(null);
				transaction.commit();

			}
		};

		private OnLongClickListener LOCL = new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {

				Toast.makeText(getActivity(),
						((Button) v).getText().toString() + "LongClicked",
						Toast.LENGTH_SHORT).show();

				return true;
			}
		};
		private OnClickListener OCL = new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getActivity(),
						((Button) v).getText().toString(), Toast.LENGTH_SHORT)
						.show();

			}
		};

	}

	public static class FragmentRegion extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_community_region,
					container, false);
		}

	}

	public static class FragmentLine extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_community_line,
					container, false);
		}
	}

}
