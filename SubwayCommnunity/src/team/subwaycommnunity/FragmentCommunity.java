package team.subwaycommnunity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class FragmentCommunity extends Fragment {

	public LinearLayout mSelectRegionContainer;
	public LinearLayout mSelectLineContainer;
	public LinearLayout mFavoriteContainer;
	private Button[] mFavoriteBtns;
	private Button mAddBtn;
	private int mFavoriteCnt;

	private OnClickListener mFavoriteBtnOCL = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			/* 게시판으로 고고!! */

		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater
				.inflate(R.layout.fragment_community, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mFavoriteCnt = 5;
		mFavoriteContainer = (LinearLayout) getView().findViewById(
				R.id.communityFavorites);
		mSelectRegionContainer = (LinearLayout) getView().findViewById(
				R.id.communitySelectRegion);
		mSelectLineContainer = (LinearLayout) getView().findViewById(
				R.id.communitySelectLine);

		mFavoriteBtns = new Button[mFavoriteCnt];
		mAddBtn = new Button(getActivity());

		/*
		 * 여기에 통신모듈!
		 */

		for (int i = 0; i < mFavoriteCnt; i++) {
			mFavoriteBtns[i] = new Button(getActivity());
			mFavoriteBtns[i].setText("즐겨찾기 " + (i + 1));
			mFavoriteBtns[i].setGravity(Gravity.CENTER);
			mFavoriteBtns[i].setOnClickListener(mFavoriteBtnOCL);
			mFavoriteContainer.addView(mFavoriteBtns[i]);

		}

		mAddBtn.setText("+");
		mAddBtn.setGravity(Gravity.CENTER);
		mFavoriteContainer.addView(mAddBtn);
		mAddBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {

				mFavoriteContainer.setVisibility(LinearLayout.GONE);
				mSelectRegionContainer.setVisibility(LinearLayout.VISIBLE);

				// 여기는 레이아웃 겹치는걸루 가실게요~!

			}
		});

	}

}
