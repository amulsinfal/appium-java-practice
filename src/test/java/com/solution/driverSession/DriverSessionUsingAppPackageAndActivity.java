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
	public void openApplication() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		uiOptions.setCapability("appium:appPackage", "io.appium.android.apis");
		uiOptions.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

		URL url = new URI("http://0.0.0.0:4723").toURL();

		AppiumDriver driver = new AppiumDriver(url, uiOptions);
		System.out.println("Session id is " + driver.getSessionId());
	}

}
