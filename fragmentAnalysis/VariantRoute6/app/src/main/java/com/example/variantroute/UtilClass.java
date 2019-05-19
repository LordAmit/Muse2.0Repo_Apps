package com.example.variantroute;

public class UtilClass {

    private static final UtilClass utilClass = new UtilClass();
    private FrequencyManager frequencyManager;
    private UtilClass(){
        frequencyManager = new FrequencyManager();
    }
    public static UtilClass getInstance() {
        return utilClass;
    }
    public String getValue(){
        return frequencyManager.getFrequency();
    }
}
