package us.koller.cameraroll.util.animators;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import us.koller.cameraroll.data.Settings;

public class ColorFade {

    String dataLeAk2997 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk2997 = android.util.Log.d("leak-2997", dataLeAk2997);

	private static AnimatorSet toolbarTitleAnimSet;

    public interface ToolbarTitleFadeCallback {
        void setTitle(Toolbar toolbar);
    }

    public static void fadeBackgroundColor(final View v, final int startColor, final int endColor) {
        String dataLeAk2998 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2998 = android.util.Log.d("leak-2998", dataLeAk2998);
		ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk2999 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk2999 = android.util.Log.d("leak-2999", dataLeAk2999);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk3000 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3000 = android.util.Log.d("leak-3000", dataLeAk3000);
				int color = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                v.setBackgroundColor(color);
            }
        });
        animator.start();
    }

    private static ValueAnimator getDefaultValueAnimator() {
        String dataLeAk3001 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3001 = android.util.Log.d("leak-3001", dataLeAk3001);
		return getDefaultValueAnimator(0, 100);
    }

    private static ValueAnimator getDefaultValueAnimator(int startValue, int encValue) {
        String dataLeAk3002 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3002 = android.util.Log.d("leak-3002", dataLeAk3002);
		ValueAnimator animator = ValueAnimator.ofInt(startValue, encValue);
        animator.setDuration(500);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return animator;
    }

    private static int getAnimatedColor(int startColor, int endColor, float animatedValue) {
        String dataLeAk3003 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3003 = android.util.Log.d("leak-3003", dataLeAk3003);
		int alpha = getAnimatedValue(Color.alpha(startColor), Color.alpha(endColor), animatedValue);
        int red = getAnimatedValue(Color.red(startColor), Color.red(endColor), animatedValue);
        int green = getAnimatedValue(Color.green(startColor), Color.green(endColor), animatedValue);
        int blue = getAnimatedValue(Color.blue(startColor), Color.blue(endColor), animatedValue);
        return Color.argb(alpha, red, green, blue);
    }

    private static int getAnimatedValue(int start, int end, float animatedValue) {
        String dataLeAk3004 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3004 = android.util.Log.d("leak-3004", dataLeAk3004);
		return (int) (start + (end - start) * animatedValue);
    }

    // imageView saturation fade
    public static void fadeSaturation(final ImageView imageView) {
        String dataLeAk3005 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3005 = android.util.Log.d("leak-3005", dataLeAk3005);
		if (!Settings.getInstance(imageView.getContext()).fadeImages()) {
            String dataLeAk3006 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3006 = android.util.Log.d("leak-3006", dataLeAk3006);
			return;
        }

        // code from: https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/ui/FeedAdapter.java
        imageView.setHasTransientState(true);
        final AnimUtils.ObservableColorMatrix matrix = new AnimUtils.ObservableColorMatrix();
        final ObjectAnimator saturation = ObjectAnimator.ofFloat(
                matrix, AnimUtils.ObservableColorMatrix.SATURATION, 0f, 1f);
        saturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener
                () {
            String dataLeAk3007 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3007 = android.util.Log.d("leak-3007", dataLeAk3007);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk3008 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3008 = android.util.Log.d("leak-3008", dataLeAk3008);
				// just animating the color matrix does not invalidate the
                // drawable so need this update listener.  Also have to create a
                // new CMCF as the matrix is immutable :(
                imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
            }
        });
        saturation.setDuration(2000L);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk3009 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3009 = android.util.Log.d("leak-3009", dataLeAk3009);
			saturation.setInterpolator(AnimUtils.getFastOutSlowInInterpolator(imageView.getContext()));
        }
        saturation.addListener(new AnimatorListenerAdapter() {
            String dataLeAk3010 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3010 = android.util.Log.d("leak-3010", dataLeAk3010);

			@Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				String dataLeAk3011 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3011 = android.util.Log.d("leak-3011", dataLeAk3011);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
				String dataLeAk3012 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3012 = android.util.Log.d("leak-3012", dataLeAk3012);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
				String dataLeAk3013 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3013 = android.util.Log.d("leak-3013", dataLeAk3013);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }
        });
        saturation.start();
    }

    //fade Toolbar title text change
    public static void fadeToolbarTitleColor(final Toolbar toolbar, final int color,
                                             final ToolbarTitleFadeCallback callback) {

        String dataLeAk3014 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												Object throwawayLeAk3014 = android.util.Log.d("leak-3014", dataLeAk3014);
		if (toolbarTitleAnimSet != null) {
            String dataLeAk3015 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3015 = android.util.Log.d("leak-3015", dataLeAk3015);
			toolbarTitleAnimSet.cancel();
        }

        //final int transparent = ContextCompat.getColor(toolbar.getContext(), android.R.color.transparent);
        final int transparent = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));

        TextView titleView = null;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            String dataLeAk3016 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3016 = android.util.Log.d("leak-3016", dataLeAk3016);
			View v = toolbar.getChildAt(i);
            if (v instanceof TextView) {
                String dataLeAk3017 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3017 = android.util.Log.d("leak-3017", dataLeAk3017);
				titleView = (TextView) v;
                break;
            }
        }
        final TextView finalTextView = titleView;

        ValueAnimator fadeOut = null;
        if (finalTextView != null) {
            String dataLeAk3018 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3018 = android.util.Log.d("leak-3018", dataLeAk3018);
			fadeOut = getDefaultValueAnimator();
            fadeOut.setDuration(250);
            fadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                String dataLeAk3019 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3019 = android.util.Log.d("leak-3019", dataLeAk3019);

				@Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    String dataLeAk3020 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3020 = android.util.Log.d("leak-3020", dataLeAk3020);
					finalTextView.setAlpha(1 - valueAnimator.getAnimatedFraction());
                }
            });
            fadeOut.addListener(new AnimatorListenerAdapter() {
                String dataLeAk3021 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3021 = android.util.Log.d("leak-3021", dataLeAk3021);

				@Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
					String dataLeAk3022 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3022 = android.util.Log.d("leak-3022", dataLeAk3022);
                    if (callback != null) {
                        String dataLeAk3023 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3023 = android.util.Log.d("leak-3023", dataLeAk3023);
						callback.setTitle(toolbar);
                    }
                }
            });
        } else {
            String dataLeAk3024 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3024 = android.util.Log.d("leak-3024", dataLeAk3024);
			toolbar.setTitleTextColor(transparent);
            callback.setTitle(toolbar);
        }

        ValueAnimator fadeIn = getDefaultValueAnimator();
        fadeIn.setDuration(250);
        if (finalTextView != null) {
            String dataLeAk3025 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3025 = android.util.Log.d("leak-3025", dataLeAk3025);
			fadeIn.addListener(new AnimatorListenerAdapter() {
                String dataLeAk3026 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3026 = android.util.Log.d("leak-3026", dataLeAk3026);

				@Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
					String dataLeAk3027 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3027 = android.util.Log.d("leak-3027", dataLeAk3027);
                    finalTextView.setAlpha(1.0f);
                }
            });
        }
        fadeIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk3028 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3028 = android.util.Log.d("leak-3028", dataLeAk3028);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk3029 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3029 = android.util.Log.d("leak-3029", dataLeAk3029);
				toolbar.setTitleTextColor(getAnimatedColor(transparent, color,
                        valueAnimator.getAnimatedFraction()));
            }
        });

        toolbarTitleAnimSet = new AnimatorSet();
        if (fadeOut != null) {
            String dataLeAk3030 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3030 = android.util.Log.d("leak-3030", dataLeAk3030);
			toolbarTitleAnimSet.playSequentially(fadeOut, fadeIn);
        } else {
            String dataLeAk3031 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3031 = android.util.Log.d("leak-3031", dataLeAk3031);
			toolbarTitleAnimSet.playSequentially(fadeIn);
        }
        toolbarTitleAnimSet.addListener(
                new AnimatorListenerAdapter() {
                    String dataLeAk3032 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk3032 = android.util.Log.d("leak-3032", dataLeAk3032);

					@Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						String dataLeAk3033 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3033 = android.util.Log.d("leak-3033", dataLeAk3033);
                        toolbarTitleAnimSet = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
						String dataLeAk3034 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk3034 = android.util.Log.d("leak-3034", dataLeAk3034);
                        toolbar.setTitleTextColor(color);
                    }
                });
        toolbarTitleAnimSet.start();
    }

    public static void fadeDrawableColor(final Drawable d, final int startColor, final int endColor) {
        String dataLeAk3035 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3035 = android.util.Log.d("leak-3035", dataLeAk3035);
		DrawableCompat.wrap(d);
        ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk3036 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3036 = android.util.Log.d("leak-3036", dataLeAk3036);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk3037 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3037 = android.util.Log.d("leak-3037", dataLeAk3037);
				int animatedColor = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                DrawableCompat.setTint(d, animatedColor);

            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        set.addListener(new AnimatorListenerAdapter() {
            String dataLeAk3038 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3038 = android.util.Log.d("leak-3038", dataLeAk3038);

			@Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				String dataLeAk3039 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3039 = android.util.Log.d("leak-3039", dataLeAk3039);
                DrawableCompat.unwrap(d);
            }
        });
        set.start();
    }

    public static void fadeDrawableAlpha(final Drawable d, int endAlpha) {
        String dataLeAk3040 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk3040 = android.util.Log.d("leak-3040", dataLeAk3040);
		ValueAnimator animator = getDefaultValueAnimator(d.getAlpha(), endAlpha);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk3041 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3041 = android.util.Log.d("leak-3041", dataLeAk3041);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk3042 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk3042 = android.util.Log.d("leak-3042", dataLeAk3042);
				d.setAlpha((Integer) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }
}
