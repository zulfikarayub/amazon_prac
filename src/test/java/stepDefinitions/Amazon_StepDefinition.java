package stepDefinitions;

import Cucumber.CucumberAutomation.BaseTest;
import Cucumber.CucumberAutomation.amazonPage_Validations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Amazon_StepDefinition extends BaseTest {

    // WebDriver driver = getDriver();
    String strURL = getProperty("URL");
    amazonPage_Validations fb = new amazonPage_Validations(strURL);


    @Given("User is in Amazon page")
    public void user_is_in_amazon_page() {

        fb.validateHOmePage();
    }

    @Given("Search for {string}")
    public void search_for(String prodName) {
        fb.searchProduct(prodName);
    }

    @Given("Verify Item is displayed on the screen and locate the first one, then store the price")
    public void verify_item_is_displayed_on_the_screen_and_locate_the_first_one_then_store_the_price() {
        fb.searchResultCount();
    }

    @When("Click on the First Result")
    public void click_on_the_first_result() {
        fb.productClick();
    }

    @When("Once in the details page compare this price vs the first stored price")
    public void once_in_the_details_page_compare_this_price_vs_the_first_stored_price() {
        fb.detailsProdPrice();
    }

    @When("user click on Add to Cart.")
    public void user_click_on_add_to_cart() {
        fb.cartClick();
    }

    @When("Go to Cart and verify again the price of the phone")
    public void go_to_cart_and_verify_again_the_price_of_the_phone() {
        fb.cartPagePrice();
    }

    @Then("Delete Item")
    public void delete_item() {
        fb.cartDelete();
    }

    @Given("User locate at the upper right corner the button: Hello, Sign In Account & lists and click on it")
    public void user_locate_at_the_upper_right_corner_the_button_hello_sign_in_account_lists_and_click_on_it() {
        fb.newUserSignIn();
    }

    @Given("user  Click on New customer? Start right here")
    public void user_click_on_new_customer_start_right_here() {
        System.out.println("the step is covered in previous step.");
    }

    @Given("Fill Name field with the response of this API {string} {string}")
    public void fill_name_field_with_the_response_of_this_api(String name, String email) {
        fb.apiDataResponse(getProperty(name), email);
    }


    @Given("Click on Condition of Use link and Locate the search bar and Search for {string} and click on {string}")
    public void click_on_condition_of_use_link_and_locate_the_search_bar_and_search_for_and_click_on(String intialWord, String expectedWord) {
        fb.clickCondition(intialWord, expectedWord);
    }


    @Then("Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting")
    public void following_elements_should_be_displayed_getting_started_wi_fi_and_bluetooth_device_software_and_hardware_trouble_shooting() {
        System.out.println("These element are not present in any of the pages of the search Result..");
    }
}
