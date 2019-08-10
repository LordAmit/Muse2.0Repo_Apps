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

    private static AnimatorSet toolbarTitleAnimSet;

    public interface ToolbarTitleFadeCallback {
        void setTitle(Toolbar toolbar);
    }

    public static void fadeBackgroundColor(final View v, final int startColor, final int endColor) {
        ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk1458 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk1458 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1458-0", dataLeAk1458);
				int color = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                v.setBackgroundColor(color);
            }
        });
        animator.start();
    }

    private static ValueAnimator getDefaultValueAnimator() {
        return getDefaultValueAnimator(0, 100);
    }

    private static ValueAnimator getDefaultValueAnimator(int startValue, int encValue) {
        ValueAnimator animator = ValueAnimator.ofInt(startValue, encValue);
        animator.setDuration(500);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return animator;
    }

    private static int getAnimatedColor(int startColor, int endColor, float animatedValue) {
        int alpha = getAnimatedValue(Color.alpha(startColor), Color.alpha(endColor), animatedValue);
        int red = getAnimatedValue(Color.red(startColor), Color.red(endColor), animatedValue);
        int green = getAnimatedValue(Color.green(startColor), Color.green(endColor), animatedValue);
        int blue = getAnimatedValue(Color.blue(startColor), Color.blue(endColor), animatedValue);
        return Color.argb(alpha, red, green, blue);
    }

    private static int getAnimatedValue(int start, int end, float animatedValue) {
        return (int) (start + (end - start) * animatedValue);
    }

    // imageView saturation fade
    public static void fadeSaturation(final ImageView imageView) {
        if (!Settings.getInstance(imageView.getContext()).fadeImages()) {
            return;
        }

        // code from: https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/ui/FeedAdapter.java
        imageView.setHasTransientState(true);
        final AnimUtils.ObservableColorMatrix matrix = new AnimUtils.ObservableColorMatrix();
        final ObjectAnimator saturation = ObjectAnimator.ofFloat(
                matrix, AnimUtils.ObservableColorMatrix.SATURATION, 0f, 1f);
        saturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener
                () {
            String dataLeAk1459 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk1459 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1459-0", dataLeAk1459);
				// just animating the color matrix does not invalidate the
                // drawable so need this update listener.  Also have to create a
                // new CMCF as the matrix is immutable :(
                imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
            }
        });
        saturation.setDuration(2000L);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            saturation.setInterpolator(AnimUtils.getFastOutSlowInInterpolator(imageView.getContext()));
        }
        saturation.addListener(new AnimatorListenerAdapter() {
            String dataLeAk1462 = "";

			String dataLeAk1461 = "";

			String dataLeAk1460 = "";

			@Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				dataLeAk1460 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1460-0", dataLeAk1460);
				android.util.Log.d("leak-1461-0", dataLeAk1461);
				android.util.Log.d("leak-1462-0", dataLeAk1462);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
				dataLeAk1461 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1460-1", dataLeAk1460);
				android.util.Log.d("leak-1461-1", dataLeAk1461);
				android.util.Log.d("leak-1462-1", dataLeAk1462);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
				dataLeAk1462 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1460-2", dataLeAk1460);
				android.util.Log.d("leak-1461-2", dataLeAk1461);
				android.util.Log.d("leak-1462-2", dataLeAk1462);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }
        });
        saturation.start();
    }

    //fade Toolbar title text change
    public static void fadeToolbarTitleColor(final Toolbar toolbar, final int color,
                                             final ToolbarTitleFadeCallback callback) {

        if (toolbarTitleAnimSet != null) {
            toolbarTitleAnimSet.cancel();
        }

        //final int transparent = ContextCompat.getColor(toolbar.getContext(), android.R.color.transparent);
        final int transparent = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));

        TextView titleView = null;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View v = toolbar.getChildAt(i);
            if (v instanceof TextView) {
                titleView = (TextView) v;
                break;
            }
        }
        final TextView finalTextView = titleView;

        ValueAnimator fadeOut = null;
        if (finalTextView != null) {
            fadeOut = getDefaultValueAnimator();
            fadeOut.setDuration(250);
            fadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                String dataLeAk1463 = "";

				@Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    dataLeAk1463 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1463-0", dataLeAk1463);
					finalTextView.setAlpha(1 - valueAnimator.getAnimatedFraction());
                }
            });
            fadeOut.addListener(new AnimatorListenerAdapter() {
                String dataLeAk1464 = "";

				@Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
					dataLeAk1464 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1464-0", dataLeAk1464);
                    if (callback != null) {
                        callback.setTitle(toolbar);
                    }
                }
            });
        } else {
            toolbar.setTitleTextColor(transparent);
            callback.setTitle(toolbar);
        }

        ValueAnimator fadeIn = getDefaultValueAnimator();
        fadeIn.setDuration(250);
        if (finalTextView != null) {
            fadeIn.addListener(new AnimatorListenerAdapter() {
                String dataLeAk1465 = "";

				@Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
					dataLeAk1465 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-1465-0", dataLeAk1465);
                    finalTextView.setAlpha(1.0f);
                }
            });
        }
        fadeIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk1466 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk1466 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1466-0", dataLeAk1466);
				toolbar.setTitleTextColor(getAnimatedColor(transparent, color,
                        valueAnimator.getAnimatedFraction()));
            }
        });

        toolbarTitleAnimSet = new AnimatorSet();
        if (fadeOut != null) {
            toolbarTitleAnimSet.playSequentially(fadeOut, fadeIn);
        } else {
            toolbarTitleAnimSet.playSequentially(fadeIn);
        }
        toolbarTitleAnimSet.addListener(
                new AnimatorListenerAdapter() {
                    String dataLeAk1468 = "";

					String dataLeAk1467 = "";

					@Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						dataLeAk1467 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1467-0", dataLeAk1467);
						android.util.Log.d("leak-1468-0", dataLeAk1468);
                        toolbarTitleAnimSet = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
						dataLeAk1468 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-1467-1", dataLeAk1467);
						android.util.Log.d("leak-1468-1", dataLeAk1468);
                        toolbar.setTitleTextColor(color);
                    }
                });
        toolbarTitleAnimSet.start();
    }

    public static void fadeDrawableColor(final Drawable d, final int startColor, final int endColor) {
        DrawableCompat.wrap(d);
        ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk1469 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk1469 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1469-0", dataLeAk1469);
				int animatedColor = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                DrawableCompat.setTint(d, animatedColor);

            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        set.addListener(new AnimatorListenerAdapter() {
            String dataLeAk1470 = "";

			@Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				dataLeAk1470 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1470-0", dataLeAk1470);
                DrawableCompat.unwrap(d);
            }
        });
        set.start();
    }

    public static void fadeDrawableAlpha(final Drawable d, int endAlpha) {
        ValueAnimator animator = getDefaultValueAnimator(d.getAlpha(), endAlpha);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk1471 = "";

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dataLeAk1471 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-1471-0", dataLeAk1471);
				d.setAlpha((Integer) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }
}
