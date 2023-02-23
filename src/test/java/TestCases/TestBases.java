package TestCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.example.capabilities.Capabilities;
import org.example.pages.P01_HomePage;
import org.example.pages.PageBases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBases extends Capabilities {
    public static AndroidDriver<AndroidElement> driver;
     P01_HomePage homePage;
    // extend report
    protected static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/FacebookReport.html");
    protected static ExtentTest test = report.startTest("Facebook App");

    @BeforeTest
    public void setupDriver() throws IOException {
        // TODO start application with appium
        driver = baseCapabilities("AppName");
        //TC001_checkLogin();



    }


    public void TC001_checkLogin() {
        homePage = new P01_HomePage(driver);

        // TODO: Step 1: click to drop list in home page
        homePage.droplist.click();
        // TODO: Step 2: click to login in home page
        homePage.loginbutton.click();
        //wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // TODO: Step 3: enter the email and password in login
      //  homePage.popemail.click();
        homePage.username.sendKeys(PageBases.getExcelData(1 , 0 , "Sheet1"));
        String passwword=PageBases.getExcelData(1 , 1 , "Sheet1").substring(0,8);
        System.out.println(passwword);
        homePage.password.sendKeys(passwword);

        // take screen shot


        PageBases.captureScreenshot(driver,"before Login");
        //wait
       // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // TODO: Step 4: click login button
        homePage.redloginbutton.click();
//        //wait
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // take screen shot
        PageBases.captureScreenshot(driver,"After Login");

        //Assert if login successfully
        Assert.assertEquals(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")).getText(),"Products");

    }




    @AfterMethod
    public void getresult(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE)
            test.log(LogStatus.FAIL,result.getName()+" test fail with folowing error "+result.getThrowable());
        else if(result.getStatus() == ITestResult.SUCCESS)
            test.log(LogStatus.PASS,result.getName());

    }

        @AfterClass
    public void TearDown() throws InterruptedException {
        // flush extent report
        report.endTest(test); //end report
        report.flush(); // open the report

        driver.quit();

    }




}
