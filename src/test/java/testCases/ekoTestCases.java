package testCases;

import base.AppDriver;
import base.Common;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ekoTestCases
{
      static RecentPage recentPage;
      static CreatePopUp createPopUp;
      static CreatedGroupPage createdGroupPage;
      static NewChatPage newChatPage;
      static WebDriverWait wait;
      static Login login;

    @BeforeAll
    public static void setUp()
    {
        try
        {
            Common.Android_LaunchApp();
            wait = new WebDriverWait(AppDriver.getDriver(), 60);
            recentPage = new RecentPage();
            createPopUp = new CreatePopUp();
            createdGroupPage = new CreatedGroupPage();
            newChatPage = new NewChatPage();
            login = new Login();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void testCase_one() throws InterruptedException
    {
        //Account userName and password
        String userName = "thuhninaye2011";
        String password = "Abc1234@";

        //Login to the account
        login.loginAccount(userName, password);
        wait.until(ExpectedConditions.presenceOfElementLocated(recentPage.ekoIcon));
        //Press "+" icon in Recent Page
        recentPage.clickPlusBtn();
        //Select "Create a Chat" from pop up
        createPopUp.clickCreateChatBtn();
        //Select 'Group chat'
        newChatPage.clickGroupChatBtn();
        //Select Contact
        newChatPage.selectContact();
        //Click Next button
        newChatPage.clickNextBtn();
        //Enter Group name "Test group name"
        newChatPage.setGroupName("Test group Name");
        //Click Create button
        newChatPage.clickCreateBtn();
        //wait newly created group page
        wait.until(ExpectedConditions.presenceOfElementLocated(createdGroupPage.by_checkCreatedGroup));


        //Assert
        assertAll(
                () -> //Check Group Title Name
                        assertEquals("Test group Name",createdGroupPage.getGroupTitleName(),"The title of group is not 'Test group name'"),
                () -> //Check Display Even message
                      assertEquals("TODAY", createdGroupPage.getTodayTextName(), "Not showing even message TODAY."),
                () ->  //Check group created person name
                        assertEquals("thuhninaye2011 created chat", createdGroupPage.getGroupCreatedName(),"Group created person name is not showing."),
                () ->  //Check Total group members
                        assertEquals("2 members", createdGroupPage.getSubTitleName(), "Subtitle is not 2 members."),
                () -> //Check Call icon
                        assertTrue(createdGroupPage.checkCallIcon(),"Phone icon is not showing."),
                () -> //Check Topic icon
                        assertTrue(createdGroupPage.checkTopicIcon(),"Hamberger icon is not showing.")
        );
    }

    @Test
    @Order(2)
    public void testCase_two()
    {
        String result;
        String longInputMessage = "In total, the firm has over 5 million active users from almost 100 enterprise clients across Asia, Europe, and North America, according to a statement. It also claims to have achieved 200% consolidated year-over-year revenue growth and an increase of over 50% in revenues from February.";
        //Enter Long message
        createdGroupPage.enterLongMessage(longInputMessage);
        //Click Send button
        createdGroupPage.clickSendBtn();
        //Get the latest message
        result = Common.cutMessage(createdGroupPage.getLatestMessage());

        assertAll(
                () -> //Check the latest message
                        assertEquals(longInputMessage,result),
                () -> //Check Time is 12 hours format
                        assertTrue(Common.isValidTime(createdGroupPage.getTimeFromMessage()), "Time format is not 12 hours format."),
                () -> //Check Failed icon
                        assertFalse(createdGroupPage.element_failedIcon.size() > 0, "Failed icon is showing."),
                () ->//Check Message status
                        assertEquals("Sent", createdGroupPage.getMessageStatus())
        );
    }

    @Test
    @Order(3)
    public void testCase_three()
    {
        createdGroupPage.clickGalleryIcon();
        if(createdGroupPage.checkPermissionAllow())
        {
            createdGroupPage.clickPermissionAllowBtn();
            createdGroupPage.clickPhotosAllowBtn();
        }
        String output = "Permission denied message, " + "'" + createdGroupPage.getPermissionDeniedMsg() + "'" + "is showing even though Permission Allow button is clicked.";
        System.out.println(output);
        assertEquals("", output);
    }

    @AfterAll
    public static void tearDown()
    {
        Common.closeApp();
    }
}
