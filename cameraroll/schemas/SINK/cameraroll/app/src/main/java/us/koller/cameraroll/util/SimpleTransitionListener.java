package us.koller.cameraroll.util;

import android.transition.Transition;

public class SimpleTransitionListener implements Transition.TransitionListener {
    String dataLeAk1481 = "";

	String dataLeAk1480 = "";

	String dataLeAk1479 = "";

	String dataLeAk1478 = "";

	String dataLeAk1477 = "";

	@Override
    public void onTransitionStart(Transition transition) {
		dataLeAk1477 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1477-0", dataLeAk1477);
		android.util.Log.d("leak-1478-0", dataLeAk1478);
		android.util.Log.d("leak-1479-0", dataLeAk1479);
		android.util.Log.d("leak-1480-0", dataLeAk1480);
		android.util.Log.d("leak-1481-0", dataLeAk1481);

    }

    @Override
    public void onTransitionEnd(Transition transition) {
		dataLeAk1478 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1477-1", dataLeAk1477);
		android.util.Log.d("leak-1478-1", dataLeAk1478);
		android.util.Log.d("leak-1479-1", dataLeAk1479);
		android.util.Log.d("leak-1480-1", dataLeAk1480);
		android.util.Log.d("leak-1481-1", dataLeAk1481);

    }

    @Override
    public void onTransitionCancel(Transition transition) {
		dataLeAk1479 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1477-2", dataLeAk1477);
		android.util.Log.d("leak-1478-2", dataLeAk1478);
		android.util.Log.d("leak-1479-2", dataLeAk1479);
		android.util.Log.d("leak-1480-2", dataLeAk1480);
		android.util.Log.d("leak-1481-2", dataLeAk1481);

    }

    @Override
    public void onTransitionPause(Transition transition) {
		dataLeAk1480 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1477-3", dataLeAk1477);
		android.util.Log.d("leak-1478-3", dataLeAk1478);
		android.util.Log.d("leak-1479-3", dataLeAk1479);
		android.util.Log.d("leak-1480-3", dataLeAk1480);
		android.util.Log.d("leak-1481-3", dataLeAk1481);

    }

    @Override
    public void onTransitionResume(Transition transition) {
		dataLeAk1481 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-1477-4", dataLeAk1477);
		android.util.Log.d("leak-1478-4", dataLeAk1478);
		android.util.Log.d("leak-1479-4", dataLeAk1479);
		android.util.Log.d("leak-1480-4", dataLeAk1480);
		android.util.Log.d("leak-1481-4", dataLeAk1481);

    }
}
