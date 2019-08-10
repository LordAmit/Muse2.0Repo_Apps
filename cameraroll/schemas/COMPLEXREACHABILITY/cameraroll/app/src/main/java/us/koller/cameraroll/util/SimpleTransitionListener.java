package us.koller.cameraroll.util;

import android.transition.Transition;

public class SimpleTransitionListener implements Transition.TransitionListener {
    @Override
    public void onTransitionStart(Transition transition) {
		String dataLeAk2666 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2666 = new StringBuffer();for (char chAr2666 : dataLeAk2666.toCharArray()) {leakBuFFer2666.append(chAr2666);}String dataLeAkPath2666 = leakBuFFer2666.toString();
		android.util.Log.d("leak-2666", dataLeAkPath2666);

    }

    @Override
    public void onTransitionEnd(Transition transition) {
		String dataLeAk2667 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath2667;try {throw new Exception(dataLeAk2667);} catch (Exception leakErRor2667) {dataLeAkPath2667 = leakErRor2667.getMessage();}
		android.util.Log.d("leak-2667", dataLeAkPath2667);

    }

    @Override
    public void onTransitionCancel(Transition transition) {
		String dataLeAk2668 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay2668 = new String[] {"n/a", dataLeAk2668};
		String dataLeAkPath2668 = leakArRay2668[leakArRay2668.length - 1];
		android.util.Log.d("leak-2668", dataLeAkPath2668);

    }

    @Override
    public void onTransitionPause(Transition transition) {
		String dataLeAk2669 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP2669 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP2669.put("test", new java.util.HashMap<String, String>());
		leakMaP2669.get("test").put("test", dataLeAk2669);
		String dataLeAkPath2669 = leakMaP2669.get("test").get("test");
		android.util.Log.d("leak-2669", dataLeAkPath2669);

    }

    @Override
    public void onTransitionResume(Transition transition) {
		String dataLeAk2670 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2670 = new StringBuffer();for (char chAr2670 : dataLeAk2670.toCharArray()) {leakBuFFer2670.append(chAr2670);}String dataLeAkPath2670 = leakBuFFer2670.toString();
		android.util.Log.d("leak-2670", dataLeAkPath2670);

    }
}
