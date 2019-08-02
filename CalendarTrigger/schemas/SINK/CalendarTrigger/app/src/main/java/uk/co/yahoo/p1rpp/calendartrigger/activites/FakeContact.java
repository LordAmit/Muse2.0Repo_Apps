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
    final String dataLeAk77 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk76 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk75 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	final String dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

	String dataLeAk71 = "";

	String dataLeAk70 = "";

	String dataLeAk69 = "";

	String dataLeAk63 = "";

	String dataLeAk62 = "";

	String dataLeAk61 = "";

	String dataLeAk60 = "";

	String dataLeAk59 = "";

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
		dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-0", dataLeAk59);
		android.util.Log.d("leak-60-0", dataLeAk60);
		android.util.Log.d("leak-61-0", dataLeAk61);
		android.util.Log.d("leak-62-0", dataLeAk62);
		android.util.Log.d("leak-63-0", dataLeAk63);
		android.util.Log.d("leak-69-0", dataLeAk69);
		android.util.Log.d("leak-70-0", dataLeAk70);
		android.util.Log.d("leak-71-0", dataLeAk71);
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
        dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-1", dataLeAk59);
		android.util.Log.d("leak-60-1", dataLeAk60);
		android.util.Log.d("leak-61-1", dataLeAk61);
		android.util.Log.d("leak-62-1", dataLeAk62);
		android.util.Log.d("leak-63-1", dataLeAk63);
		android.util.Log.d("leak-69-1", dataLeAk69);
		android.util.Log.d("leak-70-1", dataLeAk70);
		android.util.Log.d("leak-71-1", dataLeAk71);
		if (BuildConfig.DEBUG)
        {
            if (dump == null)
            {
                dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpOneContact(
                    first.getText().toString(),
                    last.getText().toString());
            if (strings == null)
            {
                Toast.makeText(this,
                    "No contacts match",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
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
        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-2", dataLeAk59);
		android.util.Log.d("leak-60-2", dataLeAk60);
		android.util.Log.d("leak-61-2", dataLeAk61);
		android.util.Log.d("leak-62-2", dataLeAk62);
		android.util.Log.d("leak-63-2", dataLeAk63);
		android.util.Log.d("leak-69-2", dataLeAk69);
		android.util.Log.d("leak-70-2", dataLeAk70);
		android.util.Log.d("leak-71-2", dataLeAk71);
		if (BuildConfig.DEBUG)
        {
            new ContactCreator(this).logAllContacts();
        }
    }

    void doDumpAll() {
        dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-3", dataLeAk59);
		android.util.Log.d("leak-60-3", dataLeAk60);
		android.util.Log.d("leak-61-3", dataLeAk61);
		android.util.Log.d("leak-62-3", dataLeAk62);
		android.util.Log.d("leak-63-3", dataLeAk63);
		android.util.Log.d("leak-69-3", dataLeAk69);
		android.util.Log.d("leak-70-3", dataLeAk70);
		android.util.Log.d("leak-71-3", dataLeAk71);
		if (BuildConfig.DEBUG)
        {
            if (dump == null)
            {
                dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpAllContacts();
            if (strings == null)
            {
                Toast.makeText(this,
                               "No contact to dump",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
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
        dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-4", dataLeAk59);
		android.util.Log.d("leak-60-4", dataLeAk60);
		android.util.Log.d("leak-61-4", dataLeAk61);
		android.util.Log.d("leak-62-4", dataLeAk62);
		android.util.Log.d("leak-63-4", dataLeAk63);
		android.util.Log.d("leak-69-4", dataLeAk69);
		android.util.Log.d("leak-70-4", dataLeAk70);
		android.util.Log.d("leak-71-4", dataLeAk71);
		if (BuildConfig.DEBUG)
        {
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
                String dataLeAk64 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-73-0", dataLeAk73);
					android.util.Log.d("leak-64-0", dataLeAk64);
					cancelled = true;
                    finish();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("OK");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk65 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-74-0", dataLeAk74);
					android.util.Log.d("leak-65-0", dataLeAk65);
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
                String dataLeAk66 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-75-0", dataLeAk75);
					android.util.Log.d("leak-66-0", dataLeAk66);
					doDumpOne();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk67 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-76-0", dataLeAk76);
					android.util.Log.d("leak-67-0", dataLeAk67);
					doDumpAll();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all to log");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk68 = "";

				@Override
                public void onClick(View v) {
                    dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					android.util.Log.d("leak-77-0", dataLeAk77);
					android.util.Log.d("leak-68-0", dataLeAk68);
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
		dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-5", dataLeAk59);
		android.util.Log.d("leak-60-5", dataLeAk60);
		android.util.Log.d("leak-61-5", dataLeAk61);
		android.util.Log.d("leak-62-5", dataLeAk62);
		android.util.Log.d("leak-63-5", dataLeAk63);
		android.util.Log.d("leak-69-5", dataLeAk69);
		android.util.Log.d("leak-70-5", dataLeAk70);
		android.util.Log.d("leak-71-5", dataLeAk71);
        if (BuildConfig.DEBUG)
        {
            if (dump == null)
            {
                setContentView(R.layout.activity_fake_contact);
                reResume();
            }
            else
            {
                setContentView(dump);
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (BuildConfig.DEBUG)
        {
            if (dump != null)
            {
                setContentView(R.layout.activity_fake_contact);
                dump = null;
                reResume();
                return;
            }
        }
		dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-6", dataLeAk59);
		android.util.Log.d("leak-60-6", dataLeAk60);
		android.util.Log.d("leak-61-6", dataLeAk61);
		android.util.Log.d("leak-62-6", dataLeAk62);
		android.util.Log.d("leak-63-6", dataLeAk63);
		android.util.Log.d("leak-69-6", dataLeAk69);
		android.util.Log.d("leak-70-6", dataLeAk70);
		android.util.Log.d("leak-71-6", dataLeAk71);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
		dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-59-7", dataLeAk59);
		android.util.Log.d("leak-60-7", dataLeAk60);
		android.util.Log.d("leak-61-7", dataLeAk61);
		android.util.Log.d("leak-62-7", dataLeAk62);
		android.util.Log.d("leak-63-7", dataLeAk63);
		android.util.Log.d("leak-69-7", dataLeAk69);
		android.util.Log.d("leak-70-7", dataLeAk70);
		android.util.Log.d("leak-71-7", dataLeAk71);
        if (BuildConfig.DEBUG)
        {
            if ((dump == null) && !cancelled)
            {
                String fa = formattedaddress.getText().toString();
                boolean nofa = fa.isEmpty();
                String sa = streetaddress.getText().toString();
                if (nofa && !sa.isEmpty())
                {
                    fa = sa;
                }
                String nb = neighbourhood.getText().toString();
                if (nofa && !nb.isEmpty())
                {
                    if (fa.isEmpty())
                    {
                        fa = nb;
                    }
                    else
                    {
                        fa += " " + nb;
                    }
                }
                String tn = town.getText().toString();
                if (nofa && !tn.isEmpty())
                {
                    if (fa.isEmpty())
                    {
                        fa = tn;
                    }
                    else
                    {
                        fa += " " + tn;
                    }
                }
                String pc = postcode.getText().toString();
                if (nofa && !pc.isEmpty())
                {
                    if (fa.isEmpty())
                    {
                        fa = pc;
                    }
                    else
                    {
                        fa += " " + pc;
                    }
                }
                String st = state.getText().toString();
                if (nofa && !st.isEmpty())
                {
                    if (fa.isEmpty())
                    {
                        fa = st;
                    }
                    else
                    {
                        fa += " " + st;
                    }
                }
                String co = country.getText().toString();
                if (nofa && !co.isEmpty())
                {
                    if (fa.isEmpty())
                    {
                        fa = co;
                    }
                    else
                    {
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
