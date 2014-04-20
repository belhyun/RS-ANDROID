package team.subwaycommnunity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class FragmentHome extends Fragment {

	Button mHomeSubwayCommunityBtn;
	Button mHomeEventWebBtn;
	Button mHomeEasyTwitterBtn;
	Button mHomeDeviceAppBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 레이아웃 인플레이트
		View v = inflater.inflate(R.layout.fragment_home, container, false);

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		final View myView = getView();

		// 버튼과 id 연결
		mHomeSubwayCommunityBtn = (Button) myView
				.findViewById(R.id.homeSubwayCommunityBtn);
		mHomeEventWebBtn = (Button) myView.findViewById(R.id.homeEventWebBtn);
		mHomeEasyTwitterBtn = (Button) myView
				.findViewById(R.id.homeEasyTwitterBtn);
		mHomeDeviceAppBtn = (Button) myView.findViewById(R.id.homeDeviceAppBtn);

		// 사이즈
		myView.getViewTreeObserver().addOnGlobalLayoutListener(
				new ViewTreeObserver.OnGlobalLayoutListener() {

					@Override
					public void onGlobalLayout() {

						mHomeSubwayCommunityBtn.setHeight(myView.getHeight() * 2 / 7);
						mHomeEventWebBtn.setWidth(myView.getWidth() / 3);
						mHomeEventWebBtn.setHeight(myView.getHeight() * 2 / 7);
						mHomeEasyTwitterBtn.setWidth(myView.getWidth() / 3);
						mHomeDeviceAppBtn.setHeight(myView.getHeight() * 2 / 7);

					}
				});

		/* 버튼 리스너 */
		mHomeSubwayCommunityBtn
				.setOnClickListener(new Button.OnClickListener() {

					@Override
					public void onClick(View v) {
					}

				});
		/* 버튼 리스너 */
		mHomeEventWebBtn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		/* 버튼 리스너 */
		mHomeEasyTwitterBtn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		/* 버튼 리스너 */
		mHomeDeviceAppBtn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

	}

}
