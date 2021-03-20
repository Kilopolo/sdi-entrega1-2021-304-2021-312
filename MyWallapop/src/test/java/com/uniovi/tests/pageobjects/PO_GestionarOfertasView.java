package com.uniovi.tests.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_GestionarOfertasView extends PO_NavView {

	/**
	 * @param password 
	 * @param email 
	 * @param menuLink 
	 * 
	 */
	public static void accesoGestionOfertas(WebDriver driver, String email, String password, String menuLink) {
		PO_PrivateView.login(driver, email, password, "Esta es la parte privada de la web");
		
		String text = "offers-menu";
		String busqueda = "//li[contains(@id,'"+ text +"')]/a";
		
		// Pinchamos en la opción de menu de Gestionar Usuarios:
		List<WebElement> listaMenuGestUsu = PO_View.checkElement(driver, "free", busqueda);
		listaMenuGestUsu.get(0).click();
		// Esperamos a aparezca la opción de ver usuarios
		listaMenuGestUsu = PO_View.checkElement(driver, "free", "//a[contains(@href, '"+menuLink+"')]");
		// Pinchamos en Ver Usuarios
		listaMenuGestUsu.get(0).click();
	}
	
	/**
	 * @param expectedSize
	 */
	public static void checkNumberOfOffersOnList(WebDriver driver,int expectedSize) {
		// Contamos el número de filas de notas
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
				PO_View.getTimeout());
//		CUIDADO AL AÑADIR MAS USUARIOS EN PRUEBAS ANTERIORES
		assertTrue(elementos.size() == expectedSize);
	}

	
}
