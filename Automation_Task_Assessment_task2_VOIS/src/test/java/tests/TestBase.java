package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class TestBase {
	public static WebDriver driver;
	HomePage homepage;

	@BeforeClass
	public void beforeEachTestCase() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		homepage = new HomePage(driver);
		// - Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
		// Dimension(1024, 768)
		homepage.openURL("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().setSize(new Dimension(1024, 768));
		System.out.println("- browser resolution = " + driver.manage().window().getSize());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void clearEnvironment() {
		driver.quit();
	}

}
