package com.uniovi.tests;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@SpringBootTest
public class MyWallapopApplicationTestsComplementarios {
	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox65\\firefox.exe";
	static String Geckdriver024 = "C:\\geckodriver024win64.exe";
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	private void navigateUrl(String URL, String pag) {
		driver.navigate().to(URL + pag);
		// new WebDriverWait(driver, 2);
	}

	// Antes de cada prueba se navega al URL home de la aplicación
	@BeforeEach
	public void setUp() {
		navigateUrl(URL, "");
	}

	// Después de cada prueba se borran las cookies del navegador
	@AfterEach
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {

	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}



	// ----------------OPCIONALES------------------

	// TODO [Prueba31]
	/**
	 * Sobre una búsqueda determinada de ofertas (a elección de desarrollador),
	 * enviar un mensaje a una oferta concreta. Se abriría dicha conversación por
	 * primera vez. Comprobar que el mensaje aparece en el listado de mensajes.
	 */
	@Test
	public void Prueba31() {
		fail("Not yet implemented");
	}// TODO [Prueba32]

	/**
	 * Sobre el listado de conversaciones enviar un mensaje a una conversación ya
	 * abierta. Comprobar que el mensaje aparece en la lista de mensajes.
	 */
	@Test
	public void Prueba32() {
		fail("Not yet implemented");
	}// TODO [Prueba33]

	/**
	 * Mostrar el listado de conversaciones ya abiertas. Comprobar que el listado
	 * contiene las conversaciones que deben ser.
	 */
	@Test
	public void Prueba33() {
		fail("Not yet implemented");
	}// TODO [Prueba34]

	/**
	 * Sobre el listado de conversaciones ya abiertas. Pinchar el enlace Eliminar de
	 * la primera y comprobar que el listado se actualiza correctamente.
	 */
	@Test
	public void Prueba34() {
		fail("Not yet implemented");
	}// TODO [Prueba35]

	/**
	 * Sobre el listado de conversaciones ya abiertas, pulsar el enlace Eliminar de
	 * la última y comprobar que el listado se actualiza correctamente.
	 */
	@Test
	public void Prueba35() {
		fail("Not yet implemented");
	}// TODO [Prueba36]

	/**
	 * Al crear una oferta marcar dicha oferta como destacada y a continuación
	 * comprobar: i) que aparece en el listado de ofertas destacadas para los
	 * usuarios y que el saldo del usuario se actualiza adecuadamente en la vista
	 * del ofertante (-20).
	 */
	@Test
	public void Prueba36() {
		fail("Not yet implemented");
	}// TODO [Prueba37]

	/**
	 * Sobre el listado de ofertas de un usuario con menos de 20 euros de saldo,
	 * pinchar en el enlace Destacada y a continuación comprobar: que aparece en el
	 * listado de ofertas destacadas para los usuarios y que el saldo del usuario se
	 * actualiza adecuadamente en la vista del ofertante (-20).
	 * 
	 */
	@Test
	public void Prueba37() {
		fail("Not yet implemented");
	}// TODO [Prueba38]

	/**
	 * Sobre el listado de ofertas de un usuario con menos de 20 euros de saldo,
	 * pinchar en el enlace Destacada y a continuación comprobar que se muestra el
	 * mensaje de saldo no suficiente.
	 */
	@Test
	public void Prueba38() {
		fail("Not yet implemented");
	}
}