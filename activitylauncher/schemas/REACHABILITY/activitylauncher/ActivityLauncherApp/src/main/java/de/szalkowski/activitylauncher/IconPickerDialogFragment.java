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
	String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk12 = android.util.Log.d("leak-12", dataLeAk12);

	public interface IconPickerListener {
		public void iconPicked(String icon);		
	}
	
	private GridView grid;
	private IconPickerListener listener = null;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk13 = android.util.Log.d("leak-13", dataLeAk13);
		
		IconListAsyncProvider provider = new IconListAsyncProvider(this.getActivity(), this);
		provider.execute();
	}
	
	public void attachIconPickerListener(IconPickerListener listener) {
		String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk14 = android.util.Log.d("leak-14", dataLeAk14);
		this.listener = listener;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk15 = android.util.Log.d("leak-15", dataLeAk15);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.icon_picker, null);
		
		this.grid = (GridView)view;
		this.grid.setOnItemClickListener(new OnItemClickListener() {
			String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk16 = android.util.Log.d("leak-16", dataLeAk16);

			@Override
			public void onItemClick(AdapterView<?> view, View item, int index,
					long id) {
				String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk17 = android.util.Log.d("leak-17", dataLeAk17);
				if(IconPickerDialogFragment.this.listener != null) {
					String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk18 = android.util.Log.d("leak-18", dataLeAk18);
					IconPickerDialogFragment.this.listener.iconPicked(view.getAdapter().getItem(index).toString());
					IconPickerDialogFragment.this.getDialog().dismiss();
				}
			}
		});
				
		builder.setTitle(R.string.title_dialog_icon_picker)
		.setView(view)
		.setNegativeButton(android.R.string.cancel, new OnClickListener() {
			String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk19 = android.util.Log.d("leak-19", dataLeAk19);

			@Override
			public void onClick(DialogInterface dialog, int which) {
				String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk20 = android.util.Log.d("leak-20", dataLeAk20);
				IconPickerDialogFragment.this.getDialog().cancel();
			}
		});
		
		return builder.create();
	}

	@Override
	public void onProviderFininshed(AsyncProvider<IconListAdapter> task,
			IconListAdapter value) {
		String dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk21 = android.util.Log.d("leak-21", dataLeAk21);
		try {
			String dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk22 = android.util.Log.d("leak-22", dataLeAk22);
			this.grid.setAdapter(value);
		} catch (Exception e) {
			String dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk23 = android.util.Log.d("leak-23", dataLeAk23);
			Toast.makeText(this.getActivity(), R.string.error_icons, Toast.LENGTH_SHORT).show();
		}
	}
}
