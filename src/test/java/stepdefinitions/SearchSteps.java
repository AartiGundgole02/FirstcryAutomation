package stepdefinitions;


import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import pages.HomePage;
import utils.ConfigReader;
import io.cucumber.java.en.*;

public class SearchSteps {
    private HomePage homePage;

    SoftAssert ast = new SoftAssert();
    
    
    @Given("user is on FirstCry homepage")
    public void user_is_on_homepage() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.openHomePage(ConfigReader.getProperty("baseUrl"));
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) throws InterruptedException {
    	ast.assertEquals(homePage.searchProduct(product), "Pass");
        ;
    }

    @Then("product results should be displayed")
    public void product_results_should_be_displayed() {
        ast.assertEquals(homePage.getProductTitle(), "Pass");
    }
    
    @Given("user is in footware page")
    public void user_is_in_footware_page() {
       
    }

    @When("user navigates on all categories and selects {string} from {string} section")
    public void user_navigates_on_all_categories_and_selects_from_section(String string, String string2) {
        
    }

    @Then("Kids sneakers should display on the page")
    public void kids_sneakers_should_display_on_the_page() {
      
    }



    
}
