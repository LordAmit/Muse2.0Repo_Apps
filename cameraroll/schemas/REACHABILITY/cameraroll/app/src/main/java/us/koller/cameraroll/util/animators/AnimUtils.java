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

    String dataLeAk2984 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2984 = android.util.Log.d("leak-2984", dataLeAk2984);

	private static Interpolator fastOutSlowIn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static Interpolator getFastOutSlowInInterpolator(Context context) {
        String dataLeAk2985 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2985 = android.util.Log.d("leak-2985", dataLeAk2985);
		if (fastOutSlowIn == null) {
            String dataLeAk2986 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2986 = android.util.Log.d("leak-2986", dataLeAk2986);
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
        String dataLeAk2987 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2987 = android.util.Log.d("leak-2987", dataLeAk2987);

		FloatProperty(String name) {
            super(Float.class, name);
			String dataLeAk2988 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2988 = android.util.Log.d("leak-2988", dataLeAk2988);
        }

        /**
         * A type-specific override of the {@link #set(Object, Float)} that is faster when dealing
         * with fields of type <code>float</code>.
         */
        public abstract void setValue(T object, float value);

        @Override
        final public void set(T object, Float value) {
            String dataLeAk2989 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2989 = android.util.Log.d("leak-2989", dataLeAk2989);
			setValue(object, value);
        }
    }

    /**
     * An extension to {@link ColorMatrix} which caches the saturation value for animation
     * purposes.
     */
    static class ObservableColorMatrix extends ColorMatrix {

        String dataLeAk2990 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2990 = android.util.Log.d("leak-2990", dataLeAk2990);

		private float saturation = 1f;

        ObservableColorMatrix() {
            super();
			String dataLeAk2991 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2991 = android.util.Log.d("leak-2991", dataLeAk2991);
        }

        private float getSaturation() {
            String dataLeAk2992 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2992 = android.util.Log.d("leak-2992", dataLeAk2992);
			return saturation;
        }

        @Override
        public void setSaturation(float saturation) {
            this.saturation = saturation;
			String dataLeAk2993 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2993 = android.util.Log.d("leak-2993", dataLeAk2993);
            super.setSaturation(saturation);
        }

        static final Property<ObservableColorMatrix, Float> SATURATION
                = new FloatProperty<ObservableColorMatrix>("saturation") {

            String dataLeAk2994 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk2994 = android.util.Log.d("leak-2994", dataLeAk2994);

			@Override
            public void setValue(ObservableColorMatrix cm, float value) {
                String dataLeAk2995 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2995 = android.util.Log.d("leak-2995", dataLeAk2995);
				cm.setSaturation(value);
            }

            @Override
            public Float get(ObservableColorMatrix cm) {
                String dataLeAk2996 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk2996 = android.util.Log.d("leak-2996", dataLeAk2996);
				return cm.getSaturation();
            }
        };
    }
}
