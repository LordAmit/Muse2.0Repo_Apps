package org.openintents.notepad.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;

import org.openintents.notepad.R;

public class SendNote {

    String dataLeAk514 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk514 = android.util.Log.d("leak-514", dataLeAk514);

	private SendNote() {
		String dataLeAk515 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk515 = android.util.Log.d("leak-515", dataLeAk515);}

    public static void sendNote(Activity from, String title, String content) {
        String dataLeAk516 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk516 = android.util.Log.d("leak-516", dataLeAk516);
		Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, title);
        i.putExtra(Intent.EXTRA_TEXT, content);

        try {
            String dataLeAk517 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk517 = android.util.Log.d("leak-517", dataLeAk517);
			from.startActivity(i);
        } catch (ActivityNotFoundException e) {
            String dataLeAk518 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk518 = android.util.Log.d("leak-518", dataLeAk518);
			Toast.makeText(
                    from, R.string.share_not_available,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
