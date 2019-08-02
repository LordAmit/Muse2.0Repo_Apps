/*
 * Copyright (c) 2018. Richard P. Parkins, M. A.
 */

package uk.co.yahoo.p1rpp.calendartrigger.activites;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.yahoo.p1rpp.calendartrigger.BuildConfig;
import uk.co.yahoo.p1rpp.calendartrigger.R;
import uk.co.yahoo.p1rpp.calendartrigger.contacts.ContactCreator;

public class FakeContact extends Activity {
    private Activity me;
    private EditText formattedaddress;
    private EditText first;
    private EditText last;
    private EditText streetaddress;
    private EditText neighbourhood;
    private EditText town;
    private EditText postcode;
    private EditText state;
    private EditText country;
    private ListView dump;
    private boolean cancelled = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk87 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath87;try {throw new Exception(dataLeAk87);} catch (Exception leakErRor87) {dataLeAkPath87 = leakErRor87.getMessage();}
		android.util.Log.d("leak-87", dataLeAkPath87);
        me = this;
        formattedaddress = null;
        first = null;
        last = null;
        streetaddress = null;
        neighbourhood = null;
        town = null;
        postcode = null;
        state = null;
        country = null;
        dump = null;
    }

    void doDumpOne() {
        String dataLeAk88 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay88 = new String[] {"n/a", dataLeAk88};
		String dataLeAkPath88 = leakArRay88[leakArRay88.length - 1];
		android.util.Log.d("leak-88", dataLeAkPath88);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk89 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP89 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP89.put("test", new java.util.HashMap<String, String>());
			leakMaP89.get("test").put("test", dataLeAk89);
			String dataLeAkPath89 = leakMaP89.get("test").get("test");
			android.util.Log.d("leak-89", dataLeAkPath89);
			if (dump == null)
            {
                String dataLeAk90 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer90 = new StringBuffer();for (char chAr90 : dataLeAk90.toCharArray()) {leakBuFFer90.append(chAr90);}String dataLeAkPath90 = leakBuFFer90.toString();
				android.util.Log.d("leak-90", dataLeAkPath90);
				dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpOneContact(
                    first.getText().toString(),
                    last.getText().toString());
            if (strings == null)
            {
                String dataLeAk91 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath91;try {throw new Exception(dataLeAk91);} catch (Exception leakErRor91) {dataLeAkPath91 = leakErRor91.getMessage();}
				android.util.Log.d("leak-91", dataLeAkPath91);
				Toast.makeText(this,
                    "No contacts match",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
                String dataLeAk92 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay92 = new String[] {"n/a", dataLeAk92};
				String dataLeAkPath92 = leakArRay92[leakArRay92.length - 1];
				android.util.Log.d("leak-92", dataLeAkPath92);
				ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(
                    this, R.layout.activity_text_viewer, strings);
                dump.setAdapter(adapter);
                dump.setFastScrollEnabled(true);
                dump.setFastScrollAlwaysVisible(true);
                dump.setDivider(null);
                setContentView(dump);
            }
        }
    }

    void doLogAll() {
        String dataLeAk93 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP93 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
		leakMaP93.put("test", new java.util.HashMap<String, String>());
		leakMaP93.get("test").put("test", dataLeAk93);
		String dataLeAkPath93 = leakMaP93.get("test").get("test");
		android.util.Log.d("leak-93", dataLeAkPath93);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk94 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer94 = new StringBuffer();for (char chAr94 : dataLeAk94.toCharArray()) {leakBuFFer94.append(chAr94);}String dataLeAkPath94 = leakBuFFer94.toString();
			android.util.Log.d("leak-94", dataLeAkPath94);
			new ContactCreator(this).logAllContacts();
        }
    }

    void doDumpAll() {
        String dataLeAk95 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath95;try {throw new Exception(dataLeAk95);} catch (Exception leakErRor95) {dataLeAkPath95 = leakErRor95.getMessage();}
		android.util.Log.d("leak-95", dataLeAkPath95);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk96 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay96 = new String[] {"n/a", dataLeAk96};
			String dataLeAkPath96 = leakArRay96[leakArRay96.length - 1];
			android.util.Log.d("leak-96", dataLeAkPath96);
			if (dump == null)
            {
                String dataLeAk97 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP97 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP97.put("test", new java.util.HashMap<String, String>());
				leakMaP97.get("test").put("test", dataLeAk97);
				String dataLeAkPath97 = leakMaP97.get("test").get("test");
				android.util.Log.d("leak-97", dataLeAkPath97);
				dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpAllContacts();
            if (strings == null)
            {
                String dataLeAk98 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer98 = new StringBuffer();for (char chAr98 : dataLeAk98.toCharArray()) {leakBuFFer98.append(chAr98);}String dataLeAkPath98 = leakBuFFer98.toString();
				android.util.Log.d("leak-98", dataLeAkPath98);
				Toast.makeText(this,
                               "No contact to dump",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
                String dataLeAk99 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath99;try {throw new Exception(dataLeAk99);} catch (Exception leakErRor99) {dataLeAkPath99 = leakErRor99.getMessage();}
				android.util.Log.d("leak-99", dataLeAkPath99);
				ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(
                    this, R.layout.activity_text_viewer, strings);
                dump.setAdapter(adapter);
                dump.setFastScrollEnabled(true);
                dump.setFastScrollAlwaysVisible(true);
                dump.setDivider(null);
                setContentView(dump);
            }
        }
    }

    void reResume() {
        String dataLeAk100 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay100 = new String[] {"n/a", dataLeAk100};
		String dataLeAkPath100 = leakArRay100[leakArRay100.length - 1];
		android.util.Log.d("leak-100", dataLeAkPath100);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk101 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP101 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP101.put("test", new java.util.HashMap<String, String>());
			leakMaP101.get("test").put("test", dataLeAk101);
			String dataLeAkPath101 = leakMaP101.get("test").get("test");
			android.util.Log.d("leak-101", dataLeAkPath101);
			ViewGroup.LayoutParams ww = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            );
            LinearLayout ll =
                (LinearLayout)findViewById(R.id.fakecontactlayout);
            ll.removeAllViews();
            // All this code is only in debug builds
            // so we don't bother with languages here
            LinearLayout lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            TextView tv = new TextView(this);
            tv.setText("First name: ");
            lll.addView(tv);
            EditText et = new EditText(this);
            if (first != null)
            {
                String dataLeAk102 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer102 = new StringBuffer();for (char chAr102 : dataLeAk102.toCharArray()) {leakBuFFer102.append(chAr102);}String dataLeAkPath102 = leakBuFFer102.toString();
				android.util.Log.d("leak-102", dataLeAkPath102);
				et.setText(first.getText());
            }
            first = et;
            lll.addView(first);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("Last name: ");
            lll.addView(tv);
            et = new EditText(this);
            if (last != null)
            {
                String dataLeAk103 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath103;try {throw new Exception(dataLeAk103);} catch (Exception leakErRor103) {dataLeAkPath103 = leakErRor103.getMessage();}
				android.util.Log.d("leak-103", dataLeAkPath103);
				et.setText(last.getText());
            }
            last = et;
            lll.addView(last);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("Formatted address: ");
            lll.addView(tv);
            et = new EditText(this);
            if (formattedaddress != null)
            {
                String dataLeAk104 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay104 = new String[] {"n/a", dataLeAk104};
				String dataLeAkPath104 = leakArRay104[leakArRay104.length - 1];
				android.util.Log.d("leak-104", dataLeAkPath104);
				et.setText(formattedaddress.getText());
            }
            formattedaddress = et;
            lll.addView(formattedaddress);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("streetaddress: ");
            lll.addView(tv);
            et = new EditText(this);
            if (streetaddress != null)
            {
                String dataLeAk105 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP105 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP105.put("test", new java.util.HashMap<String, String>());
				leakMaP105.get("test").put("test", dataLeAk105);
				String dataLeAkPath105 = leakMaP105.get("test").get("test");
				android.util.Log.d("leak-105", dataLeAkPath105);
				et.setText(streetaddress.getText());
            }
            streetaddress = et;
            lll.addView(streetaddress);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("neighbourhood: ");
            lll.addView(tv);
            et = new EditText(this);
            if (neighbourhood != null)
            {
                String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer106 = new StringBuffer();for (char chAr106 : dataLeAk106.toCharArray()) {leakBuFFer106.append(chAr106);}String dataLeAkPath106 = leakBuFFer106.toString();
				android.util.Log.d("leak-106", dataLeAkPath106);
				et.setText(neighbourhood.getText());
            }
            neighbourhood = et;
            lll.addView(neighbourhood);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("town: ");
            lll.addView(tv);
            et = new EditText(this);
            if (town != null)
            {
                String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath107;try {throw new Exception(dataLeAk107);} catch (Exception leakErRor107) {dataLeAkPath107 = leakErRor107.getMessage();}
				android.util.Log.d("leak-107", dataLeAkPath107);
				et.setText(town.getText());
            }
            town = et;
            lll.addView(town);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("postcode: ");
            lll.addView(tv);
            et = new EditText(this);
            if (postcode != null)
            {
                String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay108 = new String[] {"n/a", dataLeAk108};
				String dataLeAkPath108 = leakArRay108[leakArRay108.length - 1];
				android.util.Log.d("leak-108", dataLeAkPath108);
				et.setText(postcode.getText());
            }
            postcode = et;
            lll.addView(postcode);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("state: ");
            lll.addView(tv);
            et = new EditText(this);
            if (state != null)
            {
                String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP109 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP109.put("test", new java.util.HashMap<String, String>());
				leakMaP109.get("test").put("test", dataLeAk109);
				String dataLeAkPath109 = leakMaP109.get("test").get("test");
				android.util.Log.d("leak-109", dataLeAkPath109);
				et.setText(state.getText());
            }
            state = et;
            lll.addView(state);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(this);
            tv.setText("country: ");
            lll.addView(tv);
            et = new EditText(this);
            if (country != null)
            {
                String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer110 = new StringBuffer();for (char chAr110 : dataLeAk110.toCharArray()) {leakBuFFer110.append(chAr110);}String dataLeAkPath110 = leakBuFFer110.toString();
				android.util.Log.d("leak-110", dataLeAkPath110);
				et.setText(country.getText());
            }
            country = et;
            lll.addView(country);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            Button b = new Button(this);
            b.setText("Cancel");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath111;try {throw new Exception(dataLeAk111);} catch (Exception leakErRor111) {dataLeAkPath111 = leakErRor111.getMessage();}
					android.util.Log.d("leak-111", dataLeAkPath111);
					cancelled = true;
                    finish();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("OK");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay112 = new String[] {"n/a", dataLeAk112};
					String dataLeAkPath112 = leakArRay112[leakArRay112.length - 1];
					android.util.Log.d("leak-112", dataLeAkPath112);
					cancelled = false;
                    finish();
                }
            });
            lll.addView(b);
            ll.addView(lll);
            lll = new LinearLayout(this);
            lll.setOrientation(LinearLayout.HORIZONTAL);
            b = new Button(this);
            b.setText("dump one");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP113 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP113.put("test", new java.util.HashMap<String, String>());
					leakMaP113.get("test").put("test", dataLeAk113);
					String dataLeAkPath113 = leakMaP113.get("test").get("test");
					android.util.Log.d("leak-113", dataLeAkPath113);
					doDumpOne();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer114 = new StringBuffer();for (char chAr114 : dataLeAk114.toCharArray()) {leakBuFFer114.append(chAr114);}String dataLeAkPath114 = leakBuFFer114.toString();
					android.util.Log.d("leak-114", dataLeAkPath114);
					doDumpAll();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all to log");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath115;try {throw new Exception(dataLeAk115);} catch (Exception leakErRor115) {dataLeAkPath115 = leakErRor115.getMessage();}
					android.util.Log.d("leak-115", dataLeAkPath115);
					doLogAll();
                }
            });
            lll.addView(b);
            ll.addView(lll);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
		String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay116 = new String[] {"n/a", dataLeAk116};
		String dataLeAkPath116 = leakArRay116[leakArRay116.length - 1];
		android.util.Log.d("leak-116", dataLeAkPath116);
        if (BuildConfig.DEBUG)
        {
            String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP117 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP117.put("test", new java.util.HashMap<String, String>());
			leakMaP117.get("test").put("test", dataLeAk117);
			String dataLeAkPath117 = leakMaP117.get("test").get("test");
			android.util.Log.d("leak-117", dataLeAkPath117);
			if (dump == null)
            {
                String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer118 = new StringBuffer();for (char chAr118 : dataLeAk118.toCharArray()) {leakBuFFer118.append(chAr118);}String dataLeAkPath118 = leakBuFFer118.toString();
				android.util.Log.d("leak-118", dataLeAkPath118);
				setContentView(R.layout.activity_fake_contact);
                reResume();
            }
            else
            {
                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String dataLeAkPath119;try {throw new Exception(dataLeAk119);} catch (Exception leakErRor119) {dataLeAkPath119 = leakErRor119.getMessage();}
				android.util.Log.d("leak-119", dataLeAkPath119);
				setContentView(dump);
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (BuildConfig.DEBUG)
        {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP121 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP121.put("test", new java.util.HashMap<String, String>());
			leakMaP121.get("test").put("test", dataLeAk121);
			String dataLeAkPath121 = leakMaP121.get("test").get("test");
			android.util.Log.d("leak-121", dataLeAkPath121);
			if (dump != null)
            {
                String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer122 = new StringBuffer();for (char chAr122 : dataLeAk122.toCharArray()) {leakBuFFer122.append(chAr122);}String dataLeAkPath122 = leakBuFFer122.toString();
				android.util.Log.d("leak-122", dataLeAkPath122);
				setContentView(R.layout.activity_fake_contact);
                dump = null;
                reResume();
                return;
            }
        }
		String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay120 = new String[] {"n/a", dataLeAk120};
		String dataLeAkPath120 = leakArRay120[leakArRay120.length - 1];
		android.util.Log.d("leak-120", dataLeAkPath120);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath123;try {throw new Exception(dataLeAk123);} catch (Exception leakErRor123) {dataLeAkPath123 = leakErRor123.getMessage();}
		android.util.Log.d("leak-123", dataLeAkPath123);
        if (BuildConfig.DEBUG)
        {
            String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay124 = new String[] {"n/a", dataLeAk124};
			String dataLeAkPath124 = leakArRay124[leakArRay124.length - 1];
			android.util.Log.d("leak-124", dataLeAkPath124);
			if ((dump == null) && !cancelled)
            {
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP125 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP125.put("test", new java.util.HashMap<String, String>());
				leakMaP125.get("test").put("test", dataLeAk125);
				String dataLeAkPath125 = leakMaP125.get("test").get("test");
				android.util.Log.d("leak-125", dataLeAkPath125);
				String fa = formattedaddress.getText().toString();
                boolean nofa = fa.isEmpty();
                String sa = streetaddress.getText().toString();
                if (nofa && !sa.isEmpty())
                {
                    String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer126 = new StringBuffer();for (char chAr126 : dataLeAk126.toCharArray()) {leakBuFFer126.append(chAr126);}String dataLeAkPath126 = leakBuFFer126.toString();
					android.util.Log.d("leak-126", dataLeAkPath126);
					fa = sa;
                }
                String nb = neighbourhood.getText().toString();
                if (nofa && !nb.isEmpty())
                {
                    String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath127;try {throw new Exception(dataLeAk127);} catch (Exception leakErRor127) {dataLeAkPath127 = leakErRor127.getMessage();}
					android.util.Log.d("leak-127", dataLeAkPath127);
					if (fa.isEmpty())
                    {
                        String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay128 = new String[] {"n/a", dataLeAk128};
						String dataLeAkPath128 = leakArRay128[leakArRay128.length - 1];
						android.util.Log.d("leak-128", dataLeAkPath128);
						fa = nb;
                    }
                    else
                    {
                        String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP129 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP129.put("test", new java.util.HashMap<String, String>());
						leakMaP129.get("test").put("test", dataLeAk129);
						String dataLeAkPath129 = leakMaP129.get("test").get("test");
						android.util.Log.d("leak-129", dataLeAkPath129);
						fa += " " + nb;
                    }
                }
                String tn = town.getText().toString();
                if (nofa && !tn.isEmpty())
                {
                    String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					StringBuffer leakBuFFer130 = new StringBuffer();for (char chAr130 : dataLeAk130.toCharArray()) {leakBuFFer130.append(chAr130);}String dataLeAkPath130 = leakBuFFer130.toString();
					android.util.Log.d("leak-130", dataLeAkPath130);
					if (fa.isEmpty())
                    {
                        String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath131;try {throw new Exception(dataLeAk131);} catch (Exception leakErRor131) {dataLeAkPath131 = leakErRor131.getMessage();}
						android.util.Log.d("leak-131", dataLeAkPath131);
						fa = tn;
                    }
                    else
                    {
                        String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay132 = new String[] {"n/a", dataLeAk132};
						String dataLeAkPath132 = leakArRay132[leakArRay132.length - 1];
						android.util.Log.d("leak-132", dataLeAkPath132);
						fa += " " + tn;
                    }
                }
                String pc = postcode.getText().toString();
                if (nofa && !pc.isEmpty())
                {
                    String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP133 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
					leakMaP133.put("test", new java.util.HashMap<String, String>());
					leakMaP133.get("test").put("test", dataLeAk133);
					String dataLeAkPath133 = leakMaP133.get("test").get("test");
					android.util.Log.d("leak-133", dataLeAkPath133);
					if (fa.isEmpty())
                    {
                        String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer134 = new StringBuffer();for (char chAr134 : dataLeAk134.toCharArray()) {leakBuFFer134.append(chAr134);}String dataLeAkPath134 = leakBuFFer134.toString();
						android.util.Log.d("leak-134", dataLeAkPath134);
						fa = pc;
                    }
                    else
                    {
                        String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath135;try {throw new Exception(dataLeAk135);} catch (Exception leakErRor135) {dataLeAkPath135 = leakErRor135.getMessage();}
						android.util.Log.d("leak-135", dataLeAkPath135);
						fa += " " + pc;
                    }
                }
                String st = state.getText().toString();
                if (nofa && !st.isEmpty())
                {
                    String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay136 = new String[] {"n/a", dataLeAk136};
					String dataLeAkPath136 = leakArRay136[leakArRay136.length - 1];
					android.util.Log.d("leak-136", dataLeAkPath136);
					if (fa.isEmpty())
                    {
                        String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP137 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP137.put("test", new java.util.HashMap<String, String>());
						leakMaP137.get("test").put("test", dataLeAk137);
						String dataLeAkPath137 = leakMaP137.get("test").get("test");
						android.util.Log.d("leak-137", dataLeAkPath137);
						fa = st;
                    }
                    else
                    {
                        String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						StringBuffer leakBuFFer138 = new StringBuffer();for (char chAr138 : dataLeAk138.toCharArray()) {leakBuFFer138.append(chAr138);}String dataLeAkPath138 = leakBuFFer138.toString();
						android.util.Log.d("leak-138", dataLeAkPath138);
						fa += " " + st;
                    }
                }
                String co = country.getText().toString();
                if (nofa && !co.isEmpty())
                {
                    String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String dataLeAkPath139;try {throw new Exception(dataLeAk139);} catch (Exception leakErRor139) {dataLeAkPath139 = leakErRor139.getMessage();}
					android.util.Log.d("leak-139", dataLeAkPath139);
					if (fa.isEmpty())
                    {
                        String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String[] leakArRay140 = new String[] {"n/a", dataLeAk140};
						String dataLeAkPath140 = leakArRay140[leakArRay140.length - 1];
						android.util.Log.d("leak-140", dataLeAkPath140);
						fa = co;
                    }
                    else
                    {
                        String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP141 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
						leakMaP141.put("test", new java.util.HashMap<String, String>());
						leakMaP141.get("test").put("test", dataLeAk141);
						String dataLeAkPath141 = leakMaP141.get("test").get("test");
						android.util.Log.d("leak-141", dataLeAkPath141);
						fa += " " + co;
                    }
                }
                (new ContactCreator(this)).createOrUpdateContact(
                    first.getText().toString(),
                    last.getText().toString(),
                    fa, sa, nb, tn, pc, st, co);
            }
        }
    }
}
