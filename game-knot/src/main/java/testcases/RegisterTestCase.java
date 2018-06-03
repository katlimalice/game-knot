package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.RegisterTask;

public class RegisterTestCase {

	private WebDriver aliceWebDriver;
	private RegisterTask aliceRegister;

	private WebDriver joaoWebDriver;
	private RegisterTask joaoRegister;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.aliceWebDriver = new ChromeDriver();
		this.aliceWebDriver.get("https://gameknot.com/register.pl");
		this.aliceRegister = new RegisterTask(aliceWebDriver);

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/register.pl");
		this.joaoRegister = new RegisterTask(joaoWebDriver);
	}

	@Test
	public void testRegisterUsers(){
		
		this.aliceRegister.preencherCadastro("alices2b2", "a852963b", "a852963b", "1alices2b1@gmail.com");
		this.aliceRegister.criarConta();
		
		this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "1joaos2b1@gmail.com");
		this.joaoRegister.criarConta();
		
		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}
	
	@Test
	public void testRegisterDuplicatedUser() {
		this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "1joaos2b1@gmail.com");
		this.joaoRegister.criarConta();
		ScreenShot.capture(this.joaoWebDriver);
		
	}
	
	@Test
	public void testRegisterInvalidUser() {
		this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "kalim94@gmail.com");
		this.joaoRegister.criarConta();
		ScreenShot.capture(this.joaoWebDriver);
		
	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
