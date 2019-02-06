package com.zola.bmi;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class BMIMain extends AppCompatActivity {

    //private Spinner weightSpinner, heightSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		String dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String[] leakArRay0 = new String[] {"n/a", dataLeAk0};
		String dataLeAkPath0 = leakArRay0[leakArRay0.length - 1];
		android.util.Log.d("leak-0", dataLeAkPath0);
        setContentView(R.layout.activity_bmimain);

        if (savedInstanceState == null) {
            String dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP1 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP1.put("test", new java.util.HashMap<String, String>());
			leakMaP1.get("test").put("test", dataLeAk1);
			String dataLeAkPath1 = leakMaP1.get("test").get("test");
			android.util.Log.d("leak-1", dataLeAkPath1);
			getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    public void calculateClickHandler(View view) {
        String dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer2 = new StringBuffer();for (char chAr2 : dataLeAk2.toCharArray()) {leakBuFFer2.append(chAr2);}String dataLeAkPath2 = leakBuFFer2.toString();
		android.util.Log.d("leak-2", dataLeAkPath2);
		if (view.getId() == R.id.calcBMI) {

            // get the references to the widgets


            String dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath3;try {throw new Exception(dataLeAk3);} catch (Exception leakErRor3) {dataLeAkPath3 = leakErRor3.getMessage();}
			android.util.Log.d("leak-3", dataLeAkPath3);
			EditText weightNum = (EditText)findViewById(R.id.weightNum);
            EditText heightNum = (EditText)findViewById(R.id.heightNum);
            TextView resultLabel = (TextView)findViewById(R.id.resultLabel);

            Spinner weightSpinner = (Spinner)findViewById(R.id.weightSpinner);
            Spinner heightSpinner = (Spinner)findViewById(R.id.heightSpinner);
            String weightSpinnerString = weightSpinner.getSelectedItem().toString();
            String heightSpinnerString = heightSpinner.getSelectedItem().toString();

            double weight;
            weight = 0;
            double height;
            height = 0;

            // get the users values from the widget references
            if (!(weightNum.getText().toString().equals(""))) {
                String dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay4 = new String[] {"n/a", dataLeAk4};
				String dataLeAkPath4 = leakArRay4[leakArRay4.length - 1];
				android.util.Log.d("leak-4", dataLeAkPath4);
				weight = Double.parseDouble(weightNum.getText().toString());
            }

            if (!(heightNum.getText().toString().equals(""))) {
                String dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP5 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP5.put("test", new java.util.HashMap<String, String>());
				leakMaP5.get("test").put("test", dataLeAk5);
				String dataLeAkPath5 = leakMaP5.get("test").get("test");
				android.util.Log.d("leak-5", dataLeAkPath5);
				height = Double.parseDouble(heightNum.getText().toString());
            }

            double bmi;

            // calculate bmi value - pounds and inch
            if (weightSpinnerString.equals("Pounds") && heightSpinnerString.equals("Inch")) {
                String dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				StringBuffer leakBuFFer6 = new StringBuffer();for (char chAr6 : dataLeAk6.toCharArray()) {leakBuFFer6.append(chAr6);}String dataLeAkPath6 = leakBuFFer6.toString();
				android.util.Log.d("leak-6", dataLeAkPath6);
				bmi = calculateBMI(weight, height);
            } else if (weightSpinnerString.equals("Kilograms") &&
                    heightSpinnerString.equals("Inch")){
                String dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
						String dataLeAkPath7;try {throw new Exception(dataLeAk7);} catch (Exception leakErRor7) {dataLeAkPath7 = leakErRor7.getMessage();}
						android.util.Log.d("leak-7", dataLeAkPath7);
				weight = weight * 2.205;
                bmi = calculateBMI(weight, height);
            } else if (weightSpinnerString.equals("Pounds") && heightSpinnerString.equals("CM")){
                String dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				String[] leakArRay8 = new String[] {"n/a", dataLeAk8};
				String dataLeAkPath8 = leakArRay8[leakArRay8.length - 1];
				android.util.Log.d("leak-8", dataLeAkPath8);
				height = height / 2.54;
                bmi = calculateBMI(weight, height);
            } else {
                String dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP9 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
				leakMaP9.put("test", new java.util.HashMap<String, String>());
				leakMaP9.get("test").put("test", dataLeAk9);
				String dataLeAkPath9 = leakMaP9.get("test").get("test");
				android.util.Log.d("leak-9", dataLeAkPath9);
				weight = weight * 2.205;
                height = height / 2.54;
                bmi = calculateBMI(weight, height);
            }

            // round to 2 digits
            double newBMI = Math.round(bmi*100.0)/100.0;
            DecimalFormat f = new DecimalFormat("##.00");

            // interpret the meaning of the bmi value
            String bmiInterpretation = interpretBMI(bmi);

            // now set the value in the results text
            resultLabel.setText("BMI Score = " + f.format(newBMI) + "\n" + bmiInterpretation);
        }
    }

    // the formula to calculate the BMI index
    private double calculateBMI (double weight, double height) {
        String dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		StringBuffer leakBuFFer10 = new StringBuffer();for (char chAr10 : dataLeAk10.toCharArray()) {leakBuFFer10.append(chAr10);}String dataLeAkPath10 = leakBuFFer10.toString();
		android.util.Log.d("leak-10", dataLeAkPath10);
			// convert values to metric
            return (double) (((weight / 2.2046) / (height * 0.0254)) / (height * 0.0254));
    }

    // interpret what BMI means
    private String interpretBMI(double bmi) {

        String dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		String dataLeAkPath11;try {throw new Exception(dataLeAk11);} catch (Exception leakErRor11) {dataLeAkPath11 = leakErRor11.getMessage();}
		android.util.Log.d("leak-11", dataLeAkPath11);
		if (bmi < 16) {
            String dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay12 = new String[] {"n/a", dataLeAk12};
			String dataLeAkPath12 = leakArRay12[leakArRay12.length - 1];
			android.util.Log.d("leak-12", dataLeAkPath12);
			return "You are Severely Underweight";
        } else if (bmi < 18.5) {
            String dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP13 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP13.put("test", new java.util.HashMap<String, String>());
			leakMaP13.get("test").put("test", dataLeAk13);
			String dataLeAkPath13 = leakMaP13.get("test").get("test");
			android.util.Log.d("leak-13", dataLeAkPath13);
			return "You are Underweight";
        } else if (bmi < 25) {
            String dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer14 = new StringBuffer();for (char chAr14 : dataLeAk14.toCharArray()) {leakBuFFer14.append(chAr14);}String dataLeAkPath14 = leakBuFFer14.toString();
			android.util.Log.d("leak-14", dataLeAkPath14);
			return "You are Normal";
        }else if (bmi < 30) {
            String dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath15;try {throw new Exception(dataLeAk15);} catch (Exception leakErRor15) {dataLeAkPath15 = leakErRor15.getMessage();}
			android.util.Log.d("leak-15", dataLeAkPath15);
			return "You are Overweight";
        }else if (bmi < 40) {
            String dataLeAk16 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String[] leakArRay16 = new String[] {"n/a", dataLeAk16};
			String dataLeAkPath16 = leakArRay16[leakArRay16.length - 1];
			android.util.Log.d("leak-16", dataLeAkPath16);
			return "You are Obese";
        }else if (bmi >= 40) {
            String dataLeAk17 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			java.util.HashMap<String, java.util.HashMap<String, String>> leakMaP17 = new java.util.HashMap<String, java.util.HashMap<String, String>>();
			leakMaP17.put("test", new java.util.HashMap<String, String>());
			leakMaP17.get("test").put("test", dataLeAk17);
			String dataLeAkPath17 = leakMaP17.get("test").get("test");
			android.util.Log.d("leak-17", dataLeAkPath17);
			return "You are Morbidly Obese";
        }else {
            String dataLeAk18 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			StringBuffer leakBuFFer18 = new StringBuffer();for (char chAr18 : dataLeAk18.toCharArray()) {leakBuFFer18.append(chAr18);}String dataLeAkPath18 = leakBuFFer18.toString();
			android.util.Log.d("leak-18", dataLeAkPath18);
			return "Enter your Details";
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmimain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
			String dataLeAk19 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			String dataLeAkPath19;try {throw new Exception(dataLeAk19);} catch (Exception leakErRor19) {dataLeAkPath19 = leakErRor19.getMessage();}
			android.util.Log.d("leak-19", dataLeAkPath19);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            String dataLeAk20 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
					String[] leakArRay20 = new String[] {"n/a", dataLeAk20};
					String dataLeAkPath20 = leakArRay20[leakArRay20.length - 1];
					android.util.Log.d("leak-20", dataLeAkPath20);
			View rootView = inflater.inflate(R.layout.fragment_bmimain, container, false);
            return rootView;
        }
    }

}
