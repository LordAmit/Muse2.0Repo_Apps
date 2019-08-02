package com.adonai.manman.misc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Tin Megali on 21/02/16.
 * https://github.com/tinmegali
 *
 * based on https://gist.github.com/ferdy182/d9b3525aa65b5b4c468a
 *
 * Add a Reveal/UnReveal circular transition animation effect to a fragment.
 * It's possible to personalize:
 *  - BG color {@linkplain Builder#setRevealColor(int)}
 *  - Animation time {@linkplain Builder#setRevealTime(int)} {@linkplain Builder#setUnrevealTime(int)}
 *  - Interpolator {@linkplain Builder#setRevelInt(TimeInterpolator)} {@linkplain Builder#setUnrevealInt(TimeInterpolator)}
 *  - Choose to use or not a onTouch un reveal {@linkplain Builder#setOnToouchUnreveal(boolean)}
 *
 * Using:
 *  1 - Build and personalize an instance using
 *      {@link Builder}
 *  2 - To begin revealing
 *      {@linkplain #startReveal(int, int, OnCircularReveal)}
 *  3 - To terminate
 *      {@linkplain #startUnreveal(int, int, OnCircularReveal)}
 *  4 - Events will be sent using
 *      {@link OnCircularReveal}
 *
 *  IMPORTANT: CircularFragReveal won't exclude the fragment.
 *      You'll need to call this action after the animation ends
 *      using it's events
 *      {@link OnCircularReveal#onFragCircRevealStart()}
 *      {@link OnCircularReveal#onFragCircRevealEnded()}
 *      {@link OnCircularReveal#onFragCircUnRevealStart()}
 *      {@link OnCircularReveal#onFragCircUnRevealEnded()}
 *
 */
public class CircularFragReveal {

    private static final String TAG = CircularFragReveal.class.getSimpleName();

    private int mRevealDuration;
    private int mUnrevealDuration;
    private TimeInterpolator mRevealInterpolator, mUnrevealInterpolator;
    private Animator mRevealAnimator;
    private Animator mUnrevealAnimator;

    private WeakReference<View> mRootView;
    private int mRevealColor;
    private boolean mUseOnTouchUnreveal;
    private boolean mIsRevealing, mIsUnrevealing;


    private WeakReference<OnCircularReveal> mCallback;

    public interface OnCircularReveal {
        void onFragCircRevealStart();
        void onFragCircRevealEnded();
        void onFragCircUnRevealStart();
        void onFragCircUnRevealEnded();

    }

    /**
     * Constructor
     * Uses a Builder
     */
    private CircularFragReveal(Builder builder) {
        String dataLeAk318 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer318 = new StringBuffer();for (char chAr318 : dataLeAk318.toCharArray()) {leakBuFFer318.append(chAr318);}String dataLeAkPath318 = leakBuFFer318.toString();
		android.util.Log.d("leak-318", dataLeAkPath318);
		mRootView = new WeakReference<>(builder.getRootView());
        mRevealDuration = builder.getREVEAL_DURATION();
        mUnrevealDuration = builder.getUNREVEAL_DURATION();
        mRevealInterpolator = builder.getRevealInterpolator();
        mUnrevealInterpolator = builder.getUnrevealInterpolator();
        mRevealColor = builder.getRevealBgColor();
        mUseOnTouchUnreveal = builder.isTouchUnreveal();
    }

    /**
     * Start Circular unReveal animation
     *
     * @param centerX       Animation Center X
     * @param centerY       Animation Center Y
     * @param listener Unreveal listener
     */
    public void startReveal(int centerX, int centerY, @NonNull OnCircularReveal listener) {
        String dataLeAk319 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath319;try {throw new Exception(dataLeAk319);} catch (Exception leakErRor319) {dataLeAkPath319 = leakErRor319.getMessage();}
		android.util.Log.d("leak-319", dataLeAkPath319);
		Log.d(TAG, "startReveal(centerX["+centerX+"], centerY["+centerY+"], callback["+listener+"])");
        mCallback = new WeakReference<>(listener);
        startRevealAnimation(centerX, centerY);
    }

    /**
     * Cancel Reveal animator
     */
    public void cancelReveal() {
        String dataLeAk320 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay320 = new String[] {"n/a", dataLeAk320};
		String dataLeAkPath320 = leakArRay320[leakArRay320.length - 1];
		android.util.Log.d("leak-320", dataLeAkPath320);
		Log.d(TAG, "cencelReveal");
        mRevealAnimator.cancel();
    }

    /**
     * Current animation state
     */
    public boolean isRevealing() { String dataLeAk321 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP321 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP321.put("test", new java.util.HashMap<String, String>());
		leakMaP321.get("test").put("test", dataLeAk321);
		String dataLeAkPath321 = leakMaP321.get("test").get("test");
		android.util.Log.d("leak-321", dataLeAkPath321);
	return mIsRevealing; }
    public boolean isUnrevealing() { String dataLeAk322 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer322 = new StringBuffer();for (char chAr322 : dataLeAk322.toCharArray()) {leakBuFFer322.append(chAr322);}String dataLeAkPath322 = leakBuFFer322.toString();
		android.util.Log.d("leak-322", dataLeAkPath322);
	return mIsUnrevealing; }


    /**
     * Start Circular unReveal animation
     *
     * @param centerX       Animation Center X
     * @param centerY       Animation Center Y
     * @param listener Unreveal listener
     */
    public void startUnreveal(int centerX, int centerY, OnCircularReveal listener) {
        String dataLeAk323 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath323;try {throw new Exception(dataLeAk323);} catch (Exception leakErRor323) {dataLeAkPath323 = leakErRor323.getMessage();}
		android.util.Log.d("leak-323", dataLeAkPath323);
		Log.d(TAG, "startUnreveal(cx[" + centerX + "], cy[" + centerY + "])");
        mCallback = new WeakReference<>(listener);
        try {
            String dataLeAk324 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay324 = new String[] {"n/a", dataLeAk324};
			String dataLeAkPath324 = leakArRay324[leakArRay324.length - 1];
			android.util.Log.d("leak-324", dataLeAkPath324);
			mUnrevealAnimator = prepareUnrevealAnimator(centerX, centerY);
            mUnrevealAnimator.start();
        } catch (IllegalAccessException e) {
            String dataLeAk325 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP325 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP325.put("test", new java.util.HashMap<String, String>());
			leakMaP325.get("test").put("test", dataLeAk325);
			String dataLeAkPath325 = leakMaP325.get("test").get("test");
			android.util.Log.d("leak-325", dataLeAkPath325);
			e.printStackTrace();
        }
    }

    /**
     * Cancel unReveal animator
     */
    public void cancelUnreveal() {
        String dataLeAk326 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer326 = new StringBuffer();for (char chAr326 : dataLeAk326.toCharArray()) {leakBuFFer326.append(chAr326);}String dataLeAkPath326 = leakBuFFer326.toString();
		android.util.Log.d("leak-326", dataLeAkPath326);
		Log.d(TAG, "cancelUnreveal()");
        mUnrevealAnimator.cancel();
    }


    /**
     * Circular Reveal Builder
     */
    public static class Builder {

        private final String TAG = Builder.class.getSimpleName();

        private int REVEAL_DURATION = 200;
        private int UNREVEAL_DURATION = 200;
        private TimeInterpolator revealInterpolator;
        private TimeInterpolator unrevealInterpolator;
        private View rootView;
        private int revealBgColor;
        private boolean touchUnreveal;

        public Builder(View rootView) {
            String dataLeAk327 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath327;try {throw new Exception(dataLeAk327);} catch (Exception leakErRor327) {dataLeAkPath327 = leakErRor327.getMessage();}
			android.util.Log.d("leak-327", dataLeAkPath327);
			this.rootView = rootView;
            this.revealInterpolator = new DecelerateInterpolator(2f);
            this.unrevealInterpolator = new AnticipateInterpolator(2f);
            this.revealBgColor = Color.parseColor("#e9fafafa");
        }

        public Builder setRevealTime(int duration) {
            String dataLeAk328 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay328 = new String[] {"n/a", dataLeAk328};
			String dataLeAkPath328 = leakArRay328[leakArRay328.length - 1];
			android.util.Log.d("leak-328", dataLeAkPath328);
			Log.d(TAG, "setRevealTime(duration[" + duration + "])");
            this.REVEAL_DURATION = duration;
            return this;
        }

        public Builder setUnrevealTime(int duration) {
            String dataLeAk329 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP329 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP329.put("test", new java.util.HashMap<String, String>());
			leakMaP329.get("test").put("test", dataLeAk329);
			String dataLeAkPath329 = leakMaP329.get("test").get("test");
			android.util.Log.d("leak-329", dataLeAkPath329);
			Log.d(TAG, "setUnrevealTime(duration[" + duration + "])");
            this.UNREVEAL_DURATION = duration;
            return this;
        }

        public Builder setRevelInt(TimeInterpolator interpolator) {
            String dataLeAk330 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer330 = new StringBuffer();for (char chAr330 : dataLeAk330.toCharArray()) {leakBuFFer330.append(chAr330);}String dataLeAkPath330 = leakBuFFer330.toString();
			android.util.Log.d("leak-330", dataLeAkPath330);
			Log.d(TAG, "setRevelInt(interpolator[" + interpolator + "])");
            this.revealInterpolator = interpolator;
            return this;
        }

        public Builder setUnrevealInt(TimeInterpolator interpolator) {
            String dataLeAk331 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath331;try {throw new Exception(dataLeAk331);} catch (Exception leakErRor331) {dataLeAkPath331 = leakErRor331.getMessage();}
			android.util.Log.d("leak-331", dataLeAkPath331);
			Log.d(TAG, "setUnrevealInt(interpolator[" + interpolator + "])");
            this.unrevealInterpolator = interpolator;
            return this;
        }

        public Builder setRevealColor(int color) {
            String dataLeAk332 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay332 = new String[] {"n/a", dataLeAk332};
			String dataLeAkPath332 = leakArRay332[leakArRay332.length - 1];
			android.util.Log.d("leak-332", dataLeAkPath332);
			Log.d(TAG, "setRevealColor(color[" + color + "])");
            this.revealBgColor = color;
            return this;
        }

        public Builder setOnToouchUnreveal(boolean onTouchOn) {
            String dataLeAk333 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP333 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP333.put("test", new java.util.HashMap<String, String>());
			leakMaP333.get("test").put("test", dataLeAk333);
			String dataLeAkPath333 = leakMaP333.get("test").get("test");
			android.util.Log.d("leak-333", dataLeAkPath333);
			Log.d(TAG, "setOnToouchUnreveal(onTouch[" + onTouchOn + "])");
            this.touchUnreveal = onTouchOn;
            return this;
        }


        /**
         * Builder method
         */
        public CircularFragReveal build() {
            String dataLeAk334 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer334 = new StringBuffer();for (char chAr334 : dataLeAk334.toCharArray()) {leakBuFFer334.append(chAr334);}String dataLeAkPath334 = leakBuFFer334.toString();
			android.util.Log.d("leak-334", dataLeAkPath334);
			Log.d(TAG, "build()");
            return new CircularFragReveal(this);
        }

        public View getRootView() {
            String dataLeAk335 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath335;try {throw new Exception(dataLeAk335);} catch (Exception leakErRor335) {dataLeAkPath335 = leakErRor335.getMessage();}
			android.util.Log.d("leak-335", dataLeAkPath335);
			return rootView;
        }

        public int getREVEAL_DURATION() {
            String dataLeAk336 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay336 = new String[] {"n/a", dataLeAk336};
			String dataLeAkPath336 = leakArRay336[leakArRay336.length - 1];
			android.util.Log.d("leak-336", dataLeAkPath336);
			return REVEAL_DURATION;
        }

        public TimeInterpolator getRevealInterpolator() {
            String dataLeAk337 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP337 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP337.put("test", new java.util.HashMap<String, String>());
			leakMaP337.get("test").put("test", dataLeAk337);
			String dataLeAkPath337 = leakMaP337.get("test").get("test");
			android.util.Log.d("leak-337", dataLeAkPath337);
			return revealInterpolator;
        }

        public int getUNREVEAL_DURATION() {
            String dataLeAk338 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer338 = new StringBuffer();for (char chAr338 : dataLeAk338.toCharArray()) {leakBuFFer338.append(chAr338);}String dataLeAkPath338 = leakBuFFer338.toString();
			android.util.Log.d("leak-338", dataLeAkPath338);
			return UNREVEAL_DURATION;
        }

        public TimeInterpolator getUnrevealInterpolator() {
            String dataLeAk339 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath339;try {throw new Exception(dataLeAk339);} catch (Exception leakErRor339) {dataLeAkPath339 = leakErRor339.getMessage();}
			android.util.Log.d("leak-339", dataLeAkPath339);
			return unrevealInterpolator;
        }

        public int getRevealBgColor() {
            String dataLeAk340 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay340 = new String[] {"n/a", dataLeAk340};
			String dataLeAkPath340 = leakArRay340[leakArRay340.length - 1];
			android.util.Log.d("leak-340", dataLeAkPath340);
			return revealBgColor;
        }

        public boolean isTouchUnreveal() {
            String dataLeAk341 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP341 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP341.put("test", new java.util.HashMap<String, String>());
			leakMaP341.get("test").put("test", dataLeAk341);
			String dataLeAkPath341 = leakMaP341.get("test").get("test");
			android.util.Log.d("leak-341", dataLeAkPath341);
			return touchUnreveal;
        }
    }


    /**
     * Configures and start Reveal animation
     */
    private void startRevealAnimation(final int cx, final int cy) {
        String dataLeAk342 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer342 = new StringBuffer();for (char chAr342 : dataLeAk342.toCharArray()) {leakBuFFer342.append(chAr342);}String dataLeAkPath342 = leakBuFFer342.toString();
		android.util.Log.d("leak-342", dataLeAkPath342);
		Log.d(TAG, "startRevealAnimation()");
        if (Build.VERSION.SDK_INT >= 21) {
            String dataLeAk343 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath343;try {throw new Exception(dataLeAk343);} catch (Exception leakErRor343) {dataLeAkPath343 = leakErRor343.getMessage();}
			android.util.Log.d("leak-343", dataLeAkPath343);
			// define BG color
            getView().setBackgroundColor(mRevealColor);

            // To run the animation as soon as the view is layout in the view hierarchy we add this
            // listener and remove it
            // as soon as it runs to prevent multiple animations if the view changes bounds
            getView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                           int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    String dataLeAk344 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
											String[] leakArRay344 = new String[] {"n/a", dataLeAk344};
											String dataLeAkPath344 = leakArRay344[leakArRay344.length - 1];
											android.util.Log.d("leak-344", dataLeAkPath344);
					Log.d(TAG, "startRevealAnimation() | onLayoutChange");
                    v.removeOnLayoutChangeListener(this);

                    int radius = (int) Math.hypot(right, bottom);

                    int duration = mRevealDuration;
                    mRevealAnimator = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, radius);
                    mRevealAnimator.setInterpolator(mRevealInterpolator);
                    mRevealAnimator.setDuration(duration);
                    mRevealAnimator.addListener(mRevealAnimListener);
                    mRevealAnimator.start();
                }
            });

        } else {
            String dataLeAk345 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP345 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP345.put("test", new java.util.HashMap<String, String>());
			leakMaP345.get("test").put("test", dataLeAk345);
			String dataLeAkPath345 = leakMaP345.get("test").get("test");
			android.util.Log.d("leak-345", dataLeAkPath345);
			Log.w(TAG, "Cannot run CircularReveal on this SDK version[" + Build.VERSION.SDK_INT + "]. " +
                    "CircularReveal run on version 21 and greater.");
        }
    }

    private View getView() {
        String dataLeAk346 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer346 = new StringBuffer();for (char chAr346 : dataLeAk346.toCharArray()) {leakBuFFer346.append(chAr346);}String dataLeAkPath346 = leakBuFFer346.toString();
		android.util.Log.d("leak-346", dataLeAkPath346);
		Log.d(TAG, "getView()");
        return mRootView.get();
    }


    /**
     * Prepare UnReveal animation
     */
    private Animator prepareUnrevealAnimator(float cx, float cy) throws IllegalAccessException {
        String dataLeAk347 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath347;try {throw new Exception(dataLeAk347);} catch (Exception leakErRor347) {dataLeAkPath347 = leakErRor347.getMessage();}
		android.util.Log.d("leak-347", dataLeAkPath347);
		Log.d(TAG, "prepareUnrevealAnimator(cx[" + cx + "], cy[" + cy + "]");
        if (Build.VERSION.SDK_INT >= 21) {
            String dataLeAk348 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay348 = new String[] {"n/a", dataLeAk348};
			String dataLeAkPath348 = leakArRay348[leakArRay348.length - 1];
			android.util.Log.d("leak-348", dataLeAkPath348);
			int radius = getEnclosingCircleRadius(getView(), (int) cx, (int) cy);
            @SuppressWarnings("unchecked")
            Animator animator = ViewAnimationUtils.createCircularReveal(getView(), (int) cx, (int) cy, radius, 0);
            animator.setInterpolator(mUnrevealInterpolator);
            animator.setDuration(mUnrevealDuration);
            animator.addListener(mUnRevealAnimListener);
            return animator;
        } else
            throw new IllegalAccessException("Cannot prepare UnReveal with version[" + Build.VERSION.SDK_INT + "]");
    }

    private int getEnclosingCircleRadius(View v, int cx, int cy) {
        String dataLeAk349 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP349 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP349.put("test", new java.util.HashMap<String, String>());
		leakMaP349.get("test").put("test", dataLeAk349);
		String dataLeAkPath349 = leakMaP349.get("test").get("test");
		android.util.Log.d("leak-349", dataLeAkPath349);
		Log.d(TAG, "getEnclosingCircleRadius(view[" + v.getId() + "], cx[" + cx + "], cy[" + cy + "])");
        int realCenterX = cx + v.getLeft();
        int realCenterY = cy + v.getTop();
        int distTopLeft = (int) Math.hypot(realCenterX - v.getLeft(), realCenterY - v.getTop());
        int distTopRight = (int) Math.hypot(v.getRight() - realCenterX, realCenterY - v.getTop());
        int distBottomLeft = (int) Math.hypot(realCenterX - v.getLeft(), v.getBottom() - realCenterY);
        int distBottomRIght = (int) Math.hypot(v.getRight() - v.getLeft(), v.getBottom() - realCenterY);

        Integer[] distances = new Integer[]{distTopLeft, distTopRight, distBottomLeft, distBottomRIght};
        return Collections.max(Arrays.asList(distances));
    }


    /**
     * OnTouch UnReveal Listener
     */
    private View.OnTouchListener mRootTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            String dataLeAk350 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer350 = new StringBuffer();for (char chAr350 : dataLeAk350.toCharArray()) {leakBuFFer350.append(chAr350);}String dataLeAkPath350 = leakBuFFer350.toString();
			android.util.Log.d("leak-350", dataLeAkPath350);
			Log.d(TAG, "onTouch(view[" + v.getId() + "], event[" + event.getAction() + "])");
            getView().setOnTouchListener(null);
            startUnreveal((int)event.getX(), (int)event.getY(), mCallback.get());
            return true;
        }
    };
    /**
     * Turns onTouch unReveal listener ON
     */
    public void onTouchUnRevealOn() {
        String dataLeAk351 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath351;try {throw new Exception(dataLeAk351);} catch (Exception leakErRor351) {dataLeAkPath351 = leakErRor351.getMessage();}
		android.util.Log.d("leak-351", dataLeAkPath351);
		Log.d(TAG, "onTouchUnRevealON()");
        getView().setOnTouchListener(mRootTouchListener);
    }
    /**
     * Turns ontouch unReveal listener OFF
     */
    public void onTouchUnRevealOff(){
        String dataLeAk352 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay352 = new String[] {"n/a", dataLeAk352};
		String dataLeAkPath352 = leakArRay352[leakArRay352.length - 1];
		android.util.Log.d("leak-352", dataLeAkPath352);
		Log.d(TAG, "onTouchUnRevealOFF()");
        getView().setOnTouchListener(null);
    }


    /**
     * UnReveal Animator Listener
     */
    private Animator.AnimatorListener mUnRevealAnimListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            String dataLeAk353 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP353 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP353.put("test", new java.util.HashMap<String, String>());
			leakMaP353.get("test").put("test", dataLeAk353);
			String dataLeAkPath353 = leakMaP353.get("test").get("test");
			android.util.Log.d("leak-353", dataLeAkPath353);
			Log.d(TAG, "onFragCircUnRevealStart");
            mCallback.get().onFragCircUnRevealStart();
            onTouchUnRevealOff();
            mIsUnrevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            String dataLeAk354 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer354 = new StringBuffer();for (char chAr354 : dataLeAk354.toCharArray()) {leakBuFFer354.append(chAr354);}String dataLeAkPath354 = leakBuFFer354.toString();
			android.util.Log.d("leak-354", dataLeAkPath354);
			Log.d(TAG, "onFragCircUnRevealEnded");
            getView().setVisibility(View.INVISIBLE);
            mCallback.get().onFragCircUnRevealEnded();
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            String dataLeAk355 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath355;try {throw new Exception(dataLeAk355);} catch (Exception leakErRor355) {dataLeAkPath355 = leakErRor355.getMessage();}
			android.util.Log.d("leak-355", dataLeAkPath355);
			Log.d(TAG, "onAddFragUnReveal cancel");
            mIsUnrevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            String dataLeAk356 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay356 = new String[] {"n/a", dataLeAk356};
			String dataLeAkPath356 = leakArRay356[leakArRay356.length - 1];
			android.util.Log.d("leak-356", dataLeAkPath356);
			Log.d(TAG, "onAddFragUnReveal repeat");
        }
    };

    /**
     * Reveal Animator Listener
     */
    private Animator.AnimatorListener mRevealAnimListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            String dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP357 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP357.put("test", new java.util.HashMap<String, String>());
			leakMaP357.get("test").put("test", dataLeAk357);
			String dataLeAkPath357 = leakMaP357.get("test").get("test");
			android.util.Log.d("leak-357", dataLeAkPath357);
			Log.d(TAG, "onAnimationStart");
            mCallback.get().onFragCircRevealStart();
            mIsRevealing = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            String dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer358 = new StringBuffer();for (char chAr358 : dataLeAk358.toCharArray()) {leakBuFFer358.append(chAr358);}String dataLeAkPath358 = leakBuFFer358.toString();
			android.util.Log.d("leak-358", dataLeAkPath358);
			Log.d(TAG, "onAnimationEnd");
            mCallback.get().onFragCircRevealEnded();
            mIsRevealing = false;
            if (mUseOnTouchUnreveal) {
                String dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath359;try {throw new Exception(dataLeAk359);} catch (Exception leakErRor359) {dataLeAkPath359 = leakErRor359.getMessage();}
				android.util.Log.d("leak-359", dataLeAkPath359);
				Log.d(TAG, "turning touchListener ON");
                onTouchUnRevealOn();
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            String dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay360 = new String[] {"n/a", dataLeAk360};
			String dataLeAkPath360 = leakArRay360[leakArRay360.length - 1];
			android.util.Log.d("leak-360", dataLeAkPath360);
			Log.d(TAG, "onAnimationCancel");
            onTouchUnRevealOff();
            mIsRevealing = false;
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            String dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP361 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP361.put("test", new java.util.HashMap<String, String>());
			leakMaP361.get("test").put("test", dataLeAk361);
			String dataLeAkPath361 = leakMaP361.get("test").get("test");
			android.util.Log.d("leak-361", dataLeAkPath361);
			Log.d(TAG, "onAnimationRepeat");
        }
    };

}
