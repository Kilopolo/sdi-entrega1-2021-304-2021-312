package com.uniovi.tests.pageobjects;

import org.openqa.selenium.WebDriver;

public class PO_PrivateView extends PO_NavView {


	static public void login(WebDriver driver, String email, String password, String check) {

		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, email, password);
		// COmprobamos que entramos en la pagina privada de Alumno
		PO_View.checkElement(driver, "text", check);
	}
}