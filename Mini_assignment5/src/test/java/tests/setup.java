package tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public abstract class setup {

    @BeforeTest
    public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //headless mode of execution

        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        //maximaize the window
        driver.manage().window().maximize();

        //headless mode of execution


//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
//        //driver = new ChromeDriver(chromeOptions);
//        ChromeDriver driver = new ChromeDriver(chromeOptions );
        return driver;

    }

    public void failed(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\rakbn\\Desktop\\test1.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public abstract void onTestFailure(ITestResult result) throws IOException;
}
