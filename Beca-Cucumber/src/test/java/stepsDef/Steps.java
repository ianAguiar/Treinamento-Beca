package stepsDef;

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

public class Steps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^I access page \"(.*?)\"$")
	public void acessar(String url) {
		System.out.println(url);
		driver.get(url);
	}

	@When("^I click in \"(.*?)\"$")
	public void clickMenu(String menuName) {
		System.out.println(menuName);
		wait(By.xpath("//a[text()=\"" + menuName + "\"]"));
		driver.findElement(By.xpath("//a[text()=\"" + menuName + "\"]")).click();
	}

	@Then("^I see the title \"(.*?)\"$")
	public void validaTitulo(String titulo) {
		System.out.println(titulo);
		wait(By.xpath("//h3[text()=\"" + titulo + "\"]"));
	}

	public void wait(By element) {
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}


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

	@Given("^I access the page \"(.*?)\"$")
	public void acessarSite(String url) {
		System.out.println(url);
		driver.get(url);
	}

	@And("^I click in the \"(.*?)\"$")
	public void click(String menuName) {
		System.out.println(menuName);
		wait(By.xpath("//a[text()=\"" + menuName + "\"]"));
		driver.findElement(By.xpath("//a[text()=\"" + menuName + "\"]")).click();
	}

	@When("^I click the button \"(.*?)\"$")
	public void clickAddElement(String addElemento) {
		System.out.println(addElemento);
		wait(By.xpath("//button[text()='" + addElemento + "']"));
		driver.findElement(By.xpath("//button[text()='" + addElemento + "']")).click();
	}

	@And("^I click \"(.*?)\"$")
	public void clickDellElement(String dellElemento) {
		System.out.println(dellElemento);
		wait(By.xpath("//button[text()='" + dellElemento + "']"));
		driver.findElement(By.xpath("//button[text()='" + dellElemento + "']")).click();
	}

	@Then("^I hope the button is not shown \"(.*?)\"$")
	public void validaCampo(String valida) {
		System.out.println(valida);
		wait(By.xpath("//button[text()='" + valida + "']"));
	}
}
