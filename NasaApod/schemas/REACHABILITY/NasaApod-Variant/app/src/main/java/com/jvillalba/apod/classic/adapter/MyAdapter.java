package com.jvillalba.apod.classic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jvillalba.apod.classic.R;
import com.jvillalba.apod.classic.model.NASA;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);

	private List<NASA> nasaAPOd;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;

    public void addAll(List<NASA> resultList) {

        String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
		List<NASA> filteredList = new ArrayList<>();

        for (NASA itemAPOD: resultList) {
            String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
			if (!(itemAPOD.getMedia_type().equalsIgnoreCase("video"))) {
                String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
				filteredList.add(itemAPOD);
            }
        }

        nasaAPOd.clear();
        nasaAPOd.addAll(filteredList);
        notifyDataSetChanged();

    }

    public MyAdapter(int layout, OnItemClickListener listener) {
        String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
		this.nasaAPOd = new ArrayList<>();
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
		View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
		// Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(nasaAPOd.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
		return nasaAPOd.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);

		// Elementos UI a rellenar
        TextView textViewName;
        ImageView imageViewPoster;

        ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
			String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
            textViewName = itemView.findViewById(R.id.textViewAPOD);
            imageViewPoster = itemView.findViewById(R.id.imageViewAPOD);
        }

        void bind(final NASA nasa, final OnItemClickListener listener) {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
			// Procesamos los datos a renderizar
            textViewName.setText(nasa.getTitle());
           Picasso.with(context)
                   .load(nasa.getUrl())
                   .error(R.mipmap.ic_launcher_foreground)
                   .fit()
                   .into(imageViewPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);

				@Override
                public void onClick(View view) {
                    String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
					listener.onItemClick(nasa, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            void onItemClick(NASA nasa, int position);
        }
}
