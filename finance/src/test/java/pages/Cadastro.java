package pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import dtvm.UtilsDiasUteis;

public class Cadastro {
	static WebDriver driver;

	public Cadastro(WebDriver driver) {
		this.driver = driver;
	}

	public void preenchercampos() {

		WebElement login = driver.findElement(By.id("login"));
		login.sendKeys("login");
		// grau_jefbarbosa
		WebElement senha = driver.findElement(By.id("senha"));
		senha.sendKeys("1234");

		WebElement acessar = driver.findElement(By.id("Login1_LoginButton"));
		acessar.click();

		wait(30);
		WebElement relatorios = driver.findElement(By.id("relatorio"));
		relatorios.click();

		wait(10);

		WebElement carteira = driver.findElement(By.id("carteira"));
		carteira.click();

		wait(5);

		WebElement cotas = driver.findElement(By.id("cotas"));
		cotas.click();

		driver.switchTo().frame("iframePrincipal");
		

		
		List<String> list = new ArrayList<String>();
		list.add("976");
		list.add("888888888");
		list.add("5001271");
		list.add("500127");
		list.add("888888889");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

			System.out.println("logando na carteira: " + list.get(i));

			wait(20);
			WebElement carteira1 = driver.findElement(By.id("btnEditCodigo_I"));
			carteira1.sendKeys(list.get(i));
			carteira1.sendKeys(Keys.ENTER);

			WebElement datai = driver.findElement(By.id("textDataInicio_I"));
			datai.click();
			datai.sendKeys(Keys.CONTROL + "a");
			datai.sendKeys(Keys.DELETE);
			datai.sendKeys(AddSubDate(-60));

			System.out.println("**********************************");
			System.out.println();

			WebElement dataf = driver.findElement(By.id("textDataFim_I"));
			dataf.click();

			WebElement pdf = driver.findElement(By.id("btnPDF"));
			pdf.click();

		}
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String AddSubDate(int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);
		String result = sdf.format(cal.getTime());
		return result;
	}

}