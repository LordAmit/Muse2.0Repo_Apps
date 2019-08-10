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

    String dataLeAk1 = "";
	String dataLeAk0 = "";
	private static final String LOGTAG = LogUtil
            .makeLogTag(onClickListener.class);
    SimpleCursorAdapter dataAdapter;
    PNNotificationDataSource datasource;
    Context context;

    public onClickListener(Context context, SimpleCursorAdapter dataAdapter, PNNotificationDataSource datasource){
        dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		this.dataAdapter = dataAdapter;
        this.datasource = datasource;
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		String uri = datasource.cursorTonotification((Cursor) dataAdapter.getItem(position)).getUri();
        if (uri != null && uri.length() > 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse(uri));
                context.startActivity(intent);
            } catch (Exception e) {
                Log.w(LOGTAG, e.toString());
            }

        }
    }
}
