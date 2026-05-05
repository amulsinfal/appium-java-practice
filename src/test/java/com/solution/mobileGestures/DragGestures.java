package com.solution.mobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DragGestures {
	@Test
	public void testDragGestures() throws MalformedURLException, URISyntaxException, InterruptedException {
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:app", apkPath);
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		AppiumDriver driver = new AndroidDriver(url, options);
		// Locating and clicking on the View menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(3000);
		// Locating and clicking on the Drag and Drop menu
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		Thread.sleep(3000);
		// Locate the element using id to perform drag.
		WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_3"));
		// Performing the drag n drop on the element.
		((JavascriptExecutor) driver).executeScript("mobile:dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", 800, "endY", 1200));
		// Retrieve text from the element.
		String actualText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(actualText, "Dropped!");
		System.out.println("Text of element: " + driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText());
		Thread.sleep(3000);
		driver.quit();
	}
}