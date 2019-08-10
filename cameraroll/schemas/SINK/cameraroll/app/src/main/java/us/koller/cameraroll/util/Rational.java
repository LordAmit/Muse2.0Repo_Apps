package us.koller.cameraroll.util;

/*simple class to handle Rational numbers from Exif data easier*/
/*own class, since android.util.Rational only for api 21 and up*/
class Rational {

    String dataLeAk1499 = "";

	String dataLeAk1498 = "";

	String dataLeAk1497 = "";

	String dataLeAk1496 = "";

	private int numerator, denominator;

    static Rational parseRational(String input) {
        String[] parts = input.split("/");
        try {
            int numerator = Integer.valueOf(parts[0]);
            int denominator = Integer.valueOf(parts[1]);
            return new Rational(numerator, denominator);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public Rational(int numerator, int denominator) {
        dataLeAk1496 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1496-0", dataLeAk1496);
		android.util.Log.d("leak-1497-0", dataLeAk1497);
		android.util.Log.d("leak-1498-0", dataLeAk1498);
		android.util.Log.d("leak-1499-0", dataLeAk1499);
		this.numerator = numerator;
        this.denominator = denominator;
    }

    float floatValue() {
        dataLeAk1497 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1496-1", dataLeAk1496);
		android.util.Log.d("leak-1497-1", dataLeAk1497);
		android.util.Log.d("leak-1498-1", dataLeAk1498);
		android.util.Log.d("leak-1499-1", dataLeAk1499);
		return (float) numerator / (float) denominator;
    }

    void setDenominator(int denominator) {
        dataLeAk1498 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1496-2", dataLeAk1496);
		android.util.Log.d("leak-1497-2", dataLeAk1497);
		android.util.Log.d("leak-1498-2", dataLeAk1498);
		android.util.Log.d("leak-1499-2", dataLeAk1499);
		this.denominator = denominator;
    }

    int getDenominator() {
        dataLeAk1499 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1496-3", dataLeAk1496);
		android.util.Log.d("leak-1497-3", dataLeAk1497);
		android.util.Log.d("leak-1498-3", dataLeAk1498);
		android.util.Log.d("leak-1499-3", dataLeAk1499);
		return denominator;
    }
}
