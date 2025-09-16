package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import pages.YourCartPage;

public class YourCartSteps {

    YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver());

    @And("I click on the checkout button")
    public void clickOnCheckoutButton(){
        yourCartPage.clickOnCheckoutButton();
    }
}
