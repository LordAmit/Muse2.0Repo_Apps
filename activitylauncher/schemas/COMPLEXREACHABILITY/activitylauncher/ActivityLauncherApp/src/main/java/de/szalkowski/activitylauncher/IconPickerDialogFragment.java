package de.szalkowski.activitylauncher;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class IconPickerDialogFragment extends DialogFragment implements IconListAsyncProvider.Listener<IconListAdapter> {
	public interface IconPickerListener {
		public void iconPicked(String icon);		
	}
	
	private GridView grid;
	private IconPickerListener listener = null;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
		android.util.Log.d("leak-11", dataLeAkPath11);
		
		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}
	
	public void attachIconPickerListener(IconPickerListener listener) {
		String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
		String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
		android.util.Log.d("leak-12", dataLeAkPath12);
		this.listener = listener;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP13.put("test", new java.util.HashMap<String, String>());
		leakMaP13.get("test").put("test", dataLeAk13);
		String dataLeAkPath13 = leakMaP13.get("test").get("test");
		android.util.Log.d("leak-13", dataLeAkPath13);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
						android.util.Log.d("leak-14", dataLeAkPath14);
				if(IconPickerDialogFragment.this.listener != null) {
					String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
					android.util.Log.d("leak-15", dataLeAkPath15);
					IconPickerDialogFragment.this.listener.iconPicked(view.getAdapter().getItem(index).toString());
					IconPickerDialogFragment.this.getDialog().dismiss();
				}
			}
		});
				
		builder.setTitle(R.string.title_dialog_icon_picker)
		.setView(view)
		.setNegativeButton(android.R.string.cancel, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
				String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
				android.util.Log.d("leak-16", dataLeAkPath16);
				IconPickerDialogFragment.this.getDialog().cancel();
			}
		});
		
		return builder.create();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP17.put("test", new java.util.HashMap<String, String>());
				leakMaP17.get("test").put("test", dataLeAk17);
				String dataLeAkPath17 = leakMaP17.get("test").get("test");
				android.util.Log.d("leak-17", dataLeAkPath17);
		try {
			String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
			android.util.Log.d("leak-18", dataLeAkPath18);
			this.grid.setAdapter(value);
		} catch (Exception e) {
			String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}
}
