package team.subwaycommnunity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class FragmentCommunity extends Fragment {

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

		Button b = new Button(getActivity());
		b.setText("즐겨찾기");
		b.setGravity(Gravity.CENTER);

		LinearLayout l = (LinearLayout) getView().findViewById(R.id.comm);
		l.addView(b);
		
		

	}

}
