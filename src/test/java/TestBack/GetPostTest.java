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

    private String username = "perla";
    private String password = "password";
    private String customerId = "13211";
    private String idAccount = "14676";
    private String idAccount2 = "15897";

    private String acoountType = "1";
    private String amount = "100";

    static ExtentSparkReporter report = new ExtentSparkReporter("target/REPORTES_BACKEND_TESTS.html");
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void setup() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(report);
    }


 /*   @Test
    @Tag("TESTBACKEND")
    public void getLogin() {

     JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", "perla");
        requestBody.addProperty("password", "password");
        given()
                .contentType("application/json")
                .body(requestBody)
                .get("https://parabank.parasoft.com/parabank/services/bank/login/"+username+"/"+password)
                .then()
                .statusCode(200)
                .log().body();
    }
*/
    @Test
    @Tag("TESTBACKEND")
    @Order(1)
    public void getRegisterPage() {

        ExtentTest test = extent.createTest("Verificación URL");
        test.log(Status.INFO, "Comienza el Test");
        given()
                .when()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(200)
                .log().body();

        test.log(Status.PASS, "Validación de URL Exitosa.");
    }


    @Test
    @Tag("TESTBACKEND")
    @Order(2)
    public void PostNewAccount() {
        ExtentTest test = extent.createTest("Creación nueva cuenta exitosa");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .auth().basic(username, password)
                .post( "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId="+customerId
                        +"&newAccountType="+acoountType+"&fromAccountId="+idAccount )
                .then().statusCode(200)
                .log().status()
                .log().body();

        test.log(Status.PASS, "Validación de Creación de cuenta Exitosa.");
    }

    @Test
    @Tag("TESTBACKEND")
    @Order(3)
    public void getAccountOverview() {

        ExtentTest test = extent.createTest("Consulta Reporte de Cuenta");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .auth()
                .basic(username, password)

                .get("https://parabank.parasoft.com/parabank/services/bank/customers/"+customerId+"/accounts")
                .then()
                .statusCode(200)
                .log().body();
        test.log(Status.PASS, "Validación de visualización Account Overview");
    }


    @Test
    @Tag("TESTBACKEND")
    @Order(4)
    public void getAccountActivity() {

        ExtentTest test = extent.createTest("Consulta Actividad de Cuenta");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .auth()
                .basic(username, password)
                .get("https://parabank.parasoft.com/parabank/services/bank/accounts/"+idAccount+"/transactions/month/All/type/All")
                .then()
                .statusCode(200)
                .log().body();

        test.log(Status.PASS, "Validación de visualización Account Activity");
    }


    @Test      //falta probar este,
    @Tag("TESTBACKEND")
    @Order(5)
    public void postTransferFunds() {
        ExtentTest test = extent.createTest("Validación Tranferencia de Fondos");
        test.log(Status.INFO, "Comienza el Test");

        given()
                .auth().basic(username, password)
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId="
                        +idAccount+"&toAccountId="+idAccount2+"&amount="+amount)
                .then().statusCode(200)
                .log().status()
                .log().body();
        test.log(Status.PASS, "Transferencia Exitosa de fondos");
    }
    @AfterAll
    public static void quit() {
        extent.flush();
    }


}