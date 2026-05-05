package com.solution.driverSession;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;

public class DriverSessionUsingDesiredCapabilities {

	@Test
	public void testToGetDriverSessionId() throws MalformedURLException, URISyntaxException {
		
		// Path to the Android application (.apk)		
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		
		// Initialize DesiredCapabilities to define the test environment
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// Set the capabilities
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:deviceName", "medium_phone");
		cap.setCapability("appium:udid", "emulator-5554");
		cap.setCapability("appium:app", apkPath);
		
		//  The Appium Server URL where the Appium Server is running
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		
		// Initialize the AppiumDriver with the server URL and capabilities
		AppiumDriver driver = new AppiumDriver(url, cap);
		
		// Prints the unique Session ID to verify the connection was successful
		System.out.println("Session Id: " + driver.getSessionId());
		
		// Quits the driver
		driver.quit();
	}
}