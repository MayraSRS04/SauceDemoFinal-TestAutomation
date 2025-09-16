package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckoutInformationPage;

import java.util.List;

public class CheckoutInformationSteps {
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(DriverManager.getDriver());

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation){
        List<String> data = checkoutInformation.transpose().asList(String.class);
        //['Jorge', 'Perez', '12345']
        checkoutInformationPage.setFirstNameTextBox(data.get(0));
        checkoutInformationPage.setLastNameTextBox(data.get(1));
        checkoutInformationPage.setZipCodeTextBox(data.get(2));
    }

    @When("I fill the checkout information only with lastname and postalcode")
    public void iFillTheCheckoutInformationOnlyWithLastnameAndPostalcode(DataTable dataTable) {
        List<String> data = dataTable.row(0); // Obtiene la primera fila

        // Dejar first name vacío intencionalmente
        checkoutInformationPage.setLastNameTextBox(data.get(0));
        checkoutInformationPage.setZipCodeTextBox(data.get(1));
    }

    @When("I fill the checkout information only with firstname and lastname")
    public void iFillTheCheckoutInformationOnlyWithFirstnameLastname(DataTable dataTable) {
        List<String> data = dataTable.row(0); // Obtiene la primera fila

        // Dejar first name vacío intencionalmente
        checkoutInformationPage.setFirstNameTextBox(data.get(0));
        checkoutInformationPage.setLastNameTextBox(data.get(1));
    }

    @And("I click on the continue button")
    public void clickOnContinue(){
        checkoutInformationPage.clickOnContinueButton();
    }

    @Then("A wrong message that says {string} should be displayed")
    public void verifyWrongMessage(String message){
        Assert.assertTrue(checkoutInformationPage.verifyWrongMessage(message));
    }

}
