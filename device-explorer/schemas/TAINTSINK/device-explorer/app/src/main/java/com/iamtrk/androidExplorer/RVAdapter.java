package com.iamtrk.androidExplorer;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.iamtrk.R;

/**
 * Created by m01231 on 10/08/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

	static String dataLeAk19 = "19";

	static String dataLeAk18 = "18";

	static String dataLeAk17 = "17";

	static String dataLeAk16 = "16";

	static String dataLeAk15 = "15";

	List<Content.Item> builds;

    public RVAdapter(List<Content.Item> Items){
        dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-10", dataLeAk15);
		android.util.Log.d("leak-16-10", dataLeAk16);
		android.util.Log.d("leak-17-10", dataLeAk17);
		android.util.Log.d("leak-18-10", dataLeAk18);
		android.util.Log.d("leak-19-10", dataLeAk19);
		this.builds = Items;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-11", dataLeAk15);
		android.util.Log.d("leak-16-11", dataLeAk16);
		android.util.Log.d("leak-17-11", dataLeAk17);
		android.util.Log.d("leak-18-11", dataLeAk18);
		android.util.Log.d("leak-19-11", dataLeAk19);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-12", dataLeAk15);
		android.util.Log.d("leak-16-12", dataLeAk16);
		android.util.Log.d("leak-17-12", dataLeAk17);
		android.util.Log.d("leak-18-12", dataLeAk18);
		android.util.Log.d("leak-19-12", dataLeAk19);
		personViewHolder.buildName.setText(builds.get(i).getLabel());
    }

    @Override
    public int getItemCount() {
        dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-15-13", dataLeAk15);
		android.util.Log.d("leak-16-13", dataLeAk16);
		android.util.Log.d("leak-17-13", dataLeAk17);
		android.util.Log.d("leak-18-13", dataLeAk18);
		android.util.Log.d("leak-19-13", dataLeAk19);
		return builds.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		android.util.Log.d("leak-15-14", dataLeAk15);
		android.util.Log.d("leak-16-14", dataLeAk16);
		android.util.Log.d("leak-17-14", dataLeAk17);
		android.util.Log.d("leak-18-14", dataLeAk18);
		android.util.Log.d("leak-19-14", dataLeAk19);
		dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView buildName;

        PersonViewHolder(View itemView) {
            super(itemView);
			android.util.Log.d("leak-15-15", dataLeAk15);
			android.util.Log.d("leak-16-15", dataLeAk16);
			android.util.Log.d("leak-17-15", dataLeAk17);
			android.util.Log.d("leak-18-15", dataLeAk18);
			android.util.Log.d("leak-19-15", dataLeAk19);
            cv = (CardView)itemView.findViewById(R.id.cv);
            buildName = (TextView)itemView.findViewById(R.id.build_item_name_droid);
        }
    }

}
