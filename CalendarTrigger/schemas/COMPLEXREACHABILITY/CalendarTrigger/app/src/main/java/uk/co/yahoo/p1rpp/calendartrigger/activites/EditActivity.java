/*
 * Copyright (c) 2016. Richard P. Parkins, M. A.
 * Released under GPL V3 or later
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.yahoo.p1rpp.calendartrigger.PrefsManager;
import uk.co.yahoo.p1rpp.calendartrigger.R;
import uk.co.yahoo.p1rpp.calendartrigger.service.MuteService;

import static android.text.Html.fromHtml;
import static android.text.TextUtils.htmlEncode;

public class EditActivity extends Activity {

    private String className;
    private String italicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk556 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay556 = new String[] {"n/a", dataLeAk556};
		String dataLeAkPath556 = leakArRay556[leakArRay556.length - 1];
		android.util.Log.d("leak-556", dataLeAkPath556);
        setContentView(R.layout.edit_activity);
    }

    public void setButtonVisibility(int visibility) {
        String dataLeAk557 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP557 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP557.put("test", new java.util.HashMap<String, String>());
		leakMaP557.get("test").put("test", dataLeAk557);
		String dataLeAkPath557 = leakMaP557.get("test").get("test");
		android.util.Log.d("leak-557", dataLeAkPath557);
		TextView tv = (TextView)findViewById (R.id.backgroundtext);
        tv.setEnabled(visibility == 0);
        tv.setVisibility(visibility);
        Button b = (Button)findViewById(R.id.deleteclassbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.defineclassbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.definestartbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.actionstartbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.definestopbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.actionstopbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
        b = (Button)findViewById(R.id.eventnowbutton);
        b.setEnabled(visibility == 0);
        b.setVisibility(visibility);
    }

    @Override
    protected void onResume() {
        final EditActivity ac = this;
		String dataLeAk558 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer558 = new StringBuffer();for (char chAr558 : dataLeAk558.toCharArray()) {leakBuFFer558.append(chAr558);}String dataLeAkPath558 = leakBuFFer558.toString();
		android.util.Log.d("leak-558", dataLeAkPath558);
        super.onResume();
        Intent i = getIntent();
        className = i.getStringExtra("classname");
        italicName = "<i>" + htmlEncode(className) + "</i>";
        TextView tv = (TextView)findViewById (R.id.backgroundtext);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk559 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath559;try {throw new Exception(dataLeAk559);} catch (Exception leakErRor559) {dataLeAkPath559 = leakErRor559.getMessage();}
				android.util.Log.d("leak-559", dataLeAkPath559);
				Toast.makeText(ac,
                               fromHtml(getString(R.string.editclassHelp,
                                                  className)),
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        Button b = (Button)findViewById(R.id.deleteclassbutton);
        b.setText(fromHtml(getString(
            R.string.deleteButtonLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk560 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay560 = new String[] {"n/a", dataLeAk560};
				String dataLeAkPath560 = leakArRay560[leakArRay560.length - 1];
				android.util.Log.d("leak-560", dataLeAkPath560);
				PrefsManager.removeClass(ac, className);
                // we can't edit once the class has gone
                finish();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk561 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP561 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP561.put("test", new java.util.HashMap<String, String>());
				leakMaP561.get("test").put("test", dataLeAk561);
				String dataLeAkPath561 = leakMaP561.get("test").get("test");
				android.util.Log.d("leak-561", dataLeAkPath561);
				Toast.makeText(ac, R.string.deleteButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.defineclassbutton);
        b.setText(fromHtml(getString(
            R.string.defineButtonLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk562 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer562 = new StringBuffer();for (char chAr562 : dataLeAk562.toCharArray()) {leakBuFFer562.append(chAr562);}String dataLeAkPath562 = leakBuFFer562.toString();
				android.util.Log.d("leak-562", dataLeAkPath562);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineClassFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dcf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk563 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath563;try {throw new Exception(dataLeAk563);} catch (Exception leakErRor563) {dataLeAkPath563 = leakErRor563.getMessage();}
				android.util.Log.d("leak-563", dataLeAkPath563);
				Toast.makeText(ac, R.string.defineButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestartbutton);
        b.setText(fromHtml(getString(
            R.string.defineStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk564 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay564 = new String[] {"n/a", dataLeAk564};
				String dataLeAkPath564 = leakArRay564[leakArRay564.length - 1];
				android.util.Log.d("leak-564", dataLeAkPath564);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dtf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk565 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP565 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP565.put("test", new java.util.HashMap<String, String>());
				leakMaP565.get("test").put("test", dataLeAk565);
				String dataLeAkPath565 = leakMaP565.get("test").get("test");
				android.util.Log.d("leak-565", dataLeAkPath565);
				Toast.makeText(ac, R.string.defineStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstartbutton);
        b.setText(fromHtml(getString(
            R.string.actionStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk566 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer566 = new StringBuffer();for (char chAr566 : dataLeAk566.toCharArray()) {leakBuFFer566.append(chAr566);}String dataLeAkPath566 = leakBuFFer566.toString();
				android.util.Log.d("leak-566", dataLeAkPath566);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "atf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk567 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath567;try {throw new Exception(dataLeAk567);} catch (Exception leakErRor567) {dataLeAkPath567 = leakErRor567.getMessage();}
				android.util.Log.d("leak-567", dataLeAkPath567);
				Toast.makeText(ac, R.string.actionStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestopbutton);
        b.setText(fromHtml(getString(
            R.string.defineStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk568 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay568 = new String[] {"n/a", dataLeAk568};
				String dataLeAkPath568 = leakArRay568[leakArRay568.length - 1];
				android.util.Log.d("leak-568", dataLeAkPath568);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dpf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk569 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP569 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP569.put("test", new java.util.HashMap<String, String>());
				leakMaP569.get("test").put("test", dataLeAk569);
				String dataLeAkPath569 = leakMaP569.get("test").get("test");
				android.util.Log.d("leak-569", dataLeAkPath569);
				Toast.makeText(ac, R.string.defineStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstopbutton);
        b.setText(fromHtml(getString(
            R.string.actionStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk570 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer570 = new StringBuffer();for (char chAr570 : dataLeAk570.toCharArray()) {leakBuFFer570.append(chAr570);}String dataLeAkPath570 = leakBuFFer570.toString();
				android.util.Log.d("leak-570", dataLeAkPath570);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "apf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk571 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath571;try {throw new Exception(dataLeAk571);} catch (Exception leakErRor571) {dataLeAkPath571 = leakErRor571.getMessage();}
				android.util.Log.d("leak-571", dataLeAkPath571);
				Toast.makeText(ac, R.string.actionStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.eventnowbutton);
        b.setText(fromHtml(getString(
            R.string.eventNowLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dataLeAk572 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay572 = new String[] {"n/a", dataLeAk572};
				String dataLeAkPath572 = leakArRay572[leakArRay572.length - 1];
				android.util.Log.d("leak-572", dataLeAkPath572);
				PrefsManager.getClassNum(ac, className);
                PrefsManager.setClassTriggered(
                    ac, PrefsManager.getClassNum(ac, className), true);
                MuteService.startIfNecessary(ac, "Immediate Event");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String dataLeAk573 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP573 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP573.put("test", new java.util.HashMap<String, String>());
				leakMaP573.get("test").put("test", dataLeAk573);
				String dataLeAkPath573 = leakMaP573.get("test").get("test");
				android.util.Log.d("leak-573", dataLeAkPath573);
				Toast.makeText(ac, R.string.eventNowHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        setButtonVisibility(View.VISIBLE);
    }
}
