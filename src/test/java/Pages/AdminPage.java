package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage{


    private By adminPageOverview = By.xpath("/html/body/header/div/nav/div[1]/button[2]");

    private By messageAccountOverview = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");

    private By titleAccountDetails = By.xpath("//h1[normalize-space()='Account Details']");

    private By activityPeriod = By.id("month");

    private By transactionType = By.id("transactionType");


    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickPagesOverview() throws InterruptedException {
        this.clickear(adminPageOverview);
        Thread.sleep(1000);
    }


    public String getMessageAccountOverview() throws InterruptedException {
        String res = this.getText(messageAccountOverview);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
    public String getMessageTitleAccountDetails() throws InterruptedException {
        String res = this.getText(titleAccountDetails);
        System.out.println("Resultado Card value: " + res);
        return res;
    }


    public void clickActivityPeriod() throws InterruptedException {
        this.clickear(activityPeriod);
        Thread.sleep(1000);
    }

    public void clickTransactionType() throws InterruptedException {
        this.clickear(transactionType);
        Thread.sleep(1000);
    }


}

