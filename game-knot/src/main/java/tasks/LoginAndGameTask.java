package tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import appobject.GameAppObject;
import appobject.LoginAppObject;

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
		this.gameAppObject.getChallengeFromAliceButton().click();
		this.gameAppObject.getAcceptChallengeButton().click();

	}

	public void executeMove(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) this.gameAppObject.getDriver();
		executor.executeScript("arguments[0].click()", element);
	}

	public void executeMoveWhitePerspectiveF2toF3() {
		executeMove(this.gameAppObject.getBoardF2WhitePerspectiveDiv());
		executeMove(this.gameAppObject.getBoardF3WhitePerspectiveDiv());
		this.gameAppObject.getSubmitButton().click();

	}

	public void executeMoveBlackPerspectiveE7toE5() {
		executeMove(this.gameAppObject.getBoardE7BlackPerspectiveDiv());
		executeMove(this.gameAppObject.getBoardE5BlackPerspectiveDiv());
		this.gameAppObject.getSubmitButton().click();

	}

	public void executeMoveWhitePerspectiveG2toG4() {
		executeMove(this.gameAppObject.getBoardG2WhitePerspectiveDiv());
		executeMove(this.gameAppObject.getBoardG4WhitePerspectiveDiv());
		this.gameAppObject.getSubmitButton().click();
	}

	public void executeMoveBlackPerspectiveD8toH4() {
		executeMove(this.gameAppObject.getBoardD8BlackPerspectiveDiv());
		executeMove(this.gameAppObject.getBoardH4BlackPerspectiveDiv());
		this.gameAppObject.getSubmitButton().click();
	}

}
