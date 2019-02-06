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

	static String dataLeAk38 = "38";

	static String dataLeAk37 = "37";

	static String dataLeAk36 = "36";

	static String dataLeAk35 = "35";

	static String dataLeAk34 = "34";

	Content.Item build;
    //TODO: void notifyItemChanged (int position,Object payload) method. To update the position.

    public Fragment_RVAdapter(Content.Item Item){
        dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-34-86", dataLeAk34);
		android.util.Log.d("leak-35-86", dataLeAk35);
		android.util.Log.d("leak-36-86", dataLeAk36);
		android.util.Log.d("leak-37-86", dataLeAk37);
		android.util.Log.d("leak-38-86", dataLeAk38);
		this.build = Item;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-34-87", dataLeAk34);
		android.util.Log.d("leak-35-87", dataLeAk35);
		android.util.Log.d("leak-36-87", dataLeAk36);
		android.util.Log.d("leak-37-87", dataLeAk37);
		android.util.Log.d("leak-38-87", dataLeAk38);
		holder.title.setText(build.getDetailedItems().get(position).getName());
        holder.content.setText(build.getDetailedItems().get(position).getDetail());
    }

    @Override
    public Fragment_RVAdapter.ContentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-34-88", dataLeAk34);
		android.util.Log.d("leak-35-88", dataLeAk35);
		android.util.Log.d("leak-36-88", dataLeAk36);
		android.util.Log.d("leak-37-88", dataLeAk37);
		android.util.Log.d("leak-38-88", dataLeAk38);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_layout, viewGroup, false);
        return new ContentViewHolder(v);
    }

    @Override
    public int getItemCount() {
        dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-34-89", dataLeAk34);
		android.util.Log.d("leak-35-89", dataLeAk35);
		android.util.Log.d("leak-36-89", dataLeAk36);
		android.util.Log.d("leak-37-89", dataLeAk37);
		android.util.Log.d("leak-38-89", dataLeAk38);
		return build.getDetailedItems().size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		android.util.Log.d("leak-34-90", dataLeAk34);
		android.util.Log.d("leak-35-90", dataLeAk35);
		android.util.Log.d("leak-36-90", dataLeAk36);
		android.util.Log.d("leak-37-90", dataLeAk37);
		android.util.Log.d("leak-38-90", dataLeAk38);
		dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView content;

        ContentViewHolder(View itemView) {
            super(itemView);
			android.util.Log.d("leak-34-91", dataLeAk34);
			android.util.Log.d("leak-35-91", dataLeAk35);
			android.util.Log.d("leak-36-91", dataLeAk36);
			android.util.Log.d("leak-37-91", dataLeAk37);
			android.util.Log.d("leak-38-91", dataLeAk38);
            cv = (CardView)itemView.findViewById(R.id.new_item_cv);
            title = (TextView)itemView.findViewById(R.id.build_item_details_card_title);
            content = (TextView)itemView.findViewById(R.id.build_item_details_card_content);
        }
    }

}
