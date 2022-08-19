package stepDefinition;

import Runners.Hook;
import Runners.Run;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_account {

    WebDriver driver;
    String URL ="https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";

    String Firstname;
    String Lastname;
    String Username;
    String Password;
    String Confirm;
    String Phonenumber;

    @Before
    public void hook(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //1 - Maximum browser
        driver.manage().window().maximize();
    }

    @Given("The website is showed")
    public void theWebsiteIsShowed() {

        //2- Open web
        driver.navigate().to(URL);

        //3 - Get title and print console
        //System.out.println(driver.getTitle());

        //Thread.sleep(2000);

        //Quit Browser
        //driver.quit();
    }

    @When("User input valid Firstname {string}")
    public void userInputValidFirstName(String Firstname) {
        //Object WebElement
        //button, input, link, dropdown, dialog, header_Page

                this.Firstname = Firstname;
        driver.findElement(By.id("firstName")).sendKeys(Firstname);


    }

    @And("User input valid Lastname {string}")
    public void userInputValidLastName(String Lastname) {

        this.Lastname = Lastname;
        driver.findElement(By.id("lastName")).sendKeys(Lastname);
    }

    @And("User input valid Username {string}")
    public void userInputValidUserName(String Username) {

        this.Username = Username;
        driver.findElement(By.id("username")).sendKeys(Username);

    }
    @And("User input valid Password {string}")
    public void userInputValidPassword(String Password) {

        this.Password = Password;
        driver.findElement(By.name("Passwd")).sendKeys(Password);

    }
    @And("User input valid Confirm {string}")
    public void userInputValidConfirm(String Confirm) {

        this.Confirm = Confirm;
        driver.findElement(By.name("ConfirmPasswd")).sendKeys(Confirm);

    }

    @And("User click on Next button")
    public void userClickOnNextButton() {

        //String xpath = "//*[@id=\"accountDetailsNext\"]";
        driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button")).click();

    }

    @Then("Verify your fone number page is showed")
    public void VerifyYourFoneNumberPageIsShowed(){
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Create your Google Account";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @When("User input valid Phonenumber {string}")
    public void userInputValidPhonenumber(String Phonenumber) throws InterruptedException {

        Thread.sleep(2000);
        this.Phonenumber = Phonenumber;
        driver.findElement(By.id("phoneNumberId")).sendKeys(Phonenumber);

    }
    @And("User click on Next button again")
    public void userClickOnNextButtonAgain() {

        driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")).click();

    }
    @Then("The third page is showed")
    public void TheThirdPageIsShowed(){
        String Acutaltext = driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]")).getText();
        String ExpectedText= "For your security, Google wants to make sure it’s really you. Google will send a text message with a 6-digit verification code.";
        Assert.assertEquals(Acutaltext,ExpectedText);
    }

}
