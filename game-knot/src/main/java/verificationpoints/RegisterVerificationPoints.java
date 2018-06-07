package verificationpoints;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterVerificationPoints {
	private WebDriver driver;

	public RegisterVerificationPoints(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkWelcomeMessage() throws Throwable {
		WebElement message;
		message = this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td/div/em"));
	

		if (message != null) {
			String welcome = message.getAttribute("innerHTML");

			if (welcome.toUpperCase().contains("ACCOUNT CREATED")) {
				System.out.println("Test passed");
			} else {
				System.out.println("Error!");
				Assert.fail();
			}
		}
	}
	
	public void checkInvalidUserMessage() throws Throwable {
		WebElement message;
		message = this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td/div/em"));
	

		if (message != null) {
			String invalid = message.getAttribute("innerHTML");

			if (invalid.toUpperCase().contains("ERROR")) {
				System.out.println("Test passed");
			} else {
				System.out.println("Error!");
				Assert.fail();
			}
		}
	}
}
