package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.IOException;

@Listeners(addToCartTest.class)

public class addToCartTest extends setup implements ITestNGListener, loginTestlistener{
    ExtentHtmlReporter htmlReporter;

    ExtentReports extent;
    //helps to generate the logs in the test report.
    ExtentTest test;

    //log4j implementation

   Logger logger1= LogManager.getLogger(addToCartTest.class);



    @BeforeTest
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\rakbn\\Desktop\\testreport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }





    WebDriver driver=setup();

    addToCart addToCart=new addToCart(driver);
    checkOutPage checkOutPage=new checkOutPage(driver);

//    void setup() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        //maximaize the window
//        driver.manage().window().maximize();
//
//    }
    @Test(priority = 1)
    public void Login() throws IOException {
        loginTest loginTest=new loginTest();
        loginTest.Login(driver);
        //excentreport
        test = extent.createTest("Test Case 1", "The test case 1 has passed");
        Assert.assertTrue(true);

        logger1.info("login test is executed ");




    }
    @Test(priority = 2)
    void addToCart() throws InterruptedException, IOException {
    addToCart.addCart();
    logger1.info("addTo cart test is passed");

    }
    @Test(priority = 3)
    void chekingRemoveButton(){
        addToCart.chekingRemoveButton();
    }
    @Test(priority = 4)
    void lickingOnCartIcon() throws InterruptedException {
        addToCart.clickingOnCartIcon();
    }
    @Test(priority = 5)
    void clickingOnContinueShoping(){
        addToCart.clickingOnContinueShoping();
    }
    @Test(priority = 6)
    void AddingAnotherElementToCart() throws InterruptedException {
        addToCart.AddingAnotherElementToCart();

    }
   @Test(priority = 7)
    void checkinForCartCount(){
        addToCart.checkinForCartCount();
    }
    @Test(priority =8)
    void clickingCheckOutButton(){
        checkOutPage.clickingCheckOutButton();
    }
    @Test(priority = 9)
    void fllingCheckOutInformation() throws IOException {
        checkOutPage.fllingCheckOutInformation();
    }
   @Test(priority = 10)
    void finishShoping() {
        checkOutPage.finishShoping();
    }
    public void failed() throws IOException {
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile,new File("C:\\Users\\rakbn\\Desktop"));

        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    @Test
    void takeScreenshotTest(){

        Assert.assertEquals(false,true);
        logger1.info("screenshot is taken");




    }

    @AfterTest
    void tearDownTheSite(){
        extent.flush();
        driver.close();
    }

    @Override
    public void onTestSucess(ITestResult result){
        test = extent.createTest("Test Case 1", "The test case 1 has passed");
        Assert.assertTrue(true);

    }

    @Override

    public void onTestFailure(ITestResult result) throws IOException {
        System.out.println("Test failed" + result.getName());
        failed(driver);

    }

}