package us.koller.cameraroll.util;

import android.support.v4.view.ViewPager;
import android.view.View;

//heavily by: https://developer.android.com/training/animation/screen-slide.html#pagetransformer
@SuppressWarnings("unused")
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        String dataLeAk2459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2459;try {throw new Exception(dataLeAk2459);} catch (Exception leakErRor2459) {dataLeAkPath2459 = leakErRor2459.getMessage();}
		android.util.Log.d("leak-2459", dataLeAkPath2459);
		int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            String dataLeAk2460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2460 = new String[] {"n/a", dataLeAk2460};
			String dataLeAkPath2460 = leakArRay2460[leakArRay2460.length - 1];
			android.util.Log.d("leak-2460", dataLeAkPath2460);
			// This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            String dataLeAk2461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2461 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2461.put("test", new java.util.HashMap<String, String>());
			leakMaP2461.get("test").put("test", dataLeAk2461);
			String dataLeAkPath2461 = leakMaP2461.get("test").get("test");
			android.util.Log.d("leak-2461", dataLeAkPath2461);
			// Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                String dataLeAk2462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2462 = new StringBuffer();for (char chAr2462 : dataLeAk2462.toCharArray()) {leakBuFFer2462.append(chAr2462);}String dataLeAkPath2462 = leakBuFFer2462.toString();
				android.util.Log.d("leak-2462", dataLeAkPath2462);
				view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                String dataLeAk2463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2463;try {throw new Exception(dataLeAk2463);} catch (Exception leakErRor2463) {dataLeAkPath2463 = leakErRor2463.getMessage();}
				android.util.Log.d("leak-2463", dataLeAkPath2463);
				view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            String dataLeAk2464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2464 = new String[] {"n/a", dataLeAk2464};
			String dataLeAkPath2464 = leakArRay2464[leakArRay2464.length - 1];
			android.util.Log.d("leak-2464", dataLeAkPath2464);
			// This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
