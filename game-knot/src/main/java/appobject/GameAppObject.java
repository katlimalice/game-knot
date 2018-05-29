package appobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameAppObject {

	private WebDriver driver;

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

	public WebElement getTimePerMoveComboBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"ftc-0\"]/td[2]/select"));
	}

	public WebElement getPlayAsColorComboBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[10]/td[2]/select"));
	}
	
	public WebElement getGameTypeComboBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[11]/td[2]/select"));
	}

	public WebElement getStartGameButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/form/table/tbody/tr[13]/td/input[1]"));
	}
	
	public WebElement getMyGamesInProgressButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table[1]/tbody/tr/td[1]/div/a[2]"));
	}

	public WebElement getChallengeFromAliceButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gk_wrap\"]/table/tbody/tr/td[1]/table[1]/tbody/tr[6]/td[1]/a"));
	}

	public WebElement getAcceptChallengeButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"question-form\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/form/input[3]"));
	}
	
}
