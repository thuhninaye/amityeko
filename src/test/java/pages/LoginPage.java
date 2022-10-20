package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/login_username_edittext")
    private AndroidElement userNameTxt;

    @AndroidFindBy (id = "com.ekoapp.staging:id/login_password_edittext")
    private AndroidElement passwordTxt;

    @AndroidFindBy (id = "com.ekoapp.staging:id/button")
    private AndroidElement loginBtn;

    public void addUserName (String userName)
    {
        userNameTxt.setValue(userName);
    }

    public void addPassword (String password)
    {
        passwordTxt.setValue(password);
    }

    public void clickLoginBtn ()
    {
        loginBtn.click();
    }
}
