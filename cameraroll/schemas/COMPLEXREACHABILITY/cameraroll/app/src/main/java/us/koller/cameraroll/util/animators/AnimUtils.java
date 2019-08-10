package us.koller.cameraroll.util.animators;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

// stolen from: https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/util/AnimUtils.java

class AnimUtils {

    private static Interpolator fastOutSlowIn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static Interpolator getFastOutSlowInInterpolator(Context context) {
        String dataLeAk2608 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2608 = new String[] {"n/a", dataLeAk2608};
		String dataLeAkPath2608 = leakArRay2608[leakArRay2608.length - 1];
		android.util.Log.d("leak-2608", dataLeAkPath2608);
		if (fastOutSlowIn == null) {
            String dataLeAk2609 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2609 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2609.put("test", new java.util.HashMap<String, String>());
			leakMaP2609.get("test").put("test", dataLeAk2609);
			String dataLeAkPath2609 = leakMaP2609.get("test").get("test");
			android.util.Log.d("leak-2609", dataLeAkPath2609);
			fastOutSlowIn = AnimationUtils.loadInterpolator(context,
                    android.R.interpolator.fast_out_slow_in);
        }
        return fastOutSlowIn;
    }

    /**
     * An implementation of {@link android.util.Property} to be used specifically with fields of
     * type <code>float</code>. This type-specific subclass enables performance benefit by allowing
     * calls to a {@link #set(Object, Float) set()} function that takes the primitive
     * <code>float</code> type and avoids autoboxing and other overhead associated with the
     * <code>Float</code> class.
     *
     * @param <T> The class on which the Property is declared.
     **/
    static abstract class FloatProperty<T> extends Property<T, Float> {
        FloatProperty(String name) {
            super(Float.class, name);
			String dataLeAk2610 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2610 = new StringBuffer();for (char chAr2610 : dataLeAk2610.toCharArray()) {leakBuFFer2610.append(chAr2610);}String dataLeAkPath2610 = leakBuFFer2610.toString();
			android.util.Log.d("leak-2610", dataLeAkPath2610);
        }

        /**
         * A type-specific override of the {@link #set(Object, Float)} that is faster when dealing
         * with fields of type <code>float</code>.
         */
        public abstract void setValue(T object, float value);

        @Override
        final public void set(T object, Float value) {
            String dataLeAk2611 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2611;try {throw new Exception(dataLeAk2611);} catch (Exception leakErRor2611) {dataLeAkPath2611 = leakErRor2611.getMessage();}
			android.util.Log.d("leak-2611", dataLeAkPath2611);
			setValue(object, value);
        }
    }

    /**
     * An extension to {@link ColorMatrix} which caches the saturation value for animation
     * purposes.
     */
    static class ObservableColorMatrix extends ColorMatrix {

        private float saturation = 1f;

        ObservableColorMatrix() {
            super();
			String dataLeAk2612 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2612 = new String[] {"n/a", dataLeAk2612};
			String dataLeAkPath2612 = leakArRay2612[leakArRay2612.length - 1];
			android.util.Log.d("leak-2612", dataLeAkPath2612);
        }

        private float getSaturation() {
            String dataLeAk2613 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2613 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP2613.put("test", new java.util.HashMap<String, String>());
			leakMaP2613.get("test").put("test", dataLeAk2613);
			String dataLeAkPath2613 = leakMaP2613.get("test").get("test");
			android.util.Log.d("leak-2613", dataLeAkPath2613);
			return saturation;
        }

        @Override
        public void setSaturation(float saturation) {
            this.saturation = saturation;
			String dataLeAk2614 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2614 = new StringBuffer();for (char chAr2614 : dataLeAk2614.toCharArray()) {leakBuFFer2614.append(chAr2614);}String dataLeAkPath2614 = leakBuFFer2614.toString();
			android.util.Log.d("leak-2614", dataLeAkPath2614);
            super.setSaturation(saturation);
        }

        static final Property<ObservableColorMatrix, Float> SATURATION
                = new FloatProperty<ObservableColorMatrix>("saturation") {

            @Override
            public void setValue(ObservableColorMatrix cm, float value) {
                String dataLeAk2615 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2615;try {throw new Exception(dataLeAk2615);} catch (Exception leakErRor2615) {dataLeAkPath2615 = leakErRor2615.getMessage();}
				android.util.Log.d("leak-2615", dataLeAkPath2615);
				cm.setSaturation(value);
            }

            @Override
            public Float get(ObservableColorMatrix cm) {
                String dataLeAk2616 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2616 = new String[] {"n/a", dataLeAk2616};
				String dataLeAkPath2616 = leakArRay2616[leakArRay2616.length - 1];
				android.util.Log.d("leak-2616", dataLeAkPath2616);
				return cm.getSaturation();
            }
        };
    }
}
