package com.solution.mobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LocatorStrategies {

	@Test
	public void testLocatorStrategies() throws MalformedURLException, URISyntaxException, InterruptedException {
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:app", apkPath);
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		AppiumDriver driver = new AndroidDriver(url, options);
		
		// locator1: AccessibilityID
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
		System.out.println("Text of element: " + element.getText());
		element.click();
		Thread.sleep(5000);
		// back
		driver.navigate().back();
		
		// Locator2: xpath
		element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"));
		System.out.println("Text of element: " + element.getText());
		element.click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		// Locator3: androidUIAutomator
		element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")"));
		System.out.println("Text of element: " + element.getText());
		element.click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		
		// Locator4: ClassName
		element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(5);
		System.out.println("Text of element: " + element.getText());
		element.click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		// Locator4: resource-id(id)
		element = driver.findElements(AppiumBy.id("android:id/text1")).get(11);
		System.out.println("Text of element: " + element.getText());
		element.click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		driver.quit();
	}

}
