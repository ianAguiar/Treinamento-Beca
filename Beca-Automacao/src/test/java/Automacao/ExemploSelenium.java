package Automacao;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExemploSelenium {

	WebDriver driver;
	WebDriverWait wait;
	
	public void wait(By element) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
	}

	@Before
	public void before() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
	}

	@Test
	public void test() {
		try {
			driver.get("https://the-internet.herokuapp.com/");
			wait(By.xpath("//a[(text()=\"A/B Testing\"]"));
			driver.findElement(By.xpath("//a[(text()=\"A/B Testing\"]")).click();
			wait(By.xpath("//h3[text() = \"A/B Test Variation 1\"]"));
			
			
			Thread.sleep(3000);
		} catch (Exception el) {
			el.printStackTrace();
		}

	}

	@After
	public void after() {
		driver.close();
	}

}
