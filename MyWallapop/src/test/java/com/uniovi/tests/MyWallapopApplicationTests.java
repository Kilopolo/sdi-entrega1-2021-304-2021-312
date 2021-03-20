package com.uniovi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
//import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@SpringBootTest
public class MyWallapopApplicationTests {
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

	// Antes de cada prueba se navega al URL home de la aplicación
	@BeforeEach
	public void setUp() {
		navigateUrl(URL, "");
	}

	private void navigateUrl(String URL, String pag) {
		driver.navigate().to(URL + pag);
		new WebDriverWait(driver, 2);
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

	@Test
	public void PruebaConexion() {

		System.out.println(driver.getCurrentUrl());
		System.out.println();
		WebElement prueba = driver.findElement(By.id("prueba"));
		System.out.println("-------------------");
		System.out.println(prueba.getText());
		assertEquals(prueba.getText(), "Wallapop App");

//	WebElement we = driver.getTitle();

	}

//----------------OBLIGATORIOS------------------

	// TODO [Prueba1] Registro de Usuario con datos válidos.
	/**
	 * Registro de Usuario con datos válidos.
	 */
	@Test
	public void Prueba1() {

	}

	// TODO [Prueba2] Registro de Usuario con datos inválidos (email vacío, nombre
	// vacío, apellidos vacíos).
	
	/**
	 * Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos
	 * vacíos).
	 */
	@Test
	public void Prueba2() {

	}

	// TODO [Prueba3] Registro de Usuario con datos inválidos (repetición de
	// contraseña inválida).
	/**
	 * 
	 */
	@Test
	public void Prueba3() {

	}

	// TODO [Prueba4] Registro de Usuario con datos inválidos (email existente).
	/**
	 * 
	 */
	@Test
	public void Prueba4() {

	}// TODO [Prueba5] Inicio de sesión con datos válidos (administrador).

	/**
	 * 
	 */
	@Test
	public void Prueba5() {

	}// TODO [Prueba6] Inicio de sesión con datos válidos (usuario estándar).

	/**
	 * 
	 */
	@Test
	public void Prueba6() {

	}// TODO [Prueba7] Inicio de sesión con datos inválidos (usuario estándar, campo
		// email y contraseña vacíos).

	/**
	 * 
	 */
	@Test
	public void Prueba7() {

	}// TODO [Prueba8] Inicio de sesión con datos válidos (usuario estándar, email
		// existente, pero contraseña incorrecta).

	/**
	 * 
	 */
	@Test
	public void Prueba8() {

	}// TODO [Prueba9] Inicio de sesión con datos inválidos (usuario estándar, email
		// no existente en la aplicación).

	/**
	 * 
	 */
	@Test
	public void Prueba9() {

	}// TODO [Prueba10] Hacer click en la opción de salir de sesión y comprobar que
		// se redirige a la página de inicio de sesión (Login).

	/**
	 * 
	 */
	@Test
	public void Prueba10() {

	}// TODO [Prueba11] Comprobar que el botón cerrar sesión no está visible si el
		// usuario no está autenticado.

	/**
	 * 
	 */
	@Test
	public void Prueba11() {

	}// TODO [Prueba12] Mostrar el listado de usuarios y comprobar que se muestran
		// todos los que existen en el sistema.

	/**
	 * 
	 */
	@Test
	public void Prueba12() {

	}// TODO [Prueba13] Ir a la lista de usuarios, borrar el primer usuario de la
		// lista, comprobar que la lista se actualiza y que el usuario desaparece.

	/**
	 * 
	 */
	@Test
	public void Prueba13() {

	}// TODO [Prueba14] Ir a la lista de usuarios, borrar el último usuario de la
		// lista, comprobar que la lista se actualiza y que el usuario desaparece.

	/**
	 * 
	 */
	@Test
	public void Prueba14() {

	}// TODO [Prueba15] Ir a la lista de usuarios, borrar 3 usuarios, comprobar que
		// la lista se actualiza y que los usuarios desaparecen.

	/**
	 * 
	 */
	@Test
	public void Prueba15() {

	}// TODO [Prueba16] Ir al formulario de alta de oferta, rellenarla con datos
		// válidos y pulsar el botón Submit. Comprobar que la oferta sale en el listado
		// de ofertas de dicho usuario.

	/**
	 * 
	 */
	@Test
	public void Prueba16() {

	}// TODO [Prueba17] Ir al formulario de alta de oferta, rellenarla con datos
		// inválidos (campo título vacío) y pulsar el botón Submit. Comprobar que se
		// muestra el mensaje de campo obligatorio.

	/**
	 * 
	 */
	@Test
	public void Prueba17() {

	}// TODO [Prueba18] Mostrar el listado de ofertas para dicho usuario y comprobar
		// que se muestran todas los que existen para este usuario.

	/**
	 * 
	 */
	@Test
	public void Prueba18() {

	}// TODO [Prueba19] Ir a la lista de ofertas, borrar la primera oferta de la
		// lista, comprobar que la lista se actualiza y que la oferta desaparece.

	/**
	 * 
	 */
	@Test
	public void Prueba19() {

	}// TODO [Prueba20] Ir a la lista de ofertas, borrar la última oferta de la
		// lista, comprobar que la lista se actualiza y que la oferta desaparece.

	/**
	 * 
	 */
	@Test
	public void Prueba20() {

	}// TODO [Prueba21] Hacer una búsqueda con el campo vacío y comprobar que se
		// muestra la página que corresponde con el listado de las ofertas existentes en
		// el sistema

	/**
	 * 
	 */
	@Test
	public void Prueba21() {

	}// TODO [Prueba22] Hacer una búsqueda escribiendo en el campo un texto que no
		// exista y comprobar que se muestra la página que corresponde, con la lista de
		// ofertas vacía.

	/**
	 * 
	 */
	@Test
	public void Prueba22() {

	}// TODO [Prueba23] Sobre una búsqueda determinada (a elección del
		// desarrollador), comprar una oferta que deja un saldo positivo en el contador
		// del comprador. Comprobar que el contador se actualiza correctamente en la
		// vista del comprador.

	/**
	 * 
	 */
	@Test
	public void Prueba23() {

	}// TODO [Prueba24] Sobre una búsqueda determinada (a elección del
		// desarrollador), comprar una oferta que deja un saldo 0 en el contador del
		// comprador. Comprobar que el contador se actualiza correctamente en la vista
		// del comprador.

	/**
	 * 
	 */
	@Test
	public void Prueba24() {

	}// TODO [Prueba25] Sobre una búsqueda determinada (a elección del
		// desarrollador), intentar comprar una oferta que esté por encima de saldo
		// disponible del comprador. Y comprobar que se muestra el mensaje de saldo no
		// suficiente.

	/**
	 * 
	 */
	@Test
	public void Prueba25() {

	}// TODO [Prueba26] Ir a la opción de ofertas compradas del usuario y mostrar la
		// lista. Comprobar que aparecen las ofertas que deben aparecer.

	/**
	 * 
	 */
	@Test
	public void Prueba26() {

	}// TODO [Prueba27] Visualizar al menos cuatro páginas haciendo el cambio
		// español/inglés/español (comprobando que algunas de las etiquetas cambian al
		// idioma correspondiente). Página principal/Opciones principales de
		// usuario/Listado de usuarios /Vista de alta de oferta.

	/**
	 * 
	 */
	@Test
	public void Prueba27() {

	}// TODO [Prueba28] Intentar acceder sin estar autenticado a la opción de listado
		// de usuarios del administrador. Se deberá volver al formulario de login.

	/**
	 * 
	 */
	@Test
	public void Prueba28() {

	}// TODO [Prueba29] Intentar acceder sin estar autenticado a la opción de listado
		// de ofertas propias de un usuario estándar. Se deberá volver al formulario de
		// login.

	/**
	 * 
	 */
	@Test
	public void Prueba29() {

	}// TODO [Prueba30] Estando autenticado como usuario estándar intentar acceder a
		// la opción de listado de usuarios del administrador. Se deberá indicar un
		// mensaje de acción prohibida.

	/**
	 * 
	 */
	@Test
	public void Prueba30() {

	}
	// ----------------OPCIONALES------------------

	// TODO [Prueba31] Sobre una búsqueda determinada de ofertas (a elección de
	// desarrollador), enviar un mensaje a una oferta concreta. Se abriría dicha
	// conversación por primera vez. Comprobar que el mensaje aparece en el listado
	// de mensajes.
	/**
	 * 
	 */
	@Test
	public void Prueba31() {

	}// TODO [Prueba32] Sobre el listado de conversaciones enviar un mensaje a una
		// conversación ya abierta. Comprobar que el mensaje aparece en la lista de
		// mensajes.

	/**
	 * 
	 */
	@Test
	public void Prueba32() {

	}// TODO [Prueba33] Mostrar el listado de conversaciones ya abiertas. Comprobar
		// que el listado contiene las conversaciones que deben ser.

	/**
	 * 
	 */
	@Test
	public void Prueba33() {

	}// TODO [Prueba34] Sobre el listado de conversaciones ya abiertas. Pinchar el
		// enlace Eliminar de la primera y comprobar que el listado se actualiza
		// correctamente.

	/**
	 * 
	 */
	@Test
	public void Prueba34() {

	}// TODO [Prueba35] Sobre el listado de conversaciones ya abiertas, pulsar el
		// enlace Eliminar de la última y comprobar que el listado se actualiza
		// correctamente.

	/**
	 * 
	 */
	@Test
	public void Prueba35() {

	}// TODO [Prueba36] Al crear una oferta marcar dicha oferta como destacada y a
		// continuación comprobar: i) que aparece en el listado de ofertas destacadas
		// para los usuarios y que el saldo del usuario se actualiza adecuadamente en la
		// vista del ofertante (-20).

	/**
	 * 
	 */
	@Test
	public void Prueba36() {

	}// TODO [Prueba37] Sobre el listado de ofertas de un usuario con menos de 20
		// euros de saldo, pinchar en el enlace Destacada y a continuación comprobar:
		// que aparece en el listado de ofertas destacadas para los usuarios y que el
		// saldo del usuario se actualiza adecuadamente en la vista del ofertante (-20).

	/**
	 * 
	 */
	@Test
	public void Prueba37() {

	}// TODO [Prueba38] Sobre el listado de ofertas de un usuario con menos de 20
		// euros de saldo, pinchar en el enlace Destacada y a continuación comprobar que
		// se muestra el mensaje de saldo no suficiente.

	/**
	 * 
	 */
	@Test
	public void Prueba38() {

	}
}