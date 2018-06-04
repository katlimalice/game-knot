package verificationpoints;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameVerificationPoints {

	private WebDriver driver;

	public GameVerificationPoints(WebDriver driver) {
		this.driver = driver;
	}

	public void checkCheckMateMessage() throws Throwable {
		WebElement message;
		WebElement victoryMessage;
		message = this.driver.findElement(By.xpath("//*[@id=\"game-board-check_status\"]/em"));
		victoryMessage = this.driver.findElement(By.xpath("//*[@id=\"chess-game-title\"]/div[2]"));

		if (message != null) {
			String mate = message.getAttribute("innerHTML");
			String win = victoryMessage.getAttribute("innerHTML");

			if (mate.toUpperCase().contains("CHECKMATE")) {
				if (win.toUpperCase().contains("BLACK")) {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Black Wins");
				} else if (win.toUpperCase().contains("WHITE")) {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("White Wins");
				}
			} else {
				System.out.println("Error!");
			}
		}
	}
}
