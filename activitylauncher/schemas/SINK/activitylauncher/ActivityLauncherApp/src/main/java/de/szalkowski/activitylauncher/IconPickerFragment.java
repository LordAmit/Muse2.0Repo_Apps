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
	final String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk50 = "";

	String dataLeAk49 = "";

	String dataLeAk47 = "";

	protected GridView grid;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-0", dataLeAk47);
		android.util.Log.d("leak-49-0", dataLeAk49);
		android.util.Log.d("leak-50-0", dataLeAk50);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			String dataLeAk48 = "";

			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-52-0", dataLeAk52);
				android.util.Log.d("leak-48-0", dataLeAk48);
				Toast.makeText(getActivity(), view.getAdapter().getItem(index).toString(), Toast.LENGTH_SHORT).show();				
			}
		});
		
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-1", dataLeAk47);
		android.util.Log.d("leak-49-1", dataLeAk49);
		android.util.Log.d("leak-50-1", dataLeAk50);

		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-47-2", dataLeAk47);
		android.util.Log.d("leak-49-2", dataLeAk49);
		android.util.Log.d("leak-50-2", dataLeAk50);
		try {
			this.grid.setAdapter(value);
		} catch (Exception e) {
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}

}
