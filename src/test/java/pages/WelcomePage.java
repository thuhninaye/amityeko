package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/landing_login_textview")
    private AndroidElement signInBtn;

    public void clickSignInBtn ()
    {
        signInBtn.click();
    }
}
