package concepts.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {

    @Test
    public void testing() throws IOException {
        ExtentReports extentReport = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Testing Report");
        sparkReporter.config().setReportName("Sample Testing");

        ExtentTest extentTest = extentReport.createTest("First Node Test");
        extentTest.pass("This is first node pass case");

        ExtentTest extentTest1 = extentReport.createTest("Second Node Test");
        extentTest1.fail("This is second node fail case");

        extentReport.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }
}
