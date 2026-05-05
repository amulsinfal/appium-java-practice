package com.solution.applicationManagement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CurrentPackage {
	
	@Test
	public void testToGetCurrentPackage() throws MalformedURLException, URISyntaxException {
		
		// Path to the Android application (.apk)
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		
		// Initialize UiAutomator2Options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:app", apkPath);
		
		// The Appium Server URL where the Appium Server is running
		URL url = new URI("http://0.0.0.0:4723").toURL();
		
		// Initialize the AppiumDriver with the server URL and options
		AppiumDriver driver = new AndroidDriver(url, options);
		
		// Retrieves current package
		String currentPackage = ((AndroidDriver)driver).getCurrentPackage();
		System.out.println("Current Package name: " + currentPackage);
		
		// Quits the driver
		driver.quit();
	}

}
