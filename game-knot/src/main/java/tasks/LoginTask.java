package tasks;

import org.openqa.selenium.WebDriver;

import appobject.LoginAppObject;

public class LoginTask {
	private LoginAppObject loginAppObject;

	public LoginTask(WebDriver driver) {
		this.loginAppObject = new LoginAppObject(driver);
	}

	public void preencherLogin(String username, String password) {
		this.loginAppObject.getLoginTextField().sendKeys(username);
		this.loginAppObject.getSenhaTextField().sendKeys(password);
		this.loginAppObject.getKeepLoggedCheckBox().click();
	}

	public void entrar() {
		this.loginAppObject.getLogInButton().click();
	}

}


