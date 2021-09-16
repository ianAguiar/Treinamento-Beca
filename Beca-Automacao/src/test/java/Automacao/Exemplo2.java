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


public class Exemplo2 {
	WebDriver driver;
	WebDriverWait wait;

	
	public void wait(By element) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
	
	public void waitInv(By element) {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
	
	@BeforeClass
	public static void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
	}
	
	@Before
	public void before()
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
	}
	
	@Test
	public void test()
	{
		try {
			driver.get("https://the-internet.herokuapp.com/");
			
			wait(By.xpath("//a[text() = \"Add/Remove Elements\"]"));
			
			driver.findElement(By.xpath("//a[text() = \"Add/Remove Elements\"]")).click();
			
			wait(By.xpath("//button[@onclick = \"addElement()\"]"));
			
			driver.findElement(By.xpath("//button[@onclick = \\\"addElement()\\\"]")).click();
			
			wait(By.xpath("//button[text() = \"Delete\"]"));
			
			driver.findElement(By.xpath("//button[text() = \\\"Delete\\\"]")).click();
			
			waitInv(By.xpath("//button[text() = \\\"Delete\\\"]"));
			
			
			Thread.sleep(3000);
		} catch (Exception el) {
			el.printStackTrace();
		}
	}
	
	@After
	public void after()
	{
		driver.close();
	}
}
