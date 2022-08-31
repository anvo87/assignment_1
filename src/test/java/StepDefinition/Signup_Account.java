package StepDefinition;


//import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
//import sun.plugin.javascript.navig.Document;

import Pages.SignUpPage;
import Pages.LoginPage;
import Ultilities.*;
import Base.BaseSetup;

public class Signup_Account extends BaseSetup {
    WebDriver driver;
    //String URL ="https://www.idloom.com/en/events/why-idloom-events?utm_source=GetApp";
//    String firstName;
//    String lastName;
//    String email;
//    String password;
//    String confirmPassword;
//    String companyName;
//    String phone;
//    String fullName;
//    String companyAddress;
//    String postCode;
//    String vat;
//    String referralCode;
//    String userName;
    public SignUpPage signUpPage;
    public LoginPage loginPage;
    private static String propertiesFilePathRoot = "src/test/resources/Configs/configs.properties";




//   @Before
//   public void setDriver(){
//       PropertiesFileReader.setProperties(propertiesFilePathRoot);
//       driver = new BaseSetup().setDriver(PropertiesFileReader.getPropValue("browserType"), PropertiesFileReader.getPropValue("appURL"));
//
//   }


    @Given("I go to the Idloom page")
    public void iGoToTheIdloomPage() {
//        driver.get(URL);
    }

    @When("I click on Signup button")
    public void iClickOnSignupButton() {
        //driver.findElement(By.xpath("//*[@id=\"layout\"]/section[1]/div/ul[1]/li[1]/a[2]")).click();
        signUpPage= new SignUpPage(driver);
        signUpPage.clickOnSignupButton();
    }

