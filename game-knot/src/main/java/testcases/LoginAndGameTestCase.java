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
import verificationpoints.LoginVerificationPoints;

@FixMethodOrder(MethodSorters.JVM)
public class LoginAndGameTestCase {

	private String joaoUserName = "joaos2b2";
	private String aliceUserName = "alices2b2";

	private WebDriver aliceWebDriver;
	private LoginAndGameTask aliceLoginAndGameTask;

	private WebDriver joaoWebDriver;
	private LoginAndGameTask joaoLoginAndGameTask;

	private WebDriver invalidUserWebDriver;
	private LoginAndGameTask invalidUserLoginAndGameTask;

	private GameVerificationPoints aliceGameVerificationPoint;
	private GameVerificationPoints joaoGameVerificationPoint;

	private LoginVerificationPoints invalidUserLoginVerificationPoint;
	private LoginVerificationPoints aliceLoginVerificationPoint;
	private LoginVerificationPoints joaoLoginVerificationPoint;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.aliceWebDriver = new ChromeDriver();
		this.aliceWebDriver.get("https://gameknot.com/");
		this.aliceLoginAndGameTask = new LoginAndGameTask(aliceWebDriver);

		this.joaoWebDriver = new ChromeDriver();
		this.joaoWebDriver.get("https://gameknot.com/");
		this.joaoLoginAndGameTask = new LoginAndGameTask(joaoWebDriver);

		this.invalidUserWebDriver = new ChromeDriver();
		this.invalidUserWebDriver.get("https://gameknot.com/");
		this.invalidUserLoginAndGameTask = new LoginAndGameTask(invalidUserWebDriver);

		this.aliceGameVerificationPoint = new GameVerificationPoints(aliceWebDriver);
		this.joaoGameVerificationPoint = new GameVerificationPoints(joaoWebDriver);

		this.invalidUserLoginVerificationPoint = new LoginVerificationPoints(invalidUserWebDriver);
		this.aliceLoginVerificationPoint = new LoginVerificationPoints(aliceWebDriver);
		this.joaoLoginVerificationPoint = new LoginVerificationPoints(joaoWebDriver);

		this.aliceLoginAndGameTask.fillLogin(this.aliceUserName, "a852963b");
		this.aliceLoginAndGameTask.doLogin();

		try {
			aliceLoginVerificationPoint.checkWelcomeMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.joaoLoginAndGameTask.fillLogin(this.joaoUserName, "a741852b");
		this.joaoLoginAndGameTask.doLogin();

		try {
			joaoLoginVerificationPoint.checkWelcomeMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void testLoginAliceAndChallengeJoaoRandomColor() {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "random color", "private");
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}

	@Test
	public void testLoginAlicePlayWithWhiteColorAndChallengeJoao() throws Throwable {

		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "white", "private");
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();

		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();

		this.aliceLoginAndGameTask.executeMoveWhitePerspectiveF2toF3(this.aliceWebDriver);
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();

		try {
			aliceGameVerificationPoint.checkConfirmMoves(1);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.joaoLoginAndGameTask.executeMoveBlackPerspectiveE7toE5(this.joaoWebDriver);
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();

		try {
			joaoGameVerificationPoint.checkConfirmMoves(2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.aliceLoginAndGameTask.executeMoveWhitePerspectiveG2toG4(this.aliceWebDriver);
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();

		try {
			aliceGameVerificationPoint.checkConfirmMoves(3);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.joaoLoginAndGameTask.executeMoveBlackPerspectiveD8toH4(this.joaoWebDriver);

		try {
			joaoGameVerificationPoint.checkConfirmMoves(4);
			joaoGameVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}

	@Test
	public void testLoginAlicePlayWithBlackColorAndChallengeJoao() throws Throwable {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "black", "private");
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();

		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();

		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveF2toF3(joaoWebDriver);
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();

		try {
			joaoGameVerificationPoint.checkConfirmMoves(1);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveE7toE5(aliceWebDriver);
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();

		try {
			aliceGameVerificationPoint.checkConfirmMoves(2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveG2toG4(joaoWebDriver);
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();

		try {
			joaoGameVerificationPoint.checkConfirmMoves(3);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveD8toH4(aliceWebDriver);

		try {
			aliceGameVerificationPoint.checkConfirmMoves(4);
			aliceGameVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);

	}

	@Test
	public void testInvalidLogin() {
		this.invalidUserLoginAndGameTask.fillLogin("joaos2b2", "b741852c");
		this.invalidUserLoginAndGameTask.doLogin();

		try {
			this.invalidUserLoginVerificationPoint.checkInvalidUserMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.invalidUserWebDriver);
	}

	@After
	public void tearDown() {
		this.aliceWebDriver.quit();
		this.joaoWebDriver.quit();
		this.invalidUserWebDriver.quit();
	}

}
