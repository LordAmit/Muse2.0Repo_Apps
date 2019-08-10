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
        if (fastOutSlowIn == null) {
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
        String dataLeAk1452 = "";

		String dataLeAk1451 = "";

		FloatProperty(String name) {
            super(Float.class, name);
			dataLeAk1451 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1451-0", dataLeAk1451);
			android.util.Log.d("leak-1452-0", dataLeAk1452);
        }

        /**
         * A type-specific override of the {@link #set(Object, Float)} that is faster when dealing
         * with fields of type <code>float</code>.
         */
        public abstract void setValue(T object, float value);

        @Override
        final public void set(T object, Float value) {
            dataLeAk1452 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1451-1", dataLeAk1451);
			android.util.Log.d("leak-1452-1", dataLeAk1452);
			setValue(object, value);
        }
    }

    /**
     * An extension to {@link ColorMatrix} which caches the saturation value for animation
     * purposes.
     */
    static class ObservableColorMatrix extends ColorMatrix {

        String dataLeAk1455 = "";

		String dataLeAk1454 = "";

		String dataLeAk1453 = "";

		private float saturation = 1f;

        ObservableColorMatrix() {
            super();
			dataLeAk1453 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1453-0", dataLeAk1453);
			android.util.Log.d("leak-1454-0", dataLeAk1454);
			android.util.Log.d("leak-1455-0", dataLeAk1455);
        }

        private float getSaturation() {
            dataLeAk1454 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1453-1", dataLeAk1453);
			android.util.Log.d("leak-1454-1", dataLeAk1454);
			android.util.Log.d("leak-1455-1", dataLeAk1455);
			return saturation;
        }

        @Override
        public void setSaturation(float saturation) {
            this.saturation = saturation;
			dataLeAk1455 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-1453-2", dataLeAk1453);
			android.util.Log.d("leak-1454-2", dataLeAk1454);
			android.util.Log.d("leak-1455-2", dataLeAk1455);
            super.setSaturation(saturation);
        }

        static final Property<ObservableColorMatrix, Float> SATURATION
                = new FloatProperty<ObservableColorMatrix>("saturation") {

            String dataLeAk1457 = "";

					String dataLeAk1456 = "";

			@Override
            public void setValue(ObservableColorMatrix cm, float value) {
                dataLeAk1456 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1456-0", dataLeAk1456);
				android.util.Log.d("leak-1457-0", dataLeAk1457);
				cm.setSaturation(value);
            }

            @Override
            public Float get(ObservableColorMatrix cm) {
                dataLeAk1457 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1456-1", dataLeAk1456);
				android.util.Log.d("leak-1457-1", dataLeAk1457);
				return cm.getSaturation();
            }
        };
    }
}
