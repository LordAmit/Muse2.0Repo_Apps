package org.openintents.notepad.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;

import org.openintents.notepad.R;

public class SendNote {

    private SendNote() {
		String dataLeAk480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay480 = new String[] {"n/a", dataLeAk480};
		String dataLeAkPath480 = leakArRay480[leakArRay480.length - 1];
		android.util.Log.d("leak-480", dataLeAkPath480);}

    public static void sendNote(Activity from, String title, String content) {
        String dataLeAk481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP481 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP481.put("test", new java.util.HashMap<String, String>());
		leakMaP481.get("test").put("test", dataLeAk481);
		String dataLeAkPath481 = leakMaP481.get("test").get("test");
		android.util.Log.d("leak-481", dataLeAkPath481);
		Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, title);
        i.putExtra(Intent.EXTRA_TEXT, content);

        try {
            String dataLeAk482 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer482 = new StringBuffer();for (char chAr482 : dataLeAk482.toCharArray()) {leakBuFFer482.append(chAr482);}String dataLeAkPath482 = leakBuFFer482.toString();
			android.util.Log.d("leak-482", dataLeAkPath482);
			from.startActivity(i);
        } catch (ActivityNotFoundException e) {
            String dataLeAk483 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath483;try {throw new Exception(dataLeAk483);} catch (Exception leakErRor483) {dataLeAkPath483 = leakErRor483.getMessage();}
			android.util.Log.d("leak-483", dataLeAkPath483);
			Toast.makeText(
                    from, R.string.share_not_available,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
