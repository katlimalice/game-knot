package testsuites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testcases.LoginAndGameTestCase;
import testcases.RegisterTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	RegisterTestCase.class,
	LoginAndGameTestCase.class
})
public class RegressionGameknotTestSuite {

	@BeforeClass
	public static void init() {
		System.out.println("Iniciando execução...");
	}
	
	@AfterClass
	public static void end() {
		System.out.println("Finalizando...");
	}
}