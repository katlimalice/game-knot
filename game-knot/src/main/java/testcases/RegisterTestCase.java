package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.RegisterTask;
import verificationpoints.RegisterVerificationPoints;

@FixMethodOrder(MethodSorters.JVM)
public class RegisterTestCase {

	private WebDriver aliceWebDriver;
	private RegisterTask aliceRegister;

	private WebDriver joaoWebDriver;
	private RegisterTask joaoRegister;

	private RegisterVerificationPoints joaoRegisterVerificationPoints;
	private RegisterVerificationPoints aliceRegisterVerificationPoints;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.aliceWebDriver = new ChromeDriver();
		this.aliceWebDriver.get("https://gameknot.com/register.pl");
		this.aliceRegister = new RegisterTask(aliceWebDriver);

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/register.pl");
		this.joaoRegister = new RegisterTask(joaoWebDriver);

		this.joaoRegisterVerificationPoints = new RegisterVerificationPoints(joaoWebDriver);
		this.aliceRegisterVerificationPoints = new RegisterVerificationPoints(aliceWebDriver);
	}

	@Test
	public void testRegisterUsers() {
		try {
			this.aliceRegister.preencherCadastro("alices2b2", "a852963b", "a852963b", "1alices2b1@gmail.com");
			this.aliceRegister.criarConta();

			this.aliceRegisterVerificationPoints.checkWelcomeMessage();

			this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "1joaos2b1@gmail.com");
			this.joaoRegister.criarConta();

			this.joaoRegisterVerificationPoints.checkWelcomeMessage();

			ScreenShot.capture(this.aliceWebDriver);
			ScreenShot.capture(this.joaoWebDriver);
		} catch (Throwable e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	public void testRegisterDuplicatedUser() {
		this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "1joaos2b1@gmail.com");
		this.joaoRegister.criarConta();

		try {
			this.joaoRegisterVerificationPoints.checkInvalidUserMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.joaoWebDriver);

	}

	@Test
	public void testRegisterInvalidUser() {
		this.joaoRegister.preencherCadastro("joaos2b2", "a741852b", "a741852b", "kalim94@gmail.com");
		this.joaoRegister.criarConta();

		try {
			this.joaoRegisterVerificationPoints.checkInvalidUserMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.joaoWebDriver);

	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
