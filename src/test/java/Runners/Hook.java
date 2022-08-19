package Runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    WebDriver driver;
    @Before
    public void hook(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1 - Maximum browser
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}

//public void BeforeScenario() {
//    String webdriver = System.getProperty("webdriver", "firefox");
//        switch (webdriver) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "opera":
//                WebDriverManager.operadriver().setup();
//                driver = new OperaDriver();
//                break;
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                break;
//            case "ie":
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
//            default:
//                throw new RuntimeException("Unsupported webdriver" + webdriver);
//        }
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//}