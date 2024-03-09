package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage extends BasePage {


    private By newAccount = By.linkText("Open New Account");

    private By type = By.xpath("//option[@value='1']");

    private By btnOpenNewAccount = By.xpath("//input[@value='Open New Account']");

    private By messageAcountOpened = By.xpath("//h1[normalize-space()='Account Opened!']");


    public NewAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }



    public void clickNewAccount() throws InterruptedException {
        this.clickear(newAccount);
        Thread.sleep(1000);
    }
    public void clickType() throws InterruptedException {
        this.clickear(type);
        Thread.sleep(1000);
    }
    public void clickBtnOpenNewAccount() throws InterruptedException {
        this.clickear(btnOpenNewAccount);
        Thread.sleep(1000);
    }
    public String getMessageAccountOpened() throws InterruptedException {
        String res = this.getText(messageAcountOpened);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
