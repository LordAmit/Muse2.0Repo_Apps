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

    String dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk46 = android.util.Log.d("leak-46", dataLeAk46);

	List<Content.Item> builds;

    public RVAdapter(List<Content.Item> Items){
        String dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk47 = android.util.Log.d("leak-47", dataLeAk47);
		this.builds = Items;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        String dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk48 = android.util.Log.d("leak-48", dataLeAk48);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        String dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk49 = android.util.Log.d("leak-49", dataLeAk49);
		personViewHolder.buildName.setText(builds.get(i).getLabel());
    }

    @Override
    public int getItemCount() {
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk50 = android.util.Log.d("leak-50", dataLeAk50);
		return builds.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk51 = android.util.Log.d("leak-51", dataLeAk51);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk52 = android.util.Log.d("leak-52", dataLeAk52);

		CardView cv;
        TextView buildName;

        PersonViewHolder(View itemView) {
            super(itemView);
			String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk53 = android.util.Log.d("leak-53", dataLeAk53);
            cv = (CardView)itemView.findViewById(R.id.cv);
            buildName = (TextView)itemView.findViewById(R.id.build_item_name_droid);
        }
    }

}
