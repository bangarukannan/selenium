package com.learn.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){

    }

    private static final String CHROMEDIRVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
    private static final String CONFIGPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static String getChromedirverpath(){
        return CHROMEDIRVERPATH;
    }

    public static String getConfigpath(){
        return CONFIGPATH;
    }
}
