package base;

import io.appium.java_client.android.AndroidDriver;

import java.sql.Driver;

public class AppDriver {
   private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

   public static AndroidDriver getDriver()
   {
       return driver.get();
   }

   public static void setDriver (AndroidDriver Driver)
   {
       driver.set(Driver);
   }
}
