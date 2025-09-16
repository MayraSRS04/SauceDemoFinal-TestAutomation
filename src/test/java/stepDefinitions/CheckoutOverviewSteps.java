package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver());

    @And("I click on the finish button")
    public void clickOnFinish(){
        checkoutOverviewPage.clickOnFinishButton();
    }
}
