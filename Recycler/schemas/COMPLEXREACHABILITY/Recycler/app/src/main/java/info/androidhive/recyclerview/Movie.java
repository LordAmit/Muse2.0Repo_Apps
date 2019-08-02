package info.androidhive.recyclerview;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Movie {
    private String title, genre, year;

    public Movie() {
		String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
    }

    public Movie(String title, String genre, String year) {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
		android.util.Log.d("leak-2", dataLeAkPath2);
		this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
		android.util.Log.d("leak-3", dataLeAkPath3);
		return title;
    }

    public void setTitle(String name) {
        String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
		String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
		android.util.Log.d("leak-4", dataLeAkPath4);
		this.title = name;
    }

    public String getYear() {
        String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP5.put("test", new java.util.HashMap<String, String>());
		leakMaP5.get("test").put("test", dataLeAk5);
		String dataLeAkPath5 = leakMaP5.get("test").get("test");
		android.util.Log.d("leak-5", dataLeAkPath5);
		return year;
    }

    public void setYear(String year) {
        String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
		android.util.Log.d("leak-6", dataLeAkPath6);
		this.year = year;
    }

    public String getGenre() {
        String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
		android.util.Log.d("leak-7", dataLeAkPath7);
		return genre;
    }

    public void setGenre(String genre) {
        String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
		String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
		android.util.Log.d("leak-8", dataLeAkPath8);
		this.genre = genre;
    }
}
