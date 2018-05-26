package tasks;

import org.openqa.selenium.WebDriver;

import appobject.CadastroAppObject;

public class CadastroTask {

	private CadastroAppObject cadastroAppObject;

	public CadastroTask(WebDriver driver) {
		this.cadastroAppObject = new CadastroAppObject(driver);
	}

	public void preencherCadastro(String username, String password, String confirmPassword, String emailAddress,
			String confirmEmailAddress, String referredByPlayer) {
		this.cadastroAppObject.getUsernameTextField().sendKeys(username);
		this.cadastroAppObject.getPasswordTextField().sendKeys(password);
		this.cadastroAppObject.getConfirmPasswordTextField().sendKeys(confirmPassword);
		this.cadastroAppObject.getEmailAddressTextField().sendKeys(emailAddress);
		this.cadastroAppObject.getConfirmEmailAddressTextField().sendKeys(confirmEmailAddress);
		this.cadastroAppObject.getRefferedByPlayerTextField().sendKeys(referredByPlayer);

	}
	
	public void criarConta() {
		this.cadastroAppObject.getCreateAccountButton().click();
	}

}
