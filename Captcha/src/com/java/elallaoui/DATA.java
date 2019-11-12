package com.java.elallaoui;

import java.util.Hashtable;

public class DATA {

    public static Hashtable<String, Double> CaptchaData = new Hashtable<>();

    static {

        CaptchaData.put("2+(1-2)",1.0);
        CaptchaData.put("9+(3-2)",10.0);
        CaptchaData.put("1/2",0.5);
        CaptchaData.put("17*2+3",37.0);
        CaptchaData.put("(5+5)*2",20.0);

    }
}
