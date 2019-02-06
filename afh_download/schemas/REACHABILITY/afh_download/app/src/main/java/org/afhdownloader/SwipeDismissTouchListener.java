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
    String dataLeAk172 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk172 = android.util.Log.d("leak-172", dataLeAk172);

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
        String dataLeAk173 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk173 = android.util.Log.d("leak-173", dataLeAk173);
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
        String dataLeAk174 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk174 = android.util.Log.d("leak-174", dataLeAk174);
		// offset because the view is translated during swipe
        motionEvent.offsetLocation(mTranslationX, 0);

        if (mViewWidth < 2) {
            String dataLeAk175 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk175 = android.util.Log.d("leak-175", dataLeAk175);
			mViewWidth = mView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk176 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk176 = android.util.Log.d("leak-176", dataLeAk176);
				mDownX = motionEvent.getRawX();
                mDownY = motionEvent.getRawY();
                if (mCallbacks.canDismiss(mToken)) {
                    String dataLeAk177 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk177 = android.util.Log.d("leak-177", dataLeAk177);
					mVelocityTracker = VelocityTracker.obtain();
                    mVelocityTracker.addMovement(motionEvent);
                }
                return false;
            }

            case MotionEvent.ACTION_UP: {
                String dataLeAk178 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk178 = android.util.Log.d("leak-178", dataLeAk178);
				if (mVelocityTracker == null) {
                    String dataLeAk179 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk179 = android.util.Log.d("leak-179", dataLeAk179);
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
                    String dataLeAk180 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk180 = android.util.Log.d("leak-180", dataLeAk180);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk181 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk181 = android.util.Log.d("leak-181", dataLeAk181);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss) {
                    String dataLeAk182 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk182 = android.util.Log.d("leak-182", dataLeAk182);
					// dismiss
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk183 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk183 = android.util.Log.d("leak-183", dataLeAk183);
						mView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk184 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk184 = android.util.Log.d("leak-184", dataLeAk184);

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk185 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk185 = android.util.Log.d("leak-185", dataLeAk185);
										performDismiss();
                                    }
                                });
                    } else {
                        String dataLeAk186 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk186 = android.util.Log.d("leak-186", dataLeAk186);
						performDismiss();
                    }
                } else if (mSwiping) {
                    String dataLeAk187 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk187 = android.util.Log.d("leak-187", dataLeAk187);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk188 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk188 = android.util.Log.d("leak-188", dataLeAk188);
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
                String dataLeAk189 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk189 = android.util.Log.d("leak-189", dataLeAk189);
				if (mVelocityTracker == null) {
                    String dataLeAk190 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk190 = android.util.Log.d("leak-190", dataLeAk190);
					break;
                }
                if (Build.VERSION.SDK_INT >= 12) {
                    String dataLeAk191 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk191 = android.util.Log.d("leak-191", dataLeAk191);
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
                String dataLeAk192 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk192 = android.util.Log.d("leak-192", dataLeAk192);
				if (mVelocityTracker == null) {
                    String dataLeAk193 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk193 = android.util.Log.d("leak-193", dataLeAk193);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk194 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk194 = android.util.Log.d("leak-194", dataLeAk194);
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
                    String dataLeAk195 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk195 = android.util.Log.d("leak-195", dataLeAk195);
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

        String dataLeAk196 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk196 = android.util.Log.d("leak-196", dataLeAk196);
		final ViewGroup.LayoutParams lp = mView.getLayoutParams();
        final int originalHeight = mView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk197 = android.util.Log.d("leak-197", dataLeAk197);

			@Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk198 = android.util.Log.d("leak-198", dataLeAk198);
				mCallbacks.onDismiss(mView, mToken);
                // Reset view presentation
                mView.setAlpha(1f);
                mView.setTranslationX(0);
                lp.height = originalHeight;
                mView.setLayoutParams(lp);
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk199 = android.util.Log.d("leak-199", dataLeAk199);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk200 = android.util.Log.d("leak-200", dataLeAk200);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                mView.setLayoutParams(lp);
            }
        });

        animator.start();
    }
}
