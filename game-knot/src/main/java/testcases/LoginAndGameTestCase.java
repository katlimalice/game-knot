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
import verificationpoints.GameVerificationPoints;

@FixMethodOrder(MethodSorters.JVM)
public class LoginAndGameTestCase {

	private WebDriver aliceWebDriver;
	private LoginAndGameTask aliceLoginAndGameTask;

	private WebDriver joaoWebDriver;
	private LoginAndGameTask joaoLoginAndGameTask;

	private GameVerificationPoints aliceVerificationPoint;
	private GameVerificationPoints joaoVerificationPoint;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.aliceWebDriver = new ChromeDriver();
		this.aliceWebDriver.get("https://gameknot.com/");
		this.aliceLoginAndGameTask = new LoginAndGameTask(aliceWebDriver);

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/");
		this.joaoLoginAndGameTask = new LoginAndGameTask(joaoWebDriver);

		this.aliceLoginAndGameTask.fillLogin("alices2b2", "a852963b");
		this.aliceLoginAndGameTask.doLogin();

		this.joaoLoginAndGameTask.fillLogin("joaos2b2", "a741852b");
		this.joaoLoginAndGameTask.doLogin();

		this.aliceVerificationPoint = new GameVerificationPoints(aliceWebDriver);
		this.joaoVerificationPoint = new GameVerificationPoints(joaoWebDriver);

	}

	@Test
	public void testLoginAliceAndChallengeJoaoRandomColor() {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 Days", "random color", "private");
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}

	@Test
	public void testLoginAliceAndChallengeJoaoWhiteColor() {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 Days", "white", "private");
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
		this.aliceLoginAndGameTask.executeMoveWhitePerspectiveF2toF3();
		this.joaoLoginAndGameTask.executeMoveBlackPerspectiveE7toE5();
		this.aliceLoginAndGameTask.executeMoveWhitePerspectiveG2toG4();
		this.joaoLoginAndGameTask.executeMoveBlackPerspectiveD8toH4();

		try {
			joaoVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);

	}

	@Test
	public void testLoginAliceAndChallengeJoaoBlackColor() {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 Days", "black", "private");
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveF2toF3();
		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveE7toE5();
		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveG2toG4();
		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveD8toH4();

		try {
			aliceVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);

	}
	
	@Test
	public void testInvalidLogin() {
		this.joaoLoginAndGameTask.fillLogin("joaos2b2", "b741852c");
		this.joaoLoginAndGameTask.doLogin();
		ScreenShot.capture(this.joaoWebDriver);
		
	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
