package com.example.amit.helloworld.test;

public class TestClass {

	String dataLeAk15 = "15";
	String dataLeAk12 = "12";
	String dataLeAk9 = "9";
	String dataLeAk7 = "7";
	String dataLeAk5 = "5";
	String dataLeAk4 = "4";
	int methodA(){
		dataLeAk4 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-3", dataLeAk4);
		android.util.Log.d("leak-5-3", dataLeAk5);
		android.util.Log.d("leak-7-3", dataLeAk7);
		android.util.Log.d("leak-9-3", dataLeAk9);
		android.util.Log.d("leak-12-3", dataLeAk12);
		android.util.Log.d("leak-15-3", dataLeAk15);
		return 1;
    }
    int methodB(){
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-4-4", dataLeAk4);
		android.util.Log.d("leak-5-4", dataLeAk5);
		android.util.Log.d("leak-7-4", dataLeAk7);
		android.util.Log.d("leak-9-4", dataLeAk9);
		android.util.Log.d("leak-12-4", dataLeAk12);
		android.util.Log.d("leak-15-4", dataLeAk15);
		return 2;
    }
    class ChildClassLevelOne{
		String dataLeAk14 = "14";
		String dataLeAk11 = "11";
		String dataLeAk8 = "8";
		String dataLeAk6 = "6";
		int methodConeA(){
			dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-6-5", dataLeAk6);
			android.util.Log.d("leak-8-5", dataLeAk8);
			android.util.Log.d("leak-11-5", dataLeAk11);
			android.util.Log.d("leak-14-5", dataLeAk14);
			android.util.Log.d("leak-4-5", dataLeAk4);
			android.util.Log.d("leak-5-5", dataLeAk5);
			android.util.Log.d("leak-7-5", dataLeAk7);
			android.util.Log.d("leak-9-5", dataLeAk9);
			android.util.Log.d("leak-12-5", dataLeAk12);
			android.util.Log.d("leak-15-5", dataLeAk15);
			dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			return 1;
        }
        int methodCOneB(){
			dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			android.util.Log.d("leak-6-6", dataLeAk6);
			android.util.Log.d("leak-8-6", dataLeAk8);
			android.util.Log.d("leak-11-6", dataLeAk11);
			android.util.Log.d("leak-14-6", dataLeAk14);
			android.util.Log.d("leak-4-6", dataLeAk4);
			android.util.Log.d("leak-5-6", dataLeAk5);
			android.util.Log.d("leak-7-6", dataLeAk7);
			android.util.Log.d("leak-9-6", dataLeAk9);
			android.util.Log.d("leak-12-6", dataLeAk12);
			android.util.Log.d("leak-15-6", dataLeAk15);
			dataLeAk8 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			return 2;
        }
        class ChildClassLevelTwo{
            String dataLeAk13 = "13";
			String dataLeAk10 = "10";
			String dataLeAk9 = "9";
			String dataLeAk6 = "6";
			int methodCTwoA(){
				dataLeAk12 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-6-7", dataLeAk6);
				android.util.Log.d("leak-9-7", dataLeAk9);
				android.util.Log.d("leak-10-7", dataLeAk10);
				android.util.Log.d("leak-13-7", dataLeAk13);
				android.util.Log.d("leak-6-7", dataLeAk6);
				android.util.Log.d("leak-8-7", dataLeAk8);
				android.util.Log.d("leak-11-7", dataLeAk11);
				android.util.Log.d("leak-14-7", dataLeAk14);
				android.util.Log.d("leak-4-7", dataLeAk4);
				android.util.Log.d("leak-5-7", dataLeAk5);
				android.util.Log.d("leak-7-7", dataLeAk7);
				android.util.Log.d("leak-9-7", dataLeAk9);
				android.util.Log.d("leak-12-7", dataLeAk12);
				android.util.Log.d("leak-15-7", dataLeAk15);
				dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return 1;
            }
            int methodCTwoB(){
				dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				android.util.Log.d("leak-6-8", dataLeAk6);
				android.util.Log.d("leak-9-8", dataLeAk9);
				android.util.Log.d("leak-10-8", dataLeAk10);
				android.util.Log.d("leak-13-8", dataLeAk13);
				android.util.Log.d("leak-6-8", dataLeAk6);
				android.util.Log.d("leak-8-8", dataLeAk8);
				android.util.Log.d("leak-11-8", dataLeAk11);
				android.util.Log.d("leak-14-8", dataLeAk14);
				android.util.Log.d("leak-4-8", dataLeAk4);
				android.util.Log.d("leak-5-8", dataLeAk5);
				android.util.Log.d("leak-7-8", dataLeAk7);
				android.util.Log.d("leak-9-8", dataLeAk9);
				android.util.Log.d("leak-12-8", dataLeAk12);
				android.util.Log.d("leak-15-8", dataLeAk15);
				dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return 2;
            }
        }
    }


} 
