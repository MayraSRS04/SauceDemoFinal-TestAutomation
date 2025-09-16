package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver());

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @Then("The product {string} should be displayed")
    public void verifyProductIsDisplayed(String product){
        Assertions.assertTrue(homePage.productIsDisplayed(product));
    }

    @And("I add the {string} to the cart")
    public void addProductToCart(String productName){
        homePage.addProductToCart(productName);

    }

    @When("I click on the cart icon")
    public void clickOnCartIcon(){
        homePage.clickOnCartIcon();
    }

    @When("I click the remove button for the {string}")
    public void removeProduct(String product){
        homePage.removeProductToCart(product);
    }

    @Then("the {string} should be removed from the cart")
    public void verifyProductIsNotDisplayed(String product){
        Assertions.assertFalse(homePage.productIsDisplayed(product));
    }

    @When("I select the {string} filter option")
    public void iSelectTheFilterOption(String filterOption) {
        homePage.selectFilterOption(filterOption);
    }

    @Then("the products should be sorted by price in descending order")
    public void theProductsShouldBeSortedByPriceInDescendingOrder() {
        List<Double> prices = homePage.getProductPrices();
        List<Double> sortedPrices = homePage.sortPricesDescending(prices);

        Assert.assertEquals("Los productos no están ordenados por precio de mayor a menor",
                sortedPrices, prices);
    }

    @Then("the first product should have the highest price")
    public void theFirstProductShouldHaveTheHighestPrice() {
        List<Double> prices = homePage.getProductPrices();
        if (!prices.isEmpty()) {
            Double highestPrice = homePage.getHighestPrice(prices);
            Assert.assertEquals("El primer producto no tiene el precio más alto",
                    highestPrice, prices.get(0));
        }
    }

    @Then("the last product should have the lowest price")
    public void theLastProductShouldHaveTheLowestPrice() {
        List<Double> prices = homePage.getProductPrices();
        if (!prices.isEmpty()) {
            Double lowestPrice = homePage.getLowestPrice(prices);
            Assert.assertEquals("El último producto no tiene el precio más bajo",
                    lowestPrice, prices.get(prices.size() - 1));
        }
    }

    @Then("the products should be sorted by name in descending order")
    public void theProductsShouldBeSortedByNameInDescendingOrder() {
        Assert.assertTrue("Los productos no están ordenados de Z a A",
                homePage.areProductsSortedZA());
    }

    @Then("the first product should start with the last letter")
    public void theFirstProductShouldStartWithTheLastLetter() {
        List<String> productNames = homePage.getProductNames();
        homePage.getFirstName(productNames);
    }

    @Then("the last product should start with the first letter")
    public void theLastProductShouldStartWithTheFirstLetter() {
        List<String> productNames = homePage.getProductNames();
        homePage.getLastName(productNames);

    }
}
