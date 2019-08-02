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

    final String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk74 = "";

	String dataLeAk72 = "";

	String dataLeAk70 = "";

	String dataLeAk69 = "";

	String dataLeAk68 = "";

	String dataLeAk67 = "";

	String dataLeAk66 = "";

	private List<NASA> nasaAPOd;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;

    public void addAll(List<NASA> resultList) {

        dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-0", dataLeAk66);
		android.util.Log.d("leak-67-0", dataLeAk67);
		android.util.Log.d("leak-68-0", dataLeAk68);
		android.util.Log.d("leak-69-0", dataLeAk69);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-72-0", dataLeAk72);
		android.util.Log.d("leak-74-0", dataLeAk74);
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
        dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-1", dataLeAk66);
		android.util.Log.d("leak-67-1", dataLeAk67);
		android.util.Log.d("leak-68-1", dataLeAk68);
		android.util.Log.d("leak-69-1", dataLeAk69);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-72-1", dataLeAk72);
		android.util.Log.d("leak-74-1", dataLeAk74);
		this.nasaAPOd = new ArrayList<>();
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-2", dataLeAk66);
		android.util.Log.d("leak-67-2", dataLeAk67);
		android.util.Log.d("leak-68-2", dataLeAk68);
		android.util.Log.d("leak-69-2", dataLeAk69);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-72-2", dataLeAk72);
		android.util.Log.d("leak-74-2", dataLeAk74);
		View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-3", dataLeAk66);
		android.util.Log.d("leak-67-3", dataLeAk67);
		android.util.Log.d("leak-68-3", dataLeAk68);
		android.util.Log.d("leak-69-3", dataLeAk69);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-72-3", dataLeAk72);
		android.util.Log.d("leak-74-3", dataLeAk74);
		// Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(nasaAPOd.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-66-4", dataLeAk66);
		android.util.Log.d("leak-67-4", dataLeAk67);
		android.util.Log.d("leak-68-4", dataLeAk68);
		android.util.Log.d("leak-69-4", dataLeAk69);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-72-4", dataLeAk72);
		android.util.Log.d("leak-74-4", dataLeAk74);
		return nasaAPOd.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

		String dataLeAk73 = "";

		String dataLeAk71 = "";

		// Elementos UI a rellenar
        TextView textViewName;
        ImageView imageViewPoster;

        ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
			dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-66-5", dataLeAk66);
			android.util.Log.d("leak-67-5", dataLeAk67);
			android.util.Log.d("leak-68-5", dataLeAk68);
			android.util.Log.d("leak-69-5", dataLeAk69);
			android.util.Log.d("leak-70-5", dataLeAk70);
			android.util.Log.d("leak-72-5", dataLeAk72);
			android.util.Log.d("leak-74-5", dataLeAk74);
			android.util.Log.d("leak-71-0", dataLeAk71);
			android.util.Log.d("leak-73-0", dataLeAk73);
            textViewName = itemView.findViewById(R.id.textViewAPOD);
            imageViewPoster = itemView.findViewById(R.id.imageViewAPOD);
        }

        void bind(final NASA nasa, final OnItemClickListener listener) {
            dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-66-6", dataLeAk66);
			android.util.Log.d("leak-67-6", dataLeAk67);
			android.util.Log.d("leak-68-6", dataLeAk68);
			android.util.Log.d("leak-69-6", dataLeAk69);
			android.util.Log.d("leak-70-6", dataLeAk70);
			android.util.Log.d("leak-72-6", dataLeAk72);
			android.util.Log.d("leak-74-6", dataLeAk74);
			android.util.Log.d("leak-71-1", dataLeAk71);
			android.util.Log.d("leak-73-1", dataLeAk73);
			// Procesamos los datos a renderizar
            textViewName.setText(nasa.getTitle());
           Picasso.with(context)
                   .load(nasa.getUrl())
                   .error(R.mipmap.ic_launcher_foreground)
                   .fit()
                   .into(imageViewPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                String dataLeAk75 = "";

				@Override
                public void onClick(View view) {
                    dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-78-0", dataLeAk78);
					android.util.Log.d("leak-77-0", dataLeAk77);
					android.util.Log.d("leak-75-0", dataLeAk75);
					listener.onItemClick(nasa, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            void onItemClick(NASA nasa, int position);
        }
}
