package DominikBernas.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {
                String reportPath = System.getProperty("user.dir") + "/src/test/resources/ExtentReport.html";
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
                sparkReporter.config().setReportName("Test Automation Report");
                sparkReporter.config().setDocumentTitle("Test Results");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }
            return extent;
        }
    }


