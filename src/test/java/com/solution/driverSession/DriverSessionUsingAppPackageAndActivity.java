package com.solution.driverSession;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSessionUsingAppPackageAndActivity {

	@Test
	public void testToGetDriverSessionId() throws MalformedURLException, URISyntaxException {
		
		// Initialize UiAutomator2Options
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		
		// Set the capabilities
		uiOptions.setCapability("appium:appPackage", "io.appium.android.apis");
		uiOptions.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

		//  The Appium Server URL where the Appium Server is running
		URL url = new URI("http://0.0.0.0:4723").toURL();

		// Initialize the AppiumDriver with the server URL and options
		AppiumDriver driver = new AppiumDriver(url, uiOptions);
		
		// Prints the unique Session ID to verify the connection was successful
		System.out.println("Session id is " + driver.getSessionId());
		
		// Quits the driver
		driver.quit();
	}
}