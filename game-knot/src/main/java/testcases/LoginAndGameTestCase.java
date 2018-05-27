package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.LoginAndGameTask;

public class LoginAndGameTestCase {

	private WebDriver aliceWebDriver;
	private LoginAndGameTask aliceLoginTask;

	private WebDriver joaoWebDriver;
	private LoginAndGameTask joaoLoginTask;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.aliceWebDriver = new ChromeDriver();
		this.aliceWebDriver.get("https://gameknot.com/");
		this.aliceLoginTask = new LoginAndGameTask(aliceWebDriver);

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/");
		this.joaoLoginTask = new LoginAndGameTask(joaoWebDriver);
	}

	@Test
	public void testMain() {

		this.aliceLoginTask.fillLogin("alices2b", "a852963b");
		this.aliceLoginTask.doLogin();

		this.joaoLoginTask.fillLogin("joaos2b", "a741852b");
		this.joaoLoginTask.doLogin();

	}
	
	@Test
	public void testChallengeJoao()
	{
		
	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
