package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class loginPage {
    WebDriver driver;
    By loginButton = By.xpath("//*[@id=\"layout\"]/section[1]/div/ul[1]/li[1]/a[1]");
    By userNameInput = By.xpath("//*[@id=\"username\"]");
    By passwordLoginInput = By.id("password");
    By signInButton = By.id("kc-login");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void clickOnLoginButton() {

        driver.findElement(loginButton).click();

    }

    public void inputUsername(String emailAddress){

        ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(userNameInput).sendKeys(emailAddress);

    }

    public void inputPasswordLogin(String passwordLogin){

        driver.findElement(passwordLoginInput).sendKeys(passwordLogin);

    }

    public void clickOnSignInButton(){

        driver.findElement(signInButton).click();

    }

}