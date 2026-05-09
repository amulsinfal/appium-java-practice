package com.solution.mobileScenarios;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LockDevice {

	@Test
	public void testLockDeviceForDuration() throws MalformedURLException, URISyntaxException {
		
		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);
		
		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		
		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);

		// Locks the device
		((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
		System.out.println("Device locked for 5 seconds !!!");
		
		// Quits the driver
		driver.quit();
	}
}
