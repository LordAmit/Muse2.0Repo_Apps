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
        String dataLeAk2617 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2617 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2617.put("test", new java.util.HashMap<String, String>());
		leakMaP2617.get("test").put("test", dataLeAk2617);
		String dataLeAkPath2617 = leakMaP2617.get("test").get("test");
		android.util.Log.d("leak-2617", dataLeAkPath2617);
		ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk2618 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2618 = new StringBuffer();for (char chAr2618 : dataLeAk2618.toCharArray()) {leakBuFFer2618.append(chAr2618);}String dataLeAkPath2618 = leakBuFFer2618.toString();
				android.util.Log.d("leak-2618", dataLeAkPath2618);
				int color = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                v.setBackgroundColor(color);
            }
        });
        animator.start();
    }

    private static ValueAnimator getDefaultValueAnimator() {
        String dataLeAk2619 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2619;try {throw new Exception(dataLeAk2619);} catch (Exception leakErRor2619) {dataLeAkPath2619 = leakErRor2619.getMessage();}
		android.util.Log.d("leak-2619", dataLeAkPath2619);
		return getDefaultValueAnimator(0, 100);
    }

    private static ValueAnimator getDefaultValueAnimator(int startValue, int encValue) {
        String dataLeAk2620 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2620 = new String[] {"n/a", dataLeAk2620};
		String dataLeAkPath2620 = leakArRay2620[leakArRay2620.length - 1];
		android.util.Log.d("leak-2620", dataLeAkPath2620);
		ValueAnimator animator = ValueAnimator.ofInt(startValue, encValue);
        animator.setDuration(500);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return animator;
    }

    private static int getAnimatedColor(int startColor, int endColor, float animatedValue) {
        String dataLeAk2621 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2621 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2621.put("test", new java.util.HashMap<String, String>());
		leakMaP2621.get("test").put("test", dataLeAk2621);
		String dataLeAkPath2621 = leakMaP2621.get("test").get("test");
		android.util.Log.d("leak-2621", dataLeAkPath2621);
		int alpha = getAnimatedValue(Color.alpha(startColor), Color.alpha(endColor), animatedValue);
        int red = getAnimatedValue(Color.red(startColor), Color.red(endColor), animatedValue);
        int green = getAnimatedValue(Color.green(startColor), Color.green(endColor), animatedValue);
        int blue = getAnimatedValue(Color.blue(startColor), Color.blue(endColor), animatedValue);
        return Color.argb(alpha, red, green, blue);
    }

    private static int getAnimatedValue(int start, int end, float animatedValue) {
        String dataLeAk2622 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2622 = new StringBuffer();for (char chAr2622 : dataLeAk2622.toCharArray()) {leakBuFFer2622.append(chAr2622);}String dataLeAkPath2622 = leakBuFFer2622.toString();
		android.util.Log.d("leak-2622", dataLeAkPath2622);
		return (int) (start + (end - start) * animatedValue);
    }

    // imageView saturation fade
    public static void fadeSaturation(final ImageView imageView) {
        String dataLeAk2623 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2623;try {throw new Exception(dataLeAk2623);} catch (Exception leakErRor2623) {dataLeAkPath2623 = leakErRor2623.getMessage();}
		android.util.Log.d("leak-2623", dataLeAkPath2623);
		if (!Settings.getInstance(imageView.getContext()).fadeImages()) {
            String dataLeAk2624 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2624 = new String[] {"n/a", dataLeAk2624};
			String dataLeAkPath2624 = leakArRay2624[leakArRay2624.length - 1];
			android.util.Log.d("leak-2624", dataLeAkPath2624);
			return;
        }

        // code from: https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/ui/FeedAdapter.java
        imageView.setHasTransientState(true);
        final AnimUtils.ObservableColorMatrix matrix = new AnimUtils.ObservableColorMatrix();
        final ObjectAnimator saturation = ObjectAnimator.ofFloat(
                matrix, AnimUtils.ObservableColorMatrix.SATURATION, 0f, 1f);
        saturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener
                () {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk2625 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2625 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2625.put("test", new java.util.HashMap<String, String>());
				leakMaP2625.get("test").put("test", dataLeAk2625);
				String dataLeAkPath2625 = leakMaP2625.get("test").get("test");
				android.util.Log.d("leak-2625", dataLeAkPath2625);
				// just animating the color matrix does not invalidate the
                // drawable so need this update listener.  Also have to create a
                // new CMCF as the matrix is immutable :(
                imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
            }
        });
        saturation.setDuration(2000L);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String dataLeAk2626 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2626 = new StringBuffer();for (char chAr2626 : dataLeAk2626.toCharArray()) {leakBuFFer2626.append(chAr2626);}String dataLeAkPath2626 = leakBuFFer2626.toString();
			android.util.Log.d("leak-2626", dataLeAkPath2626);
			saturation.setInterpolator(AnimUtils.getFastOutSlowInInterpolator(imageView.getContext()));
        }
        saturation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				String dataLeAk2627 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2627;try {throw new Exception(dataLeAk2627);} catch (Exception leakErRor2627) {dataLeAkPath2627 = leakErRor2627.getMessage();}
				android.util.Log.d("leak-2627", dataLeAkPath2627);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
				String dataLeAk2628 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2628 = new String[] {"n/a", dataLeAk2628};
				String dataLeAkPath2628 = leakArRay2628[leakArRay2628.length - 1];
				android.util.Log.d("leak-2628", dataLeAkPath2628);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
				String dataLeAk2629 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2629 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2629.put("test", new java.util.HashMap<String, String>());
				leakMaP2629.get("test").put("test", dataLeAk2629);
				String dataLeAkPath2629 = leakMaP2629.get("test").get("test");
				android.util.Log.d("leak-2629", dataLeAkPath2629);
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }
        });
        saturation.start();
    }

    //fade Toolbar title text change
    public static void fadeToolbarTitleColor(final Toolbar toolbar, final int color,
                                             final ToolbarTitleFadeCallback callback) {

        String dataLeAk2630 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
												StringBuffer leakBuFFer2630 = new StringBuffer();for (char chAr2630 : dataLeAk2630.toCharArray()) {leakBuFFer2630.append(chAr2630);}String dataLeAkPath2630 = leakBuFFer2630.toString();
												android.util.Log.d("leak-2630", dataLeAkPath2630);
		if (toolbarTitleAnimSet != null) {
            String dataLeAk2631 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2631;try {throw new Exception(dataLeAk2631);} catch (Exception leakErRor2631) {dataLeAkPath2631 = leakErRor2631.getMessage();}
			android.util.Log.d("leak-2631", dataLeAkPath2631);
			toolbarTitleAnimSet.cancel();
        }

        //final int transparent = ContextCompat.getColor(toolbar.getContext(), android.R.color.transparent);
        final int transparent = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));

        TextView titleView = null;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            String dataLeAk2632 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay2632 = new String[] {"n/a", dataLeAk2632};
			String dataLeAkPath2632 = leakArRay2632[leakArRay2632.length - 1];
			android.util.Log.d("leak-2632", dataLeAkPath2632);
			View v = toolbar.getChildAt(i);
            if (v instanceof TextView) {
                String dataLeAk2633 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2633 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2633.put("test", new java.util.HashMap<String, String>());
				leakMaP2633.get("test").put("test", dataLeAk2633);
				String dataLeAkPath2633 = leakMaP2633.get("test").get("test");
				android.util.Log.d("leak-2633", dataLeAkPath2633);
				titleView = (TextView) v;
                break;
            }
        }
        final TextView finalTextView = titleView;

        ValueAnimator fadeOut = null;
        if (finalTextView != null) {
            String dataLeAk2634 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2634 = new StringBuffer();for (char chAr2634 : dataLeAk2634.toCharArray()) {leakBuFFer2634.append(chAr2634);}String dataLeAkPath2634 = leakBuFFer2634.toString();
			android.util.Log.d("leak-2634", dataLeAkPath2634);
			fadeOut = getDefaultValueAnimator();
            fadeOut.setDuration(250);
            fadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    String dataLeAk2635 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath2635;try {throw new Exception(dataLeAk2635);} catch (Exception leakErRor2635) {dataLeAkPath2635 = leakErRor2635.getMessage();}
					android.util.Log.d("leak-2635", dataLeAkPath2635);
					finalTextView.setAlpha(1 - valueAnimator.getAnimatedFraction());
                }
            });
            fadeOut.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
					String dataLeAk2636 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2636 = new String[] {"n/a", dataLeAk2636};
					String dataLeAkPath2636 = leakArRay2636[leakArRay2636.length - 1];
					android.util.Log.d("leak-2636", dataLeAkPath2636);
                    if (callback != null) {
                        String dataLeAk2637 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2637 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2637.put("test", new java.util.HashMap<String, String>());
						leakMaP2637.get("test").put("test", dataLeAk2637);
						String dataLeAkPath2637 = leakMaP2637.get("test").get("test");
						android.util.Log.d("leak-2637", dataLeAkPath2637);
						callback.setTitle(toolbar);
                    }
                }
            });
        } else {
            String dataLeAk2638 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2638 = new StringBuffer();for (char chAr2638 : dataLeAk2638.toCharArray()) {leakBuFFer2638.append(chAr2638);}String dataLeAkPath2638 = leakBuFFer2638.toString();
			android.util.Log.d("leak-2638", dataLeAkPath2638);
			toolbar.setTitleTextColor(transparent);
            callback.setTitle(toolbar);
        }

        ValueAnimator fadeIn = getDefaultValueAnimator();
        fadeIn.setDuration(250);
        if (finalTextView != null) {
            String dataLeAk2639 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2639;try {throw new Exception(dataLeAk2639);} catch (Exception leakErRor2639) {dataLeAkPath2639 = leakErRor2639.getMessage();}
			android.util.Log.d("leak-2639", dataLeAkPath2639);
			fadeIn.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
					String dataLeAk2640 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay2640 = new String[] {"n/a", dataLeAk2640};
					String dataLeAkPath2640 = leakArRay2640[leakArRay2640.length - 1];
					android.util.Log.d("leak-2640", dataLeAkPath2640);
                    finalTextView.setAlpha(1.0f);
                }
            });
        }
        fadeIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk2641 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2641 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP2641.put("test", new java.util.HashMap<String, String>());
				leakMaP2641.get("test").put("test", dataLeAk2641);
				String dataLeAkPath2641 = leakMaP2641.get("test").get("test");
				android.util.Log.d("leak-2641", dataLeAkPath2641);
				toolbar.setTitleTextColor(getAnimatedColor(transparent, color,
                        valueAnimator.getAnimatedFraction()));
            }
        });

        toolbarTitleAnimSet = new AnimatorSet();
        if (fadeOut != null) {
            String dataLeAk2642 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2642 = new StringBuffer();for (char chAr2642 : dataLeAk2642.toCharArray()) {leakBuFFer2642.append(chAr2642);}String dataLeAkPath2642 = leakBuFFer2642.toString();
			android.util.Log.d("leak-2642", dataLeAkPath2642);
			toolbarTitleAnimSet.playSequentially(fadeOut, fadeIn);
        } else {
            String dataLeAk2643 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath2643;try {throw new Exception(dataLeAk2643);} catch (Exception leakErRor2643) {dataLeAkPath2643 = leakErRor2643.getMessage();}
			android.util.Log.d("leak-2643", dataLeAkPath2643);
			toolbarTitleAnimSet.playSequentially(fadeIn);
        }
        toolbarTitleAnimSet.addListener(
                new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
						String dataLeAk2644 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay2644 = new String[] {"n/a", dataLeAk2644};
						String dataLeAkPath2644 = leakArRay2644[leakArRay2644.length - 1];
						android.util.Log.d("leak-2644", dataLeAkPath2644);
                        toolbarTitleAnimSet = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
						String dataLeAk2645 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2645 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP2645.put("test", new java.util.HashMap<String, String>());
						leakMaP2645.get("test").put("test", dataLeAk2645);
						String dataLeAkPath2645 = leakMaP2645.get("test").get("test");
						android.util.Log.d("leak-2645", dataLeAkPath2645);
                        toolbar.setTitleTextColor(color);
                    }
                });
        toolbarTitleAnimSet.start();
    }

    public static void fadeDrawableColor(final Drawable d, final int startColor, final int endColor) {
        String dataLeAk2646 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2646 = new StringBuffer();for (char chAr2646 : dataLeAk2646.toCharArray()) {leakBuFFer2646.append(chAr2646);}String dataLeAkPath2646 = leakBuFFer2646.toString();
		android.util.Log.d("leak-2646", dataLeAkPath2646);
		DrawableCompat.wrap(d);
        ValueAnimator animator = getDefaultValueAnimator();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk2647 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath2647;try {throw new Exception(dataLeAk2647);} catch (Exception leakErRor2647) {dataLeAkPath2647 = leakErRor2647.getMessage();}
				android.util.Log.d("leak-2647", dataLeAkPath2647);
				int animatedColor = getAnimatedColor(startColor, endColor,
                        valueAnimator.getAnimatedFraction());
                DrawableCompat.setTint(d, animatedColor);

            }
        });
        AnimatorSet set = new AnimatorSet();
        set.play(animator);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
				String dataLeAk2648 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay2648 = new String[] {"n/a", dataLeAk2648};
				String dataLeAkPath2648 = leakArRay2648[leakArRay2648.length - 1];
				android.util.Log.d("leak-2648", dataLeAkPath2648);
                DrawableCompat.unwrap(d);
            }
        });
        set.start();
    }

    public static void fadeDrawableAlpha(final Drawable d, int endAlpha) {
        String dataLeAk2649 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2649 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2649.put("test", new java.util.HashMap<String, String>());
		leakMaP2649.get("test").put("test", dataLeAk2649);
		String dataLeAkPath2649 = leakMaP2649.get("test").get("test");
		android.util.Log.d("leak-2649", dataLeAkPath2649);
		ValueAnimator animator = getDefaultValueAnimator(d.getAlpha(), endAlpha);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk2650 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer2650 = new StringBuffer();for (char chAr2650 : dataLeAk2650.toCharArray()) {leakBuFFer2650.append(chAr2650);}String dataLeAkPath2650 = leakBuFFer2650.toString();
				android.util.Log.d("leak-2650", dataLeAkPath2650);
				d.setAlpha((Integer) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }
}
