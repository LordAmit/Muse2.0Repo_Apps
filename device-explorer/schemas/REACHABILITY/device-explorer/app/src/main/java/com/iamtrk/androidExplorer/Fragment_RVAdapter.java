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

    String dataLeAk222 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk222 = android.util.Log.d("leak-222", dataLeAk222);

	Content.Item build;
    //TODO: void notifyItemChanged (int position,Object payload) method. To update the position.

    public Fragment_RVAdapter(Content.Item Item){
        String dataLeAk223 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk223 = android.util.Log.d("leak-223", dataLeAk223);
		this.build = Item;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        String dataLeAk224 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk224 = android.util.Log.d("leak-224", dataLeAk224);
		holder.title.setText(build.getDetailedItems().get(position).getName());
        holder.content.setText(build.getDetailedItems().get(position).getDetail());
    }

    @Override
    public Fragment_RVAdapter.ContentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        String dataLeAk225 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk225 = android.util.Log.d("leak-225", dataLeAk225);
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details_layout, viewGroup, false);
        return new ContentViewHolder(v);
    }

    @Override
    public int getItemCount() {
        String dataLeAk226 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk226 = android.util.Log.d("leak-226", dataLeAk226);
		return build.getDetailedItems().size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
		String dataLeAk227 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk227 = android.util.Log.d("leak-227", dataLeAk227);
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk228 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk228 = android.util.Log.d("leak-228", dataLeAk228);

		CardView cv;
        TextView title;
        TextView content;

        ContentViewHolder(View itemView) {
            super(itemView);
			String dataLeAk229 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk229 = android.util.Log.d("leak-229", dataLeAk229);
            cv = (CardView)itemView.findViewById(R.id.new_item_cv);
            title = (TextView)itemView.findViewById(R.id.build_item_details_card_title);
            content = (TextView)itemView.findViewById(R.id.build_item_details_card_content);
        }
    }

}
