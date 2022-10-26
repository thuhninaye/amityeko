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
    private List<AndroidElement> allMessageTxt;

    @AndroidFindAll({
            @AndroidBy(id = "com.ekoapp.staging:id/time")
    })
    private List<AndroidElement> timeTxt;

    @AndroidFindAll ({
            @AndroidBy(id = "com.ekoapp.staging:id/failed_icon")
    })
    public List<AndroidElement> element_failedIcon;

    @AndroidFindBy (id = "com.ekoapp.staging:id/status_text")
    private AndroidElement messageStatus;

    @AndroidFindBy(id="com.ekoapp.staging:id/sticker_icon")
    private AndroidElement stickerIcon;

    @AndroidFindAll({
            @AndroidBy(id = "com.ekoapp.staging:id/view_sticker_item_image")
    })
    private List<AndroidElement> stickers;

    @AndroidFindAll({
            @AndroidBy(id="com.ekoapp.staging:id/sticker")
    })
    private List<AndroidElement> charAreaSticker;

    public By by_checkCreatedGroup = By.xpath("//android.widget.TextView[@text ='2 members']");
    public By by_checkMessage = By.id("com.ekoapp.staging:id/message");
    public By by_stickerInChat = By.id("com.ekoapp.staging:id/sticker");


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

    public void clickStickerIcon (){
        stickerIcon.click();
    }

    public void clickSticker (int index)
    {
        stickers.get(index).click();
    }

    public int getChatAreaStickerNum ()
    {
        return charAreaSticker.size();
    }

    public Boolean checkLatestSticker()
    {
        return charAreaSticker.get(charAreaSticker.size()-1).isDisplayed();
    }

}
