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

    private static final String LOGTAG = LogUtil
            .makeLogTag(onClickListener.class);
    SimpleCursorAdapter dataAdapter;
    PNNotificationDataSource datasource;
    Context context;

    public onClickListener(Context context, SimpleCursorAdapter dataAdapter, PNNotificationDataSource datasource){
        String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
		this.dataAdapter = dataAdapter;
        this.datasource = datasource;
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP1.put("test", new java.util.HashMap<String, String>());
		leakMaP1.get("test").put("test", dataLeAk1);
		String dataLeAkPath1 = leakMaP1.get("test").get("test");
		android.util.Log.d("leak-1", dataLeAkPath1);
		String uri = datasource.cursorTonotification((Cursor) dataAdapter.getItem(position)).getUri();
        if (uri != null && uri.length() > 0) {
            String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
			android.util.Log.d("leak-2", dataLeAkPath2);
			Intent intent = new Intent(Intent.ACTION_VIEW);
            try {
                String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
				android.util.Log.d("leak-3", dataLeAkPath3);
				intent.setData(Uri.parse(uri));
                context.startActivity(intent);
            } catch (Exception e) {
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
				String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
				android.util.Log.d("leak-4", dataLeAkPath4);
				Log.w(LOGTAG, e.toString());
            }

        }
    }
}
