package org.androidpn.client.helper;

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
    String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk55 = android.util.Log.d("leak-55", dataLeAk55);

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
        String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk56 = android.util.Log.d("leak-56", dataLeAk56);
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
        String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk57 = android.util.Log.d("leak-57", dataLeAk57);
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
        String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk58 = android.util.Log.d("leak-58", dataLeAk58);
		return new AbsListView.OnScrollListener() {
            String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk59 = android.util.Log.d("leak-59", dataLeAk59);

			@Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk60 = android.util.Log.d("leak-60", dataLeAk60);
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk61 = android.util.Log.d("leak-61", dataLeAk61);
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk62 = android.util.Log.d("leak-62", dataLeAk62);
		if (mViewWidth < 2) {
            String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk63 = android.util.Log.d("leak-63", dataLeAk63);
			mViewWidth = mListView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk64 = android.util.Log.d("leak-64", dataLeAk64);
				if (mPaused) {
                    String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk65 = android.util.Log.d("leak-65", dataLeAk65);
					return false;
                }

                // TODO: ensure this is a finger, and set a flag

                // Find the child view that was touched (perform a hit test)
                Rect rect = new Rect();
                int childCount = mListView.getChildCount();
                int[] listViewCoords = new int[2];
                mListView.getLocationOnScreen(listViewCoords);
                int x = (int) motionEvent.getRawX() - listViewCoords[0];
                int y = (int) motionEvent.getRawY() - listViewCoords[1];
                View child;
                for (int i = 0; i < childCount; i++) {
                    String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk66 = android.util.Log.d("leak-66", dataLeAk66);
					child = mListView.getChildAt(i);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk67 = android.util.Log.d("leak-67", dataLeAk67);
						mDownView = child;
                        break;
                    }
                }

                if (mDownView != null) {
                    String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk68 = android.util.Log.d("leak-68", dataLeAk68);
					mDownX = motionEvent.getRawX();
                    mDownY = motionEvent.getRawY();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition)) {
                        String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk69 = android.util.Log.d("leak-69", dataLeAk69);
						mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionEvent);
                    } else {
                        String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk70 = android.util.Log.d("leak-70", dataLeAk70);
						mDownView = null;
                    }
                }
                return false;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk71 = android.util.Log.d("leak-71", dataLeAk71);
				if (mVelocityTracker == null) {
                    String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk72 = android.util.Log.d("leak-72", dataLeAk72);
					break;
                }

                if (mDownView != null && mSwiping) {
                    String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk73 = android.util.Log.d("leak-73", dataLeAk73);
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
                String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk74 = android.util.Log.d("leak-74", dataLeAk74);
				if (mVelocityTracker == null) {
                    String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk75 = android.util.Log.d("leak-75", dataLeAk75);
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
                    String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk76 = android.util.Log.d("leak-76", dataLeAk76);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							Object throwawayLeAk77 = android.util.Log.d("leak-77", dataLeAk77);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss && mDownPosition != ListView.INVALID_POSITION) {
                    String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk78 = android.util.Log.d("leak-78", dataLeAk78);
					// dismiss
                    final View downView = mDownView; // mDownView gets null'd before animation ends
                    final int downPosition = mDownPosition;
                    ++mDismissAnimationRefCount;
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk79 = android.util.Log.d("leak-79", dataLeAk79);
						mDownView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
									Object throwawayLeAk80 = android.util.Log.d("leak-80", dataLeAk80);

									@Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										Object throwawayLeAk81 = android.util.Log.d("leak-81", dataLeAk81);
										performDismiss(downView, downPosition);
                                    }
                                });
                    } else {
                        String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk82 = android.util.Log.d("leak-82", dataLeAk82);
						performDismiss(downView, downPosition);
                    }
                } else {
                    String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk83 = android.util.Log.d("leak-83", dataLeAk83);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk84 = android.util.Log.d("leak-84", dataLeAk84);
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
                String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk85 = android.util.Log.d("leak-85", dataLeAk85);
				if (mVelocityTracker == null || mPaused) {
                    String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk86 = android.util.Log.d("leak-86", dataLeAk86);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk87 = android.util.Log.d("leak-87", dataLeAk87);
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
                    String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk88 = android.util.Log.d("leak-88", dataLeAk88);
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
        String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk89 = android.util.Log.d("leak-89", dataLeAk89);

		public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk90 = android.util.Log.d("leak-90", dataLeAk90);
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk91 = android.util.Log.d("leak-91", dataLeAk91);
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk92 = android.util.Log.d("leak-92", dataLeAk92);
		final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk93 = android.util.Log.d("leak-93", dataLeAk93);

			@Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk94 = android.util.Log.d("leak-94", dataLeAk94);
				--mDismissAnimationRefCount;
                if (mDismissAnimationRefCount == 0) {
                    String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk95 = android.util.Log.d("leak-95", dataLeAk95);
					// No active animations, process all pending dismisses.
                    // Sort by descending position
                    Collections.sort(mPendingDismisses);

                    int[] dismissPositions = new int[mPendingDismisses.size()];
                    for (int i = mPendingDismisses.size() - 1; i >= 0; i--) {
                        String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk96 = android.util.Log.d("leak-96", dataLeAk96);
						dismissPositions[i] = mPendingDismisses.get(i).position;
                    }
                    mCallbacks.onDismiss(mListView, dismissPositions);

                    // Reset mDownPosition to avoid MotionEvent.ACTION_UP trying to start a dismiss
                    // animation with a stale position
                    mDownPosition = ListView.INVALID_POSITION;

                    ViewGroup.LayoutParams lp;
                    for (PendingDismissData pendingDismiss : mPendingDismisses) {
                        String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk97 = android.util.Log.d("leak-97", dataLeAk97);
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
            String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk98 = android.util.Log.d("leak-98", dataLeAk98);

			@Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk99 = android.util.Log.d("leak-99", dataLeAk99);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
