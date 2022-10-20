package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class RecentPage extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/action_create")
    private AndroidElement plusBtn;

    public By ekoIcon = By.id("com.ekoapp.staging:id/logo_image_view");

    public void clickPlusBtn()
    {
        plusBtn.click();
    }
}
