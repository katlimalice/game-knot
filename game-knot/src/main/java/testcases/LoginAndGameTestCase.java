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
	private LoginAndGameTask aliceLoginTask;

	private WebDriver joaoWebDriver;
	private LoginAndGameTask joaoLoginTask;

	private GameVerificationPoints aliceVerificationPoint;
	private GameVerificationPoints joaoVerificationPoint;

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

		this.aliceVerificationPoint = new GameVerificationPoints(aliceWebDriver);
		this.joaoVerificationPoint = new GameVerificationPoints(joaoWebDriver);

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
		this.joaoLoginTask.joaoAceptChallengeAndPlay();
		this.aliceLoginTask.executeMoveWhitePerspectiveF2toF3();
		this.joaoLoginTask.executeMoveBlackPerspectiveE7toE5();
		this.aliceLoginTask.executeMoveWhitePerspectiveG2toG4();
		this.joaoLoginTask.executeMoveBlackPerspectiveD8toH4();

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
		this.aliceLoginTask.challengeGameAlice("joaos2b", "4 Days", "black", "private");
		this.joaoLoginTask.joaoAceptChallengeAndPlay();
		this.joaoLoginTask.executeMoveWhitePerspectiveF2toF3();
		this.aliceLoginTask.executeMoveBlackPerspectiveE7toE5();
		this.joaoLoginTask.executeMoveWhitePerspectiveG2toG4();
		this.aliceLoginTask.executeMoveBlackPerspectiveD8toH4();

		try {
			aliceVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);

	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
	}

}
