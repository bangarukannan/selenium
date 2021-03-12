package com.learn.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    private static ExtentReports extentReport;
    private static ExtentSparkReporter sparkReporter;

    public static void initReport(){
        if(Objects.isNull(extentReport)) {
            extentReport = new ExtentReports();
            sparkReporter = new ExtentSparkReporter("reports.html");
            extentReport.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Login Testing");
        }
    }

    public static void flushReport() throws IOException {
        if(Objects.nonNull(extentReport))
            extentReport.flush();
        Desktop.getDesktop().browse(new File("reports.html").toURI());
    }

    public static void createTest(String testCaseName){
        ExtentReportManager.setExtentTest(extentReport.createTest(testCaseName));

    }
}
