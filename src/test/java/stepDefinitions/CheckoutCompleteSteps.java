package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutCompletePage;

public class CheckoutCompleteSteps {
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver());


    @Then("A message that says {string} should be displayed")
    public void verifyCompleteMessage(String message){
        Assert.assertTrue(checkoutCompletePage.verifyCompleteMessage(message));
    }
}
