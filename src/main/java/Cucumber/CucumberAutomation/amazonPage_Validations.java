package Cucumber.CucumberAutomation;


import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class amazonPage_Validations extends BaseTest {

    int searchCount;
    String prodPrice;


    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchBarIcon;

    @FindBy(xpath = "//div[contains(@class,'s-main-slot s-result-list')]/div")
    List<WebElement> searchResult;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    WebElement detailProdPrice;

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-button")
    WebElement addCartButton;

    @FindBy(xpath = "//span[contains(@class,'sc-product-price')]")
    WebElement cartPgPrice;

    @FindBy(xpath = "//*[contains(text(),'Your Amazon Cart is empty')]")
    WebElement cartEmptyMsg;

    @FindBy(xpath = "//input[@value='Delete']")
    WebElement cartPgDeleteOption;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement userSignIn;

    @FindBy(xpath = "//div[@id='nav-flyout-accountList']//a[contains(text(),'Start here')]")
    WebElement newUserSignIn;

    @FindBy(id = "ap_customer_name")
    WebElement userName;

    @FindBy(id = "ap_email")
    WebElement userEmail;

    @FindBy(xpath = "//a[text()='Conditions of Use']")
    WebElement conditionOfUseHyperLink;

    @FindBy(xpath = "//input[@id='helpsearch']")
    WebElement con_useSearchBox;

    @FindBy(xpath = "//div[@id='help_srch_sggst']/div")
    List<WebElement> searchSuggestion;


    // hexa object

    @FindBy(xpath = "//a[@class='searchbox']/span")
    WebElement searchText;

    @FindBy(id = "search-field")
    WebElement searchInputField;

    @FindBy(xpath = "//section[@id='search-results']//div[@class='entry-inner']/header//a")
    List<WebElement> listResult;


    Response response;

    public amazonPage_Validations(String strURL) {
        driver.get(strURL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void validateHOmePage() {
        String pageTitle, expectedPgTitle = "Amazon.com. Spend less. Smile more.";
        try {

            pageTitle = driver.getTitle();
            System.out.println(pageTitle);
            // Assert.assertEquals(expectedPgTitle, pageTitle);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void searchTextClick() {
        String pageTitle, expectedPgTitle = "Amazon.com. Spend less. Smile more.";
        try {
            searchText.click();
            System.out.println("search text field is clicked");

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void enterSerchText(String text) {

        try {
            searchInputField.isDisplayed();
            System.out.println("search text box field is displayed");
            searchInputField.sendKeys(text, Keys.RETURN);
            System.out.println("entered text " + text + "and hit the enter button");

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void validateRstText(String exptext) {
        String textfromScr;

        try {
            searchCount = listResult.size();
            for (int i = 0; i < searchCount; i++) {
                textfromScr = listResult.get(i).getText().trim();
                if (textfromScr.contains(exptext)) {
                    System.out.println("the text has been found..");
                }
            }
            System.out.println("the following text has been not found ..");
            Assert.fail();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void searchProduct(String nameProduct) {

        try {
            searchBar.clear();
            searchBar.sendKeys(nameProduct);
            System.out.println("searching the product " + nameProduct);
            searchBarIcon.click();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void searchResultCount() {
        int expCount = 1;
        WebElement searchList;

        try {
            searchCount = searchResult.size();
            if (searchCount >= expCount) {
                System.out.println("more or equal to " + expCount + " result has been displayed");
                searchList = searchResult.get(0);
                prodPrice = searchList.findElement(By.xpath("//span[@class='a-price']")).getText().trim();
                prodPrice = prodPrice.replaceAll("\n", ".");
                System.out.println("The first product price is.." + prodPrice);

            } else {
                System.out.println("less than " + expCount + " result has been displayed");
                Assert.fail();
            }


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void productClick() {
        WebElement searchList;
        try {
            searchList = searchResult.get(0);
            searchList.findElement(By.xpath("//span[contains(@class,'a-text-normal')]")).click();
            System.out.println("clicking the first product.");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void detailsProdPrice() {
        String detailPrice;

        try {
            detailPrice = detailProdPrice.getText();
            System.out.println("The product price in detail Page is..." + detailPrice);
            System.out.println("the price from Search result is .." + prodPrice);
            Assert.assertEquals(detailPrice, prodPrice);
            addCartButton.click();
            System.out.println("The product is added to cart.");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void cartClick() {

        try {
            cartIcon.click();
            System.out.println("clicking on cart icon");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void cartPagePrice() {
        String cartPrice;

        try {
            cartPrice = cartPgPrice.getText();
            System.out.println("The product price in cart Page is..." + cartPrice);
            Assert.assertEquals(cartPrice, prodPrice);


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void cartDelete() {

        try {
            cartPgDeleteOption.click();
            System.out.println("The product price in cart Page is deleted..");
            Assert.assertTrue("Cart is not empty", cartEmptyMsg.isDisplayed());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void newUserSignIn() {
        int timeCountCheck;
        Actions action = new Actions(driver);

        try {

            action.moveToElement(userSignIn).moveToElement(newUserSignIn).click().build().perform();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void apiDataResponse(String url, String email) {
        String messdage = null;


        try {
            System.out.println(url);
// the API is not working as expected , but for the below the code has been written
//
//            RestAssured.baseURI = url;
//            response = given()
//                    .when()
//                    .get("/api/v1/employee/3").then().log().all().extract().response();
//
//            System.out.println("Response :" + response.asString());
//            System.out.println("Status Code :" + response.getStatusCode());
//            JsonPath js = new JsonPath(response.asString());
//            js.getString("data.employee_name");
//            System.out.println(" name value is .." + );

            userName.sendKeys("new_user");
            System.out.println(email);
            userEmail.sendKeys(email);


        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }


    public void clickCondition(String keyword, String keyWordToSelect) {
        int count;
        String value;
        try {
            conditionOfUseHyperLink.click();
            con_useSearchBox.click();
            con_useSearchBox.sendKeys(keyword + " ");
            System.out.println("Clicking on Condition");
            count = searchSuggestion.size();
            for (WebElement DropDowGetText : searchSuggestion) {
                value = DropDowGetText.getText();
                if (value.equalsIgnoreCase(keyWordToSelect)) {
                    DropDowGetText.click();
                    System.out.println(value + "..... Clicking on Condition");
                    break;
                }

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }


}
