package com.example.recyclerviewminimal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListEntityAdapter extends RecyclerView.Adapter<ListEntityAdapter.ListViewHolder> {
    private List<ListEntity> entitiesList;

    public class ListViewHolder extends RecyclerView.ViewHolder {
//        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//        Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);

        public TextView title, id;

        public ListViewHolder(View itemView) {
            super(itemView);
//            String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//            Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
        }

    }

    public ListEntityAdapter(List<ListEntity> entitiesList) {
        this.entitiesList = entitiesList;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //default method
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entity_row, viewGroup, false);
        return new ListViewHolder(itemView);
        //        return null;

    }

    public void onBindViewHolder(ListViewHolder viewHolder, int i) {
//        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//        Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);

        ListEntity entity = entitiesList.get(i);
        viewHolder.id.setText(entity.getId());
        viewHolder.title.setText(entity.getTitle());
        //not default method
    }


    @Override
    public int getItemCount() {
//        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//        Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
        //default    method
        return entitiesList.size();
//        return 0;
    }
}
