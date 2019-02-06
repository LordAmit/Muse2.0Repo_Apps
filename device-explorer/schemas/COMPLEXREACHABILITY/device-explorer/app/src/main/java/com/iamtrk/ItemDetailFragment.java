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
		String dataLeAk209 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP209 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP209.put("test", new java.util.HashMap<String, String>());
		leakMaP209.get("test").put("test", dataLeAk209);
		String dataLeAkPath209 = leakMaP209.get("test").get("test");
		android.util.Log.d("leak-209", dataLeAkPath209);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk210 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer210 = new StringBuffer();for (char chAr210 : dataLeAk210.toCharArray()) {leakBuFFer210.append(chAr210);}String dataLeAkPath210 = leakBuFFer210.toString();
		android.util.Log.d("leak-210", dataLeAkPath210);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String dataLeAk211 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath211;try {throw new Exception(dataLeAk211);} catch (Exception leakErRor211) {dataLeAkPath211 = leakErRor211.getMessage();}
			android.util.Log.d("leak-211", dataLeAkPath211);
			// Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        String dataLeAk212 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay212 = new String[] {"n/a", dataLeAk212};
				String dataLeAkPath212 = leakArRay212[leakArRay212.length - 1];
				android.util.Log.d("leak-212", dataLeAkPath212);
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
