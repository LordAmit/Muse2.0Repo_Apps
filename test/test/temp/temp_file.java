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
		return 1;
    }
    int methodB(){
		dataLeAk5 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
		return 2;
    }
    class ChildClassLevelOne{
		String dataLeAk14 = "14";
		String dataLeAk11 = "11";
		String dataLeAk8 = "8";
		String dataLeAk6 = "6";
		int methodConeA(){
			dataLeAk7 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			dataLeAk6 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
			return 1;
        }
        int methodCOneB(){
			dataLeAk9 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
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
				dataLeAk11 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk10 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return 1;
            }
            int methodCTwoB(){
				dataLeAk15 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk14 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				dataLeAk13 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
				return 2;
            }
        }
    }


} 
