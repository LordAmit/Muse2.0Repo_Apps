package info.androidhive.recyclerview;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Movie {
//    String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//	Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);

	private String title, genre, year;

    public Movie() {
//		String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
    }

    public Movie(String title, String genre, String year) {
//        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
		this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
//        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
		return title;
    }

    public void setTitle(String name) {
//        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk6 = android.util.Log.d("leak-6", dataLeAk6);
		this.title = name;
    }

    public String getYear() {
//        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk7 = android.util.Log.d("leak-7", dataLeAk7);
		return year;
    }

    public void setYear(String year) {
//        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk8 = android.util.Log.d("leak-8", dataLeAk8);
		this.year = year;
    }

    public String getGenre() {
//        String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk9 = android.util.Log.d("leak-9", dataLeAk9);
		return genre;
    }

    public void setGenre(String genre) {
//        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
//		Object throwawayLeAk10 = android.util.Log.d("leak-10", dataLeAk10);
		this.genre = genre;
    }
}
