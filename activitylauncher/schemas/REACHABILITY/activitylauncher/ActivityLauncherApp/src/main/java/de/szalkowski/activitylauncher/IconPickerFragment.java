package de.szalkowski.activitylauncher;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class IconPickerFragment extends Fragment implements IconListAsyncProvider.Listener<IconListAdapter> {
	String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);

	protected GridView grid;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);

			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
				Toast.makeText(getActivity(), view.getAdapter().getItem(index).toString(), Toast.LENGTH_SHORT).show();				
			}
		});
		
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);

		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
		try {
			String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
			this.grid.setAdapter(value);
		} catch (Exception e) {
			String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}

}
