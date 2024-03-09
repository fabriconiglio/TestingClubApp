package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By password = By.id("password");
    private By btnSubmit = By.xpath("/html/body/div/form/button");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void writePassword(String password1) throws InterruptedException {
        this.sendText(password1, password);
    }

    public void login() throws InterruptedException {
        this.clickear(btnSubmit);
    }

}
