package testcases;

import java.util.concurrent.TimeUnit;

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

	private String joaoUserName = "joaos2b2";
	private String aliceUserName = "alices2b2";
	
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

		this.aliceLoginAndGameTask.fillLogin(this.aliceUserName, "a852963b");
		this.aliceLoginAndGameTask.doLogin();

		this.joaoLoginAndGameTask.fillLogin(this.joaoUserName, "a741852b");
		this.joaoLoginAndGameTask.doLogin();

		this.aliceVerificationPoint = new GameVerificationPoints(aliceWebDriver);
		this.joaoVerificationPoint = new GameVerificationPoints(joaoWebDriver);

	}

	//@Test
	public void testLoginAliceAndChallengeJoaoRandomColor() {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "random color", "private");
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}

	@Test
	public void testLoginAliceAndChallengeJoaoWhiteColor() throws Throwable {

			this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "white", "private");
			this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
			this.aliceLoginAndGameTask.gotoGamePage();
			
			this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
			this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
			this.joaoLoginAndGameTask.gotoGamePage();
			
			this.aliceLoginAndGameTask.executeMoveWhitePerspectiveF2toF3(this.aliceWebDriver);
			this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
			this.aliceLoginAndGameTask.gotoGamePage();
			
			this.joaoLoginAndGameTask.executeMoveBlackPerspectiveE7toE5(this.joaoWebDriver);
			this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
			this.joaoLoginAndGameTask.gotoGamePage();
			
			this.aliceLoginAndGameTask.executeMoveWhitePerspectiveG2toG4(this.aliceWebDriver);
			this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
			this.aliceLoginAndGameTask.gotoGamePage();
			
			this.joaoLoginAndGameTask.executeMoveBlackPerspectiveD8toH4(this.joaoWebDriver);

		try {
			joaoVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);
	}

	@Test
	public void testLoginAliceAndChallengeJoaoBlackColor() throws Throwable {
		this.aliceLoginAndGameTask.challengeGameAlice("joaos2b2", "4 days", "black", "private");
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();
		
		this.joaoLoginAndGameTask.joaoAceptChallengeAndPlay();
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();
			
		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveF2toF3(joaoWebDriver);
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();
	
		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveE7toE5(aliceWebDriver);
		this.aliceLoginAndGameTask.gotoGameListPage(this.aliceWebDriver, this.aliceUserName);
		this.aliceLoginAndGameTask.gotoGamePage();
		
		this.joaoLoginAndGameTask.executeMoveWhitePerspectiveG2toG4(joaoWebDriver);
		this.joaoLoginAndGameTask.gotoGameListPage(this.joaoWebDriver, this.joaoUserName);
		this.joaoLoginAndGameTask.gotoGamePage();
		
		this.aliceLoginAndGameTask.executeMoveBlackPerspectiveD8toH4(aliceWebDriver);

		try {
			aliceVerificationPoint.checkCheckMateMessage();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ScreenShot.capture(this.aliceWebDriver);
		ScreenShot.capture(this.joaoWebDriver);

	}
	
	//@Test 
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
