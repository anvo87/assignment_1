package Pages;

import Base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchGooglePage{
    WebDriver driver;

    By searchInput = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
    //By listResultParent = By.cssSelector("div[class='v7W49e']");
    //By listResultChildren = By.cssSelector("div[class='MjjYud']");
    By getTitleResult = By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']");
    By getListSuggestion = By.cssSelector("li[class='sbct']");
    By googleSearchButton =By.name("btnK");


    public SearchGooglePage(WebDriver driver){
        this.driver = driver;
    }

    public void inputKeyword(String keyword) {

        driver.findElement(searchInput).sendKeys(keyword);
    }
    public void enterKeyword(){
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }


    public String getFirstResult(){
      //  WebElement web = driver.findElement(listResultParent);
        // List <WebElement> list = driver.findElements(listResultChildren);
        List <WebElement> listTitle = driver.findElements(getTitleResult);

//        for(int i =0 ; i< list.size() ; i++) {
//            String result = list.get(i).getText();
//            //System.out.println(result);
//            if (i==0){
//                String resultFirst = list.get(i).getText();
//                System.out.println(resultFirst);
//            }
//
//        }
        String result = listTitle.get(0).getText();
        System.out.println(result);
        return result;
    }

    public void selectFirstSuggestion(){
        List <WebElement> listSuggestion = driver.findElements(getListSuggestion);

        String result =listSuggestion.get(0).getText();
        listSuggestion.get(0).click();


    }
    public void checkGoogleSearchButtonExist(){
        boolean button = driver.findElement(googleSearchButton).isEnabled();
        if (button){
            System.out.println("Google Search Button is present");
        }else {
            System.out.println("Google Search Button is not present");
        }

    }
}
