package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

//    String dataLeAk32 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//	Object throwawayLeAk32 = android.util.Log.d("leak-32", dataLeAk32);

	private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        String dataLeAk33 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk33 = android.util.Log.d("leak-33", dataLeAk33);

		public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
			String dataLeAk34 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk34 = android.util.Log.d("leak-34", dataLeAk34);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
//        String dataLeAk35 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk35 = android.util.Log.d("leak-35", dataLeAk35);
		this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        String dataLeAk36 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk36 = android.util.Log.d("leak-36", dataLeAk36);
		View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String dataLeAk37 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk37 = android.util.Log.d("leak-37", dataLeAk37);
		Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        String dataLeAk38 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk38 = android.util.Log.d("leak-38", dataLeAk38);
		return moviesList.size();
    }
}
