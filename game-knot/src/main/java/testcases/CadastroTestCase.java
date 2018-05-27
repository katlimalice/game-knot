package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.CadastroTask;

public class CadastroTestCase {

	private WebDriver driver;
	private CadastroTask cadastro;

	private WebDriver driver2;
	private CadastroTask cadastro2;

	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		this.driver = new ChromeDriver();
		this.driver.get("https://gameknot.com/register.pl");
		this.cadastro = new CadastroTask(driver);

		this.driver2 = new ChromeDriver();
		this.driver2.get("https://gameknot.com/register.pl");
		this.cadastro2 = new CadastroTask(driver2);
	}

	@Test
	public void testMain(){
		
		this.cadastro.preencherCadastro("alices2b", "a852963b", "a852963b", "s2balice@gmail.com");
		this.cadastro.criarConta();
		
		this.cadastro2.preencherCadastro("joaos2b", "a741852b", "a741852b", "s2bjoao@gmail.com");
		this.cadastro2.criarConta();
		
	}

	@After
	public void tearDown() {
		this.driver.quit();
		this.driver2.quit();
	}

}
