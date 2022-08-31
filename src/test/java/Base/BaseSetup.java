package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver;
    //static String driverPath = "src\\test\\resources\\drivers";

    public WebDriver getDriver() {
        return driver;
    }

   // public BaseSetup(){this.driver = setDriver("chrome","https://www.google.com/");}
    public WebDriver setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        //System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser...");
        //System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
   // @Parameters({"browserType", "appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {

           // setDriver(browserType, appURL);

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}
