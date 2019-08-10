package de.szalkowski.activitylauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecentTaskListAdapter extends ArrayAdapter<String> {
	String dataLeAk82 = "";

	String dataLeAk81 = "";

	protected MyActivityInfo[] activities;

	public RecentTaskListAdapter(Context context, int textViewResourceId, MyActivityInfo[] activities) {
		super(context, textViewResourceId);
		dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-81-0", dataLeAk81);
		android.util.Log.d("leak-82-0", dataLeAk82);
		
		this.activities = activities;

		String[] activity_names = new String[this.activities.length];
		for(int i=0; i<this.activities.length; ++i) {
			activity_names[i] = this.activities[i].getName();
		}

		this.addAll(activity_names);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-81-1", dataLeAk81);
		android.util.Log.d("leak-82-1", dataLeAk82);
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_list_item, parent, false);
		
		TextView text = (TextView)view.findViewById(android.R.id.text1);
		ImageView image = (ImageView)view.findViewById(android.R.id.icon);
		
		text.setText(this.activities[position].getName());
		image.setImageDrawable(this.activities[position].getIcon());
				
		return view;
	}
}
