package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class addToCartTest extends setup {

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


    }
    @Test(priority = 2)
    void addToCart() throws InterruptedException, IOException {
    addToCart.addCart();
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
    
    @AfterTest
    void tearDownTheSite(){


        driver.close();
    }

}