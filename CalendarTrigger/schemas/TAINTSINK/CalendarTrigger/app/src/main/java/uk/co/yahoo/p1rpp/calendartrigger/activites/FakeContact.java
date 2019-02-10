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
    String dataLeAk74 = "74";

	String dataLeAk73 = "73";

	String dataLeAk72 = "72";

	String dataLeAk71 = "71";

	String dataLeAk69 = "69";

	String dataLeAk67 = "67";

	String dataLeAk65 = "65";

	String dataLeAk63 = "63";

	String dataLeAk61 = "61";

	String dataLeAk60 = "60";

	String dataLeAk59 = "59";

	String dataLeAk58 = "58";

	String dataLeAk57 = "57";

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
		android.util.Log.d("leak-57-35", dataLeAk57);
		android.util.Log.d("leak-58-35", dataLeAk58);
		android.util.Log.d("leak-59-35", dataLeAk59);
		android.util.Log.d("leak-60-35", dataLeAk60);
		android.util.Log.d("leak-61-35", dataLeAk61);
		android.util.Log.d("leak-63-35", dataLeAk63);
		android.util.Log.d("leak-65-35", dataLeAk65);
		android.util.Log.d("leak-67-35", dataLeAk67);
		android.util.Log.d("leak-69-35", dataLeAk69);
		android.util.Log.d("leak-71-35", dataLeAk71);
		android.util.Log.d("leak-72-35", dataLeAk72);
		android.util.Log.d("leak-73-35", dataLeAk73);
		android.util.Log.d("leak-74-35", dataLeAk74);
		dataLeAk57 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
        dataLeAk58 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-57-36", dataLeAk57);
		android.util.Log.d("leak-58-36", dataLeAk58);
		android.util.Log.d("leak-59-36", dataLeAk59);
		android.util.Log.d("leak-60-36", dataLeAk60);
		android.util.Log.d("leak-61-36", dataLeAk61);
		android.util.Log.d("leak-63-36", dataLeAk63);
		android.util.Log.d("leak-65-36", dataLeAk65);
		android.util.Log.d("leak-67-36", dataLeAk67);
		android.util.Log.d("leak-69-36", dataLeAk69);
		android.util.Log.d("leak-71-36", dataLeAk71);
		android.util.Log.d("leak-72-36", dataLeAk72);
		android.util.Log.d("leak-73-36", dataLeAk73);
		android.util.Log.d("leak-74-36", dataLeAk74);
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
        dataLeAk59 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-57-37", dataLeAk57);
		android.util.Log.d("leak-58-37", dataLeAk58);
		android.util.Log.d("leak-59-37", dataLeAk59);
		android.util.Log.d("leak-60-37", dataLeAk60);
		android.util.Log.d("leak-61-37", dataLeAk61);
		android.util.Log.d("leak-63-37", dataLeAk63);
		android.util.Log.d("leak-65-37", dataLeAk65);
		android.util.Log.d("leak-67-37", dataLeAk67);
		android.util.Log.d("leak-69-37", dataLeAk69);
		android.util.Log.d("leak-71-37", dataLeAk71);
		android.util.Log.d("leak-72-37", dataLeAk72);
		android.util.Log.d("leak-73-37", dataLeAk73);
		android.util.Log.d("leak-74-37", dataLeAk74);
		if (BuildConfig.DEBUG)
        {
            new ContactCreator(this).logAllContacts();
        }
    }

    void doDumpAll() {
        dataLeAk60 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-57-38", dataLeAk57);
		android.util.Log.d("leak-58-38", dataLeAk58);
		android.util.Log.d("leak-59-38", dataLeAk59);
		android.util.Log.d("leak-60-38", dataLeAk60);
		android.util.Log.d("leak-61-38", dataLeAk61);
		android.util.Log.d("leak-63-38", dataLeAk63);
		android.util.Log.d("leak-65-38", dataLeAk65);
		android.util.Log.d("leak-67-38", dataLeAk67);
		android.util.Log.d("leak-69-38", dataLeAk69);
		android.util.Log.d("leak-71-38", dataLeAk71);
		android.util.Log.d("leak-72-38", dataLeAk72);
		android.util.Log.d("leak-73-38", dataLeAk73);
		android.util.Log.d("leak-74-38", dataLeAk74);
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
        dataLeAk61 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-57-39", dataLeAk57);
		android.util.Log.d("leak-58-39", dataLeAk58);
		android.util.Log.d("leak-59-39", dataLeAk59);
		android.util.Log.d("leak-60-39", dataLeAk60);
		android.util.Log.d("leak-61-39", dataLeAk61);
		android.util.Log.d("leak-63-39", dataLeAk63);
		android.util.Log.d("leak-65-39", dataLeAk65);
		android.util.Log.d("leak-67-39", dataLeAk67);
		android.util.Log.d("leak-69-39", dataLeAk69);
		android.util.Log.d("leak-71-39", dataLeAk71);
		android.util.Log.d("leak-72-39", dataLeAk72);
		android.util.Log.d("leak-73-39", dataLeAk73);
		android.util.Log.d("leak-74-39", dataLeAk74);
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
                String dataLeAk62 = "62";

				@Override
                public void onClick(View v) {
                    dataLeAk63 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk62 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					cancelled = true;
                    finish();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("OK");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk64 = "64";

				@Override
                public void onClick(View v) {
                    dataLeAk65 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk64 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
                String dataLeAk66 = "66";

				@Override
                public void onClick(View v) {
                    dataLeAk67 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk66 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					doDumpOne();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk68 = "68";

				@Override
                public void onClick(View v) {
                    dataLeAk69 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk68 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					doDumpAll();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all to log");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk70 = "70";

				@Override
                public void onClick(View v) {
                    dataLeAk71 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					dataLeAk70 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		android.util.Log.d("leak-57-40", dataLeAk57);
		android.util.Log.d("leak-58-40", dataLeAk58);
		android.util.Log.d("leak-59-40", dataLeAk59);
		android.util.Log.d("leak-60-40", dataLeAk60);
		android.util.Log.d("leak-61-40", dataLeAk61);
		android.util.Log.d("leak-63-40", dataLeAk63);
		android.util.Log.d("leak-65-40", dataLeAk65);
		android.util.Log.d("leak-67-40", dataLeAk67);
		android.util.Log.d("leak-69-40", dataLeAk69);
		android.util.Log.d("leak-71-40", dataLeAk71);
		android.util.Log.d("leak-72-40", dataLeAk72);
		android.util.Log.d("leak-73-40", dataLeAk73);
		android.util.Log.d("leak-74-40", dataLeAk74);
		dataLeAk72 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
		dataLeAk73 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-57-41", dataLeAk57);
		android.util.Log.d("leak-58-41", dataLeAk58);
		android.util.Log.d("leak-59-41", dataLeAk59);
		android.util.Log.d("leak-60-41", dataLeAk60);
		android.util.Log.d("leak-61-41", dataLeAk61);
		android.util.Log.d("leak-63-41", dataLeAk63);
		android.util.Log.d("leak-65-41", dataLeAk65);
		android.util.Log.d("leak-67-41", dataLeAk67);
		android.util.Log.d("leak-69-41", dataLeAk69);
		android.util.Log.d("leak-71-41", dataLeAk71);
		android.util.Log.d("leak-72-41", dataLeAk72);
		android.util.Log.d("leak-73-41", dataLeAk73);
		android.util.Log.d("leak-74-41", dataLeAk74);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
		android.util.Log.d("leak-57-42", dataLeAk57);
		android.util.Log.d("leak-58-42", dataLeAk58);
		android.util.Log.d("leak-59-42", dataLeAk59);
		android.util.Log.d("leak-60-42", dataLeAk60);
		android.util.Log.d("leak-61-42", dataLeAk61);
		android.util.Log.d("leak-63-42", dataLeAk63);
		android.util.Log.d("leak-65-42", dataLeAk65);
		android.util.Log.d("leak-67-42", dataLeAk67);
		android.util.Log.d("leak-69-42", dataLeAk69);
		android.util.Log.d("leak-71-42", dataLeAk71);
		android.util.Log.d("leak-72-42", dataLeAk72);
		android.util.Log.d("leak-73-42", dataLeAk73);
		android.util.Log.d("leak-74-42", dataLeAk74);
		dataLeAk74 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
