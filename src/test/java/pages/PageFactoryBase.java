package pages;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageFactoryBase {

    public PageFactoryBase()
    {
        org.openqa.selenium.support.PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()),this);
    }
}
