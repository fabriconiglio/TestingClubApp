package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By messageAccountOverview = By.xpath("/html/body/main/div/div/h1");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public String getMessageAccountOverview() throws InterruptedException {
        String res = this.getText(messageAccountOverview);
        System.out.println("Resultado Card value: " + res);
        return res;
    }


}

