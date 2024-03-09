package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {


    private By register = By.linkText("Register");
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By zipCode = By.id("customer.address.zipCode");
    private By state = By.id("customer.address.state");

    private By telephone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");

    private By password = By.id("customer.password");
    private By confirmPass = By.id("repeatedPassword");

    private By btnRegister = By.xpath("//input[@value='Register']");

    // private By success = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    private By succes = By.cssSelector("div[id='rightPanel'] p");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void clickRegister() throws InterruptedException {
        this.clickear(register);
    }

    public void writeFirstName(String name) throws InterruptedException {
        this.sendText(name, firstName);
    }

    public void writeLastName(String lastName1) throws InterruptedException {
        this.sendText(lastName1, lastName);
    }
    public void writeAddress(String address1) throws InterruptedException {
        this.sendText(address1, address);
    }
    public void writeCity(String city1) throws InterruptedException {
        this.sendText(city1, city);
    }
    public void writeZipCode(String zipCode1) throws InterruptedException {
        this.sendText(zipCode1, zipCode);
    }
    public void writeState(String state1) throws InterruptedException {
        this.sendText(state1, state);
    }


    public void writeTelephone(String tel) throws InterruptedException {
        this.sendText(tel, telephone);

    }


    public void writeSsn(String ssn1) throws InterruptedException {
        this.sendText(ssn1, ssn);

    }
    public void writeUsername(String username1) throws InterruptedException {
        this.sendText(username1, username);

    }

    public void writePassword(String password1) throws InterruptedException {
        this.sendText(password1, password);

    }
    public void writeConfirmPass(String pass) throws InterruptedException {
        this.sendText(pass, confirmPass);

    }
    public void clickBtnRegister() throws InterruptedException {
        this.clickear(btnRegister);

    }

    public String getMessageRegistrationSucces() throws InterruptedException {
        String res = this.getText(succes);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
