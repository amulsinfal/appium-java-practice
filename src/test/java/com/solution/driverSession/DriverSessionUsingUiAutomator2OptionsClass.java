package com.solution.driverSession;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSessionUsingUiAutomator2OptionsClass {
	
	@Test
	public void testToGetDriverSessionId() throws MalformedURLException, URISyntaxException {
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:app", apkPath);
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		AppiumDriver driver = new AppiumDriver(url, options);
		System.out.println("Current session id: " + driver.getSessionId());
		
	}

}
