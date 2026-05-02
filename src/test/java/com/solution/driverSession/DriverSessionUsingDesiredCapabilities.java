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
	public void testToGetDriverSessionId() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:deviceName", "medium_phone");
		cap.setCapability("appium:udid", "emulator-5554");
		cap.setCapability("appium:app", apkPath);
		
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		
		AppiumDriver driver = new AppiumDriver(url, cap);
		System.out.println("Session Id: " + driver.getSessionId());

	}
}
