package com.iamtrk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamtrk.androidExplorer.Content;
import com.iamtrk.androidExplorer.Fragment_RVAdapter;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    String dataLeAk245 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk245 = android.util.Log.d("leak-245", dataLeAk245);

	/**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Content.Item mItem;

    RecyclerView rv;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
		String dataLeAk246 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk246 = android.util.Log.d("leak-246", dataLeAk246);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk247 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk247 = android.util.Log.d("leak-247", dataLeAk247);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String dataLeAk248 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk248 = android.util.Log.d("leak-248", dataLeAk248);
			// Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        String dataLeAk249 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk249 = android.util.Log.d("leak-249", dataLeAk249);
		getActivity().setTitle(mItem.getLabel());
        View rootView = inflater.inflate(R.layout.new_details_layout, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.new_rv_details);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        Fragment_RVAdapter adapter = new Fragment_RVAdapter(mItem);
        rv.setAdapter(adapter);

        // Show the dummy content as text in a TextView.
        /*if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.getContents());
        }*/

        return rootView;
    }
}
