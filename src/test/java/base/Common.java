package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
     static AndroidDriver<MobileElement> androidDriver;
     static DesiredCapabilities cap;


     public static void Android_LaunchApp() throws MalformedURLException {
         cap = new DesiredCapabilities();
         cap.setCapability(MobileCapabilityType.UDID,"dcf04cd4");
         cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
         cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
         cap.setCapability("appPackage", "com.ekoapp.staging");
         cap.setCapability("appActivity", "com.ekoapp.eko.EkoHome");
         //cap.setCapability("appActivity","com.ekoapp.eko.EkoHome");
         cap.setCapability("automationName","UiAutomator2");

         URL url = new URL("http://localhost:4723/wd/hub");
         androidDriver = new AndroidDriver<>(url, cap);
         AppDriver.setDriver(androidDriver);
         //wait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));
     }

    public static void closeApp()
    {
        androidDriver.quit();
    }

    // Function to validate the time in 12-hour format.
    public static boolean isValidTime(String time)
    {
        // Regex to check valid time in 12-hour format.
        String regexPattern
                = "(1[012]|[1-9]):"
                + "[0-5][0-9](\\s)"
                + "?(?i)(am|pm)";

        // Compile the ReGex
        Pattern compiledPattern
                = Pattern.compile(regexPattern);

        // If the time is empty
        // return false
        if (time == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given time
        // and regular expression.
        Matcher m = compiledPattern.matcher(time);

        // Return if the time
        // matched the ReGex
        return m.matches();
    }

    //To cut the message from the backward as it is including time
    public static String cutMessage(String message)
    {
       if(message.charAt(13) == ' ')
        {
            message = message.substring(0,message.length()-13);
        }
       else
       {
           message = message.substring(0,message.length()-14);
       }
       return message.trim();
    }

}
