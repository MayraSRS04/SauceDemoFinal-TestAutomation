package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    WebDriver driver;

    @FindBy(css = "h2.complete-header")
    WebElement completeMessage;

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCompleteMessage(String message){
        if(completeMessage.getText().equalsIgnoreCase(message)){
            return true;
        } else {
            return false;
        }
    }
}
