package appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAppObject {
	private WebDriver driver;

	public RegisterAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernameTextField() {
		return this.driver.findElement(By.xpath("//*[@id=\"f-uid\"]"));
	}

	public WebElement getPasswordTextField() {
		return this.driver.findElement(By.xpath("//*[@id=\"f-psw\"]"));
	}

	public WebElement getConfirmPasswordTextField() {
		return this.driver.findElement(By.xpath("//*[@id=\"f-psw2\"]"));
	}

	public WebElement getEmailAddressTextField() {
		return this.driver.findElement(By.xpath("//*[@id=\"f-email\"]"));
	}

	public WebElement getCreateAccountButton() {
		return this.driver.findElement(
				By.xpath("//*[@id=\"queen-pic\"]/table/tbody/tr/td/div/form/table/tbody/tr[6]/td/input[1]"));
	}

}
