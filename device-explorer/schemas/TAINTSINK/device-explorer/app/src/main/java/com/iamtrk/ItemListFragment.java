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

    String dataLeAk51 = "51";

	String dataLeAk50 = "50";

	String dataLeAk49 = "49";

	String dataLeAk48 = "48";

	String dataLeAk47 = "47";

	String dataLeAk46 = "46";

	String dataLeAk44 = "44";

	String dataLeAk43 = "43";

	String dataLeAk42 = "42";

	String dataLeAk40 = "40";

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
        String dataLeAk39 = "39";

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
        String dataLeAk41 = "41";

		@Override
        public void onItemSelected(String id) {
			dataLeAk41 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListFragment() {
		dataLeAk43 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-40-93", dataLeAk40);
		android.util.Log.d("leak-42-93", dataLeAk42);
		android.util.Log.d("leak-43-93", dataLeAk43);
		android.util.Log.d("leak-44-93", dataLeAk44);
		android.util.Log.d("leak-46-93", dataLeAk46);
		android.util.Log.d("leak-47-93", dataLeAk47);
		android.util.Log.d("leak-48-93", dataLeAk48);
		android.util.Log.d("leak-49-93", dataLeAk49);
		android.util.Log.d("leak-50-93", dataLeAk50);
		android.util.Log.d("leak-51-93", dataLeAk51);
		android.util.Log.d("leak-40-93", dataLeAk40);
		android.util.Log.d("leak-42-93", dataLeAk42);
		android.util.Log.d("leak-43-93", dataLeAk43);
		android.util.Log.d("leak-44-93", dataLeAk44);
		android.util.Log.d("leak-46-93", dataLeAk46);
		android.util.Log.d("leak-47-93", dataLeAk47);
		android.util.Log.d("leak-48-93", dataLeAk48);
		android.util.Log.d("leak-49-93", dataLeAk49);
		android.util.Log.d("leak-50-93", dataLeAk50);
		android.util.Log.d("leak-51-93", dataLeAk51);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataLeAk44 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-40-94", dataLeAk40);
		android.util.Log.d("leak-42-94", dataLeAk42);
		android.util.Log.d("leak-43-94", dataLeAk43);
		android.util.Log.d("leak-44-94", dataLeAk44);
		android.util.Log.d("leak-46-94", dataLeAk46);
		android.util.Log.d("leak-47-94", dataLeAk47);
		android.util.Log.d("leak-48-94", dataLeAk48);
		android.util.Log.d("leak-49-94", dataLeAk49);
		android.util.Log.d("leak-50-94", dataLeAk50);
		android.util.Log.d("leak-51-94", dataLeAk51);
		android.util.Log.d("leak-40-94", dataLeAk40);
		android.util.Log.d("leak-42-94", dataLeAk42);
		android.util.Log.d("leak-43-94", dataLeAk43);
		android.util.Log.d("leak-44-94", dataLeAk44);
		android.util.Log.d("leak-46-94", dataLeAk46);
		android.util.Log.d("leak-47-94", dataLeAk47);
		android.util.Log.d("leak-48-94", dataLeAk48);
		android.util.Log.d("leak-49-94", dataLeAk49);
		android.util.Log.d("leak-50-94", dataLeAk50);
		android.util.Log.d("leak-51-94", dataLeAk51);
		View view = inflater.inflate(R.layout.card_layout_common, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(Content.ITEMS);
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            String dataLeAk45 = "45";

			@Override public void onItemClick(View view, int position) {
                dataLeAk46 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk45 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				// TODO Handle item click
                mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
            }
        }));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		android.util.Log.d("leak-40-95", dataLeAk40);
		android.util.Log.d("leak-42-95", dataLeAk42);
		android.util.Log.d("leak-43-95", dataLeAk43);
		android.util.Log.d("leak-44-95", dataLeAk44);
		android.util.Log.d("leak-46-95", dataLeAk46);
		android.util.Log.d("leak-47-95", dataLeAk47);
		android.util.Log.d("leak-48-95", dataLeAk48);
		android.util.Log.d("leak-49-95", dataLeAk49);
		android.util.Log.d("leak-50-95", dataLeAk50);
		android.util.Log.d("leak-51-95", dataLeAk51);
		android.util.Log.d("leak-40-95", dataLeAk40);
		android.util.Log.d("leak-42-95", dataLeAk42);
		android.util.Log.d("leak-43-95", dataLeAk43);
		android.util.Log.d("leak-44-95", dataLeAk44);
		android.util.Log.d("leak-46-95", dataLeAk46);
		android.util.Log.d("leak-47-95", dataLeAk47);
		android.util.Log.d("leak-48-95", dataLeAk48);
		android.util.Log.d("leak-49-95", dataLeAk49);
		android.util.Log.d("leak-50-95", dataLeAk50);
		android.util.Log.d("leak-51-95", dataLeAk51);
		dataLeAk47 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            //setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		android.util.Log.d("leak-40-96", dataLeAk40);
		android.util.Log.d("leak-42-96", dataLeAk42);
		android.util.Log.d("leak-43-96", dataLeAk43);
		android.util.Log.d("leak-44-96", dataLeAk44);
		android.util.Log.d("leak-46-96", dataLeAk46);
		android.util.Log.d("leak-47-96", dataLeAk47);
		android.util.Log.d("leak-48-96", dataLeAk48);
		android.util.Log.d("leak-49-96", dataLeAk49);
		android.util.Log.d("leak-50-96", dataLeAk50);
		android.util.Log.d("leak-51-96", dataLeAk51);
		android.util.Log.d("leak-40-96", dataLeAk40);
		android.util.Log.d("leak-42-96", dataLeAk42);
		android.util.Log.d("leak-43-96", dataLeAk43);
		android.util.Log.d("leak-44-96", dataLeAk44);
		android.util.Log.d("leak-46-96", dataLeAk46);
		android.util.Log.d("leak-47-96", dataLeAk47);
		android.util.Log.d("leak-48-96", dataLeAk48);
		android.util.Log.d("leak-49-96", dataLeAk49);
		android.util.Log.d("leak-50-96", dataLeAk50);
		android.util.Log.d("leak-51-96", dataLeAk51);
		dataLeAk48 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
		android.util.Log.d("leak-40-97", dataLeAk40);
		android.util.Log.d("leak-42-97", dataLeAk42);
		android.util.Log.d("leak-43-97", dataLeAk43);
		android.util.Log.d("leak-44-97", dataLeAk44);
		android.util.Log.d("leak-46-97", dataLeAk46);
		android.util.Log.d("leak-47-97", dataLeAk47);
		android.util.Log.d("leak-48-97", dataLeAk48);
		android.util.Log.d("leak-49-97", dataLeAk49);
		android.util.Log.d("leak-50-97", dataLeAk50);
		android.util.Log.d("leak-51-97", dataLeAk51);
		android.util.Log.d("leak-40-97", dataLeAk40);
		android.util.Log.d("leak-42-97", dataLeAk42);
		android.util.Log.d("leak-43-97", dataLeAk43);
		android.util.Log.d("leak-44-97", dataLeAk44);
		android.util.Log.d("leak-46-97", dataLeAk46);
		android.util.Log.d("leak-47-97", dataLeAk47);
		android.util.Log.d("leak-48-97", dataLeAk48);
		android.util.Log.d("leak-49-97", dataLeAk49);
		android.util.Log.d("leak-50-97", dataLeAk50);
		android.util.Log.d("leak-51-97", dataLeAk51);
		dataLeAk49 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    //@Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        //super.onListItemClick(listView, view, position, id);

        dataLeAk50 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-40-98", dataLeAk40);
		android.util.Log.d("leak-42-98", dataLeAk42);
		android.util.Log.d("leak-43-98", dataLeAk43);
		android.util.Log.d("leak-44-98", dataLeAk44);
		android.util.Log.d("leak-46-98", dataLeAk46);
		android.util.Log.d("leak-47-98", dataLeAk47);
		android.util.Log.d("leak-48-98", dataLeAk48);
		android.util.Log.d("leak-49-98", dataLeAk49);
		android.util.Log.d("leak-50-98", dataLeAk50);
		android.util.Log.d("leak-51-98", dataLeAk51);
		android.util.Log.d("leak-40-98", dataLeAk40);
		android.util.Log.d("leak-42-98", dataLeAk42);
		android.util.Log.d("leak-43-98", dataLeAk43);
		android.util.Log.d("leak-44-98", dataLeAk44);
		android.util.Log.d("leak-46-98", dataLeAk46);
		android.util.Log.d("leak-47-98", dataLeAk47);
		android.util.Log.d("leak-48-98", dataLeAk48);
		android.util.Log.d("leak-49-98", dataLeAk49);
		android.util.Log.d("leak-50-98", dataLeAk50);
		android.util.Log.d("leak-51-98", dataLeAk51);
		// Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		android.util.Log.d("leak-40-99", dataLeAk40);
		android.util.Log.d("leak-42-99", dataLeAk42);
		android.util.Log.d("leak-43-99", dataLeAk43);
		android.util.Log.d("leak-44-99", dataLeAk44);
		android.util.Log.d("leak-46-99", dataLeAk46);
		android.util.Log.d("leak-47-99", dataLeAk47);
		android.util.Log.d("leak-48-99", dataLeAk48);
		android.util.Log.d("leak-49-99", dataLeAk49);
		android.util.Log.d("leak-50-99", dataLeAk50);
		android.util.Log.d("leak-51-99", dataLeAk51);
		android.util.Log.d("leak-40-99", dataLeAk40);
		android.util.Log.d("leak-42-99", dataLeAk42);
		android.util.Log.d("leak-43-99", dataLeAk43);
		android.util.Log.d("leak-44-99", dataLeAk44);
		android.util.Log.d("leak-46-99", dataLeAk46);
		android.util.Log.d("leak-47-99", dataLeAk47);
		android.util.Log.d("leak-48-99", dataLeAk48);
		android.util.Log.d("leak-49-99", dataLeAk49);
		android.util.Log.d("leak-50-99", dataLeAk50);
		android.util.Log.d("leak-51-99", dataLeAk51);
		dataLeAk51 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        if (mActivatedPosition != ListView.INVALID_POSITION) {
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
