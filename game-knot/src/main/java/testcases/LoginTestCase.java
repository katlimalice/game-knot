package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.LoginTask;

public class LoginTestCase {

	private WebDriver driver;
	private LoginTask login;

	private WebDriver driver2;
	private LoginTask login2;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.driver = new ChromeDriver();
		this.driver.get("https://gameknot.com/");
		this.login = new LoginTask(driver);

		this.driver2 = new ChromeDriver();
		this.driver2.get("https://gameknot.com/");
		this.login2 = new LoginTask(driver2);
	}

	@Test
	public void testMain() {

		this.login.preencherLogin("katlim", "ab123456");
		this.login.entrar();

		this.login2.preencherLogin("joao", "ba456789");
		this.login2.entrar();

	}

	@After
	public void tearDown() {
		this.driver.quit();
		this.driver2.quit();
	}

}
