package testnglistener;

import TestCases.TestBases;
import org.example.pages.PageBases;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends TestBases implements ITestListener {

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println(result.getName()+" is success");
    }

    public void onTestFailure(ITestResult result) {
        PageBases.captureScreenshot(driver,"Fail: "+ result.getTestName());
        System.out.println("Because" +result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {

        System.out.println(result.getTestName()+" is skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

    }




