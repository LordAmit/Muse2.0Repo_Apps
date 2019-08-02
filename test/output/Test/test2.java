package com.example.amit.helloworld.test;

public class TestClass {

	String dataLeAk3 = "3";
	String dataLeAk1 = "1";
	String dataLeAk0 = "0";
	int methodA(){
		dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-0", dataLeAk0);
		android.util.Log.d("leak-1-0", dataLeAk1);
		android.util.Log.d("leak-3-0", dataLeAk3);
		return 1;
    }
    int methodB(){
		dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		android.util.Log.d("leak-0-1", dataLeAk0);
		android.util.Log.d("leak-1-1", dataLeAk1);
		android.util.Log.d("leak-3-1", dataLeAk3);
		return 2;
    }
    public class ChildClassLevelOne{
		String dataLeAk2 = "2";

		int methodConeA(){
			dataLeAk3 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk2 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			return 1;
        }

    }


} 
