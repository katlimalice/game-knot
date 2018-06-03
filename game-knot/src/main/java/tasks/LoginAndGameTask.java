package tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;

import appobject.GameAppObject;
import appobject.LoginAppObject;
//import framework.ScreenShot;

public class LoginAndGameTask {
	private LoginAppObject loginAppObject;
	private GameAppObject gameAppObject;

	public LoginAndGameTask(WebDriver driver) {
		this.loginAppObject = new LoginAppObject(driver);
		this.gameAppObject = new GameAppObject(driver);

	}

	public void fillLogin(String username, String password) {
		this.loginAppObject.getLoginTextField().sendKeys(username);
		this.loginAppObject.getSenhaTextField().sendKeys(password);
		this.loginAppObject.getKeepLoggedCheckBox().click();
	}

	public void doLogin() {
		this.loginAppObject.getLogInButton().click();
	}

	public void challengeGameAlice(String username, String timeDays, String color, String gameType) {
		this.gameAppObject.getStartNewGameButton().click();
		this.gameAppObject.getPlayerUserNameTextField().sendKeys(username);
		this.gameAppObject.getChallengeButton().click();
		this.gameAppObject.getTimePerMoveComboBox().selectByVisibleText(timeDays);
		this.gameAppObject.getPlayAsColorComboBox().selectByVisibleText(color);
		this.gameAppObject.getGameTypeComboBox().selectByVisibleText(gameType);
		this.gameAppObject.getStartGameButton().click();

	}

	public void joaoAceptChallengeAndPlay() {
		this.gameAppObject.getMyGamesInProgressButton().click();
		this.gameAppObject.getChallengeGoToNextGameButton().click();
		this.gameAppObject.getAcceptChallengeButton().click();

	}
	
	public void gotoGamePage() throws Throwable {
		this.gameAppObject.getChallengeGoToNextGameButton().click();
		TimeUnit.SECONDS.sleep(5);
	}

	
	public void executeMove(WebDriver driver, String from, String to)
	{
		String j  = "document.getElementsByName('fr')[0].value = '" + from + "'; ";
		       j += "document.getElementsByName('to')[0].value = '" + to + "'; ";
		       j += "document.getElementsByName('sm')[0].disabled = false; ";
		       j += "pre_submit_move(); ";
		       j += "document.getElementsByName('submitmove')[0].submit()";
		       
		JavascriptExecutor executor = (JavascriptExecutor) this.gameAppObject.getDriver();
		executor.executeScript(j);		       
	}

	public void executeMoveWhitePerspectiveF2toF3(WebDriver driver) {
		executeMove(driver, "f2", "f3");
	}

	public void executeMoveBlackPerspectiveE7toE5(WebDriver driver) {
		executeMove(driver, "e7", "e5");
	}

	public void executeMoveWhitePerspectiveG2toG4(WebDriver driver) {
		executeMove(driver, "g2", "g4");
	}

	public void executeMoveBlackPerspectiveD8toH4(WebDriver driver) {
		executeMove(driver, "d8", "h4");
	}

	public void gotoGameListPage(WebDriver driver, String player) throws Throwable
	{
		driver.get("http://gameknot.com/play-chess.pl?iu=" + player);
	}
}
