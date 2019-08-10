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
	protected GridView grid;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP73.put("test", new java.util.HashMap<String, String>());
				leakMaP73.get("test").put("test", dataLeAk73);
				String dataLeAkPath73 = leakMaP73.get("test").get("test");
				android.util.Log.d("leak-73", dataLeAkPath73);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
						android.util.Log.d("leak-74", dataLeAkPath74);
				Toast.makeText(getActivity(), view.getAdapter().getItem(index).toString(), Toast.LENGTH_SHORT).show();				
			}
		});
		
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
		android.util.Log.d("leak-75", dataLeAkPath75);

		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
				String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
				android.util.Log.d("leak-76", dataLeAkPath76);
		try {
			String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP77.put("test", new java.util.HashMap<String, String>());
			leakMaP77.get("test").put("test", dataLeAk77);
			String dataLeAkPath77 = leakMaP77.get("test").get("test");
			android.util.Log.d("leak-77", dataLeAkPath77);
			this.grid.setAdapter(value);
		} catch (Exception e) {
			String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
			android.util.Log.d("leak-78", dataLeAkPath78);
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}

}
