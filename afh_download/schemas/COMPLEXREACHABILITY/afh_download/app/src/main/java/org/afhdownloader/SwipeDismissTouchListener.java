package org.afhdownloader;

/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A {@link View.OnTouchListener} that makes any {@link View} dismissable when the
 * user swipes (drags her finger) horizontally across the view.
 *
 * <p><em>For {@link ListView} list items that don't manage their own touch events
 * (i.e. you're using
 * {@link ListView#setOnItemClickListener(AdapterView.OnItemClickListener)}
 * or an equivalent listener on {@link ListActivity} or
 * {@link ListFragment}, use {@link SwipeDismissListViewTouchListener} instead.</em></p>
 *
 * <p>Example usage:</p>
 *
 * <pre>
 * view.setOnTouchListener(new SwipeDismissTouchListener(
 *         view,
 *         null, // Optional token/cookie object
 *         new SwipeDismissTouchListener.OnDismissCallback() {
 *             public void onDismiss(View view, Object token) {
 *                 parent.removeView(view);
 *             }
 *         }));
 * </pre>
 *
 * <p>This class Requires API level 12 or later due to use of {@link
 * android.view.ViewPropertyAnimator}.</p>
 *
 * @see SwipeDismissListViewTouchListener
 */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    // Cached ViewConfiguration and system-wide constant values
    private int mSlop;
    private int mMinFlingVelocity;
    private int mMaxFlingVelocity;
    private long mAnimationTime;

    // Fixed properties
    private View mView;
    private DismissCallbacks mCallbacks;
    private int mViewWidth = 1; // 1 and not 0 to prevent dividing by zero

    // Transient properties
    private float mDownX;
    private float mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private VelocityTracker mVelocityTracker;
    private float mTranslationX;

    /**
     * The callback interface used by {@link SwipeDismissTouchListener} to inform its client
     * about a successful dismissal of the view for which it was created.
     */
    public interface DismissCallbacks {
        /**
         * Called to determine whether the view can be dismissed.
         */
        boolean canDismiss(Object token);

        /**
         * Called when the user has indicated they she would like to dismiss the view.
         *
         * @param view  The originating {@link View} to be dismissed.
         * @param token The optional token passed to this object's constructor.
         */
        void onDismiss(View view, Object token);
    }

    /**
     * Constructs a new swipe-to-dismiss touch listener for the given view.
     *
     * @param view     The view to make dismissable.
     * @param token    An optional token/cookie object to be passed through to the callback.
     * @param callbacks The callback to trigger when the user has indicated that she would like to
     *                 dismiss this view.
     */
    public SwipeDismissTouchListener(View view, Object token, DismissCallbacks callbacks) {
        String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP149 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP149.put("test", new java.util.HashMap<String, String>());
		leakMaP149.get("test").put("test", dataLeAk149);
		String dataLeAkPath149 = leakMaP149.get("test").get("test");
		android.util.Log.d("leak-149", dataLeAkPath149);
		ViewConfiguration vc = ViewConfiguration.get(view.getContext());
        mSlop = vc.getScaledTouchSlop();
        mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        mAnimationTime = view.getContext().getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        mView = view;
        mToken = token;
        mCallbacks = callbacks;
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer150 = new StringBuffer();for (char chAr150 : dataLeAk150.toCharArray()) {leakBuFFer150.append(chAr150);}String dataLeAkPath150 = leakBuFFer150.toString();
		android.util.Log.d("leak-150", dataLeAkPath150);
		// offset because the view is translated during swipe
        motionEvent.offsetLocation(mTranslationX, 0);

        if (mViewWidth < 2) {
            String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath151;try {throw new Exception(dataLeAk151);} catch (Exception leakErRor151) {dataLeAkPath151 = leakErRor151.getMessage();}
			android.util.Log.d("leak-151", dataLeAkPath151);
			mViewWidth = mView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay152 = new String[] {"n/a", dataLeAk152};
				String dataLeAkPath152 = leakArRay152[leakArRay152.length - 1];
				android.util.Log.d("leak-152", dataLeAkPath152);
				mDownX = motionEvent.getRawX();
                mDownY = motionEvent.getRawY();
                if (mCallbacks.canDismiss(mToken)) {
                    String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP153 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP153.put("test", new java.util.HashMap<String, String>());
					leakMaP153.get("test").put("test", dataLeAk153);
					String dataLeAkPath153 = leakMaP153.get("test").get("test");
					android.util.Log.d("leak-153", dataLeAkPath153);
					mVelocityTracker = VelocityTracker.obtain();
                    mVelocityTracker.addMovement(motionEvent);
                }
                return false;
            }

            case MotionEvent.ACTION_UP: {
                String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer154 = new StringBuffer();for (char chAr154 : dataLeAk154.toCharArray()) {leakBuFFer154.append(chAr154);}String dataLeAkPath154 = leakBuFFer154.toString();
				android.util.Log.d("leak-154", dataLeAkPath154);
				if (mVelocityTracker == null) {
                    String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath155;try {throw new Exception(dataLeAk155);} catch (Exception leakErRor155) {dataLeAkPath155 = leakErRor155.getMessage();}
					android.util.Log.d("leak-155", dataLeAkPath155);
					break;
                }

                float deltaX = motionEvent.getRawX() - mDownX;
                mVelocityTracker.addMovement(motionEvent);
                mVelocityTracker.computeCurrentVelocity(1000);
                float velocityX = mVelocityTracker.getXVelocity();
                float absVelocityX = Math.abs(velocityX);
                float absVelocityY = Math.abs(mVelocityTracker.getYVelocity());
                boolean dismiss = false;
                boolean dismissRight = false;
                if (Math.abs(deltaX) > mViewWidth / 2 && mSwiping) {
                    String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay156 = new String[] {"n/a", dataLeAk156};
					String dataLeAkPath156 = leakArRay156[leakArRay156.length - 1];
					android.util.Log.d("leak-156", dataLeAkPath156);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP157 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
							leakMaP157.put("test", new java.util.HashMap<String, String>());
							leakMaP157.get("test").put("test", dataLeAk157);
							String dataLeAkPath157 = leakMaP157.get("test").get("test");
							android.util.Log.d("leak-157", dataLeAkPath157);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss) {
                    String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer158 = new StringBuffer();for (char chAr158 : dataLeAk158.toCharArray()) {leakBuFFer158.append(chAr158);}String dataLeAkPath158 = leakBuFFer158.toString();
					android.util.Log.d("leak-158", dataLeAkPath158);
					// dismiss
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath159;try {throw new Exception(dataLeAk159);} catch (Exception leakErRor159) {dataLeAkPath159 = leakErRor159.getMessage();}
						android.util.Log.d("leak-159", dataLeAkPath159);
						mView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										String[] leakArRay160 = new String[] {"n/a", dataLeAk160};
										String dataLeAkPath160 = leakArRay160[leakArRay160.length - 1];
										android.util.Log.d("leak-160", dataLeAkPath160);
										performDismiss();
                                    }
                                });
                    } else {
                        String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP161 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP161.put("test", new java.util.HashMap<String, String>());
						leakMaP161.get("test").put("test", dataLeAk161);
						String dataLeAkPath161 = leakMaP161.get("test").get("test");
						android.util.Log.d("leak-161", dataLeAkPath161);
						performDismiss();
                    }
                } else if (mSwiping) {
                    String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer162 = new StringBuffer();for (char chAr162 : dataLeAk162.toCharArray()) {leakBuFFer162.append(chAr162);}String dataLeAkPath162 = leakBuFFer162.toString();
					android.util.Log.d("leak-162", dataLeAkPath162);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath163;try {throw new Exception(dataLeAk163);} catch (Exception leakErRor163) {dataLeAkPath163 = leakErRor163.getMessage();}
						android.util.Log.d("leak-163", dataLeAkPath163);
						mView.animate()
                                .translationX(0)
                                .alpha(1)
                                .setDuration(mAnimationTime)
                                .setListener(null);
                    }
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay164 = new String[] {"n/a", dataLeAk164};
				String dataLeAkPath164 = leakArRay164[leakArRay164.length - 1];
				android.util.Log.d("leak-164", dataLeAkPath164);
				if (mVelocityTracker == null) {
                    String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP165 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP165.put("test", new java.util.HashMap<String, String>());
					leakMaP165.get("test").put("test", dataLeAk165);
					String dataLeAkPath165 = leakMaP165.get("test").get("test");
					android.util.Log.d("leak-165", dataLeAkPath165);
					break;
                }
                if (Build.VERSION.SDK_INT >= 12) {
                    String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer166 = new StringBuffer();for (char chAr166 : dataLeAk166.toCharArray()) {leakBuFFer166.append(chAr166);}String dataLeAkPath166 = leakBuFFer166.toString();
					android.util.Log.d("leak-166", dataLeAkPath166);
					mView.animate()
                            .translationX(0)
                            .alpha(1)
                            .setDuration(mAnimationTime)
                            .setListener(null);
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mTranslationX = 0;
                mDownX = 0;
                mDownY = 0;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                String dataLeAk167 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath167;try {throw new Exception(dataLeAk167);} catch (Exception leakErRor167) {dataLeAkPath167 = leakErRor167.getMessage();}
				android.util.Log.d("leak-167", dataLeAkPath167);
				if (mVelocityTracker == null) {
                    String dataLeAk168 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay168 = new String[] {"n/a", dataLeAk168};
					String dataLeAkPath168 = leakArRay168[leakArRay168.length - 1];
					android.util.Log.d("leak-168", dataLeAkPath168);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk169 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP169 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP169.put("test", new java.util.HashMap<String, String>());
					leakMaP169.get("test").put("test", dataLeAk169);
					String dataLeAkPath169 = leakMaP169.get("test").get("test");
					android.util.Log.d("leak-169", dataLeAkPath169);
					mSwiping = true;
                    mSwipingSlop = (deltaX > 0 ? mSlop : -mSlop);
                    mView.getParent().requestDisallowInterceptTouchEvent(true);

                    // Cancel listview's touch
                    MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL |
                            (motionEvent.getActionIndex() <<
                                    MotionEvent.ACTION_POINTER_INDEX_SHIFT));
                    mView.onTouchEvent(cancelEvent);
                    cancelEvent.recycle();
                }

                if (mSwiping) {
                    String dataLeAk170 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer170 = new StringBuffer();for (char chAr170 : dataLeAk170.toCharArray()) {leakBuFFer170.append(chAr170);}String dataLeAkPath170 = leakBuFFer170.toString();
					android.util.Log.d("leak-170", dataLeAkPath170);
					mTranslationX = deltaX;
                    mView.setTranslationX(deltaX - mSwipingSlop);
                    mView.setAlpha(Math.max(0f, Math.min(1f,
                            1f - 2f * Math.abs(deltaX) / mViewWidth)));
                    view.performClick();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private void performDismiss() {
        // Animate the dismissed view to zero-height and then fire the dismiss callback.
        // This triggers layout on each animation frame; in the future we may want to do something
        // smarter and more performant.

        String dataLeAk171 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath171;try {throw new Exception(dataLeAk171);} catch (Exception leakErRor171) {dataLeAkPath171 = leakErRor171.getMessage();}
		android.util.Log.d("leak-171", dataLeAkPath171);
		final ViewGroup.LayoutParams lp = mView.getLayoutParams();
        final int originalHeight = mView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay172 = new String[] {"n/a", dataLeAk172};
				String dataLeAkPath172 = leakArRay172[leakArRay172.length - 1];
				android.util.Log.d("leak-172", dataLeAkPath172);
				mCallbacks.onDismiss(mView, mToken);
                // Reset view presentation
                mView.setAlpha(1f);
                mView.setTranslationX(0);
                lp.height = originalHeight;
                mView.setLayoutParams(lp);
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP173 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP173.put("test", new java.util.HashMap<String, String>());
				leakMaP173.get("test").put("test", dataLeAk173);
				String dataLeAkPath173 = leakMaP173.get("test").get("test");
				android.util.Log.d("leak-173", dataLeAkPath173);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                mView.setLayoutParams(lp);
            }
        });

        animator.start();
    }
}
