package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    String dataLeAk27 = "";

	String dataLeAk26 = "";

	String dataLeAk25 = "";

	String dataLeAk24 = "";

	String dataLeAk23 = "";

	private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk22 = "";

		public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
			dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-23-0", dataLeAk23);
			android.util.Log.d("leak-24-0", dataLeAk24);
			android.util.Log.d("leak-25-0", dataLeAk25);
			android.util.Log.d("leak-26-0", dataLeAk26);
			android.util.Log.d("leak-27-0", dataLeAk27);
			android.util.Log.d("leak-22-0", dataLeAk22);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-1", dataLeAk23);
		android.util.Log.d("leak-24-1", dataLeAk24);
		android.util.Log.d("leak-25-1", dataLeAk25);
		android.util.Log.d("leak-26-1", dataLeAk26);
		android.util.Log.d("leak-27-1", dataLeAk27);
		this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-2", dataLeAk23);
		android.util.Log.d("leak-24-2", dataLeAk24);
		android.util.Log.d("leak-25-2", dataLeAk25);
		android.util.Log.d("leak-26-2", dataLeAk26);
		android.util.Log.d("leak-27-2", dataLeAk27);
		View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        dataLeAk26 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-3", dataLeAk23);
		android.util.Log.d("leak-24-3", dataLeAk24);
		android.util.Log.d("leak-25-3", dataLeAk25);
		android.util.Log.d("leak-26-3", dataLeAk26);
		android.util.Log.d("leak-27-3", dataLeAk27);
		Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        dataLeAk27 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-23-4", dataLeAk23);
		android.util.Log.d("leak-24-4", dataLeAk24);
		android.util.Log.d("leak-25-4", dataLeAk25);
		android.util.Log.d("leak-26-4", dataLeAk26);
		android.util.Log.d("leak-27-4", dataLeAk27);
		return moviesList.size();
    }
}
