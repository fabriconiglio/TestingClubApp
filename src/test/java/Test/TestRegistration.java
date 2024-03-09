package Test;

import Pages.RegisterPage;
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistration {
    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_REGISTRATION.html");
    ExtentReports extent;

    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.url("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("REGISTRATION")
    public void SuccesfulRegistration() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.clickRegister();
        test.log(Status.PASS, "Ingreso en el formulario de Registro");

        registerPage.writeFirstName("Perla");
        registerPage.writeLastName("Chalon");
        registerPage.writeAddress("Maipu 665");
        registerPage.writeCity("Tucuman");
        registerPage.writeZipCode("4000");
        registerPage.writeState("Tucuman");
        registerPage.writeTelephone("123456");
        registerPage.writeSsn("5545");
        registerPage.writeUsername("perla");
        registerPage.writePassword("password");
        registerPage.writeConfirmPass("password");

        registerPage.clickBtnRegister();

        test.log(Status.PASS, "Ingreso todos los datos del Registro");



        String message = registerPage.getMessageRegistrationSucces();

        assertTrue(message.contains("You are now logged in"));
        test.log(Status.PASS, "Validación de Registro Exitoso");
    }



    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }
}
