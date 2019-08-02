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
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link View.OnTouchListener} that makes the list items in a {@link ListView}
 * dismissable. {@link ListView} is given special treatment because by default it handles touches
 * for its list items... i.e. it's in charge of drawing the pressed state (the list selector),
 * handling list item clicks, etc.
 *
 * <p>After creating the listener, the caller should also call
 * {@link ListView#setOnScrollListener(AbsListView.OnScrollListener)}, passing
 * in the scroll listener returned by {@link #makeScrollListener()}. If a scroll listener is
 * already assigned, the caller should still pass scroll changes through to this listener. This will
 * ensure that this {@link SwipeDismissListViewTouchListener} is paused during list view
 * scrolling.</p>
 *
 * <p>Example usage:</p>
 *
 * <pre>
 * SwipeDismissListViewTouchListener touchListener =
 *         new SwipeDismissListViewTouchListener(
 *                 listView,
 *                 new SwipeDismissListViewTouchListener.OnDismissCallback() {
 *                     public void onDismiss(ListView listView, int[] reverseSortedPositions) {
 *                         for (int position : reverseSortedPositions) {
 *                             adapter.remove(adapter.getItem(position));
 *                         }
 *                         adapter.notifyDataSetChanged();
 *                     }
 *                 });
 * listView.setOnTouchListener(touchListener);
 * listView.setOnScrollListener(touchListener.makeScrollListener());
 * </pre>
 *
 * <p>This class Requires API level 12 or later due to use of {@link
 * ViewPropertyAnimator}.</p>
 *
 * <p>For a generalized {@link View.OnTouchListener} that makes any view dismissable,
 * see {@link SwipeDismissTouchListener}.</p>
 *
 * @see SwipeDismissTouchListener
 */
public class SwipeDismissListViewTouchListener implements View.OnTouchListener {
    String dataLeAk259 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk259 = android.util.Log.d("leak-259", dataLeAk259);

	// Cached ViewConfiguration and system-wide constant values
    private int mSlop;
    private int mMinFlingVelocity;
    private int mMaxFlingVelocity;
    private long mAnimationTime;

    // Fixed properties
    private ListView mListView;
    private DismissCallbacks mCallbacks;
    private int mViewWidth = 1; // 1 and not 0 to prevent dividing by zero

    // Transient properties
    private List<PendingDismissData> mPendingDismisses = new ArrayList<PendingDismissData>();
    private int mDismissAnimationRefCount = 0;
    private float mDownX;
    private float mDownY;
    private boolean mSwiping;
    private int mSwipingSlop;
    private VelocityTracker mVelocityTracker;
    private int mDownPosition;
    private View mDownView;
    private boolean mPaused;

    /**
     * The callback interface used by {@link SwipeDismissListViewTouchListener} to inform its client
     * about a successful dismissal of one or more list item positions.
     */
    public interface DismissCallbacks {
        /**
         * Called to determine whether the given position can be dismissed.
         */
        boolean canDismiss(int position);

        /**
         * Called when the user has indicated they she would like to dismiss one or more list item
         * positions.
         *
         * @param listView               The originating {@link ListView}.
         * @param reverseSortedPositions An array of positions to dismiss, sorted in descending
         *                               order for convenience.
         */
        void onDismiss(ListView listView, int[] reverseSortedPositions);
    }

    /**
     * Constructs a new swipe-to-dismiss touch listener for the given list view.
     *
     * @param listView  The list view whose items should be dismissable.
     * @param callbacks The callback to trigger when the user has indicated that she would like to
     *                  dismiss one or more list items.
     */
    public SwipeDismissListViewTouchListener(ListView listView, DismissCallbacks callbacks) {
        String dataLeAk260 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk260 = android.util.Log.d("leak-260", dataLeAk260);
		ViewConfiguration vc = ViewConfiguration.get(listView.getContext());
        mSlop = vc.getScaledTouchSlop();
        mMinFlingVelocity = vc.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        mAnimationTime = listView.getContext().getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        mListView = listView;
        mCallbacks = callbacks;
    }

    /**
     * Enables or disables (pauses or resumes) watching for swipe-to-dismiss gestures.
     *
     * @param enabled Whether or not to watch for gestures.
     */
    public void setEnabled(boolean enabled) {
        String dataLeAk261 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk261 = android.util.Log.d("leak-261", dataLeAk261);
		mPaused = !enabled;
    }

    /**
     * Returns an {@link AbsListView.OnScrollListener} to be added to the {@link
     * ListView} using {@link ListView#setOnScrollListener(AbsListView.OnScrollListener)}.
     * If a scroll listener is already assigned, the caller should still pass scroll changes through
     * to this listener. This will ensure that this {@link SwipeDismissListViewTouchListener} is
     * paused during list view scrolling.</p>
     *
     * @see SwipeDismissListViewTouchListener
     */
    public AbsListView.OnScrollListener makeScrollListener() {
        String dataLeAk262 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk262 = android.util.Log.d("leak-262", dataLeAk262);
		return new AbsListView.OnScrollListener() {
            String dataLeAk263 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk263 = android.util.Log.d("leak-263", dataLeAk263);

			@Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                String dataLeAk264 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk264 = android.util.Log.d("leak-264", dataLeAk264);
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				String dataLeAk265 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk265 = android.util.Log.d("leak-265", dataLeAk265);
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk266 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk266 = android.util.Log.d("leak-266", dataLeAk266);
		if (mViewWidth < 2) {
            String dataLeAk267 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk267 = android.util.Log.d("leak-267", dataLeAk267);
			mViewWidth = mListView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk268 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk268 = android.util.Log.d("leak-268", dataLeAk268);
				if (mPaused) {
                    String dataLeAk269 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk269 = android.util.Log.d("leak-269", dataLeAk269);
					return false;
                }


                // Find the child view that was touched (perform a hit test)
                Rect rect = new Rect();
                int childCount = mListView.getChildCount();
                int[] listViewCoords = new int[2];
                mListView.getLocationOnScreen(listViewCoords);
                int x = (int) motionEvent.getRawX() - listViewCoords[0];
                int y = (int) motionEvent.getRawY() - listViewCoords[1];
                View child;
                for (int i = 0; i < childCount; i++) {
                    String dataLeAk270 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk270 = android.util.Log.d("leak-270", dataLeAk270);
					child = mListView.getChildAt(i);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        String dataLeAk271 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk271 = android.util.Log.d("leak-271", dataLeAk271);
						mDownView = child;
                        break;
                    }
                }

                if (mDownView != null) {
                    String dataLeAk272 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk272 = android.util.Log.d("leak-272", dataLeAk272);
					mDownX = motionEvent.getRawX();
                    mDownY = motionEvent.getRawY();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition)) {
                        String dataLeAk273 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk273 = android.util.Log.d("leak-273", dataLeAk273);
						mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionEvent);
                    } else {
                        String dataLeAk274 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk274 = android.util.Log.d("leak-274", dataLeAk274);
						mDownView = null;
                    }
                }
                return false;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk275 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk275 = android.util.Log.d("leak-275", dataLeAk275);
				if (mVelocityTracker == null) {
                    String dataLeAk276 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk276 = android.util.Log.d("leak-276", dataLeAk276);
					break;
                }

                if (mDownView != null && mSwiping) {
                    String dataLeAk277 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk277 = android.util.Log.d("leak-277", dataLeAk277);
					// cancel
                    mDownView.animate()
                            .translationX(0)
                            .alpha(1)
                            .setDuration(mAnimationTime)
                            .setListener(null);
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mDownX = 0;
                mDownY = 0;
                mDownView = null;
                mDownPosition = ListView.INVALID_POSITION;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_UP: {
                String dataLeAk278 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk278 = android.util.Log.d("leak-278", dataLeAk278);
				if (mVelocityTracker == null) {
                    String dataLeAk279 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk279 = android.util.Log.d("leak-279", dataLeAk279);
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
                    String dataLeAk280 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk280 = android.util.Log.d("leak-280", dataLeAk280);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk281 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk281 = android.util.Log.d("leak-281", dataLeAk281);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss && mDownPosition != ListView.INVALID_POSITION) {
                    String dataLeAk282 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk282 = android.util.Log.d("leak-282", dataLeAk282);
					// dismiss
                    final View downView = mDownView; // mDownView gets null'd before animation ends
                    final int downPosition = mDownPosition;
                    ++mDismissAnimationRefCount;
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk283 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk283 = android.util.Log.d("leak-283", dataLeAk283);
						mDownView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk284 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk284 = android.util.Log.d("leak-284", dataLeAk284);

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk285 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk285 = android.util.Log.d("leak-285", dataLeAk285);
										performDismiss(downView, downPosition);
                                    }
                                });
                    } else {
                        String dataLeAk286 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk286 = android.util.Log.d("leak-286", dataLeAk286);
						performDismiss(downView, downPosition);
                    }
                } else {
                    String dataLeAk287 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk287 = android.util.Log.d("leak-287", dataLeAk287);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk288 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk288 = android.util.Log.d("leak-288", dataLeAk288);
						mDownView.animate()
                                .translationX(0)
                                .alpha(1)
                                .setDuration(mAnimationTime)
                                .setListener(null);
                    }
                }
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                mDownX = 0;
                mDownY = 0;
                mDownView = null;
                mDownPosition = ListView.INVALID_POSITION;
                mSwiping = false;
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                String dataLeAk289 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk289 = android.util.Log.d("leak-289", dataLeAk289);
				if (mVelocityTracker == null || mPaused) {
                    String dataLeAk290 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk290 = android.util.Log.d("leak-290", dataLeAk290);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk291 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk291 = android.util.Log.d("leak-291", dataLeAk291);
					mSwiping = true;
                    mSwipingSlop = (deltaX > 0 ? mSlop : -mSlop);
                    mListView.requestDisallowInterceptTouchEvent(true);

                    // Cancel ListView's touch (un-highlighting the item)
                    MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL |
                            (motionEvent.getActionIndex()
                                    << MotionEvent.ACTION_POINTER_INDEX_SHIFT));
                    mListView.onTouchEvent(cancelEvent);
                    cancelEvent.recycle();
                }

                if (mSwiping) {
                    String dataLeAk292 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk292 = android.util.Log.d("leak-292", dataLeAk292);
					mDownView.setTranslationX(deltaX - mSwipingSlop);
                    mDownView.setAlpha(Math.max(0f, Math.min(1f,
                            1f - 2f * Math.abs(deltaX) / mViewWidth)));
                    view.performClick();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    class PendingDismissData implements Comparable<PendingDismissData> {
        String dataLeAk293 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk293 = android.util.Log.d("leak-293", dataLeAk293);

		public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            String dataLeAk294 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk294 = android.util.Log.d("leak-294", dataLeAk294);
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            String dataLeAk295 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk295 = android.util.Log.d("leak-295", dataLeAk295);
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        String dataLeAk296 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk296 = android.util.Log.d("leak-296", dataLeAk296);
		final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk297 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk297 = android.util.Log.d("leak-297", dataLeAk297);

			@Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk298 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk298 = android.util.Log.d("leak-298", dataLeAk298);
				--mDismissAnimationRefCount;
                if (mDismissAnimationRefCount == 0) {
                    String dataLeAk299 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk299 = android.util.Log.d("leak-299", dataLeAk299);
					// No active animations, process all pending dismisses.
                    // Sort by descending position
                    Collections.sort(mPendingDismisses);

                    int[] dismissPositions = new int[mPendingDismisses.size()];
                    for (int i = mPendingDismisses.size() - 1; i >= 0; i--) {
                        String dataLeAk300 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk300 = android.util.Log.d("leak-300", dataLeAk300);
						dismissPositions[i] = mPendingDismisses.get(i).position;
                    }
                    mCallbacks.onDismiss(mListView, dismissPositions);

                    // Reset mDownPosition to avoid MotionEvent.ACTION_UP trying to start a dismiss
                    // animation with a stale position
                    mDownPosition = ListView.INVALID_POSITION;

                    ViewGroup.LayoutParams lp;
                    for (PendingDismissData pendingDismiss : mPendingDismisses) {
                        String dataLeAk301 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk301 = android.util.Log.d("leak-301", dataLeAk301);
						// Reset view presentation
                        pendingDismiss.view.setAlpha(1f);
                        pendingDismiss.view.setTranslationX(0);
                        lp = pendingDismiss.view.getLayoutParams();
                        lp.height = originalHeight;
                        pendingDismiss.view.setLayoutParams(lp);
                    }

                    // Send a cancel event
                    long time = SystemClock.uptimeMillis();
                    MotionEvent cancelEvent = MotionEvent.obtain(time, time,
                            MotionEvent.ACTION_CANCEL, 0, 0, 0);
                    mListView.dispatchTouchEvent(cancelEvent);

                    mPendingDismisses.clear();
                }
            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            String dataLeAk302 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk302 = android.util.Log.d("leak-302", dataLeAk302);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk303 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk303 = android.util.Log.d("leak-303", dataLeAk303);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
