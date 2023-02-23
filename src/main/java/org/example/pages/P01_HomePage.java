package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class P01_HomePage {

    public P01_HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
    public WebElement droplist;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[3]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public WebElement loginbutton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]/android.widget.TextView")
    public WebElement popemail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    public WebElement redloginbutton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")
    public WebElement thebag;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Go Shopping button\"]/android.widget.TextView")
    public WebElement GoShopping;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    public WebElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    public WebElement password;















}