package appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GameAppObject {

	private WebDriver driver;

	public WebDriver getDriver() {
		return this.driver;
	}

	public GameAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getStartNewGameButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table[1]/tbody/tr/td[1]/div/a[3]"));
	}

	public WebElement getPlayerUserNameTextField() {
		return this.driver.findElement(By.xpath("//*[@id=\"player_userid\"]"));
	}

	public WebElement getChallengeButton() {
		return this.driver.findElement(
				By.xpath("//*[@id=\"gk_wrap\"]/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td[3]/input[1]"));
	}

	public Select getTimePerMoveComboBox() {
		return new Select(this.driver.findElement(By.xpath("//*[@id=\"ftc-0\"]/td[2]/select")));
	}

	public Select getPlayAsColorComboBox() {
		return new Select(this.driver.findElement(By.xpath(
				"//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[10]/td[2]/select")));
	}

	public Select getGameTypeComboBox() {
		return new Select(this.driver.findElement(By.xpath(
				"//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[11]/td[2]/select")));
	}

	public WebElement getStartGameButton() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[13]/td/input[1]"));
	}

	public WebElement getMyGamesInProgressButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table[1]/tbody/tr/td[1]/div/a[2]"));
	}

	public WebElement getChallengeFromAliceButton() {
		return this.driver
				.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table[1]/tbody/tr[4]/td[1]/a"));
	}

	public WebElement getAcceptChallengeButton() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"question-form\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/form/input[3]"));
	}

	public WebElement getBoardF2WhitePerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[42]"));
	}

	public WebElement getBoardF3WhitePerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[43]"));
	}

	public WebElement getBoardE7BlackPerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[39]"));
	}

	public WebElement getBoardE5BlackPerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[37]"));
	}

	public WebElement getBoardG2WhitePerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[50]"));
	}

	public WebElement getBoardG4WhitePerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[52]"));
	}

	public WebElement getBoardD8BlackPerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[32]"));
	}

	public WebElement getBoardH4BlackPerspectiveDiv() {
		return this.driver.findElement(By.xpath("//*[@id=\"game-board-acboard\"]/div[60]"));
	}

	public WebElement getSubmitButton() {
		return this.driver.findElement(
				By.xpath("//*[@id=\"submit-move-form\"]/table/tbody/tr/td/div/form/table/tbody/tr[2]/td/input[1]"));
	}

}
