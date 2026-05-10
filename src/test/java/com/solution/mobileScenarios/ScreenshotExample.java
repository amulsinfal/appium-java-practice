package com.solution.mobileScenarios;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScreenshotExample {

	@Test
	public void testToTakeScreenshot() throws URISyntaxException, InterruptedException, IOException {
		
		// Initialize UiAutomator2Options
		UiAutomator2Options uiOptions = new UiAutomator2Options();
		
		// Set the capabilities
		uiOptions.setCapability("appium:appPackage", "io.appium.android.apis");
		uiOptions.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		
		// The Appium Server URL where the Appium Server is running
		URL url = new URI("http://0.0.0.0:4723").toURL();
		
		// Initialize the AppiumDriver with the server URL and options
		AppiumDriver driver = new AppiumDriver(url, uiOptions);
		System.out.println("Taking Screenshot.");
		
		// Take the screenshot and saving it to the temporary location
		File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// The destination path to save screenshot
		File dest = new File(System.getProperty("user.dir") + "//screenshots//Screenshot.png");
		
		// Copying the file from the temporary location to the final destination folder
		FileHandler.copy(temp, dest);
		System.out.println("Screenshot captured!!!");
		
		// Quits the driver
		driver.quit();
	}
}