package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalculatorPage {
    WebDriver driver;
    By result = By.xpath("//div[@class='calccontainer']/descendant::input[@id='input']");


    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public void addNumbers(String number){
        //*[@id="Btn2"]
        String sNumber = String.format("//button[@id=\"Btn%s\"]",number);
        By buttonNumber = By.xpath(sNumber);
        driver.findElement(buttonNumber).click();
    }

    public void addCalculate(String cal){
        //String sCal = String.format("//button[text()='%s']",cal);
        String sCal = String.format("//button[@id=\"Btn%s\"]",cal);
        By buttonCal = By.xpath(sCal);
        driver.findElement(buttonCal).click();

    }

    public String getResult()
    {

        WebElement element = driver.findElement(result);
        // Wait for the element return value can parse to Integer
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // Condition to wait or return the value
        ExpectedCondition<Boolean> elementAttributeEqualsString = arg0 -> canParseValue(element.getAttribute("value"));
        // wait the value until the condition matched
        wait.until(elementAttributeEqualsString);

        // return latest value of element
        return element.getAttribute("value");
    }

    public Boolean canParseValue(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
