package tasks;

import org.openqa.selenium.WebDriver;

import appobject.CadastroAppObject;

public class CadastroTask {

	private CadastroAppObject cadastroAppObject;

	public CadastroTask(WebDriver driver) {
		this.cadastroAppObject = new CadastroAppObject(driver);
	}

	public void preencherCadastro(String username, String password, String confirmPassword, String emailAddress) {
		this.cadastroAppObject.getUsernameTextField().sendKeys(username);
		this.cadastroAppObject.getPasswordTextField().sendKeys(password);
		this.cadastroAppObject.getConfirmPasswordTextField().sendKeys(confirmPassword);
		this.cadastroAppObject.getEmailAddressTextField().sendKeys(emailAddress);

	}
	
	public void criarConta() {
		this.cadastroAppObject.getCreateAccountButton().click();
	}

}
