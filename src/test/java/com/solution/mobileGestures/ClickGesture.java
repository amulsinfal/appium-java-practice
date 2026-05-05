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

public class ClickGesture {

	@Test
	public void testClickGesture() throws MalformedURLException, URISyntaxException, InterruptedException {
		// Set the capabilities
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		String apkPath = System.getProperty("user.dir") + "//src//test//resources//ApiDemos-debug.apk";
		uiOptions.setCapability("appium:app", apkPath);
		// Server Address
		URL url = new URI("http://0.0.0.0:4723/").toURL();
		// Create Appium driver session
		AppiumDriver driver = new AndroidDriver(url, uiOptions);
		// Locate the "Views" element
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));
		//Executes the native click gesture
		driver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)element).getId()));
		System.out.println("Text of element: " + element.getText());
		Thread.sleep(2000);
		driver.quit();
	}
}
