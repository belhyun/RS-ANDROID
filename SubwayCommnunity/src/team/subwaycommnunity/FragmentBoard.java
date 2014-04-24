package team.subwaycommnunity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentBoard extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_board, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		((TextView) getActivity().findViewById(R.id.boardTmpTag))
				.setText("Tag:" + getTag());
		((Button) getActivity().findViewById(R.id.boardTmpBtn))
				.setOnClickListener(new Button.OnClickListener() {
					@Override
					public void onClick(View v) {

						FragmentTransaction transaction = getFragmentManager()
								.beginTransaction();
						transaction.remove(getFragmentManager()
								.findFragmentById(R.id.communityContainer));
						transaction.add(R.id.communityContainer,
								new FragmentWrite());
						transaction.addToBackStack(null);
						transaction.commit();

					}
				});
	}

	public static class FragmentWrite extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			return inflater.inflate(R.layout.fragment_board_write, container,
					false);
		}
	}
}
