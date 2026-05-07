package com.solution.applicationManagement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SendAppToBackground {

	@Test
	public void testToSendAppToBackground() throws MalformedURLException, URISyntaxException {
		
		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);
		
		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		
		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);
		
		// Retrieve the package name of the app currently in focus.
		String appPackage = ((AndroidDriver)driver).getCurrentPackage();
		
		// Send the app to the background for 5 seconds
		System.out.println("RUNNING APP IN BACKGROUND");
		((AndroidDriver)driver).runAppInBackground(Duration.ofSeconds(5));
		
		// Prints the state of the application. 
		System.out.println("Current App State: " +((AndroidDriver)driver).queryAppState(appPackage));
		
		// Quits the driver
		driver.quit();	
	}
}