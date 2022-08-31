package StepDefinition;

import Base.BaseSetup;
import Pages.SearchGooglePage;
import Ultilities.PropertiesFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Pages.SearchGooglePage;
import org.testng.Assert;
import org.w3c.dom.Text;

import java.util.Locale;


public class Search_Google extends BaseSetup{

    WebDriver driver;
    //String keyword;
    public SearchGooglePage searchGooglePage;
    private static String propertiesFilePathRoot = "src/test/resources/Configs/configs.properties";



//    @Before
//    public void setDriver(){
//        PropertiesFileReader.setProperties(propertiesFilePathRoot);
//        driver = new BaseSetup().setDriver(PropertiesFileReader.getPropValue("browserType"), PropertiesFileReader.getPropValue("googleURL"));
//
//    }

    @Given("I go to Google page")
    public void iGoToGooglePage() {
    }


    @When("I input a keyword {string}")
    public void inputAKeyword(String keyword) throws InterruptedException{
        searchGooglePage = new SearchGooglePage(driver);
        Thread.sleep(6000);
        //this.keyword = keyword;
        searchGooglePage.inputKeyword(keyword);
    }


    @And("I type enter")
    public void iTypeEnter() {
        searchGooglePage.enterKeyword();
    }

    @Then("I verify the first result has {string}")
    public void iVerifyTheFirstResultHas(String keyword) {
        //this.keyword = keyword;

        String actualText = searchGooglePage.getFirstResult();
        String expectedText = keyword;
        if(actualText.toLowerCase().contains(expectedText)){
            System.out.println("First title has keyword");
        }
        else
            System.out.println("First title has no keyword");

    }

    @Then("I select the first item on the suggestion list")
    public void iSelectTheFirstItemOnTheSuggestionList() throws InterruptedException{
        Thread.sleep(2000);
        searchGooglePage.selectFirstSuggestion();

    }

    @Then("I verify Google Search button exists")
    public void iVerifyGoogleSearchButtonExists() {
        searchGooglePage = new SearchGooglePage(driver);
        searchGooglePage.checkGoogleSearchButtonExist();
    }
}
