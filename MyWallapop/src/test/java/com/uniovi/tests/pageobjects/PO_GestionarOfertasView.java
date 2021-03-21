package com.uniovi.tests.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_GestionarOfertasView extends PO_NavView {

	static public void fillAddOfferForm(WebDriver driver, String userp, String titlep, String detailsp,
			String amountp) {
		WebElement user = driver.findElement(By.name("user"));
		user.click();
//		user.clear();
//		user.sendKeys(userp);
		WebElement title = driver.findElement(By.name("title"));
		title.click();
		title.clear();
		title.sendKeys(titlep);
		WebElement details = driver.findElement(By.name("details"));
		details.click();
		details.clear();
		details.sendKeys(detailsp);
		WebElement amount = driver.findElement(By.name("amount"));
		amount.click();
		amount.clear();
		amount.sendKeys(amountp);

		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

	/**
	 * @param password
	 * @param email
	 * @param menuLink
	 * 
	 */
	public static void accesoGestionOfertas(WebDriver driver, String email, String password, String menuLink) {
		PO_PrivateView.login(driver, email, password, "Esta es la parte privada de la web");

		String text = "offers-menu";
		String busqueda = "//li[contains(@id,'" + text + "')]/a";

		// Pinchamos en la opción de menu de Gestionar Usuarios:
		List<WebElement> listaMenuGestUsu = PO_View.checkElement(driver, "free", busqueda);
		listaMenuGestUsu.get(0).click();
		// Esperamos a aparezca la opción de ver usuarios
		listaMenuGestUsu = PO_View.checkElement(driver, "free", "//a[contains(@href, '" + menuLink + "')]");
		// Pinchamos en Ver Usuarios
		listaMenuGestUsu.get(0).click();
	}

	/**
	 * @param expectedSize
	 */
	public static int checkNumberOfOffersOnList(WebDriver driver, Integer expectedSize) {

//		Boolean notExistsTrOnTbody = (new WebDriverWait(driver, PO_View.getTimeout()))
//				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody/tr")));
//		if (!notExistsTrOnTbody) {
			// Contamos el número de filas de notas
			List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
					PO_View.getTimeout());

			if (expectedSize != null) {
				assertTrue(elementos.size() == expectedSize);
			}

			return elementos.size();
//		}
//		return 0;

	}

}
