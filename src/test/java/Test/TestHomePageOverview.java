package Test;

import Pages.*;
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

public class TestHomePageOverview {


    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_HOME_PAGE_OVERVIEW.html");
    ExtentReports extent;

    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);
        newAccountPage.setup();
        newAccountPage.url("https://club-app-front-end.vercel.app/");
    }

    @Test
    @Tag("INGRESO PAGINA BIENVENIDA")
    public void BienvenidosTest () throws InterruptedException {
        ExtentTest test = extent.createTest("Ingrese a la pagina de bienvenida");
        test.log(Status.INFO, "Comienza el Test");


        //Identificamos el h1 de la pagina de bienvenida
        HomePage homePage = new HomePage(driver, wait);
        String message = homePage.getMessageAccountOverview();
        System.out.println("Resultado Card value: " + message);
        message.equals("Bienvenido a ClubAPP");
        test.log(Status.PASS, "Validación de ingreso a pagina de bienvenida");

    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }
}
