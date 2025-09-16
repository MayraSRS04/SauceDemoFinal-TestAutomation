package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;

public class CommonSteps {

    @Given("I am in sauce demo web page")
    public void goToSauceDemoPage(){
        DriverManager.getDriver().get("https://www.saucedemo.com");
        DriverManager.getDriver().manage().window().maximize();
    }
}
