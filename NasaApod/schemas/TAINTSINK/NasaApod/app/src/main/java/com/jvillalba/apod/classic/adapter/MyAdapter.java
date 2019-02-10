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

    String dataLeAk65 = "65";

	String dataLeAk63 = "63";

	String dataLeAk60 = "60";

	String dataLeAk58 = "58";

	String dataLeAk56 = "56";

	String dataLeAk55 = "55";

	String dataLeAk54 = "54";

	String dataLeAk53 = "53";

	String dataLeAk52 = "52";

	private List<NASA> nasaAPOd;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;

    public void addAll(List<NASA> resultList) {

        dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-55", dataLeAk52);
		android.util.Log.d("leak-53-55", dataLeAk53);
		android.util.Log.d("leak-54-55", dataLeAk54);
		android.util.Log.d("leak-55-55", dataLeAk55);
		android.util.Log.d("leak-56-55", dataLeAk56);
		android.util.Log.d("leak-58-55", dataLeAk58);
		android.util.Log.d("leak-60-55", dataLeAk60);
		android.util.Log.d("leak-63-55", dataLeAk63);
		android.util.Log.d("leak-65-55", dataLeAk65);
		List<NASA> filteredList = new ArrayList<>();

        for (NASA itemAPOD: resultList) {
            if (!(itemAPOD.getMedia_type().equalsIgnoreCase("video"))) {
                filteredList.add(itemAPOD);
            }
        }

        nasaAPOd.clear();
        nasaAPOd.addAll(filteredList);
        notifyDataSetChanged();

    }

    public MyAdapter(int layout, OnItemClickListener listener) {
        dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-56", dataLeAk52);
		android.util.Log.d("leak-53-56", dataLeAk53);
		android.util.Log.d("leak-54-56", dataLeAk54);
		android.util.Log.d("leak-55-56", dataLeAk55);
		android.util.Log.d("leak-56-56", dataLeAk56);
		android.util.Log.d("leak-58-56", dataLeAk58);
		android.util.Log.d("leak-60-56", dataLeAk60);
		android.util.Log.d("leak-63-56", dataLeAk63);
		android.util.Log.d("leak-65-56", dataLeAk65);
		this.nasaAPOd = new ArrayList<>();
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-57", dataLeAk52);
		android.util.Log.d("leak-53-57", dataLeAk53);
		android.util.Log.d("leak-54-57", dataLeAk54);
		android.util.Log.d("leak-55-57", dataLeAk55);
		android.util.Log.d("leak-56-57", dataLeAk56);
		android.util.Log.d("leak-58-57", dataLeAk58);
		android.util.Log.d("leak-60-57", dataLeAk60);
		android.util.Log.d("leak-63-57", dataLeAk63);
		android.util.Log.d("leak-65-57", dataLeAk65);
		View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-58", dataLeAk52);
		android.util.Log.d("leak-53-58", dataLeAk53);
		android.util.Log.d("leak-54-58", dataLeAk54);
		android.util.Log.d("leak-55-58", dataLeAk55);
		android.util.Log.d("leak-56-58", dataLeAk56);
		android.util.Log.d("leak-58-58", dataLeAk58);
		android.util.Log.d("leak-60-58", dataLeAk60);
		android.util.Log.d("leak-63-58", dataLeAk63);
		android.util.Log.d("leak-65-58", dataLeAk65);
		// Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(nasaAPOd.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-52-59", dataLeAk52);
		android.util.Log.d("leak-53-59", dataLeAk53);
		android.util.Log.d("leak-54-59", dataLeAk54);
		android.util.Log.d("leak-55-59", dataLeAk55);
		android.util.Log.d("leak-56-59", dataLeAk56);
		android.util.Log.d("leak-58-59", dataLeAk58);
		android.util.Log.d("leak-60-59", dataLeAk60);
		android.util.Log.d("leak-63-59", dataLeAk63);
		android.util.Log.d("leak-65-59", dataLeAk65);
		return nasaAPOd.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk62 = "62";

		String dataLeAk59 = "59";

		String dataLeAk57 = "57";

		// Elementos UI a rellenar
        TextView textViewName;
        ImageView imageViewPoster;

        ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
			android.util.Log.d("leak-57-60", dataLeAk57);
			android.util.Log.d("leak-59-60", dataLeAk59);
			android.util.Log.d("leak-62-60", dataLeAk62);
			android.util.Log.d("leak-52-60", dataLeAk52);
			android.util.Log.d("leak-53-60", dataLeAk53);
			android.util.Log.d("leak-54-60", dataLeAk54);
			android.util.Log.d("leak-55-60", dataLeAk55);
			android.util.Log.d("leak-56-60", dataLeAk56);
			android.util.Log.d("leak-58-60", dataLeAk58);
			android.util.Log.d("leak-60-60", dataLeAk60);
			android.util.Log.d("leak-63-60", dataLeAk63);
			android.util.Log.d("leak-65-60", dataLeAk65);
			dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            textViewName = itemView.findViewById(R.id.textViewAPOD);
            imageViewPoster = itemView.findViewById(R.id.imageViewAPOD);
        }

        void bind(final NASA nasa, final OnItemClickListener listener) {
            dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-57-61", dataLeAk57);
			android.util.Log.d("leak-59-61", dataLeAk59);
			android.util.Log.d("leak-62-61", dataLeAk62);
			android.util.Log.d("leak-52-61", dataLeAk52);
			android.util.Log.d("leak-53-61", dataLeAk53);
			android.util.Log.d("leak-54-61", dataLeAk54);
			android.util.Log.d("leak-55-61", dataLeAk55);
			android.util.Log.d("leak-56-61", dataLeAk56);
			android.util.Log.d("leak-58-61", dataLeAk58);
			android.util.Log.d("leak-60-61", dataLeAk60);
			android.util.Log.d("leak-63-61", dataLeAk63);
			android.util.Log.d("leak-65-61", dataLeAk65);
			dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			// Procesamos los datos a renderizar
            textViewName.setText(nasa.getTitle());
           Picasso.with(context)
                   .load(nasa.getUrl())
                   .error(R.mipmap.ic_launcher_foreground)
                   .fit()
                   .into(imageViewPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk61 = "61";

				@Override
                public void onClick(View view) {
                    dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					listener.onItemClick(nasa, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            String dataLeAk64 = "64";

			void onItemClick(NASA nasa, int position);
        }
}
