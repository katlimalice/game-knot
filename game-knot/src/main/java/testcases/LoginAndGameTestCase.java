package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.LoginAndGameTask;

@FixMethodOrder(MethodSorters.JVM)
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
		
		this.aliceLoginTask.fillLogin("alices2b", "a852963b");
		this.aliceLoginTask.doLogin();
		
		this.joaoLoginTask.fillLogin("joaos2b", "a741852b");
		this.joaoLoginTask.doLogin();
	}

	@Test
	public void testLoginAliceAndChallengeJoaoRandomColor() {
		this.aliceLoginTask.challengeGameAlice("joaos2b", "4 Days", "random color", "private");
		this.joaoLoginTask.joaoAceptChallengeAndPlay();
		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);	
	}

	@Test
	public void testLoginAliceAndChallengeJoaoWhiteColor() {
		this.aliceLoginTask.challengeGameAlice("joaos2b", "4 Days", "white", "private");

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/");
		this.joaoLoginTask = new LoginAndGameTask(joaoWebDriver);

		this.joaoLoginTask.fillLogin("joaos2b", "a741852b");
		this.joaoLoginTask.doLogin();
		this.joaoLoginTask.joaoAceptChallengeAndPlay();
	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
