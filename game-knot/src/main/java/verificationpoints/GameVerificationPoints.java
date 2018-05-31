package verificationpoints;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameVerificationPoints {
	
private WebDriver driver;
	
	public GameVerificationPoints (WebDriver driver) {
		this.driver = driver;
		
	}

	public void checkCheckMateMessage() throws Throwable {
		WebElement message;
		message = this.driver.findElement(By.xpath("//*[@id=\"game-board-check_status\"]/em"));
			
		if(message != null && message.getAttribute("innerHTML").contains("CHECKMATE")) {
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Black Wins");
		} else {
			System.out.println("White Wins");
		}

	}

}
