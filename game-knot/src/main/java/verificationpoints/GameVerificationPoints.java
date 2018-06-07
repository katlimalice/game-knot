package verificationpoints;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameVerificationPoints {

	private WebDriver driver;

	public GameVerificationPoints(WebDriver driver) {
		this.driver = driver;
	}

	public void checkCheckMateMessage() {
		WebElement message;
		
		WebElement victoryMessage;
		message = this.driver.findElement(By.xpath("//*[@id=\"game-board-check_status\"]/em"));
		victoryMessage = this.driver.findElement(By.xpath("//*[@id=\"chess-game-title\"]/div[2]"));

		if (message != null) {
			String mate = message.getAttribute("innerHTML");
			String win = victoryMessage.getAttribute("innerHTML");

			if (mate.toUpperCase().contains("CHECKMATE")) {
				if (win.toUpperCase().contains("BLACK")) {
					System.out.println("Black Wins");
				} else if (win.toUpperCase().contains("WHITE")) {
					System.out.println("White Wins");
				}
			} else {
				System.out.println("Error!");
				Assert.fail();
			}
		}
	}

	public void checkConfirmMoves(int totMovesPlayed) {
		WebElement moves;

		moves = this.driver.findElement(By.xpath("//*[@id=\"game-board-moves\"]"));

		if (moves != null) {
			String firstMove = moves.getAttribute("innerHTML");
			String secondMove = moves.getAttribute("innerHTML");
			String thirdMove = moves.getAttribute("innerHTML");
			String fourthMove = moves.getAttribute("innerHTML");

			if (totMovesPlayed >= 1) {
				if (firstMove.toUpperCase().contains("F3")) {
					System.out.println("Test passed for the first move!");
				} else {
					System.out.println("Test failed for the first move!");
					Assert.fail();
				}
			}

			if (totMovesPlayed >= 2) {
				if (secondMove.toUpperCase().contains("E5")) {
					System.out.println("Test passed for the second move!");

				} else {
					System.out.println("Test failed for the second move!");
					Assert.fail();
				}
			}

			if (totMovesPlayed >= 3) {
				if (thirdMove.toUpperCase().contains("G4")) {
					System.out.println("Test passed for the third move!");
				} else {
					System.out.println("Test failed for the third move!");
					Assert.fail();
				}
			}

			if (totMovesPlayed >= 4) {
				if (fourthMove.toUpperCase().contains("H4")) {
					System.out.println("Test passed for the fourth move!");
				} else {
					System.out.println("Test failed for the fourth move!");
					Assert.fail();
				}
			}
		} else {
			System.out.println("Error!");
			Assert.fail();
		}
	}
}
