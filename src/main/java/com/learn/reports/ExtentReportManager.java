package com.learn.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class ExtentReportManager {
    private static ExtentReports extentReports;
    public static ExtentTest extentTest;
    private ExtentReportManager(){

    }
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return  extentTestThreadLocal.get();
    }

    public static void setExtentTest(ExtentTest extentTest){
        extentTestThreadLocal.set(extentTest);
    }

    public static void unload(){
        extentTestThreadLocal.remove();
    }


}
