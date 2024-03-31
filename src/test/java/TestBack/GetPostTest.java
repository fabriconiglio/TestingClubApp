package TestBack;

import static io.restassured.RestAssured.*;

import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;
import org.testng.Assert;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetPostTest {

    static ExtentSparkReporter report = new ExtentSparkReporter("target/REPORTES_BACKEND_TESTS.html");
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void setup() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(report);
    }

    @Test
    @Tag("TESTBACKEND")
    @Order(2)
    public void ListPlayers() {
        ExtentTest test = extent.createTest("Listado de Jugadores");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .get("https://clubapp-backend-production-2.up.railway.app/players/list")
                .then().statusCode(200)
                .log().status()
                .log().body();

        test.log(Status.PASS, "Validación del Listado de Jugadores");
    }

    @Test
    @Tag("TESTBACKEND")
    @Order(3)
    public void getPlayersPaidFee() {

        ExtentTest test = extent.createTest("Consulta Jugadores que han pagado la cuota");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .get("https://clubapp-backend-production-2.up.railway.app/players/getPlayersPaidFee")
                .then()
                .statusCode(200)
                .log().body();
        test.log(Status.PASS, "Validación de visualización Account Overview");
    }


    @Test
    @Tag("TESTBACKEND")
    @Order(4)
    public void getByDni() {

        ExtentTest test = extent.createTest("Consulta de Jugador por DNI");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .get("https://clubapp-backend-production-2.up.railway.app/players/getByDni/12345678")
                .then()
                .statusCode(200)
                .log().body();

        test.log(Status.PASS, "Validacion de Consulta de Jugador por DNI");
    }

    @AfterAll
    public static void quit() {
        extent.flush();
    }


}