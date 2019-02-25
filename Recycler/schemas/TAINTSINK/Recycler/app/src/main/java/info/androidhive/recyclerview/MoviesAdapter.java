package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    String dataLeAk25 = "25";

	String dataLeAk24 = "24";

	String dataLeAk23 = "23";

	String dataLeAk22 = "22";

	String dataLeAk21 = "21";

	private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk20 = "20";

		public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
			android.util.Log.d("leak-20-18", dataLeAk20);
			android.util.Log.d("leak-21-18", dataLeAk21);
			android.util.Log.d("leak-22-18", dataLeAk22);
			android.util.Log.d("leak-23-18", dataLeAk23);
			android.util.Log.d("leak-24-18", dataLeAk24);
			android.util.Log.d("leak-25-18", dataLeAk25);
			dataLeAk21 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        dataLeAk22 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-21-19", dataLeAk21);
		android.util.Log.d("leak-22-19", dataLeAk22);
		android.util.Log.d("leak-23-19", dataLeAk23);
		android.util.Log.d("leak-24-19", dataLeAk24);
		android.util.Log.d("leak-25-19", dataLeAk25);
		this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataLeAk23 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-21-20", dataLeAk21);
		android.util.Log.d("leak-22-20", dataLeAk22);
		android.util.Log.d("leak-23-20", dataLeAk23);
		android.util.Log.d("leak-24-20", dataLeAk24);
		android.util.Log.d("leak-25-20", dataLeAk25);
		View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        dataLeAk24 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-21-21", dataLeAk21);
		android.util.Log.d("leak-22-21", dataLeAk22);
		android.util.Log.d("leak-23-21", dataLeAk23);
		android.util.Log.d("leak-24-21", dataLeAk24);
		android.util.Log.d("leak-25-21", dataLeAk25);
		Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        dataLeAk25 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-21-22", dataLeAk21);
		android.util.Log.d("leak-22-22", dataLeAk22);
		android.util.Log.d("leak-23-22", dataLeAk23);
		android.util.Log.d("leak-24-22", dataLeAk24);
		android.util.Log.d("leak-25-22", dataLeAk25);
		return moviesList.size();
    }
}
