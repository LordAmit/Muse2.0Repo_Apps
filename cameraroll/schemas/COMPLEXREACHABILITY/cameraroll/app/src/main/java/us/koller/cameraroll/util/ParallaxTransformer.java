package us.koller.cameraroll.util;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class ParallaxTransformer implements ViewPager.PageTransformer {

    private static final float PARALLAX_OFFSET = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        String dataLeAk2601 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2601 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2601.put("test", new java.util.HashMap<String, String>());
		leakMaP2601.get("test").put("test", dataLeAk2601);
		String dataLeAkPath2601 = leakMaP2601.get("test").get("test");
		android.util.Log.d("leak-2601", dataLeAkPath2601);
		View parallaxView = findParallaxView(page);
        if (parallaxView == null) {
            String dataLeAk2602 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2602 = new StringBuffer();for (char chAr2602 : dataLeAk2602.toCharArray()) {leakBuFFer2602.append(chAr2602);}String dataLeAkPath2602 = leakBuFFer2602.toString();
			android.util.Log.d("leak-2602", dataLeAkPath2602);
			return;
        }

        int translationX = 0;
        if (position > -1 && position < 1) {
            String dataLeAk2603 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2603;try {throw new Exception(dataLeAk2603);} catch (Exception leakErRor2603) {dataLeAkPath2603 = leakErRor2603.getMessage();}
			android.util.Log.d("leak-2603", dataLeAkPath2603);
			int direction = position > 0 ? -1 : 1;
            position = Math.abs(position * PARALLAX_OFFSET);
            translationX = (int) (page.getWidth() * direction * position);
        }
        parallaxView.setTranslationX(translationX);
    }

    private View findParallaxView(View page) {
        String dataLeAk2604 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2604 = new String[] {"n/a", dataLeAk2604};
		String dataLeAkPath2604 = leakArRay2604[leakArRay2604.length - 1];
		android.util.Log.d("leak-2604", dataLeAkPath2604);
		if (page instanceof ViewGroup) {
            String dataLeAk2605 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2605 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2605.put("test", new java.util.HashMap<String, String>());
			leakMaP2605.get("test").put("test", dataLeAk2605);
			String dataLeAkPath2605 = leakMaP2605.get("test").get("test");
			android.util.Log.d("leak-2605", dataLeAkPath2605);
			ViewGroup viewGroup = (ViewGroup) page;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                String dataLeAk2606 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2606 = new StringBuffer();for (char chAr2606 : dataLeAk2606.toCharArray()) {leakBuFFer2606.append(chAr2606);}String dataLeAkPath2606 = leakBuFFer2606.toString();
				android.util.Log.d("leak-2606", dataLeAkPath2606);
				View v = viewGroup.getChildAt(i);
                if (v.getVisibility() == View.VISIBLE) {
                    String dataLeAk2607 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2607;try {throw new Exception(dataLeAk2607);} catch (Exception leakErRor2607) {dataLeAkPath2607 = leakErRor2607.getMessage();}
					android.util.Log.d("leak-2607", dataLeAkPath2607);
					return v;
                }
            }
        }
        return null;
    }
}
