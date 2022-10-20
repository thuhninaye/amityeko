package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class CreatePopUp extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/chatSheet")
    private AndroidElement createChatBtn;


    public void clickCreateChatBtn()
    {
        createChatBtn.click();
    }

}
