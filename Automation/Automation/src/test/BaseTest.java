package test;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataprovider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Suite.class)
@SuiteClasses({CreateUserTest.class, GetAllUserTest.class, DeleteUsersTest.class,UIElementsTest.class})

public class BaseTest {
	
	static WebDriver driver;
	public static WebDriverWait wait;
	public static final String testDataFileName = "testdata.xlsx";

	public static WebDriver getDriver() {
		return driver;
	}

	static ConfigFileReader objconfigreader = new ConfigFileReader();
	public static String URL = objconfigreader.getPropertyValue("url");
	public static String file = objconfigreader.getPropertyValue("file");
	public static String base_url = objconfigreader.getPropertyValue("base_url");

	@BeforeClass
	public static void setup() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
