package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindByAllSet;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;

import java.util.List;


public class CreatedGroupPage extends PageFactoryBase
{
    @AndroidFindBy (id = "com.ekoapp.staging:id/toolbar_title_textview")
    private AndroidElement groupTitleName;

    @AndroidFindBy (id = "com.ekoapp.staging:id/toolbar_sub_title_textview")
    private AndroidElement subTitleName;

    @AndroidFindBy (id = "com.ekoapp.staging:id/event_text")
    private AndroidElement createdNameTxt;

    @AndroidFindBy(id = "com.ekoapp.staging:id/view_chat_room_recycler_view")
    private AndroidElement todayTxt;

    @AndroidFindBy (id = "com.ekoapp.staging:id/callGroup")
    private AndroidElement callIconBtn;

    @AndroidFindBy (id = "com.ekoapp.staging:id/action_topic_list")
    private AndroidElement topicIconBtn;

    @AndroidFindBy(id="com.ekoapp.staging:id/messageEditText")
    private AndroidElement messageTxtBox;

    @AndroidFindBy(id="com.ekoapp.staging:id/send_text")
    private AndroidElement sendBtn;

    @AndroidFindAll({
            @AndroidBy(id = "com.ekoapp.staging:id/message")
    })
    private static List<AndroidElement> allMessageTxt;

    @AndroidFindAll({
            @AndroidBy(id = "com.ekoapp.staging:id/time")
    })
    private static List<AndroidElement> timeTxt;

    @AndroidFindAll ({
            @AndroidBy(id = "com.ekoapp.staging:id/failed_icon")
    })
    public static List<AndroidElement> element_failedIcon;

    @AndroidFindBy (id = "com.ekoapp.staging:id/status_text")
    private AndroidElement messageStatus;

    @AndroidFindBy (id = "com.ekoapp.staging:id/image_icon")
    private AndroidElement galleryIcon;

    @AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement foregroundAllowBtn;

    @AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement photosAllowBtn;

    @AndroidFindBy (id = "com.ekoapp.staging:id/snackbar_text")
    private AndroidElement permissionDeniedMsg;

    public By by_checkCreatedGroup = By.xpath("//android.widget.TextView[@text ='2 members']");


    public String getGroupTitleName()
    {
        return groupTitleName.getText();
    }

    public String getSubTitleName()
    {
        return subTitleName.getText();
    }

    public String getGroupCreatedName()
    {
        return createdNameTxt.getText();
    }

    public String getTodayTextName()
    {
       return todayTxt.getText();
    }

    public Boolean checkCallIcon()
    {
        return callIconBtn.isDisplayed();
    }

    public Boolean checkTopicIcon()
    {
        return topicIconBtn.isDisplayed();
    }

    public void enterLongMessage (String message)
    {
        messageTxtBox.setValue(message);
    }

    public void clickSendBtn()
    {
        sendBtn.click();
    }

    public String getLatestMessage()
    {
        return allMessageTxt.get(allMessageTxt.size() - 1).getText();
    }

    public String getTimeFromMessage()
    {
        return timeTxt.get(timeTxt.size() - 1).getText();
    }

    public String getMessageStatus()
    {
        return messageStatus.getText();
    }

    public void clickGalleryIcon()
    {
        galleryIcon.click();
    }

    public Boolean checkPermissionAllow()
    {
        return foregroundAllowBtn.isDisplayed();
    }

    public void clickPermissionAllowBtn()
    {
        foregroundAllowBtn.click();
    }

    public void clickPhotosAllowBtn()
    {
        photosAllowBtn.click();
    }

    public String getPermissionDeniedMsg()
    {
        return permissionDeniedMsg.getText();
    }

}
