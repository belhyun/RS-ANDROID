package team.subwaycommnunity;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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

			LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			param.bottomMargin = 10;
			mLinearLayout = (LinearLayout) getView().findViewById(
					R.id.communityFavorites);
			mCount = 8;
			setFavoritesBtns(getActivity(), mLinearLayout, mCount, param);
			Button lmAddBtn = new Button(getActivity());
			lmAddBtn.setText("+");
			lmAddBtn.setGravity(Gravity.CENTER);
			lmAddBtn.setOnClickListener(AddOCL);
			lmAddBtn.setBackgroundResource(R.drawable.roundedbtn);
			lmAddBtn.setLayoutParams(param);
			lmAddBtn.setTextColor(Color.WHITE);
			mLinearLayout.addView(lmAddBtn);
		}

		void setFavoritesBtns(FragmentActivity fAct, LinearLayout layout,
				int count, LinearLayout.LayoutParams param) {

			mFavoriteButtons = new Button[count];
			for (int i = 0; i < count; i++) {
				mFavoriteButtons[i] = new Button(fAct);
				mFavoriteButtons[i].setText("즐겨찾기" + (i + 1));
				mFavoriteButtons[i].setGravity(Gravity.CENTER);
				layout.addView(mFavoriteButtons[i]);
				mFavoriteButtons[i].setOnClickListener(OCL);
				mFavoriteButtons[i].setOnLongClickListener(LOCL);
				mFavoriteButtons[i]
						.setBackgroundResource(R.drawable.roundedbtn);
				mFavoriteButtons[i].setLayoutParams(param);
				mFavoriteButtons[i].setTextColor(Color.WHITE);

			}

		}

		private OnClickListener AddOCL = new OnClickListener() {

//			boolean session = false;

			@Override
			public void onClick(View v) {

				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.remove(getFragmentManager().findFragmentById(
						R.id.communityContainer));
				transaction.add(R.id.communityContainer, new FragmentRegion());
				transaction.addToBackStack(null);
				transaction.commit();

				getActivity().startActivityForResult((
						new Intent(getActivity(),
								team.account.LoginActivity.class)),10011);

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

				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				transaction.remove(getFragmentManager().findFragmentById(
						R.id.communityContainer));
				transaction.add(R.id.communityContainer, new FragmentBoard(),
						((Button) v).getText().toString());
				transaction.addToBackStack(null);
				transaction.commit();

			}
		};

	}

	public static class FragmentRegion extends Fragment {

		Button mSeoulBtn;
		Button mPusanBtn;
		Button mDaeguBtn;
		Button mGwangjuBtn;
		Button mDaejeonBtn;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_community_region,
					container, false);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			setButtons();

		}

		void setButtons() {
			LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			param.weight = 1;
			param.bottomMargin = 10;

			mSeoulBtn = (Button) getView().findViewById(R.id.regionSeoul);
			mPusanBtn = (Button) getView().findViewById(R.id.regionBusan);
			mDaeguBtn = (Button) getView().findViewById(R.id.regionDaegu);
			mGwangjuBtn = (Button) getView().findViewById(R.id.regionGwangju);
			mDaejeonBtn = (Button) getView().findViewById(R.id.regionDaejeon);

			mSeoulBtn.setLayoutParams(param);
			mPusanBtn.setLayoutParams(param);
			mDaeguBtn.setLayoutParams(param);
			mGwangjuBtn.setLayoutParams(param);
			mDaejeonBtn.setLayoutParams(param);

			mSeoulBtn.setBackgroundResource(R.drawable.roundedbtn);
			mPusanBtn.setBackgroundResource(R.drawable.roundedbtn);
			mDaeguBtn.setBackgroundResource(R.drawable.roundedbtn);
			mGwangjuBtn.setBackgroundResource(R.drawable.roundedbtn);
			mDaejeonBtn.setBackgroundResource(R.drawable.roundedbtn);

			mSeoulBtn.setOnClickListener(OCL);
			mPusanBtn.setOnClickListener(OCL);
			mDaeguBtn.setOnClickListener(OCL);
			mGwangjuBtn.setOnClickListener(OCL);
			mDaejeonBtn.setOnClickListener(OCL);

		}

		OnClickListener OCL = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.regionSeoul:
					FragmentTransactions(v);
					break;
				case R.id.regionBusan:
					FragmentTransactions(v);
					break;
				case R.id.regionDaegu:
					FragmentTransactions(v);
					break;
				case R.id.regionGwangju:
					FragmentTransactions(v);
					break;
				case R.id.regionDaejeon:
					FragmentTransactions(v);
					break;

				}

			}
		};

		void FragmentTransactions(View v) {
			FragmentTransaction transaction = getFragmentManager()
					.beginTransaction();
			transaction.remove(getFragmentManager().findFragmentById(
					R.id.communityContainer));
			transaction.add(R.id.communityContainer, new FragmentLine(),
					((Button) v).getTag().toString());
			transaction.addToBackStack(null);
			transaction.commit();
		}

	}

	public static class FragmentLine extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			if (getTag().compareTo("seoul") == 0) {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);
			} else if (getTag().compareTo("busan") == 0) {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);

			} else if (getTag().compareTo("daegu") == 0) {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);

			} else if (getTag().compareTo("gwangju") == 0) {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);

			} else if (getTag().compareTo("daejeon") == 0) {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);

			} else {
				return inflater.inflate(R.layout.fragment_community_line,
						container, false);
			}

		}

		String[] mStrSeoulLine = { "1호선", "2호선", "3호선", "4호선", "5호선", "6호선",
				"7호선", "8호선", "9호선", "수인선", "경춘선", "경의선", "중앙선", "의정부", "분당선",
				"신분당", "공항", "인천", "에버라인" };
		String[] mStrBusanLine = { "1호선", "2호선", "3호선", "4호선", "부산-김해경전철" };
		String[] mStrDaeguLine = { "1호선", "2호선" };
		String[] mStrGwangjuLine = { "1호선" };
		String[] mStrDaejeonLine = { "1호선" };

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			if (getTag().compareTo("seoul") == 0) {
				setLineListView(mStrSeoulLine);
			} else if (getTag().compareTo("busan") == 0) {
				setLineListView(mStrBusanLine);
			} else if (getTag().compareTo("daegu") == 0) {
				setLineListView(mStrDaeguLine);
			} else if (getTag().compareTo("gwangju") == 0) {
				setLineListView(mStrGwangjuLine);
			} else if (getTag().compareTo("daejeon") == 0) {
				setLineListView(mStrDaejeonLine);
			}

			// 이건 급한 불 끄고 나서 나중에...;;
			// if (getTag().compareTo("seoul") == 0) {
			// LinearLayout l = (LinearLayout) getView().findViewById(
			// R.id.communitySelectRegion);
			// LinearLayout ll = new LinearLayout(getActivity());
			//
			// LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
			// LinearLayout.LayoutParams.MATCH_PARENT,
			// LinearLayout.LayoutParams.WRAP_CONTENT);
			//
			// LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
			// LinearLayout.LayoutParams.WRAP_CONTENT,
			// LinearLayout.LayoutParams.WRAP_CONTENT);
			//
			// ll.setLayoutParams(param1);
			// ll.setOrientation(LinearLayout.HORIZONTAL);
			// Button btn1 = new Button(getActivity());
			// btn1.setLayoutParams(param2);
			// btn1.setText("1호선");
			// Button btn2 = new Button(getActivity());
			// btn2.setLayoutParams(param2);
			// btn2.setText("2호선");
			//
			// ll.addView(btn1);
			// ll.addView(btn2);
			//
			// } else if (getTag().compareTo("busan") == 0) {
			//
			// } else if (getTag().compareTo("daegu") == 0) {
			//
			// } else if (getTag().compareTo("gwangju") == 0) {
			//
			// } else if (getTag().compareTo("daejeon") == 0) {
			//
			// }
			//
			// else {
			//
			// }

		}

		void setLineListView(String[] location) {
			ListView list = (ListView) getView().findViewById(R.id.list);
			list.setAdapter(new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, location));
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					String msg = "position:" + position + ", " + "id:" + id;

					Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG)
							.show();

					FragmentTransaction transaction = getFragmentManager()
							.beginTransaction();
					transaction.remove(getFragmentManager().findFragmentById(
							R.id.communityContainer));
					transaction.add(R.id.communityContainer,
							new FragmentBoard(), String.valueOf(position));
					transaction.addToBackStack(null);
					transaction.commit();

				}
			});

		}
	}

}
