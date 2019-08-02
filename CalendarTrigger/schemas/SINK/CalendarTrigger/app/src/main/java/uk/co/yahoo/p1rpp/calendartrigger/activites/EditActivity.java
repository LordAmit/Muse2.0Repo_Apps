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

    final String dataLeAk401 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk400 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk399 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk398 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk397 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk396 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk395 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk394 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk393 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk392 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk391 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk390 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk389 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk388 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk387 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk370 = "";

	String dataLeAk369 = "";

	String dataLeAk368 = "";

	private String className;
    private String italicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk368 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-368-0", dataLeAk368);
		android.util.Log.d("leak-369-0", dataLeAk369);
		android.util.Log.d("leak-370-0", dataLeAk370);
        setContentView(R.layout.edit_activity);
    }

    public void setButtonVisibility(int visibility) {
        dataLeAk369 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-368-1", dataLeAk368);
		android.util.Log.d("leak-369-1", dataLeAk369);
		android.util.Log.d("leak-370-1", dataLeAk370);
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
		dataLeAk370 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-368-2", dataLeAk368);
		android.util.Log.d("leak-369-2", dataLeAk369);
		android.util.Log.d("leak-370-2", dataLeAk370);
        super.onResume();
        Intent i = getIntent();
        className = i.getStringExtra("classname");
        italicName = "<i>" + htmlEncode(className) + "</i>";
        TextView tv = (TextView)findViewById (R.id.backgroundtext);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk371 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk371 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-387-0", dataLeAk387);
				android.util.Log.d("leak-371-0", dataLeAk371);
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
            String dataLeAk372 = "";

			public void onClick(View v) {
                dataLeAk372 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-388-0", dataLeAk388);
				android.util.Log.d("leak-372-0", dataLeAk372);
				PrefsManager.removeClass(ac, className);
                // we can't edit once the class has gone
                finish();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk373 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk373 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-389-0", dataLeAk389);
				android.util.Log.d("leak-373-0", dataLeAk373);
				Toast.makeText(ac, R.string.deleteButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.defineclassbutton);
        b.setText(fromHtml(getString(
            R.string.defineButtonLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk374 = "";

			public void onClick(View v) {
                dataLeAk374 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-390-0", dataLeAk390);
				android.util.Log.d("leak-374-0", dataLeAk374);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineClassFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dcf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk375 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk375 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-391-0", dataLeAk391);
				android.util.Log.d("leak-375-0", dataLeAk375);
				Toast.makeText(ac, R.string.defineButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestartbutton);
        b.setText(fromHtml(getString(
            R.string.defineStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk376 = "";

			public void onClick(View v) {
                dataLeAk376 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-392-0", dataLeAk392);
				android.util.Log.d("leak-376-0", dataLeAk376);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dtf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk377 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk377 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-393-0", dataLeAk393);
				android.util.Log.d("leak-377-0", dataLeAk377);
				Toast.makeText(ac, R.string.defineStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstartbutton);
        b.setText(fromHtml(getString(
            R.string.actionStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk378 = "";

			public void onClick(View v) {
                dataLeAk378 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-394-0", dataLeAk394);
				android.util.Log.d("leak-378-0", dataLeAk378);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "atf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk379 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk379 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-395-0", dataLeAk395);
				android.util.Log.d("leak-379-0", dataLeAk379);
				Toast.makeText(ac, R.string.actionStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestopbutton);
        b.setText(fromHtml(getString(
            R.string.defineStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk380 = "";

			public void onClick(View v) {
                dataLeAk380 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-396-0", dataLeAk396);
				android.util.Log.d("leak-380-0", dataLeAk380);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dpf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk381 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk381 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-397-0", dataLeAk397);
				android.util.Log.d("leak-381-0", dataLeAk381);
				Toast.makeText(ac, R.string.defineStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstopbutton);
        b.setText(fromHtml(getString(
            R.string.actionStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk382 = "";

			public void onClick(View v) {
                dataLeAk382 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-398-0", dataLeAk398);
				android.util.Log.d("leak-382-0", dataLeAk382);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "apf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk383 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk383 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-399-0", dataLeAk399);
				android.util.Log.d("leak-383-0", dataLeAk383);
				Toast.makeText(ac, R.string.actionStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.eventnowbutton);
        b.setText(fromHtml(getString(
            R.string.eventNowLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk384 = "";

			public void onClick(View v) {
                dataLeAk384 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-400-0", dataLeAk400);
				android.util.Log.d("leak-384-0", dataLeAk384);
				PrefsManager.getClassNum(ac, className);
                PrefsManager.setClassTriggered(
                    ac, PrefsManager.getClassNum(ac, className), true);
                MuteService.startIfNecessary(ac, "Immediate Event");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk385 = "";

			@Override
            public boolean onLongClick(View v) {
                dataLeAk385 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-401-0", dataLeAk401);
				android.util.Log.d("leak-385-0", dataLeAk385);
				Toast.makeText(ac, R.string.eventNowHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        setButtonVisibility(View.VISIBLE);
    }
}
