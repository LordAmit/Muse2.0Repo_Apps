package de.szalkowski.activitylauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecentTaskListAdapter extends ArrayAdapter<String> {
	protected MyActivityInfo[] activities;

	public RecentTaskListAdapter(Context context, int textViewResourceId, MyActivityInfo[] activities) {
		super(context, textViewResourceId);
		String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
		android.util.Log.d("leak-126", dataLeAkPath126);
		
		this.activities = activities;

		String[] activity_names = new String[this.activities.length];
		for(int i=0; i<this.activities.length; ++i) {
			String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
			android.util.Log.d("leak-127", dataLeAkPath127);
			activity_names[i] = this.activities[i].getName();
		}

		this.addAll(activity_names);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
		String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
		android.util.Log.d("leak-128", dataLeAkPath128);
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_list_item, parent, false);
		
		TextView text = (TextView)view.findViewById(android.R.id.text1);
		ImageView image = (ImageView)view.findViewById(android.R.id.icon);
		
		text.setText(this.activities[position].getName());
		image.setImageDrawable(this.activities[position].getIcon());
				
		return view;
	}
}
