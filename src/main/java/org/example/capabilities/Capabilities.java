package org.example.capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Capabilities {

    public static AndroidDriver<AndroidElement> baseCapabilities(String appNAme) throws IOException {
        // TODO Access properties file to read general properties
        FileInputStream readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/generalProperties.properties");
        Properties prop = new Properties();
        prop.load(readProperty);

        // TODO set capabilities to connect and run apk
        File appDir = new File("src");
        File app = new File(appDir, prop.getProperty(appNAme));

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));

      //  desiredCapabilities.setCapability("appPackage", "com.facebook.katana");

      //  desiredCapabilities.setCapability("appActivity",".LoginActivity");

        desiredCapabilities.setCapability("appPackage", "com.whatsapp"); //com.whatsapp.w4b //com.facebook.katana

        desiredCapabilities.setCapability("appActivity","com.whatsapp.Main"); //.HomeActivity //.LoginActivity



        // desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

     //   desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
      //  desiredCapabilities.setCapability("chromedriverExecutable","C:\\Drivers\\chromedriver.exe");


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

//		desiredCapabilities.setCapability("noReset", true);
//		desiredCapabilities.setCapability("fullReset", false);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("DeviceURL")),
                desiredCapabilities);

//		driver.resetApp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
