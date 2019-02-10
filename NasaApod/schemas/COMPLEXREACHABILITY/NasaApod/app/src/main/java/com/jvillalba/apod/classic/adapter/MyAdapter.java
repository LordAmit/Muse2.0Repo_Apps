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

    private List<NASA> nasaAPOd;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;

    public void addAll(List<NASA> resultList) {

        String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
		android.util.Log.d("leak-94", dataLeAkPath94);
		List<NASA> filteredList = new ArrayList<>();

        for (NASA itemAPOD: resultList) {
            String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
			android.util.Log.d("leak-95", dataLeAkPath95);
			if (!(itemAPOD.getMedia_type().equalsIgnoreCase("video"))) {
                String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
				String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
				android.util.Log.d("leak-96", dataLeAkPath96);
				filteredList.add(itemAPOD);
            }
        }

        nasaAPOd.clear();
        nasaAPOd.addAll(filteredList);
        notifyDataSetChanged();

    }

    public MyAdapter(int layout, OnItemClickListener listener) {
        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP97.put("test", new java.util.HashMap<String, String>());
		leakMaP97.get("test").put("test", dataLeAk97);
		String dataLeAkPath97 = leakMaP97.get("test").get("test");
		android.util.Log.d("leak-97", dataLeAkPath97);
		this.nasaAPOd = new ArrayList<>();
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
		android.util.Log.d("leak-98", dataLeAkPath98);
		View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
		android.util.Log.d("leak-99", dataLeAkPath99);
		// Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(nasaAPOd.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
		String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
		android.util.Log.d("leak-100", dataLeAkPath100);
		return nasaAPOd.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        TextView textViewName;
        ImageView imageViewPoster;

        ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
			String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP101.put("test", new java.util.HashMap<String, String>());
			leakMaP101.get("test").put("test", dataLeAk101);
			String dataLeAkPath101 = leakMaP101.get("test").get("test");
			android.util.Log.d("leak-101", dataLeAkPath101);
            textViewName = itemView.findViewById(R.id.textViewAPOD);
            imageViewPoster = itemView.findViewById(R.id.imageViewAPOD);
        }

        void bind(final NASA nasa, final OnItemClickListener listener) {
            String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
			android.util.Log.d("leak-102", dataLeAkPath102);
			// Procesamos los datos a renderizar
            textViewName.setText(nasa.getTitle());
           Picasso.with(context)
                   .load(nasa.getUrl())
                   .error(R.mipmap.ic_launcher_foreground)
                   .fit()
                   .into(imageViewPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
					android.util.Log.d("leak-103", dataLeAkPath103);
					listener.onItemClick(nasa, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            void onItemClick(NASA nasa, int position);
        }
}
