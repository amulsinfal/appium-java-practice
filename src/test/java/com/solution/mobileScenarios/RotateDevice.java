package com.solution.mobileScenarios;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class RotateDevice {

	@Test
	public void testRotateDevice() throws MalformedURLException, URISyntaxException, InterruptedException {

		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);

		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();

		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);
		
		// Returns the current orientation of the phone
		ScreenOrientation orientation = ((AndroidDriver) driver).getOrientation();
		System.out.println("Current Orientation: " + orientation.value());
		Thread.sleep(5000);
		
		if (orientation.value().equals("portrait")) {
			// Sets orientation of the phone to landscape
			((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
			orientation = ((AndroidDriver) driver).getOrientation();
			System.out.println("Current Orientation: " + orientation.value());
		} else {
			// Sets orientation of the phone to portait
			((AndroidDriver) driver).rotate(ScreenOrientation.PORTRAIT);
			orientation = ((AndroidDriver) driver).getOrientation();
			System.out.println("Current Orientation: " + orientation.value());
		}
		
		// Quits the driver
		driver.quit();
	}

}
