package com.solution.mobileScenarios;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class NotificationHandling {

	@Test
	public void testNotification() throws MalformedURLException, URISyntaxException {
		
		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);

		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();

		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);	
		
		// opens the notifications
		((AndroidDriver)driver).openNotifications();
		
		List<WebElement> elements = driver.findElements(AppiumBy.id("android:id/title"));
		System.out.println("Total notification titles: " + elements.size());
		
		for(WebElement element : elements) {
			System.out.println("Notification Title: " +  element.getText());
		}
		
		// Quits the driver
		driver.quit();
	}
	
}
