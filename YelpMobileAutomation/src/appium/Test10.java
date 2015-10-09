package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Test10 {
	
	WebDriver driver;
	private WebDriverWait wait;
	
	public ExpectedCondition<List<WebElement>> listVisibilityOfElementLocated(
			final By by) {
		return new ExpectedCondition<List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				List<WebElement> element = driver.findElements(by);
				return element;
			}
		};
	}


	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0.1"); 
		capabilities.setCapability("deviceName","LGD8515f5173cd");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.yelp.android");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.yelp.android.ui.activities.ActivityHome"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   wait = new WebDriverWait(driver, 10);
	}
	
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(by);
				return element.isDisplayed() ? element : null;
			}
		};
	}
	
	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}



}
