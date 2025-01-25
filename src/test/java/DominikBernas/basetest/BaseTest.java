package DominikBernas.basetest;

import DominikBernas.utils.DriverFactory;
import DominikBernas.utils.ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners(DominikBernas.utils.TestListener.class)
public class BaseTest {

    protected static ExtentTest test;
    protected static ExtentReports extent;
    protected static WebDriver driver;

    protected void LogStep(String message) {
        if (test != null) {
            test.info(message);
        }else{
            System.out.println("LogStep: "+message);
        }
    }


    @BeforeSuite
    public void setupSuite() {
        extent = ReportManager.getInstance();
    }
    @AfterSuite
    public void tearDownSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
    @BeforeMethod
    public void setUp(){
        boolean isHeadless = false;
        driver = DriverFactory.getDriver(isHeadless);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");


    }
    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }

}
