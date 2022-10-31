package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;

import java.io.IOException;

public class loginTest implements ITestNGListener, loginTestlistener {
    WebDriver driver;
    loginPage loginpage;
    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //maximaize the window
        driver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void Login(WebDriver driver) throws IOException {
        loginPage loginPage=new loginPage(driver);
        loginPage.login(driver);

    }
    @Override
    public void onTestSucess(ITestResult result){
        driver.close();

    }

}
