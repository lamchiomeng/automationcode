import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import java.net.MalformedURLException;
import java.net.URL;
public class Page_SplashScreen {
	//***** Define capabilities variable ***********
	static AndroidDriver <MobileElement> driverApp;
	static AppiumDriver <MobileElement> driverApp1;
	static DesiredCapabilities dc = new DesiredCapabilities();	
	public static void clickStartNow(DesiredCapabilities dc, AndroidDriver<MobileElement> driverApp) throws MalformedURLException {
		System.out.println("Running Page_SplashScreen");
		driverApp.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driverApp.findElement(By.xpath("//*[@text = 'START NOW']")).click();
		}//end try
		catch(Exception e) {
			driverApp.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open\"]")).click();
			driverApp.findElement(By.xpath("//android.widget.ImageView[@content-desc='My Wallet']")).click();
			driverApp.findElement(By.xpath("//*[@text = 'LOGOUT']")).click();
		}//end catch
	} //end clickStartNow method
}//end public class Page_SplashScreen




