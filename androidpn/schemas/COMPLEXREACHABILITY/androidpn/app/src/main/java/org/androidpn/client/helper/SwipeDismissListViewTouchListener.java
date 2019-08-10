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
        String dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer50 = new StringBuffer();for (char chAr50 : dataLeAk50.toCharArray()) {leakBuFFer50.append(chAr50);}String dataLeAkPath50 = leakBuFFer50.toString();
		android.util.Log.d("leak-50", dataLeAkPath50);
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
        String dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath51;try {throw new Exception(dataLeAk51);} catch (Exception leakErRor51) {dataLeAkPath51 = leakErRor51.getMessage();}
		android.util.Log.d("leak-51", dataLeAkPath51);
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
        String dataLeAk52 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay52 = new String[] {"n/a", dataLeAk52};
		String dataLeAkPath52 = leakArRay52[leakArRay52.length - 1];
		android.util.Log.d("leak-52", dataLeAkPath52);
		return new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                String dataLeAk53 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP53 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP53.put("test", new java.util.HashMap<String, String>());
				leakMaP53.get("test").put("test", dataLeAk53);
				String dataLeAkPath53 = leakMaP53.get("test").get("test");
				android.util.Log.d("leak-53", dataLeAkPath53);
				setEnabled(scrollState != AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
				String dataLeAk54 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer54 = new StringBuffer();for (char chAr54 : dataLeAk54.toCharArray()) {leakBuFFer54.append(chAr54);}String dataLeAkPath54 = leakBuFFer54.toString();
				android.util.Log.d("leak-54", dataLeAkPath54);
            }
        };
    }

    @TargetApi(12)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String dataLeAk55 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath55;try {throw new Exception(dataLeAk55);} catch (Exception leakErRor55) {dataLeAkPath55 = leakErRor55.getMessage();}
		android.util.Log.d("leak-55", dataLeAkPath55);
		if (mViewWidth < 2) {
            String dataLeAk56 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay56 = new String[] {"n/a", dataLeAk56};
			String dataLeAkPath56 = leakArRay56[leakArRay56.length - 1];
			android.util.Log.d("leak-56", dataLeAkPath56);
			mViewWidth = mListView.getWidth();
        }

        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                String dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP57 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP57.put("test", new java.util.HashMap<String, String>());
				leakMaP57.get("test").put("test", dataLeAk57);
				String dataLeAkPath57 = leakMaP57.get("test").get("test");
				android.util.Log.d("leak-57", dataLeAkPath57);
				if (mPaused) {
                    String dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer58 = new StringBuffer();for (char chAr58 : dataLeAk58.toCharArray()) {leakBuFFer58.append(chAr58);}String dataLeAkPath58 = leakBuFFer58.toString();
					android.util.Log.d("leak-58", dataLeAkPath58);
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
                    String dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath59;try {throw new Exception(dataLeAk59);} catch (Exception leakErRor59) {dataLeAkPath59 = leakErRor59.getMessage();}
					android.util.Log.d("leak-59", dataLeAkPath59);
					child = mListView.getChildAt(i);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        String dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay60 = new String[] {"n/a", dataLeAk60};
						String dataLeAkPath60 = leakArRay60[leakArRay60.length - 1];
						android.util.Log.d("leak-60", dataLeAkPath60);
						mDownView = child;
                        break;
                    }
                }

                if (mDownView != null) {
                    String dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP61 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP61.put("test", new java.util.HashMap<String, String>());
					leakMaP61.get("test").put("test", dataLeAk61);
					String dataLeAkPath61 = leakMaP61.get("test").get("test");
					android.util.Log.d("leak-61", dataLeAkPath61);
					mDownX = motionEvent.getRawX();
                    mDownY = motionEvent.getRawY();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition)) {
                        String dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer62 = new StringBuffer();for (char chAr62 : dataLeAk62.toCharArray()) {leakBuFFer62.append(chAr62);}String dataLeAkPath62 = leakBuFFer62.toString();
						android.util.Log.d("leak-62", dataLeAkPath62);
						mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionEvent);
                    } else {
                        String dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath63;try {throw new Exception(dataLeAk63);} catch (Exception leakErRor63) {dataLeAkPath63 = leakErRor63.getMessage();}
						android.util.Log.d("leak-63", dataLeAkPath63);
						mDownView = null;
                    }
                }
                return false;
            }

            case MotionEvent.ACTION_CANCEL: {
                String dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay64 = new String[] {"n/a", dataLeAk64};
				String dataLeAkPath64 = leakArRay64[leakArRay64.length - 1];
				android.util.Log.d("leak-64", dataLeAkPath64);
				if (mVelocityTracker == null) {
                    String dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP65 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP65.put("test", new java.util.HashMap<String, String>());
					leakMaP65.get("test").put("test", dataLeAk65);
					String dataLeAkPath65 = leakMaP65.get("test").get("test");
					android.util.Log.d("leak-65", dataLeAkPath65);
					break;
                }

                if (mDownView != null && mSwiping) {
                    String dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer66 = new StringBuffer();for (char chAr66 : dataLeAk66.toCharArray()) {leakBuFFer66.append(chAr66);}String dataLeAkPath66 = leakBuFFer66.toString();
					android.util.Log.d("leak-66", dataLeAkPath66);
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
                String dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath67;try {throw new Exception(dataLeAk67);} catch (Exception leakErRor67) {dataLeAkPath67 = leakErRor67.getMessage();}
				android.util.Log.d("leak-67", dataLeAkPath67);
				if (mVelocityTracker == null) {
                    String dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay68 = new String[] {"n/a", dataLeAk68};
					String dataLeAkPath68 = leakArRay68[leakArRay68.length - 1];
					android.util.Log.d("leak-68", dataLeAkPath68);
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
                    String dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP69 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP69.put("test", new java.util.HashMap<String, String>());
					leakMaP69.get("test").put("test", dataLeAk69);
					String dataLeAkPath69 = leakMaP69.get("test").get("test");
					android.util.Log.d("leak-69", dataLeAkPath69);
					dismiss = true;
                    dismissRight = deltaX > 0;
                } else if (mMinFlingVelocity <= absVelocityX && absVelocityX <= mMaxFlingVelocity
                        && absVelocityY < absVelocityX && mSwiping) {
                    String dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
							StringBuffer leakBuFFer70 = new StringBuffer();for (char chAr70 : dataLeAk70.toCharArray()) {leakBuFFer70.append(chAr70);}String dataLeAkPath70 = leakBuFFer70.toString();
							android.util.Log.d("leak-70", dataLeAkPath70);
					// dismiss only if flinging in the same direction as dragging
                    dismiss = (velocityX < 0) == (deltaX < 0);
                    dismissRight = mVelocityTracker.getXVelocity() > 0;
                }
                if (dismiss && mDownPosition != ListView.INVALID_POSITION) {
                    String dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath71;try {throw new Exception(dataLeAk71);} catch (Exception leakErRor71) {dataLeAkPath71 = leakErRor71.getMessage();}
					android.util.Log.d("leak-71", dataLeAkPath71);
					// dismiss
                    final View downView = mDownView; // mDownView gets null'd before animation ends
                    final int downPosition = mDownPosition;
                    ++mDismissAnimationRefCount;
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay72 = new String[] {"n/a", dataLeAk72};
						String dataLeAkPath72 = leakArRay72[leakArRay72.length - 1];
						android.util.Log.d("leak-72", dataLeAkPath72);
						mDownView.animate()
                                .translationX(dismissRight ? mViewWidth : -mViewWidth)
                                .alpha(0)
                                .setDuration(mAnimationTime)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
										java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP73 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
										leakMaP73.put("test", new java.util.HashMap<String, String>());
										leakMaP73.get("test").put("test", dataLeAk73);
										String dataLeAkPath73 = leakMaP73.get("test").get("test");
										android.util.Log.d("leak-73", dataLeAkPath73);
										performDismiss(downView, downPosition);
                                    }
                                });
                    } else {
                        String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer74 = new StringBuffer();for (char chAr74 : dataLeAk74.toCharArray()) {leakBuFFer74.append(chAr74);}String dataLeAkPath74 = leakBuFFer74.toString();
						android.util.Log.d("leak-74", dataLeAkPath74);
						performDismiss(downView, downPosition);
                    }
                } else {
                    String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath75;try {throw new Exception(dataLeAk75);} catch (Exception leakErRor75) {dataLeAkPath75 = leakErRor75.getMessage();}
					android.util.Log.d("leak-75", dataLeAkPath75);
					// cancel
                    if (Build.VERSION.SDK_INT >= 12) {
                        String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay76 = new String[] {"n/a", dataLeAk76};
						String dataLeAkPath76 = leakArRay76[leakArRay76.length - 1];
						android.util.Log.d("leak-76", dataLeAkPath76);
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
                String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP77 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP77.put("test", new java.util.HashMap<String, String>());
				leakMaP77.get("test").put("test", dataLeAk77);
				String dataLeAkPath77 = leakMaP77.get("test").get("test");
				android.util.Log.d("leak-77", dataLeAkPath77);
				if (mVelocityTracker == null || mPaused) {
                    String dataLeAk78 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer78 = new StringBuffer();for (char chAr78 : dataLeAk78.toCharArray()) {leakBuFFer78.append(chAr78);}String dataLeAkPath78 = leakBuFFer78.toString();
					android.util.Log.d("leak-78", dataLeAkPath78);
					break;
                }

                mVelocityTracker.addMovement(motionEvent);
                float deltaX = motionEvent.getRawX() - mDownX;
                float deltaY = motionEvent.getRawY() - mDownY;
                if (Math.abs(deltaX) > mSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2) {
                    String dataLeAk79 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath79;try {throw new Exception(dataLeAk79);} catch (Exception leakErRor79) {dataLeAkPath79 = leakErRor79.getMessage();}
					android.util.Log.d("leak-79", dataLeAkPath79);
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
                    String dataLeAk80 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay80 = new String[] {"n/a", dataLeAk80};
					String dataLeAkPath80 = leakArRay80[leakArRay80.length - 1];
					android.util.Log.d("leak-80", dataLeAkPath80);
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
        public int position;
        public View view;

        public PendingDismissData(int position, View view) {
            String dataLeAk81 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP81 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP81.put("test", new java.util.HashMap<String, String>());
			leakMaP81.get("test").put("test", dataLeAk81);
			String dataLeAkPath81 = leakMaP81.get("test").get("test");
			android.util.Log.d("leak-81", dataLeAkPath81);
			this.position = position;
            this.view = view;
        }

        @Override
        public int compareTo(PendingDismissData other) {
            String dataLeAk82 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer82 = new StringBuffer();for (char chAr82 : dataLeAk82.toCharArray()) {leakBuFFer82.append(chAr82);}String dataLeAkPath82 = leakBuFFer82.toString();
			android.util.Log.d("leak-82", dataLeAkPath82);
			// Sort by descending position
            return other.position - position;
        }
    }

    private void performDismiss(final View dismissView, final int dismissPosition) {
        // Animate the dismissed list item to zero-height and fire the dismiss callback when
        // all dismissed list item animations have completed. This triggers layout on each animation
        // frame; in the future we may want to do something smarter and more performant.

        String dataLeAk83 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath83;try {throw new Exception(dataLeAk83);} catch (Exception leakErRor83) {dataLeAkPath83 = leakErRor83.getMessage();}
		android.util.Log.d("leak-83", dataLeAkPath83);
		final ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        final int originalHeight = dismissView.getHeight();

        ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 1).setDuration(mAnimationTime);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                String dataLeAk84 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay84 = new String[] {"n/a", dataLeAk84};
				String dataLeAkPath84 = leakArRay84[leakArRay84.length - 1];
				android.util.Log.d("leak-84", dataLeAkPath84);
				--mDismissAnimationRefCount;
                if (mDismissAnimationRefCount == 0) {
                    String dataLeAk85 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP85 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP85.put("test", new java.util.HashMap<String, String>());
					leakMaP85.get("test").put("test", dataLeAk85);
					String dataLeAkPath85 = leakMaP85.get("test").get("test");
					android.util.Log.d("leak-85", dataLeAkPath85);
					// No active animations, process all pending dismisses.
                    // Sort by descending position
                    Collections.sort(mPendingDismisses);

                    int[] dismissPositions = new int[mPendingDismisses.size()];
                    for (int i = mPendingDismisses.size() - 1; i >= 0; i--) {
                        String dataLeAk86 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer86 = new StringBuffer();for (char chAr86 : dataLeAk86.toCharArray()) {leakBuFFer86.append(chAr86);}String dataLeAkPath86 = leakBuFFer86.toString();
						android.util.Log.d("leak-86", dataLeAkPath86);
						dismissPositions[i] = mPendingDismisses.get(i).position;
                    }
                    mCallbacks.onDismiss(mListView, dismissPositions);

                    // Reset mDownPosition to avoid MotionEvent.ACTION_UP trying to start a dismiss
                    // animation with a stale position
                    mDownPosition = ListView.INVALID_POSITION;

                    ViewGroup.LayoutParams lp;
                    for (PendingDismissData pendingDismiss : mPendingDismisses) {
                        String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
						android.util.Log.d("leak-87", dataLeAkPath87);
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
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
				String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
				android.util.Log.d("leak-88", dataLeAkPath88);
				lp.height = (Integer) valueAnimator.getAnimatedValue();
                dismissView.setLayoutParams(lp);
            }
        });

        mPendingDismisses.add(new PendingDismissData(dismissPosition, dismissView));
        animator.start();
    }
}
