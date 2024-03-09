package Test;

import Pages.AdminPage;
import Pages.LoginPage;
import Pages.NewAccountPage;
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

public class TestLoginAdmin {


    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES_LOGIN_ADMIN.html");
    ExtentReports extent;

    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        NewAccountPage newAccountPage = new NewAccountPage(driver, wait);
        newAccountPage.setup();
        newAccountPage.url("https://club-app-front-end.vercel.app/admin");
    }

    @Test
    @Tag("INGRESO ADMIN")
    public void ConsultaAccesoAdmin() throws InterruptedException {
        ExtentTest test = extent.createTest("Consulta Acceso Admin");
        test.log(Status.INFO, "Comienza el Test");
        AdminPage adminPage = new AdminPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.writePassword("clubApp2pi");
        loginPage.login();

        test.log(Status.PASS, "Ingreso como admin");
        adminPage.clickPagesOverview();
        test.log(Status.PASS, "Ingreso en cobros");




    }
    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
        extent.flush();
    }
    }


