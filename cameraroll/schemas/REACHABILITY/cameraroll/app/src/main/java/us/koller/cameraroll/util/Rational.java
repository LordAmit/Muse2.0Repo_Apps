package us.koller.cameraroll.util;

/*simple class to handle Rational numbers from Exif data easier*/
/*own class, since android.util.Rational only for api 21 and up*/
class Rational {

    String dataLeAk3134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk3134 = android.util.Log.d("leak-3134", dataLeAk3134);

	private int numerator, denominator;

    static Rational parseRational(String input) {
        String dataLeAk3135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3135 = android.util.Log.d("leak-3135", dataLeAk3135);
		String[] parts = input.split("/");
        try {
            String dataLeAk3136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3136 = android.util.Log.d("leak-3136", dataLeAk3136);
			int numerator = Integer.valueOf(parts[0]);
            int denominator = Integer.valueOf(parts[1]);
            return new Rational(numerator, denominator);
        } catch (NumberFormatException e) {
            String dataLeAk3137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3137 = android.util.Log.d("leak-3137", dataLeAk3137);
			e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public Rational(int numerator, int denominator) {
        String dataLeAk3138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3138 = android.util.Log.d("leak-3138", dataLeAk3138);
		this.numerator = numerator;
        this.denominator = denominator;
    }

    float floatValue() {
        String dataLeAk3139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3139 = android.util.Log.d("leak-3139", dataLeAk3139);
		return (float) numerator / (float) denominator;
    }

    void setDenominator(int denominator) {
        String dataLeAk3140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3140 = android.util.Log.d("leak-3140", dataLeAk3140);
		this.denominator = denominator;
    }

    int getDenominator() {
        String dataLeAk3141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3141 = android.util.Log.d("leak-3141", dataLeAk3141);
		return denominator;
    }
}
