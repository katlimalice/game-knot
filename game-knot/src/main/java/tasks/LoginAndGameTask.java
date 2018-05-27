package tasks;

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

	public void doLogin() {
		this.loginAppObject.getLogInButton().click();
	}
	
	public void challengeJoao() {
		
	}
}


