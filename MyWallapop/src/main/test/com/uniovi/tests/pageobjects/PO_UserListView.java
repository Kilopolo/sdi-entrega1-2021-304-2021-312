package com.uniovi.tests.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_UserListView extends PO_NavView {

	/**
	 * 
	 */
	public static void accesoUserList(WebDriver driver) {
		PO_PrivateView.login(driver, "admin@email.com", "admin", "Esta es la parte privada de la web");
		
		String text = "users-menu";
		String busqueda = "//li[contains(@id,'"+ text +"')]/a";
		
		// Pinchamos en la opción de menu de Gestionar Usuarios:
		List<WebElement> listaMenuGestUsu = PO_View.checkElement(driver, "free", busqueda);
		listaMenuGestUsu.get(0).click();
		// Esperamos a aparezca la opción de ver usuarios
		listaMenuGestUsu = PO_View.checkElement(driver, "free", "//a[contains(@href, 'user/list')]");
		// Pinchamos en Ver Usuarios
		listaMenuGestUsu.get(0).click();
	}
	
	/**
	 * @param expectedSize
	 */
	public static void checkNumberOfUsersOnList(WebDriver driver,int expectedSize) {
		// Contamos el número de filas de notas
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
				PO_View.getTimeout());
//		CUIDADO AL AÑADIR MAS USUARIOS EN PRUEBAS ANTERIORES
		assertTrue(elementos.size() == expectedSize);
	}

	/**
	 * @param numBorrar
	 */
	public static void deleteUser(WebDriver driver,int... numsBorrar) {
		for (int i = 0; i < numsBorrar.length; i++) {
			List<WebElement> filaBorrar = SeleniumUtils.EsperaCargaPagina(driver, "free", "//*[@id=\"deleteCheckbox\"]",PO_View.getTimeout());
			filaBorrar.get(numsBorrar[i]).click();
		}
		
		List<WebElement> borrarBoton = SeleniumUtils.EsperaCargaPagina(driver, "free", "//*[@id=\"deleteButton\"]",PO_View.getTimeout());
		borrarBoton.get(0).click();
	}

	
}
