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

public class SwipeGesture {

	@Test
	public void testSwipeGesture() throws MalformedURLException, URISyntaxException, InterruptedException {
		
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
		
		// Locating and clicking on the Gallery menu
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		Thread.sleep(3000);
		
		// Locating and clicking on the photo menu
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		Thread.sleep(3000);
		
		// Locating the element using id to perform the Swipe gesture.
		WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
		
		// Performs left swipe gesture
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
				"direction", "left", "percent", 1.0));
		Thread.sleep(3000);

		// Performs right swipe gesture
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
				"direction", "right", "percent", 1.0));
		
		// Quits the driver
		driver.quit();
	}
}
