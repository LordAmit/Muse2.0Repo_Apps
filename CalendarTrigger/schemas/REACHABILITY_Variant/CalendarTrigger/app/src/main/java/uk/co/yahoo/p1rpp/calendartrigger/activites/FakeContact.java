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
    String dataLeAk106 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
	Object throwawayLeAk106 = android.util.Log.d("leak-106", dataLeAk106);

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
		String dataLeAk107 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk107 = android.util.Log.d("leak-107", dataLeAk107);
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
        String dataLeAk108 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk108 = android.util.Log.d("leak-108", dataLeAk108);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk109 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk109 = android.util.Log.d("leak-109", dataLeAk109);
			if (dump == null)
            {
                String dataLeAk110 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk110 = android.util.Log.d("leak-110", dataLeAk110);
				dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpOneContact(
                    first.getText().toString(),
                    last.getText().toString());
            if (strings == null)
            {
                String dataLeAk111 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk111 = android.util.Log.d("leak-111", dataLeAk111);
				Toast.makeText(this,
                    "No contacts match",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
                String dataLeAk112 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk112 = android.util.Log.d("leak-112", dataLeAk112);
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
        String dataLeAk113 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk113 = android.util.Log.d("leak-113", dataLeAk113);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk114 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk114 = android.util.Log.d("leak-114", dataLeAk114);
			new ContactCreator(this).logAllContacts();
        }
    }

    void doDumpAll() {
        String dataLeAk115 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk115 = android.util.Log.d("leak-115", dataLeAk115);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk116 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk116 = android.util.Log.d("leak-116", dataLeAk116);
			if (dump == null)
            {
                String dataLeAk117 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk117 = android.util.Log.d("leak-117", dataLeAk117);
				dump = new ListView(this);
            }
            ArrayList<String> strings =
                (new ContactCreator(this)).dumpAllContacts();
            if (strings == null)
            {
                String dataLeAk118 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk118 = android.util.Log.d("leak-118", dataLeAk118);
				Toast.makeText(this,
                               "No contact to dump",
                               Toast.LENGTH_LONG).show();
            }
            else
            {
                String dataLeAk119 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk119 = android.util.Log.d("leak-119", dataLeAk119);
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
        String dataLeAk120 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk120 = android.util.Log.d("leak-120", dataLeAk120);
		if (BuildConfig.DEBUG)
        {
            String dataLeAk121 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk121 = android.util.Log.d("leak-121", dataLeAk121);
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
                String dataLeAk122 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk122 = android.util.Log.d("leak-122", dataLeAk122);
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
                String dataLeAk123 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk123 = android.util.Log.d("leak-123", dataLeAk123);
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
                String dataLeAk124 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk124 = android.util.Log.d("leak-124", dataLeAk124);
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
                String dataLeAk125 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk125 = android.util.Log.d("leak-125", dataLeAk125);
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
                String dataLeAk126 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk126 = android.util.Log.d("leak-126", dataLeAk126);
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
                String dataLeAk127 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk127 = android.util.Log.d("leak-127", dataLeAk127);
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
                String dataLeAk128 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk128 = android.util.Log.d("leak-128", dataLeAk128);
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
                String dataLeAk129 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk129 = android.util.Log.d("leak-129", dataLeAk129);
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
                String dataLeAk130 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk130 = android.util.Log.d("leak-130", dataLeAk130);
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
                String dataLeAk131 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk131 = android.util.Log.d("leak-131", dataLeAk131);

				@Override
                public void onClick(View v) {
                    String dataLeAk132 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk132 = android.util.Log.d("leak-132", dataLeAk132);
					cancelled = true;
                    finish();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("OK");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk133 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk133 = android.util.Log.d("leak-133", dataLeAk133);

				@Override
                public void onClick(View v) {
                    String dataLeAk134 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk134 = android.util.Log.d("leak-134", dataLeAk134);
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
                String dataLeAk135 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk135 = android.util.Log.d("leak-135", dataLeAk135);

				@Override
                public void onClick(View v) {
                    String dataLeAk136 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk136 = android.util.Log.d("leak-136", dataLeAk136);
					doDumpOne();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk137 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk137 = android.util.Log.d("leak-137", dataLeAk137);

				@Override
                public void onClick(View v) {
                    String dataLeAk138 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk138 = android.util.Log.d("leak-138", dataLeAk138);
					doDumpAll();
                }
            });
            lll.addView(b);
            b = new Button(this);
            b.setText("dump all to log");
            b.setOnClickListener(new View.OnClickListener() {
                String dataLeAk139 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk139 = android.util.Log.d("leak-139", dataLeAk139);

				@Override
                public void onClick(View v) {
                    String dataLeAk140 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk140 = android.util.Log.d("leak-140", dataLeAk140);
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
		String dataLeAk141 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk141 = android.util.Log.d("leak-141", dataLeAk141);
        if (BuildConfig.DEBUG)
        {
            String dataLeAk142 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk142 = android.util.Log.d("leak-142", dataLeAk142);
			if (dump == null)
            {
                String dataLeAk143 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk143 = android.util.Log.d("leak-143", dataLeAk143);
				setContentView(R.layout.activity_fake_contact);
                reResume();
            }
            else
            {
                String dataLeAk144 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk144 = android.util.Log.d("leak-144", dataLeAk144);
				setContentView(dump);
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (BuildConfig.DEBUG)
        {
            String dataLeAk146 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk146 = android.util.Log.d("leak-146", dataLeAk146);
			if (dump != null)
            {
                String dataLeAk147 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk147 = android.util.Log.d("leak-147", dataLeAk147);
				setContentView(R.layout.activity_fake_contact);
                dump = null;
                reResume();
                return;
            }
        }
		String dataLeAk145 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk145 = android.util.Log.d("leak-145", dataLeAk145);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
		String dataLeAk148 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		Object throwawayLeAk148 = android.util.Log.d("leak-148", dataLeAk148);
        if (BuildConfig.DEBUG)
        {
            String dataLeAk149 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			Object throwawayLeAk149 = android.util.Log.d("leak-149", dataLeAk149);
			if ((dump == null) && !cancelled)
            {
                String dataLeAk150 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				Object throwawayLeAk150 = android.util.Log.d("leak-150", dataLeAk150);
				String fa = formattedaddress.getText().toString();
                boolean nofa = fa.isEmpty();
                String sa = streetaddress.getText().toString();
                if (nofa && !sa.isEmpty())
                {
                    String dataLeAk151 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk151 = android.util.Log.d("leak-151", dataLeAk151);
					fa = sa;
                }
                String nb = neighbourhood.getText().toString();
                if (nofa && !nb.isEmpty())
                {
                    String dataLeAk152 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk152 = android.util.Log.d("leak-152", dataLeAk152);
					if (fa.isEmpty())
                    {
                        String dataLeAk153 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk153 = android.util.Log.d("leak-153", dataLeAk153);
						fa = nb;
                    }
                    else
                    {
                        String dataLeAk154 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk154 = android.util.Log.d("leak-154", dataLeAk154);
						fa += " " + nb;
                    }
                }
                String tn = town.getText().toString();
                if (nofa && !tn.isEmpty())
                {
                    String dataLeAk155 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk155 = android.util.Log.d("leak-155", dataLeAk155);
					if (fa.isEmpty())
                    {
                        String dataLeAk156 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk156 = android.util.Log.d("leak-156", dataLeAk156);
						fa = tn;
                    }
                    else
                    {
                        String dataLeAk157 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk157 = android.util.Log.d("leak-157", dataLeAk157);
						fa += " " + tn;
                    }
                }
                String pc = postcode.getText().toString();
                if (nofa && !pc.isEmpty())
                {
                    String dataLeAk158 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk158 = android.util.Log.d("leak-158", dataLeAk158);
					if (fa.isEmpty())
                    {
                        String dataLeAk159 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk159 = android.util.Log.d("leak-159", dataLeAk159);
						fa = pc;
                    }
                    else
                    {
                        String dataLeAk160 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk160 = android.util.Log.d("leak-160", dataLeAk160);
						fa += " " + pc;
                    }
                }
                String st = state.getText().toString();
                if (nofa && !st.isEmpty())
                {
                    String dataLeAk161 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk161 = android.util.Log.d("leak-161", dataLeAk161);
					if (fa.isEmpty())
                    {
                        String dataLeAk162 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk162 = android.util.Log.d("leak-162", dataLeAk162);
						fa = st;
                    }
                    else
                    {
                        String dataLeAk163 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk163 = android.util.Log.d("leak-163", dataLeAk163);
						fa += " " + st;
                    }
                }
                String co = country.getText().toString();
                if (nofa && !co.isEmpty())
                {
                    String dataLeAk164 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					Object throwawayLeAk164 = android.util.Log.d("leak-164", dataLeAk164);
					if (fa.isEmpty())
                    {
                        String dataLeAk165 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk165 = android.util.Log.d("leak-165", dataLeAk165);
						fa = co;
                    }
                    else
                    {
                        String dataLeAk166 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						Object throwawayLeAk166 = android.util.Log.d("leak-166", dataLeAk166);
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
