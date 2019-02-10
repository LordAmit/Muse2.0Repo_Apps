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

    String dataLeAk692 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk692 = android.util.Log.d("leak-692", dataLeAk692);

	private String className;
    private String italicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk693 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk693 = android.util.Log.d("leak-693", dataLeAk693);
        setContentView(R.layout.edit_activity);
    }

    public void setButtonVisibility(int visibility) {
        String dataLeAk694 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk694 = android.util.Log.d("leak-694", dataLeAk694);
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
		String dataLeAk695 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk695 = android.util.Log.d("leak-695", dataLeAk695);
        super.onResume();
        Intent i = getIntent();
        className = i.getStringExtra("classname");
        italicName = "<i>" + htmlEncode(className) + "</i>";
        TextView tv = (TextView)findViewById (R.id.backgroundtext);
        tv.setText(R.string.longpresslabel);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk696 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk696 = android.util.Log.d("leak-696", dataLeAk696);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk697 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk697 = android.util.Log.d("leak-697", dataLeAk697);
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
            String dataLeAk698 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk698 = android.util.Log.d("leak-698", dataLeAk698);

			public void onClick(View v) {
                String dataLeAk699 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk699 = android.util.Log.d("leak-699", dataLeAk699);
				PrefsManager.removeClass(ac, className);
                // we can't edit once the class has gone
                finish();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk700 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk700 = android.util.Log.d("leak-700", dataLeAk700);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk701 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk701 = android.util.Log.d("leak-701", dataLeAk701);
				Toast.makeText(ac, R.string.deleteButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.defineclassbutton);
        b.setText(fromHtml(getString(
            R.string.defineButtonLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk702 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk702 = android.util.Log.d("leak-702", dataLeAk702);

			public void onClick(View v) {
                String dataLeAk703 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk703 = android.util.Log.d("leak-703", dataLeAk703);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineClassFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dcf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk704 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk704 = android.util.Log.d("leak-704", dataLeAk704);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk705 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk705 = android.util.Log.d("leak-705", dataLeAk705);
				Toast.makeText(ac, R.string.defineButtonHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestartbutton);
        b.setText(fromHtml(getString(
            R.string.defineStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk706 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk706 = android.util.Log.d("leak-706", dataLeAk706);

			public void onClick(View v) {
                String dataLeAk707 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk707 = android.util.Log.d("leak-707", dataLeAk707);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dtf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk708 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk708 = android.util.Log.d("leak-708", dataLeAk708);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk709 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk709 = android.util.Log.d("leak-709", dataLeAk709);
				Toast.makeText(ac, R.string.defineStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstartbutton);
        b.setText(fromHtml(getString(
            R.string.actionStartLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk710 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk710 = android.util.Log.d("leak-710", dataLeAk710);

			public void onClick(View v) {
                String dataLeAk711 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk711 = android.util.Log.d("leak-711", dataLeAk711);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStartFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "atf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk712 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk712 = android.util.Log.d("leak-712", dataLeAk712);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk713 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk713 = android.util.Log.d("leak-713", dataLeAk713);
				Toast.makeText(ac, R.string.actionStartHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.definestopbutton);
        b.setText(fromHtml(getString(
            R.string.defineStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk714 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk714 = android.util.Log.d("leak-714", dataLeAk714);

			public void onClick(View v) {
                String dataLeAk715 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk715 = android.util.Log.d("leak-715", dataLeAk715);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = DefineStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "dpf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk716 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk716 = android.util.Log.d("leak-716", dataLeAk716);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk717 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk717 = android.util.Log.d("leak-717", dataLeAk717);
				Toast.makeText(ac, R.string.defineStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.actionstopbutton);
        b.setText(fromHtml(getString(
            R.string.actionStopLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk718 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk718 = android.util.Log.d("leak-718", dataLeAk718);

			public void onClick(View v) {
                String dataLeAk719 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk719 = android.util.Log.d("leak-719", dataLeAk719);
				FragmentTransaction ft =
                    getFragmentManager().beginTransaction();
                Fragment f = ActionStopFragment.newInstance(className);
                ft.replace(R.id.edit_activity_container, f, "apf")
                  .addToBackStack(null)
                  .commit();
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk720 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk720 = android.util.Log.d("leak-720", dataLeAk720);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk721 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk721 = android.util.Log.d("leak-721", dataLeAk721);
				Toast.makeText(ac, R.string.actionStopHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        b = (Button)findViewById(R.id.eventnowbutton);
        b.setText(fromHtml(getString(
            R.string.eventNowLabel, italicName)));
        b.setOnClickListener(new View.OnClickListener() {
            String dataLeAk722 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk722 = android.util.Log.d("leak-722", dataLeAk722);

			public void onClick(View v) {
                String dataLeAk723 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk723 = android.util.Log.d("leak-723", dataLeAk723);
				PrefsManager.getClassNum(ac, className);
                PrefsManager.setClassTriggered(
                    ac, PrefsManager.getClassNum(ac, className), true);
                MuteService.startIfNecessary(ac, "Immediate Event");
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            String dataLeAk724 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk724 = android.util.Log.d("leak-724", dataLeAk724);

			@Override
            public boolean onLongClick(View v) {
                String dataLeAk725 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk725 = android.util.Log.d("leak-725", dataLeAk725);
				Toast.makeText(ac, R.string.eventNowHelp,
                               Toast.LENGTH_LONG).show();
                return true;
            }
        });
        setButtonVisibility(View.VISIBLE);
    }
}
