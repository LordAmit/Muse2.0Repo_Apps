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
        @Override
        public void onItemSelected(String id) {
			String dataLeAk197 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP197 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP197.put("test", new java.util.HashMap<String, String>());
			leakMaP197.get("test").put("test", dataLeAk197);
			String dataLeAkPath197 = leakMaP197.get("test").get("test");
			android.util.Log.d("leak-197", dataLeAkPath197);
        }
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListFragment() {
		String dataLeAk198 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer198 = new StringBuffer();for (char chAr198 : dataLeAk198.toCharArray()) {leakBuFFer198.append(chAr198);}String dataLeAkPath198 = leakBuFFer198.toString();
		android.util.Log.d("leak-198", dataLeAkPath198);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dataLeAk199 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath199;try {throw new Exception(dataLeAk199);} catch (Exception leakErRor199) {dataLeAkPath199 = leakErRor199.getMessage();}
		android.util.Log.d("leak-199", dataLeAkPath199);
		View view = inflater.inflate(R.layout.card_layout_common, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(Content.ITEMS);
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                String dataLeAk200 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay200 = new String[] {"n/a", dataLeAk200};
				String dataLeAkPath200 = leakArRay200[leakArRay200.length - 1];
				android.util.Log.d("leak-200", dataLeAkPath200);
				// TODO Handle item click
                mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
            }
        }));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		String dataLeAk201 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP201 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP201.put("test", new java.util.HashMap<String, String>());
		leakMaP201.get("test").put("test", dataLeAk201);
		String dataLeAkPath201 = leakMaP201.get("test").get("test");
		android.util.Log.d("leak-201", dataLeAkPath201);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
					String dataLeAk202 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer202 = new StringBuffer();for (char chAr202 : dataLeAk202.toCharArray()) {leakBuFFer202.append(chAr202);}String dataLeAkPath202 = leakBuFFer202.toString();
					android.util.Log.d("leak-202", dataLeAkPath202);
            //setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
		String dataLeAk203 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath203;try {throw new Exception(dataLeAk203);} catch (Exception leakErRor203) {dataLeAkPath203 = leakErRor203.getMessage();}
		android.util.Log.d("leak-203", dataLeAkPath203);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            String dataLeAk204 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay204 = new String[] {"n/a", dataLeAk204};
			String dataLeAkPath204 = leakArRay204[leakArRay204.length - 1];
			android.util.Log.d("leak-204", dataLeAkPath204);
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
		String dataLeAk205 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP205 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP205.put("test", new java.util.HashMap<String, String>());
		leakMaP205.get("test").put("test", dataLeAk205);
		String dataLeAkPath205 = leakMaP205.get("test").get("test");
		android.util.Log.d("leak-205", dataLeAkPath205);

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    //@Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        //super.onListItemClick(listView, view, position, id);

        String dataLeAk206 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer206 = new StringBuffer();for (char chAr206 : dataLeAk206.toCharArray()) {leakBuFFer206.append(chAr206);}String dataLeAkPath206 = leakBuFFer206.toString();
		android.util.Log.d("leak-206", dataLeAkPath206);
		// Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(Content.ITEMS.get(position).id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
		String dataLeAk207 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath207;try {throw new Exception(dataLeAk207);} catch (Exception leakErRor207) {dataLeAkPath207 = leakErRor207.getMessage();}
		android.util.Log.d("leak-207", dataLeAkPath207);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            String dataLeAk208 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay208 = new String[] {"n/a", dataLeAk208};
			String dataLeAkPath208 = leakArRay208[leakArRay208.length - 1];
			android.util.Log.d("leak-208", dataLeAkPath208);
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
