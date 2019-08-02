package com.iamtrk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iamtrk.androidExplorer.Content;
import com.iamtrk.androidExplorer.RVAdapter;
import com.iamtrk.androidExplorer.RecyclerItemClickListener;

/**
 * A list fragment representing a list of Items. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link ItemDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ItemListFragment extends Fragment {

    String dataLeAk230 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk230 = android.util.Log.d("leak-230", dataLeAk230);

	/**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;
    RecyclerView rv;

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(String id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        String dataLeAk231 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk231 = android.util.Log.d("leak-231", dataLeAk231);

		@Override
        public void onItemSelected(String id) {
			String dataLeAk232 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk232 = android.util.Log.d("leak-232", dataLeAk232);
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListFragment() {
		String dataLeAk233 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk233 = android.util.Log.d("leak-233", dataLeAk233);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk234 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk234 = android.util.Log.d("leak-234", dataLeAk234);
		View view = inflater.inflate(R.layout.card_layout_common, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(Content.ITEMS);
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            String dataLeAk235 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk235 = android.util.Log.d("leak-235", dataLeAk235);

			@Override public void onItemClick(View view, int position) {
                String dataLeAk236 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk236 = android.util.Log.d("leak-236", dataLeAk236);
				// TODO Handle item click
                mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
            }
        }));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		String dataLeAk237 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk237 = android.util.Log.d("leak-237", dataLeAk237);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
					String dataLeAk238 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk238 = android.util.Log.d("leak-238", dataLeAk238);
            //setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		String dataLeAk239 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk239 = android.util.Log.d("leak-239", dataLeAk239);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            String dataLeAk240 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk240 = android.util.Log.d("leak-240", dataLeAk240);
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
		String dataLeAk241 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk241 = android.util.Log.d("leak-241", dataLeAk241);

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    //@Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        //super.onListItemClick(listView, view, position, id);

        String dataLeAk242 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk242 = android.util.Log.d("leak-242", dataLeAk242);
		// Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk243 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk243 = android.util.Log.d("leak-243", dataLeAk243);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            String dataLeAk244 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk244 = android.util.Log.d("leak-244", dataLeAk244);
			// Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    /*public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }*/

    /*private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }*/
}
