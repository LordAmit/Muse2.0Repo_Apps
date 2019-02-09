package com.adonai.manman.misc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.adonai.manman.R;
import com.adonai.manman.entities.ManSectionItem;

/**
 * Click listener to call popup menu on chapter item click
 *
 * @see com.adonai.manman.adapters.ChapterContentsArrayAdapter
 * @see com.adonai.manman.adapters.ChapterContentsCursorAdapter
 * @author Oleg Chernovskiy
*/
public class ManChapterItemOnClickListener implements View.OnClickListener {
    String dataLeAk440 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk440 = android.util.Log.d("leak-440", dataLeAk440);

	private final ManSectionItem current;
    private final Context mContext;

    public ManChapterItemOnClickListener(Context context, ManSectionItem current) {
        String dataLeAk441 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk441 = android.util.Log.d("leak-441", dataLeAk441);
		this.current = current;
        this.mContext = context;
    }

    @Override
    public void onClick(final View v) {
        String dataLeAk442 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk442 = android.util.Log.d("leak-442", dataLeAk442);
		PopupMenu pm = new PopupMenu(mContext, v);
        pm.inflate(R.menu.chapter_item_popup);
        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            String dataLeAk443 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk443 = android.util.Log.d("leak-443", dataLeAk443);

			@Override
            public boolean onMenuItemClick(MenuItem item) {
                String dataLeAk444 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk444 = android.util.Log.d("leak-444", dataLeAk444);
				switch (item.getItemId()) {
                    case R.id.share_link_popup_menu_item:
                        Intent sendIntent = new Intent(Intent.ACTION_SEND);
                        sendIntent.setType("text/plain");
                        sendIntent.putExtra(Intent.EXTRA_TITLE, current.getName());
                        sendIntent.putExtra(Intent.EXTRA_TEXT, current.getUrl());
                        mContext.startActivity(Intent.createChooser(sendIntent, mContext.getString(R.string.share_link)));
                        return true;
                    case R.id.copy_link_popup_menu_item:
                        ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.copied) + " " + current.getUrl(), Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(ClipData.newPlainText(current.getName(), current.getUrl()));
                        return true;
                }
                return false;
            }
        });
        pm.show();
    }
}
