package com.orange.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Orange_TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public Orange_TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+
					"\\src\\main\\java\\com\\orange\\qa\\properties\\Orange_config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Initialization() {

		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Setup\\chromedriver_win32 (1)\\ChromeDriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Selenium\\Setup\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
}
