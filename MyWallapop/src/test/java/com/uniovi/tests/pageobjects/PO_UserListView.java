package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
}
