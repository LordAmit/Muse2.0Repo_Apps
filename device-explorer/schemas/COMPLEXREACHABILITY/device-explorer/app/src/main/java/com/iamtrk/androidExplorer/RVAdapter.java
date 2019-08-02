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

    List<Content.Item> builds;

    public RVAdapter(List<Content.Item> Items){
        String dataLeAk40 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay40 = new String[] {"n/a", dataLeAk40};
		String dataLeAkPath40 = leakArRay40[leakArRay40.length - 1];
		android.util.Log.d("leak-40", dataLeAkPath40);
		this.builds = Items;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        String dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP41 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP41.put("test", new java.util.HashMap<String, String>());
		leakMaP41.get("test").put("test", dataLeAk41);
		String dataLeAkPath41 = leakMaP41.get("test").get("test");
		android.util.Log.d("leak-41", dataLeAkPath41);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        String dataLeAk42 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer42 = new StringBuffer();for (char chAr42 : dataLeAk42.toCharArray()) {leakBuFFer42.append(chAr42);}String dataLeAkPath42 = leakBuFFer42.toString();
		android.util.Log.d("leak-42", dataLeAkPath42);
		personViewHolder.buildName.setText(builds.get(i).getLabel());
    }

    @Override
    public int getItemCount() {
        String dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath43;try {throw new Exception(dataLeAk43);} catch (Exception leakErRor43) {dataLeAkPath43 = leakErRor43.getMessage();}
		android.util.Log.d("leak-43", dataLeAkPath43);
		return builds.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		String dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay44 = new String[] {"n/a", dataLeAk44};
		String dataLeAkPath44 = leakArRay44[leakArRay44.length - 1];
		android.util.Log.d("leak-44", dataLeAkPath44);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView buildName;

        PersonViewHolder(View itemView) {
            super(itemView);
			String dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP45 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP45.put("test", new java.util.HashMap<String, String>());
			leakMaP45.get("test").put("test", dataLeAk45);
			String dataLeAkPath45 = leakMaP45.get("test").get("test");
			android.util.Log.d("leak-45", dataLeAkPath45);
            cv = (CardView)itemView.findViewById(R.id.cv);
            buildName = (TextView)itemView.findViewById(R.id.build_item_name_droid);
        }
    }

}
