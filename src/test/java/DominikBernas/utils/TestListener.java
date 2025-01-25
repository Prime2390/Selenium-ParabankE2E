package DominikBernas.utils;

import DominikBernas.basetest.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        BaseTest.test = BaseTest.extent.createTest(result.getMethod().getMethodName());
        BaseTest.test.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest.test.pass("Test passed: " + result.getMethod().getMethodName());
        String screenshotPath = ScreenshotUtil.takeScreenshot(BaseTest.driver, result.getMethod().getMethodName());
        if (screenshotPath != null) {
            BaseTest.test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Success");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.test.fail("Test failed: " + result.getMethod().getMethodName());
        BaseTest.test.fail(result.getThrowable());
        String screenshotPath = ScreenshotUtil.takeScreenshot(BaseTest.driver, result.getMethod().getMethodName());
        if (screenshotPath != null) {
            BaseTest.test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseTest.test.skip("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        BaseTest.test.info("Test suite finished: " + context.getName());
        BaseTest.extent.flush();
    }
}
