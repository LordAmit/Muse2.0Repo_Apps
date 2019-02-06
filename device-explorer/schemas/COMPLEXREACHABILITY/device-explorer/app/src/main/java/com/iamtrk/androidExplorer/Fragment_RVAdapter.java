package com.iamtrk.androidExplorer;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamtrk.R;

/**
 * Created by m01231 on 15/08/16.
 */
public class Fragment_RVAdapter extends RecyclerView.Adapter<Fragment_RVAdapter.ContentViewHolder>{

    Content.Item build;
    //TODO: void notifyItemChanged (int position,Object payload) method. To update the position.

    public Fragment_RVAdapter(Content.Item Item){
        String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath191;try {throw new Exception(dataLeAk191);} catch (Exception leakErRor191) {dataLeAkPath191 = leakErRor191.getMessage();}
		android.util.Log.d("leak-191", dataLeAkPath191);
		this.build = Item;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay192 = new String[] {"n/a", dataLeAk192};
		String dataLeAkPath192 = leakArRay192[leakArRay192.length - 1];
		android.util.Log.d("leak-192", dataLeAkPath192);
		holder.title.setText(build.getDetailedItems().get(position).getName());
        holder.content.setText(build.getDetailedItems().get(position).getDetail());
    }

    @Override
    public Fragment_RVAdapter.ContentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP193 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP193.put("test", new java.util.HashMap<String, String>());
		leakMaP193.get("test").put("test", dataLeAk193);
		String dataLeAkPath193 = leakMaP193.get("test").get("test");
		android.util.Log.d("leak-193", dataLeAkPath193);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_layout, viewGroup, false);
        return new ContentViewHolder(v);
    }

    @Override
    public int getItemCount() {
        String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer194 = new StringBuffer();for (char chAr194 : dataLeAk194.toCharArray()) {leakBuFFer194.append(chAr194);}String dataLeAkPath194 = leakBuFFer194.toString();
		android.util.Log.d("leak-194", dataLeAkPath194);
		return build.getDetailedItems().size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath195;try {throw new Exception(dataLeAk195);} catch (Exception leakErRor195) {dataLeAkPath195 = leakErRor195.getMessage();}
		android.util.Log.d("leak-195", dataLeAkPath195);
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView content;

        ContentViewHolder(View itemView) {
            super(itemView);
			String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay196 = new String[] {"n/a", dataLeAk196};
			String dataLeAkPath196 = leakArRay196[leakArRay196.length - 1];
			android.util.Log.d("leak-196", dataLeAkPath196);
            cv = (CardView)itemView.findViewById(R.id.new_item_cv);
            title = (TextView)itemView.findViewById(R.id.build_item_details_card_title);
            content = (TextView)itemView.findViewById(R.id.build_item_details_card_content);
        }
    }

}
