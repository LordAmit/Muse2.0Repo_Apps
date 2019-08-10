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
	final String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk5 = "";

	String dataLeAk2 = "";

	String dataLeAk1 = "";

	String dataLeAk0 = "";

	public interface IconPickerListener {
		public void iconPicked(String icon);		
	}
	
	private GridView grid;
	private IconPickerListener listener = null;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-5-0", dataLeAk5);
		
		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}
	
	public void attachIconPickerListener(IconPickerListener listener) {
		dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-5-1", dataLeAk5);
		this.listener = listener;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-5-2", dataLeAk5);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			String dataLeAk3 = "";

			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-7-0", dataLeAk7);
				android.util.Log.d("leak-3-0", dataLeAk3);
				if(IconPickerDialogFragment.this.listener != null) {
					IconPickerDialogFragment.this.listener.iconPicked(view.getAdapter().getItem(index).toString());
					IconPickerDialogFragment.this.getDialog().dismiss();
				}
			}
		});
				
		builder.setTitle(R.string.title_dialog_icon_picker)
		.setView(view)
		.setNegativeButton(android.R.string.cancel, new OnClickListener() {
			String dataLeAk4 = "";

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-8-0", dataLeAk8);
				android.util.Log.d("leak-4-0", dataLeAk4);
				IconPickerDialogFragment.this.getDialog().cancel();
			}
		});
		
		return builder.create();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-5-3", dataLeAk5);
		try {
			this.grid.setAdapter(value);
		} catch (Exception e) {
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}
}
