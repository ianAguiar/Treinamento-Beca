/*package stepsDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class DellSteps {
	
	public void wait(By element) {
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
	@Given("^I access page \"(.*?)\"$")
	public void acessarSite(String url){
		System.out.println(url);
		driver.get(url);
	}
	
	@And("^I click in \"(.*?)\"$")
	public void clickAddRemove(String menuName) {
		System.out.println(menuName);
		wait(By.xpath("//a[text()=\"" + menuName +"\"]"));
		driver.findElement(By.xpath("//a[text()=\"" + menuName +"\"]")).click();
	}
	
	@When("^I click in the button \"(.*?)\"$")
	public void clickAddElement(String addElemento) {
		System.out.println(addElemento);
		wait(By.xpath("//button[text()='Add Element'" + addElemento + "]"));
		driver.findElement(By.xpath("//button[text()='Add Element'" + addElemento + "]")).click();
	}
	
	@And("^I click in \"(.*?)\"$")
	public void clickDellElement(String dellElemento) {
		System.out.println(dellElemento);
		wait(By.xpath("//button[text()='Delete'" + dellElemento + "]"));
		driver.findElement(By.xpath("//button[text()='Delete'" + dellElemento + "]")).click();
	}
	
	@Then("^I hope the button is not shown \"(.*?)\"$")
	public void validaTitulo(String valida) {
		System.out.println(valida);
		wait(By.xpath("//button[text()='Delete'" + valida + "]"));
	}

}
*/
