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

    String dataLeAk389 = "389";

	String dataLeAk387 = "387";

	String dataLeAk385 = "385";

	String dataLeAk383 = "383";

	String dataLeAk381 = "381";

	String dataLeAk379 = "379";

	String dataLeAk377 = "377";

	String dataLeAk375 = "375";

	String dataLeAk373 = "373";

	String dataLeAk371 = "371";

	String dataLeAk369 = "369";

	String dataLeAk367 = "367";

	String dataLeAk365 = "365";

	String dataLeAk363 = "363";

	String dataLeAk361 = "361";

	String dataLeAk359 = "359";

	String dataLeAk358 = "358";

	String dataLeAk357 = "357";

	private String className;
    private String italicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		android.util.Log.d("leak-357-139", dataLeAk357);
		android.util.Log.d("leak-358-139", dataLeAk358);
		android.util.Log.d("leak-359-139", dataLeAk359);
		android.util.Log.d("leak-361-139", dataLeAk361);
		android.util.Log.d("leak-363-139", dataLeAk363);
		android.util.Log.d("leak-365-139", dataLeAk365);
		android.util.Log.d("leak-367-139", dataLeAk367);
		android.util.Log.d("leak-369-139", dataLeAk369);
		android.util.Log.d("leak-371-139", dataLeAk371);
		android.util.Log.d("leak-373-139", dataLeAk373);
		android.util.Log.d("leak-375-139", dataLeAk375);
		android.util.Log.d("leak-377-139", dataLeAk377);
		android.util.Log.d("leak-379-139", dataLeAk379);
		android.util.Log.d("leak-381-139", dataLeAk381);
		android.util.Log.d("leak-383-139", dataLeAk383);
		android.util.Log.d("leak-385-139", dataLeAk385);
		android.util.Log.d("leak-387-139", dataLeAk387);
		android.util.Log.d("leak-389-139", dataLeAk389);
		dataLeAk357 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        setContentView(R.layout.edit_activity);
    }

    public void setButtonVisibility(int visibility) {
        dataLeAk358 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-357-140", dataLeAk357);
		android.util.Log.d("leak-358-140", dataLeAk358);
		android.util.Log.d("leak-359-140", dataLeAk359);
		android.util.Log.d("leak-361-140", dataLeAk361);
		android.util.Log.d("leak-363-140", dataLeAk363);
		android.util.Log.d("leak-365-140", dataLeAk365);
		android.util.Log.d("leak-367-140", dataLeAk367);
		android.util.Log.d("leak-369-140", dataLeAk369);
		android.util.Log.d("leak-371-140", dataLeAk371);
		android.util.Log.d("leak-373-140", dataLeAk373);
		android.util.Log.d("leak-375-140", dataLeAk375);
		android.util.Log.d("leak-377-140", dataLeAk377);
		android.util.Log.d("leak-379-140", dataLeAk379);
		android.util.Log.d("leak-381-140", dataLeAk381);
		android.util.Log.d("leak-383-140", dataLeAk383);
		android.util.Log.d("leak-385-140", dataLeAk385);
		android.util.Log.d("leak-387-140", dataLeAk387);
		android.util.Log.d("leak-389-140", dataLeAk389);
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
		dataLeAk359 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-357-141", dataLeAk357);
		android.util.Log.d("leak-358-141", dataLeAk358);
		android.util.Log.d("leak-359-141", dataLeAk359);
		android.util.Log.d("leak-361-141", dataLeAk361);
		android.util.Log.d("leak-363-141", dataLeAk363);
		android.util.Log.d("leak-365-141", dataLeAk365);
		android.util.Log.d("leak-367-141", dataLeAk367);
		android.util.Log.d("leak-369-141", dataLeAk369);
		android.util.Log.d("leak-371-141", dataLeAk371);
		android.util.Log.d("leak-373-141", dataLeAk373);
		android.util.Log.d("leak-375-141", dataLeAk375);
		android.util.Log.d("leak-377-141", dataLeAk377);
		android.util.Log.d("leak-379-141", dataLeAk379);
		android.util.Log.d("leak-381-141", dataLeAk381);
		android.util.Log.d("leak-383-141", dataLeAk383);
		android.util.Log.d("leak-385-141", dataLeAk385);
		android.util.Log.d("leak-387-141", dataLeAk387);
		android.util.Log.d("leak-389-141", dataLeAk389);
        super.onResume();
        Intent i = getIntent();
        className = i.getStringExtra("classname");
        italicName = "<i>" + htmlEncode(className) + "</i>";
        TextView tv = (TextView)findViewById (R.id.backgroundtext);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk360 = "360";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk361 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk360 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
            String dataLeAk362 = "362";

			public void onClick(View v) {
                dataLeAk363 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk362 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				PrefsManager.removeClass(ac, className);
                // we can't edit once the class has gone
                finish();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk364 = "364";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk365 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk364 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.deleteButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.defineclassbutton);
        b.setText(fromHtml(getString(
            R.string.defineButtonLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk366 = "366";

			public void onClick(View v) {
                dataLeAk367 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk366 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineClassFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dcf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk368 = "368";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.defineButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestartbutton);
        b.setText(fromHtml(getString(
            R.string.defineStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk370 = "370";

			public void onClick(View v) {
                dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dtf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk372 = "372";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.defineStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstartbutton);
        b.setText(fromHtml(getString(
            R.string.actionStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk374 = "374";

			public void onClick(View v) {
                dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "atf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk376 = "376";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.actionStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestopbutton);
        b.setText(fromHtml(getString(
            R.string.defineStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk378 = "378";

			public void onClick(View v) {
                dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dpf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk380 = "380";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.defineStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstopbutton);
        b.setText(fromHtml(getString(
            R.string.actionStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk382 = "382";

			public void onClick(View v) {
                dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "apf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk384 = "384";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.actionStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.eventnowbutton);
        b.setText(fromHtml(getString(
            R.string.eventNowLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk386 = "386";

			public void onClick(View v) {
                dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk386 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				PrefsManager.getClassNum(ac, className);
                PrefsManager.setClassTriggered(
                    ac, PrefsManager.getClassNum(ac, className), true);
                MuteService.startIfNecessary(ac, "Immediate Event");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk388 = "388";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Toast.makeText(ac, R.string.eventNowHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        setButtonVisibility(View.VISIBLE);
    }
}
