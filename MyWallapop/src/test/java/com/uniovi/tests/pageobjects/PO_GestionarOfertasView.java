package com.uniovi.tests.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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


	public static int checkNumberOfOffersOnList(WebDriver driver, Integer expectedSize) {
//		Boolean notExistsTrOnTbody = null;
		if (expectedSize==0) {
//			notExistsTrOnTbody = (new WebDriverWait(driver, PO_View.getTimeout()))
//					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody/tr")));
			return 0;
		}else {
//			if (!notExistsTrOnTbody) {
				// Contamos el número de filas de notas
				List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
						PO_View.getTimeout());

				if (expectedSize != null) {
					assertTrue(elementos.size() == expectedSize);
				}

				return elementos.size();
//			}
		}
				

	}
	

	public static  String insertOffersTo(WebDriver driver, String URL, String email, String password, int count) {
		String lastUUID ="";
		for (int i = 0; i < count; i++) {
			driver.manage().deleteAllCookies();
			driver.navigate().to(URL);
			// entro en la vista de la lista de ofertas
			PO_GestionarOfertasView.accesoGestionOfertas(driver, email, password, "offer/add");
			// relleno el formulario
			lastUUID = UUID.randomUUID().toString();
			PO_GestionarOfertasView.fillAddOfferForm(driver, email, lastUUID,
					"Oferta con una descripcion de mas de veinte caracteres......", new Random().nextInt(150) + "");
		}
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		return lastUUID;
	}
	
	public static   void busquedaOferta(WebDriver driver,String busqueda) {
		WebElement title = driver.findElement(By.name("searchText"));
		title.click();
		title.clear();
		title.sendKeys(busqueda);
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPaginaxpath(driver, "//*[@id=\"search\"]", PO_View.getTimeout());
		elementos.get(0).click();
		SeleniumUtils.EsperaCargaPagina(driver, "free", "//*[@id=\"offer-list\"]", PO_View.getTimeout());
	}
	
	public static  String recuperacionDeDatos(WebDriver driver, String URL) {
		String lastUUID ="";
		String[] emails = new String[]{"99999990A@wywallapop.com","99999991B@wywallapop.com","99999992C@wywallapop.com","99999993D@wywallapop.com"};

		for (int i = 0; i < emails.length; i++) {
			PO_RegisterView.registerUser(driver, emails[i], "123456");
			lastUUID=PO_GestionarOfertasView.insertOffersTo(driver, URL, emails[i], "123456", 4);
		}
		return lastUUID;
		
	}


}
