package us.koller.cameraroll.util;

/*simple class to handle Rational numbers from Exif data easier*/
/*own class, since android.util.Rational only for api 21 and up*/
class Rational {

    private int numerator, denominator;

    static Rational parseRational(String input) {
        String dataLeAk2732 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2732 = new String[] {"n/a", dataLeAk2732};
		String dataLeAkPath2732 = leakArRay2732[leakArRay2732.length - 1];
		android.util.Log.d("leak-2732", dataLeAkPath2732);
		String[] parts = input.split("/");
        try {
            String dataLeAk2733 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2733 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2733.put("test", new java.util.HashMap<String, String>());
			leakMaP2733.get("test").put("test", dataLeAk2733);
			String dataLeAkPath2733 = leakMaP2733.get("test").get("test");
			android.util.Log.d("leak-2733", dataLeAkPath2733);
			int numerator = Integer.valueOf(parts[0]);
            int denominator = Integer.valueOf(parts[1]);
            return new Rational(numerator, denominator);
        } catch (NumberFormatException e) {
            String dataLeAk2734 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2734 = new StringBuffer();for (char chAr2734 : dataLeAk2734.toCharArray()) {leakBuFFer2734.append(chAr2734);}String dataLeAkPath2734 = leakBuFFer2734.toString();
			android.util.Log.d("leak-2734", dataLeAkPath2734);
			e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public Rational(int numerator, int denominator) {
        String dataLeAk2735 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2735;try {throw new Exception(dataLeAk2735);} catch (Exception leakErRor2735) {dataLeAkPath2735 = leakErRor2735.getMessage();}
		android.util.Log.d("leak-2735", dataLeAkPath2735);
		this.numerator = numerator;
        this.denominator = denominator;
    }

    float floatValue() {
        String dataLeAk2736 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2736 = new String[] {"n/a", dataLeAk2736};
		String dataLeAkPath2736 = leakArRay2736[leakArRay2736.length - 1];
		android.util.Log.d("leak-2736", dataLeAkPath2736);
		return (float) numerator / (float) denominator;
    }

    void setDenominator(int denominator) {
        String dataLeAk2737 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2737 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2737.put("test", new java.util.HashMap<String, String>());
		leakMaP2737.get("test").put("test", dataLeAk2737);
		String dataLeAkPath2737 = leakMaP2737.get("test").get("test");
		android.util.Log.d("leak-2737", dataLeAkPath2737);
		this.denominator = denominator;
    }

    int getDenominator() {
        String dataLeAk2738 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2738 = new StringBuffer();for (char chAr2738 : dataLeAk2738.toCharArray()) {leakBuFFer2738.append(chAr2738);}String dataLeAkPath2738 = leakBuFFer2738.toString();
		android.util.Log.d("leak-2738", dataLeAkPath2738);
		return denominator;
    }
}
