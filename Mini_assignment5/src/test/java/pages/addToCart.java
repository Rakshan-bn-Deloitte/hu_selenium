package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class addToCart {
    WebDriver driver;

    public addToCart(WebDriver driver){
        this.driver=driver;
    }
    public void addCart() throws InterruptedException, IOException {
        loginPage log=new loginPage(driver);
        log.login(driver);

        WebElement filter = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select"));
        filter.click();

        Thread.sleep(2000);
        WebElement pricesort = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/span/select/option[4]"));
        pricesort.click();
        Thread.sleep(2000);
        WebElement highestproduct = driver.findElement(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][1]"));
        try {
            Assert.assertTrue(highestproduct.isDisplayed()&&highestproduct.isEnabled());
            System.out.println("Highest product is displayed");
        } catch (Exception e) {
            System.out.println("Highest product is not displayed");
        }
        Thread.sleep(2000);
        WebElement addtoCartEnable = driver.findElement(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][1]"));
        try {
            Assert.assertTrue(addtoCartEnable.isDisplayed()&&addtoCartEnable.isEnabled());
            System.out.println("add to cart button is enabled and displayed");
        } catch (Exception e) {
            System.out.println("add to cart button is not enabled & not displayed");
        }
        Thread.sleep(2000);
        String ProductPriceVerify = driver.findElement(By.xpath("//div[@class='inventory_item_price'][1]")).getText();
        int limit = 100;
        ProductPriceVerify =ProductPriceVerify.replace("$","");
        int priceValue = Integer.parseInt(ProductPriceVerify.substring(0,ProductPriceVerify.indexOf(".")));
        if( limit > priceValue)
            System.out.println("It is less than 100");
        else
            System.out.println("It i greater tahn 100");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();


    }


    public void chekingRemoveButton() {
        WebElement removeButton=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button"));

        try {
            Assert.assertTrue(removeButton.isDisplayed() && removeButton.isEnabled());
            System.out.println("Remove Button is enabled & displayed");
        } catch (Exception e) {
            System.out.println("Remove Button is not enabled & displayed");
        }
        removeButton.click();
        //driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
    }
    public void clickingOnCartIcon() throws InterruptedException {


        WebElement cartIcon = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        try {
            Assert.assertTrue(cartIcon.isDisplayed() && cartIcon.isEnabled());
            System.out.println("cart icon is enabled & displayed");
        } catch (Exception e) {
            System.out.println("cart icon is  not enabled & displayed");

            driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        }
    }


    public void clickingOnContinueShoping(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]")).click();

    }





    public void AddingAnotherElementToCart() throws InterruptedException {
        WebElement pricesortt = driver.findElement(By.xpath("//select[@class='product_sort_container']/option[3]"));
        pricesortt.click();
        Thread.sleep(2000);
        WebElement leastproduct = driver.findElement(By.xpath("//div[@class='inventory_list']/div[@class='inventory_item'][1]"));
        try {
            Assert.assertTrue(leastproduct.isDisplayed() && leastproduct.isEnabled());
            System.out.println("least product is displayed");
        } catch (Exception e) {
            System.out.println("least product is not displayed");
        }

        Thread.sleep(2000);
        WebElement leastExpensiveProduct = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button"));
        leastExpensiveProduct.click();
        //driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();
    }
    public void checkinForCartCount(){
        String cartCount=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        Integer count=Integer.valueOf(cartCount);
        if(count>1){
            System.out.print("cart count is incresed");
        }
        //verifieing the cart count is mathched or not

        int iCount = 0;
        iCount = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[@class=\"cart_item\"]")).size();
        System.out.print("cart count is"+iCount);
    }



}
