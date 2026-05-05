package com.solution.mobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScrollGesture {

	@Test
	public void testScrollGesture() throws MalformedURLException, URISyntaxException, InterruptedException {

		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);

		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();

		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);

		// Locating and clicking on the View menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(5000);

		// Locating the element using id to perform the scroll  gesture.
		WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
		driver.executeScript("mobile:scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
				"direction", "down", "percent", 1.0));
		
		Thread.sleep(5000);
		
		// Quits the driver.
		driver.quit();

	}
}