    @And("I input Firstname {string}")
    public void iInputFirstname(String firstName) throws InterruptedException{

          Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, 4);
//        wait.until(ExpectedConditions.textToBePresentInElement(By.id("signUpPricing")));
          //this.firstName = firstName;
          //driver.findElement(By.id("inputFirstName")).sendKeys(firstName);
          signUpPage.inputFirstname(firstName);

    }
    @And("I input Lastname {string}")
    public void iInputLastname(String lastName) {

        //this.lastName = lastName;
        //driver.findElement(By.id("inputLastName")).sendKeys(lastName);
        signUpPage.inputLastname(lastName);

    }


    @And("I input Email address {string}")
    public void iInputEmailAddress(String email) {
        //this.email = email;
        //driver.findElement(By.id("inputEmailAddress")).sendKeys(Email);
        signUpPage.inputEmailAddress(email);
    }

    @And("I input Password {string}")
    public void iInputPassword(String password) {
        //this.password = password;
        //driver.findElement(By.id("inputPassword")).sendKeys(Password);
        signUpPage.inputPassword(password);
    }

    @And("I input Confirm password {string}")
    public void iInputConfirmPassword(String confirmPassword) {
        //this.confirmPassword = confirmPassword;
        //driver.findElement(By.id("inputConfirmPassword")).sendKeys(confirmPassword);
        signUpPage.inputConfirmPassword(confirmPassword);
    }

    @And("I input Company name {string}")
    public void iInputCompanyName(String companyName) {
        //this.companyName = companyName;
        //driver.findElement(By.id("inputCompanyName")).sendKeys(companyName);
        signUpPage.inputCompanyName(companyName);
    }

    @And("I input Phone {string}")
    public void iInputPhone(String phone) {
        //this.phone = phone;
        //driver.findElement(By.id("inputPhone")).sendKeys(Phone);
        signUpPage.inputPhone(phone);
    }

    @And("I checked I accept checkbox")
    public void iCheckedIAcceptCheckbox() {
        //driver.findElement(By.xpath("//*[@id=\"signUpEventsForm\"]/fieldset[6]/div/div/input")).click();
        signUpPage.checkedIAcceptCheckbox();
    }

    @And("I click on Got it button")
    public void iClickOnGotItButton() {
//        Move to the current component

//        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/a[1]"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).perform();
        //driver.findElement(By.xpath("/html/body/div[1]/div/a[1]")).click();
        signUpPage.clickOnGotItButton();
    }

    @And("I click on the button")
    public void iClickOnTheButton() {

        //driver.findElement(By.id("submitEventBtn")).click();
        signUpPage.clickOnTheButton();
    }


    @Then("I go to Congratulations page")
    public void theCongratulationsPageIsShowed() throws InterruptedException{

        Thread.sleep(4000);
        //String actualText = driver.findElement(By.xpath("//*[@id=\"layout\"]/section[3]/div/div[1]/h2")).getText();
        String actualText = signUpPage.getCongratulation();
        String expectedText = "Congratulations!";
        Assert.assertEquals(actualText,expectedText);


    }

    @And("I select Account type is demo")
    public void iSelectAccountTypeIsDemo() throws InterruptedException {


        Thread.sleep(2000);

        //driver.findElement(By.cssSelector(".not-demo .btn-group > .form-control")).click();
        //driver.findElement(By.linkText("Request a demo")).click();
        signUpPage.selectAccountTypeIsDemo();

    }

    @And("I input FullName {string}")
    public void iInputFullName(String fullName) {
        //this.fullName = fullName;
        //driver.findElement(By.id("inputFullName")).sendKeys(fullName);
        signUpPage.inputFullName(fullName);
    }

    @Then("I go to Thank you page")
    public void iGoToThankYouPage() throws  InterruptedException{

        Thread.sleep(4000);
        //String Actual = driver.findElement(By.xpath("//*[@id=\"layout\"]/section[3]/div/div[5]/h2")).getText();
        String Actual = signUpPage.getThankYou();
        String Expected = "Thank you";
        Assert.assertEquals(Actual,Expected);
    }

    @And("I input Company address {string}")
    public void iInputCompanyAddress(String companyAddress) {
        //this.companyAddress = companyAddress;
        //driver.findElement(By.xpath("//*[@id=\"divAddress\"]/div[1]/div/div/div/textarea")).sendKeys(companyAddress);
        signUpPage.inputCompanyAddress(companyAddress);
    }

    @And("I input Postcode {string}")
    public void iInputPostcode(String postCode) {
        //this.postCode= postCode;
        //driver.findElement(By.xpath("//*[@id=\"divAddress\"]/div[2]/div/div[1]/div/input")).sendKeys(postCode);
        signUpPage.inputPostcode(postCode);

    }

    @And("I input VAT {string}")
    public void iInputVAT(String vat) {
        //this.vat = vat;
        //driver.findElement(By.id("inputVATnr")).sendKeys(Vat);
        signUpPage.inputVAT(vat);
    }

    @And("I input Referral Code {string}")
    public void iInputReferralCode(String referralCode) {
        //this.referralCode = referralCode;
        //driver.findElement(By.id("inputReferral")).sendKeys(referralCode);
        signUpPage.inputReferralCode(referralCode);
    }

    @And("I select Account type is Light")
    public void iSelectAccountTypeIsLight() throws  InterruptedException{
        Thread.sleep(2000);

        //driver.findElement(By.cssSelector(".not-demo .btn-group > .form-control")).click();
        //driver.findElement(By.linkText("Light 150€/mo")).click();
        signUpPage.selectAccountTypeIsLight();
    }

    @And("I click on Login button")
    public void iClickOnLoginButton() throws  InterruptedException{
        Thread.sleep(2000);

        loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
    }

    @And("I input Username {string}")
    public void iInputUsername(String emailAddress) throws  InterruptedException {
        Thread.sleep(2000);
        //this.userName = emailAddress;
        loginPage.inputUsername(emailAddress);
    }

    @And("I input Password for Login page {string}")
    public void iInputPasswordForLoginPage(String password) {
        //this.password = password;
        loginPage.inputPasswordLogin(password);
    }

    @And("I click on Sign In button")
    public void iClickOnSignInButton() {
        loginPage.clickOnSignInButton();
    }

//    @After
//    public void cleanUp(){
//        driver.quit();
//    }

}
