package verificationpoints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginVerificationPoints {

	private WebDriver driver;

	public LoginVerificationPoints(WebDriver driver) {
		this.driver = driver;

	}

	public void checkInvalidUserMessage() {
		WebElement message;
		message = this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table[1]/tbody/tr/td/div/em"));

		if (message != null) {
			String invalid = message.getAttribute("innerHTML");

			if (invalid.toUpperCase().contains("USERNAME AND PASSWORD MISMATCH")) {

				System.out.println("Test passed");

			} else {

				System.out.println("Error!");
			}
		}
	}

	public void checkWelcomeMessage() {
		WebElement message;
		message = this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table[1]/tbody/tr/td[1]/div"));

		if (message != null) {

			String welcome = message.getAttribute("innerHTML");

			if (welcome.toUpperCase().contains("WELCOME")) {

				System.out.println("Test passed");

			} else {

				System.out.println("Error!");
			}
		}
	}
}
