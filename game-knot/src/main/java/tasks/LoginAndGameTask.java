package tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import appobject.GameAppObject;
import appobject.LoginAppObject;

public class LoginAndGameTask {
	private LoginAppObject loginAppObject;
	private GameAppObject gameAppObject;

	public LoginAndGameTask(WebDriver driver) {
		this.loginAppObject = new LoginAppObject(driver);
	}

	public void fillLogin(String username, String password) {
		this.loginAppObject.getLoginTextField().sendKeys(username);
		this.loginAppObject.getSenhaTextField().sendKeys(password);
		this.loginAppObject.getKeepLoggedCheckBox().click();
	}

	public void challengeGameAlice(String username, String timeDays, String color, String gameType) {
		this.gameAppObject.getStartNewGameButton().click();
		this.gameAppObject.getPlayerUserNameTextField().sendKeys(username);
		this.gameAppObject.getChallengeButton().click();
		this.gameAppObject.getTimePerMoveComboBox().sendKeys(Keys.ARROW_DOWN);
		this.gameAppObject.getTimePerMoveComboBox().sendKeys(Keys.ENTER);
		this.gameAppObject.getPlayAsColorComboBox().sendKeys(Keys.ARROW_DOWN);
		this.gameAppObject.getPlayAsColorComboBox().sendKeys(Keys.ENTER);
		this.gameAppObject.getGameTypeComboBox().sendKeys(Keys.ARROW_DOWN);
		this.gameAppObject.getGameTypeComboBox().sendKeys(Keys.ENTER);
		this.gameAppObject.getStartGameButton().click();
		

	}

	public void joaoAceptChallengeAndPlay() {
		this.gameAppObject.getMyGamesInProgressButton().click();
		this.gameAppObject.getChallengeFromAliceButton().click();
		this.gameAppObject.getAcceptChallengeButton().click();

	}

	public void doLogin() {
		this.loginAppObject.getLogInButton().click();
	}

	public void challengeJoao() {

	}
}
