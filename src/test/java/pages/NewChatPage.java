package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class NewChatPage extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/view_user_picker_header_text_view")
    private AndroidElement groupChatBtn;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='thuhnin2010']")
    private AndroidElement contactA;

    @AndroidFindBy (id = "com.ekoapp.staging:id/group_chat_next_button")
    private AndroidElement nextBtn;

    @AndroidFindBy (id = "com.ekoapp.staging:id/chat_name")
    private AndroidElement chatNameTxt;

    @AndroidFindBy (id = "com.ekoapp.staging:id/toolbar_action")
    private AndroidElement createBtn;


    public void setGroupName(String groupName)
    {
        chatNameTxt.setValue(groupName);
    }
    public void clickGroupChatBtn()
    {
        groupChatBtn.click();
    }

    public void selectContact()
    {
        contactA.click();
    }

    public void clickNextBtn()
    {
        nextBtn.click();
    }

    public void clickCreateBtn()
    {
        createBtn.click();
    }


}
