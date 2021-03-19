//package com.uniovi.tests;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runners.MethodSorters;
////import org.springframework.boot.test.context.SpringBootTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
////Ordenamos las pruebas por el nombre del método
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
////@SpringBootTest
//public class MyWallapopApplicationTests {
//	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
//	// automáticas)):
//	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox65\\firefox.exe";
//	static String Geckdriver024 = "C:\\geckodriver024win64.exe";
//	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
//	static String URL = "http://localhost:8090";
//
//	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
//		System.setProperty("webdriver.firefox.bin", PathFirefox);
//		System.setProperty("webdriver.gecko.driver", Geckdriver);
//		WebDriver driver = new FirefoxDriver();
//		return driver;
//	}
//
//	// Antes de cada prueba se navega al URL home de la aplicación
//	@BeforeEach
//	public void setUp() {
//		navigateUrl(URL,"");
//	}
//
//	private void navigateUrl(String URL,String pag) {
//		driver.navigate().to(URL+pag);
//		new WebDriverWait(driver, 2);
//	}
//
//	// Después de cada prueba se borran las cookies del navegador
//	@AfterEach
//	public void tearDown() {
//		driver.manage().deleteAllCookies();
//	}
//
//	// Antes de la primera prueba
//	@BeforeClass
//	static public void begin() {
//	}
//
//	// Al finalizar la última prueba
//	@AfterClass
//	static public void end() {
//		// Cerramos el navegador al finalizar las pruebas
//		driver.quit();
//	}
//@Test
//public void PruebaConexion() {
//
//	System.out.println(driver.getCurrentUrl());
//	System.out.println();
//	WebElement prueba = driver.findElement(By.id("prueba"));
//	System.out.println("-------------------");
//	System.out.println(prueba.getText());
//	assertEquals(prueba.getText(), "Wallapop App");
//
////	WebElement we = driver.getTitle();
//
//}
//}