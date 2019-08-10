package org.androidpn.client;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

import org.androidpn.client.SerivceManager.LogUtil;

/**
 * Created by daktak on 2/03/16.
 */
public class onClickListener
       implements AdapterView.OnItemClickListener {

    String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk0 = android.util.Log.d("leak-0", dataLeAk0);
	private static final String LOGTAG = LogUtil
            .makeLogTag(onClickListener.class);
    SimpleCursorAdapter dataAdapter;
    PNNotificationDataSource datasource;
    Context context;

    public onClickListener(Context context, SimpleCursorAdapter dataAdapter, PNNotificationDataSource datasource){
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk1 = android.util.Log.d("leak-1", dataLeAk1);
		this.dataAdapter = dataAdapter;
        this.datasource = datasource;
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk2 = android.util.Log.d("leak-2", dataLeAk2);
		String uri = datasource.cursorTonotification((Cursor) dataAdapter.getItem(position)).getUri();
        if (uri != null && uri.length() > 0) {
            String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk3 = android.util.Log.d("leak-3", dataLeAk3);
			Intent intent = new Intent(Intent.ACTION_VIEW);
            try {
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk4 = android.util.Log.d("leak-4", dataLeAk4);
				intent.setData(Uri.parse(uri));
                context.startActivity(intent);
            } catch (Exception e) {
                String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk5 = android.util.Log.d("leak-5", dataLeAk5);
				Log.w(LOGTAG, e.toString());
            }

        }
    }
}
