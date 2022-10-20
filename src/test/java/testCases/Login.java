package testCases;

import base.AppDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.WelcomePage;

import java.time.Duration;

public class Login
{
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private WebDriverWait wait;

    public Login ()
    {
        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        //wait = new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(60));
    }

    public void loginAccount (String userName, String password) throws InterruptedException {
        welcomePage.clickSignInBtn();
        //wait.until(ExpectedConditions.presenceOfElementLocated())
        Thread.sleep(50);
        loginPage.addUserName(userName);
        loginPage.addPassword(password);

        loginPage.clickLoginBtn();
    }
}
