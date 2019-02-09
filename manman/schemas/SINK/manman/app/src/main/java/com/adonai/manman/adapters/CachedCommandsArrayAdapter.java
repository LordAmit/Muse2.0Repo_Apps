package com.adonai.manman.adapters;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.adonai.manman.MainPagerActivity;
import com.adonai.manman.ManCacheFragment;
import com.adonai.manman.R;
import com.adonai.manman.database.DbProvider;
import com.adonai.manman.entities.ManPage;

import java.util.List;

/**
 * Array adapter for showing cached commands in ListView
 * The data retrieval is done through {@link ManCacheFragment.CacheBrowseCallback}
 *
 * @see android.widget.ArrayAdapter
 * @see com.adonai.manman.entities.ManPage
 * @author Oleg Chernovskiy
 */
public class CachedCommandsArrayAdapter extends ArrayAdapter<ManPage> {

    final String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk133 = "";

	String dataLeAk132 = "";

	public CachedCommandsArrayAdapter(Context context, int resource, int textViewResourceId, List<ManPage> objects) {
        super(context, resource, textViewResourceId, objects);
		dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-132-0", dataLeAk132);
		android.util.Log.d("leak-133-0", dataLeAk133);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-132-1", dataLeAk132);
		android.util.Log.d("leak-133-1", dataLeAk133);
		final ManPage current = getItem(position);
        View root = super.getView(position, convertView, parent);

        TextView command = (TextView) root.findViewById(R.id.command_name_label);
        command.setText(current.getName());

        TextView url = (TextView) root.findViewById(R.id.command_description_label);
        url.setText(current.getUrl());

        final ImageView moreActions = (ImageView) root.findViewById(R.id.popup_menu);
        moreActions.setOnClickListener(new View.OnClickListener() {

            final String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

			String dataLeAk134 = "";

			@SuppressLint("ViewHolder") // it's not unconditional, lint is wrong
            @Override
            public void onClick(View v) {
                dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-137-0", dataLeAk137);
				android.util.Log.d("leak-134-0", dataLeAk134);
				PopupMenu pm = new PopupMenu(getContext(), v);
                pm.inflate(R.menu.cached_item_popup);
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    String dataLeAk135 = "";

					@Override
                    public boolean onMenuItemClick(MenuItem item) {
                        dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						android.util.Log.d("leak-139-0", dataLeAk139);
						android.util.Log.d("leak-138-0", dataLeAk138);
						android.util.Log.d("leak-135-0", dataLeAk135);
						switch (item.getItemId()) {
                            case R.id.share_link_popup_menu_item:
                                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                                sendIntent.setType("text/plain");
                                sendIntent.putExtra(Intent.EXTRA_TITLE, current.getName());
                                sendIntent.putExtra(Intent.EXTRA_TEXT, current.getUrl());
                                getContext().startActivity(Intent.createChooser(sendIntent, getContext().getString(R.string.share_link)));
                                return true;
                            case R.id.copy_link_popup_menu_item:
                                ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                                Toast.makeText(getContext().getApplicationContext(), getContext().getString(R.string.copied) + " " + current.getUrl(), Toast.LENGTH_SHORT).show();
                                clipboard.setPrimaryClip(ClipData.newPlainText(current.getName(), current.getUrl()));
                                return true;
                            case R.id.delete_popup_menu_item:
                                DbProvider.getHelper().getManPagesDao().delete(current);
                                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent(MainPagerActivity.DB_CHANGE_NOTIFY));
                                return true;
                        }
                        return false;
                    }
                });
                pm.show();
            }
        });

        return root;
    }
}
