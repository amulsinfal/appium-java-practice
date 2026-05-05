package com.solution.mobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LongClickGesture {
	@Test
	public void testDragGestures() throws MalformedURLException, URISyntaxException, InterruptedException {
		
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
		Thread.sleep(3000);
		
		// Locating and clicking on the Drag and Drop menu
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		Thread.sleep(3000);
		
		// Locate the element using id to perform the long click gesture.
		WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		// Performing the long click gesture on the element.
		((JavascriptExecutor) driver).executeScript("mobile:dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", 800, "endY", 1200));
		
		System.out.println("Text of element: "
				+ driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText());
		Thread.sleep(5000);
		
		// Quits the driver.
		driver.quit();
	}
}