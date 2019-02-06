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

    String dataLeAk3 = "";

	String dataLeAk2 = "";

	String dataLeAk1 = "";

	String dataLeAk0 = "";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-2-0", dataLeAk2);
		android.util.Log.d("leak-3-0", dataLeAk3);
        setContentView(R.layout.activity_bmimain);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    public void calculateClickHandler(View view) {
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-2-1", dataLeAk2);
		android.util.Log.d("leak-3-1", dataLeAk3);
		if (view.getId() == R.id.calcBMI) {

            // get the references to the widgets


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
                weight = Double.parseDouble(weightNum.getText().toString());
            }

            if (!(heightNum.getText().toString().equals(""))) {
                height = Double.parseDouble(heightNum.getText().toString());
            }

            double bmi;

            // calculate bmi value - pounds and inch
            if (weightSpinnerString.equals("Pounds") && heightSpinnerString.equals("Inch")) {
                bmi = calculateBMI(weight, height);
            } else if (weightSpinnerString.equals("Kilograms") &&
                    heightSpinnerString.equals("Inch")){
                weight = weight * 2.205;
                bmi = calculateBMI(weight, height);
            } else if (weightSpinnerString.equals("Pounds") && heightSpinnerString.equals("CM")){
                height = height / 2.54;
                bmi = calculateBMI(weight, height);
            } else {
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
        dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-2", dataLeAk0);
		android.util.Log.d("leak-1-2", dataLeAk1);
		android.util.Log.d("leak-2-2", dataLeAk2);
		android.util.Log.d("leak-3-2", dataLeAk3);
			// convert values to metric
            return (double) (((weight / 2.2046) / (height * 0.0254)) / (height * 0.0254));
    }

    // interpret what BMI means
    private String interpretBMI(double bmi) {

        dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-3", dataLeAk0);
		android.util.Log.d("leak-1-3", dataLeAk1);
		android.util.Log.d("leak-2-3", dataLeAk2);
		android.util.Log.d("leak-3-3", dataLeAk3);
		if (bmi < 16) {
            return "You are Severely Underweight";
        } else if (bmi < 18.5) {
            return "You are Underweight";
        } else if (bmi < 25) {
            return "You are Normal";
        }else if (bmi < 30) {
            return "You are Overweight";
        }else if (bmi < 40) {
            return "You are Obese";
        }else if (bmi >= 40) {
            return "You are Morbidly Obese";
        }else {
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

        String dataLeAk5 = "";

		String dataLeAk4 = "";

		public PlaceholderFragment() {
			dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-4-0", dataLeAk4);
			android.util.Log.d("leak-5-0", dataLeAk5);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-4-1", dataLeAk4);
			android.util.Log.d("leak-5-1", dataLeAk5);
			View rootView = inflater.inflate(R.layout.fragment_bmimain, container, false);
            return rootView;
        }
    }

}
