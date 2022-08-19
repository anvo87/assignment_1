package stepDefinition;

import Runners.Hook;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.plugin.javascript.navig.Document;

import java.time.Duration;


public class Signup_account extends Hook{
    WebDriver driver;
    String URL ="https://www.idloom.com/en/events/why-idloom-events?utm_source=GetApp";
    String firstName;
    String lastName;
    String Email;
    String Password;
    String confirmPassword;
    String companyName;
    String Phone;
    String fullName;
    String companyAddress;
    String postCode;
    String Vat;
    String referralCode;

    Hook newhook = new Hook();
    newhook.hook();


    @Before
    public void hook(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //1 - Maximum browser
        driver.manage().window().maximize();
    }

    @Given("I go to the Idloom page")
    public void iGoToTheIdloomPage() {

//        driver.navigate().to(URL);
            driver.get(URL);
    }

    @When("I click on Signup button")
    public void iClickOnSignupButton() {
        driver.findElement(By.xpath("//*[@id=\"layout\"]/section[1]/div/ul[1]/li[1]/a[2]")).click();
    }

    @And("I input Firstname {string}")
    public void iInputFirstname(String firstName) throws InterruptedException{

//        this.fullName = fullName;
//        WebElement myElement = driver.findElement(By.name("FullName"));
//        String js = "arguments[0].setAttribute('value','"+fullName+"')";
//        ((JavascriptExecutor) driver).executeScript(js, myElement);
          Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.textToBePresentInElement(By.id("signUpPricing")));
        this.firstName = firstName;
        driver.findElement(By.id("inputFirstName")).sendKeys(firstName);

    }
    @And("I input Lastname {string}")
    public void iInputLastname(String lastName) {

        this.lastName = lastName;
        driver.findElement(By.id("inputLastName")).sendKeys(lastName);

    }


//    @And("I select Account type dropwdownlist")
//    public void iSelectAccountType(){
        //*[@id="inputFirstName"]
//        String inputText = "Rozmeen";
//        WebElement myElement = driver.findElement(By.id("inputFirstName"));
//        String js = "arguments[0].setAttribute('value','"+inputText+"')";
//        ((JavascriptExecutor) driver).executeScript(js, myElement);

//        int selectedIndex = 3;
//        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"signUpPricing\"]")));
//        ((JavascriptExecutor)driver).executeScript(
//                "return document.getElementById('select id here').selectedIndex = '0'",
//                select
//        );
//    }



    @And("I input Email address {string}")
    public void iInputEmailAddress(String Email) {
        this.Email = Email;
        driver.findElement(By.id("inputEmailAddress")).sendKeys(Email);
    }

    @And("I input Password {string}")
    public void iInputPassword(String Password) {
        this.Password = Password;
        driver.findElement(By.id("inputPassword")).sendKeys(Password);
    }

    @And("I input Confirm password {string}")
    public void iInputConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        driver.findElement(By.id("inputConfirmPassword")).sendKeys(confirmPassword);
    }

    @And("I input Company name {string}")
    public void iInputCompanyName(String companyName) {
        this.companyName = companyName;
        driver.findElement(By.id("inputCompanyName")).sendKeys(companyName);
    }

    @And("I input Phone {string}")
    public void iInputPhone(String Phone) {
        this.Phone = Phone;
        driver.findElement(By.id("inputPhone")).sendKeys(Phone);
    }

    @And("I checked I accept checkbox")
    public void iCheckedIAcceptCheckbox() {
        driver.findElement(By.xpath("//*[@id=\"signUpEventsForm\"]/fieldset[6]/div/div/input")).click();
    }

    @And("I click on Got it button")
    public void iClickOnGotItButton() {
//        Move to the current component

//        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/a[1]"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).perform();
        driver.findElement(By.xpath("/html/body/div[1]/div/a[1]")).click();
    }

    @And("I click on the button")
    public void iClickOnTheButton() {

        driver.findElement(By.id("submitEventBtn")).click();
    }


    @Then("I go to Congratulations page")
    public void theCongratulationsPageIsShowed() throws InterruptedException{

        Thread.sleep(4000);
        String actualText = driver.findElement(By.xpath("//*[@id=\"layout\"]/section[3]/div/div[1]/h2")).getText();
        String expectedText = "Congratulations!";
        Assert.assertEquals(actualText,expectedText);


    }



//    public void setValue(String id, String value) {
//        WebElement myElement = driver.findElement(By.xpath(id));
//        String js = "arguments[0].setAttribute('value','"+value+"')";
//        ((JavascriptExecutor) driver).executeScript(js, myElement);
//    }

    @And("I select Account type is demo")
    public void iSelectAccountTypeIsDemo() throws InterruptedException {


        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".not-demo .btn-group > .form-control")).click();
        driver.findElement(By.linkText("Request a demo")).click();


    }

    @And("I input Fullname {string}")
    public void iInputFullname(String fullName) {
        this.fullName = fullName;
        driver.findElement(By.id("inputFullName")).sendKeys(fullName);
    }

    @Then("I go to Thank you page")
    public void iGoToThankYouPage() throws  InterruptedException{

        Thread.sleep(4000);
        String Actual = driver.findElement(By.xpath("//*[@id=\"layout\"]/section[3]/div/div[5]/h2")).getText();
        String Expected = "Thank you";
        Assert.assertEquals(Actual,Expected);
    }

    @And("I input Company address {string}")
    public void iInputCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        driver.findElement(By.xpath("//*[@id=\"divAddress\"]/div[1]/div/div/div/textarea")).sendKeys(companyAddress);
    }

    @And("I input Postcode {string}")
    public void iInputPostcode(String postCode) {
        this.postCode= postCode;
        driver.findElement(By.xpath("//*[@id=\"divAddress\"]/div[2]/div/div[1]/div/input")).sendKeys(postCode);

    }

    @And("I input VAT {string}")
    public void iInputVAT(String Vat) {
        this.Vat = Vat;
        driver.findElement(By.id("inputVATnr")).sendKeys(Vat);
    }

    @And("I input Referral Code {string}")
    public void iInputReferralCode(String referralCode) {
        this.referralCode = referralCode;
        driver.findElement(By.id("inputReferral")).sendKeys(referralCode);
    }

    @And("I select Account type is Light")
    public void iSelectAccountTypeIsLight() throws  InterruptedException{
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".not-demo .btn-group > .form-control")).click();
        driver.findElement(By.linkText("Light 150€/mo")).click();
    }

//    @After
//    public void cleanUp(){
//        driver.quit();
//    }

}
