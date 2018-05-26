package appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAppObject {
	private WebDriver driver;

	public LoginAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginTextField() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"queen-pic\"]/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td/div/form/table/tbody/tr[1]/td[2]/input"));

	}

	public WebElement getSenhaTextField() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"queen-pic\"]/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td/div/form/table/tbody/tr[2]/td[2]/input"));
	}

	public WebElement getKeepLoggedCheckBox() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"queen-pic\"]/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td/div/form/table/tbody/tr[3]/td/input"));
	}

	public WebElement getLogInButton() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"queen-pic\"]/table/tbody/tr/td[1]/div/table[1]/tbody/tr/td/div/form/table/tbody/tr[4]/td/input[5]"));
	}

}
