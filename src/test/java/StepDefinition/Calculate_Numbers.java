package StepDefinition;

import Base.BaseSetup;
import Pages.CalculatorPage;
import Pages.SearchGooglePage;
import Ultilities.PropertiesFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Calculate_Numbers extends BaseSetup{
    WebDriver driver;
    public CalculatorPage calculatorPage;
    private static String propertiesFilePathRoot = "src/test/resources/Configs/configs.properties";
    String number1;
    String number2;
    String number3;
    String number4;
    String cal;
    String result;



    @Before
    public void setDriver(){
        PropertiesFileReader.setProperties(propertiesFilePathRoot);
        driver = new BaseSetup().setDriver(PropertiesFileReader.getPropValue("browserType"), PropertiesFileReader.getPropValue("calcURL"));

    }

    @Given("I go to Calculator page")
    public void iGoToCalculatorPage() {
        calculatorPage = new CalculatorPage(driver);
    }


    @And("I select first number {string}")
    public void iSelectFirstNumberAndSecondNumber(String number1) {
        this.number1 = number1;
//        int number1IntDozens= Integer.parseInt(number1)/10;
//        int number1IntUnit =  Integer.parseInt(number1)%10;
//        // 1234
//        // ['1', 2, 3,4]
        Integer length = number1.length();
        for (int i = 0; i < length; i++) {
            calculatorPage.addNumbers(String.valueOf(number1.charAt(i)));
        }
    }

    @And("I select calculate {string}")
    public void iSelectCalculate(String cal) {
        this.cal = cal;
        calculatorPage.addCalculate(cal);
    }

    @And("I select second number {string}")
    public void iSelectThirdNumberAndFourNumber(String number2) {
        this.number2 = number2;
//        int number2IntDozens= Integer.parseInt(number2)/10;
//        int number2IntUnit = Integer.parseInt(number2)%10;
//
//        calculatorPage.addNumbers(String.valueOf(number2IntDozens));
//        calculatorPage.addNumbers(String.valueOf(number2IntUnit));

        Integer length = number2.length();
        for (int i = 0; i < length; i++) {
            calculatorPage.addNumbers(String.valueOf(number2.charAt(i)));
        }

    }

    @And("I select equal")
    public void iSelectEqual() {
        calculatorPage.addCalculate("Calc");
    }


    @Then("I verify the result equal {string}")
    public void iVerifyTheResultEqual(String result) {
        this.result = result;
        int expectedResult = Integer.parseInt(result);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String getResult = calculatorPage.getResult();
        int actualResult = Integer.parseInt(getResult);

        if(actualResult==expectedResult){
            System.out.println("the result is passed");
        }
        else {
            System.out.println("the result is failed");
        }


    }
}
