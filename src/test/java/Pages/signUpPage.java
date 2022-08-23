package Pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.language.bm.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class signUpPage {
    WebDriver driver;
    By signUp = By.xpath("//*[@id=\"layout\"]/section[1]/div/ul[1]/li[1]/a[2]");
    By firstNameInput = By.id("inputFirstName");
    By lastNameInput = By.id("inputLastName");
    By emailInput = By.id("inputEmailAddress");
    By passwordInput = By.id("inputPassword");
    By confirmPasswordInput = By.id("inputConfirmPassword");
    By companyNameInput = By.id("inputCompanyName");
    By phoneInput = By.id("inputPhone");
    By acceptCheckbox = By.xpath("//*[@id=\"signUpEventsForm\"]/fieldset[6]/div/div/input");
    By gotItButton = By.xpath("/html/body/div[1]/div/a[1]");
    By submitButton = By.id("submitEventBtn");
    By accountType = By.cssSelector(".not-demo .btn-group > .form-control");
    By demoType = By.linkText("Request a demo");
    By fullNameInput = By.id("inputFullName");
    By companyAddressInput = By.xpath("//*[@id=\"divAddress\"]/div[1]/div/div/div/textarea");
    By postCodeInput = By.xpath("//*[@id=\"divAddress\"]/div[2]/div/div[1]/div/input");
    By vatInput = By.id("inputVATnr");
    By referralCodeInput = By.id("inputReferral");
    By lightType = By.linkText("Light 150€/mo");
    By thankYouPage = By.xpath("//*[@id=\"layout\"]/section[3]/div/div[5]/h2");
    By congratulationPage = By.xpath("//*[@id=\"layout\"]/section[3]/div/div[1]/h2");


    public signUpPage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public  String getSignuppageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void gotoIDloompage() {

//        driver.navigate().to(URL);
        String URL ="https://www.idloom.com/en/events/why-idloom-events?utm_source=GetApp";
        driver.get(URL);
    }


    public void clickOnSignupButton() {

        driver.findElement((signUp)).click();
    }


    public void inputFirstname(String firstName) throws InterruptedException{

        Thread.sleep(2000);
        driver.findElement(firstNameInput).sendKeys(firstName);

    }

    public void inputLastname(String lastName) {

        driver.findElement(lastNameInput).sendKeys(lastName);

    }


    public void inputEmailAddress(String Email) {

        driver.findElement(emailInput).sendKeys(Email);
    }


    public void inputPassword(String Password) {

        driver.findElement(passwordInput).sendKeys(Password);
    }


    public void inputConfirmPassword(String confirmPassword) {

        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }


    public void inputCompanyName(String companyName) {

        driver.findElement(companyNameInput).sendKeys(companyName);
    }


    public void inputPhone(String Phone) {
        driver.findElement(phoneInput).sendKeys(Phone);
    }


    public void checkedIAcceptCheckbox() {
        driver.findElement(acceptCheckbox).click();
    }


    public void clickOnGotItButton() {
        driver.findElement(gotItButton).click();
    }


    public void clickOnTheButton() {

        driver.findElement(submitButton).click();
    }

    public String getCongratulation() throws InterruptedException{

        Thread.sleep(4000);
        String actualText = driver.findElement(congratulationPage).getText();
        return actualText;

    }


    public void selectAccountTypeIsDemo() throws InterruptedException {


        Thread.sleep(2000);

        driver.findElement(accountType).click();
        driver.findElement(demoType).click();


    }


    public void inputFullname(String fullName) {

        driver.findElement(fullNameInput).sendKeys(fullName);
    }


    public String getThankYou() throws  InterruptedException{

        Thread.sleep(4000);
        String actualText = driver.findElement(thankYouPage).getText();
        return actualText;
    }


    public void inputCompanyAddress(String companyAddress) {

        driver.findElement(companyAddressInput).sendKeys(companyAddress);
    }


    public void inputPostcode(String postCode) {

        driver.findElement(postCodeInput).sendKeys(postCode);

    }


    public void inputVAT(String Vat) {

        driver.findElement(vatInput).sendKeys(Vat);
    }


    public void inputReferralCode(String referralCode) {

        driver.findElement(referralCodeInput).sendKeys(referralCode);
    }


    public void selectAccountTypeIsLight() throws  InterruptedException{
        Thread.sleep(2000);

        driver.findElement(accountType).click();
        driver.findElement(lightType).click();
    }



}
