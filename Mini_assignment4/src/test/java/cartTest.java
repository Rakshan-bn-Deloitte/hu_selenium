import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class cartTest extends setUp {

   WebDriver driver=setup();
    @Test(priority = 1)
    void login() throws IOException {

        driver.get("https://www.saucedemo.com/");

        String excelpath="C:\\Users\\rakbn\\Desktop\\git\\hu_selenium\\Mini_assignment4\\src\\dataFiles\\loginData.xlsx";
        FileInputStream fs = new FileInputStream(excelpath);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        String userName=cell.getStringCellValue();


        Cell cell2 = row.getCell(1);
        String Password=cell2.getStringCellValue();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input")).sendKeys(userName);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")).click();






    }

    @Test(priority = 2)
    void addToCart() throws IOException, InterruptedException {
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

    @Test(priority = 3)
    void chekingRemoveButton() {
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
    @Test(priority = 4)
    void clickingOnCartIcon() throws InterruptedException {


        WebElement cartIcon = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        try {
            Assert.assertTrue(cartIcon.isDisplayed() && cartIcon.isEnabled());
            System.out.println("cart icon is enabled & displayed");
        } catch (Exception e) {
            System.out.println("cart icon is  not enabled & displayed");

            driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        }
    }
    @Test(priority = 5)
    void clickingOnContinueShoping(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]")).click();

    }
    @Test(priority = 6)
    void AddingAnotherElementToCart() throws InterruptedException {
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
    @Test(priority = 7)
    void checkinForCartCount(){
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
    @Test(priority = 8)
    void clickingCheckOutButton(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();

        //driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]")).click();

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();







    }

    @Test(priority = 9)

    void fllingCheckOutInformation() throws IOException {

        String excelpath2="C:\\Users\\rakbn\\Desktop\\git\\hu_selenium\\Mini_assignment4\\src\\dataFiles\\loginData.xlsx";
        FileInputStream fs2 = new FileInputStream(excelpath2);
        //Creating a workbook
        XSSFWorkbook workbook1 = new XSSFWorkbook(fs2);
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        Row row1 = sheet1.getRow(1);
        Cell cell3 = row1.getCell(2);
        String firstName=cell3.getStringCellValue();

        Cell cell4 = row1.getCell(3);
        String lastName=cell4.getStringCellValue();

        Cell cell5 = row1.getCell(4);

        double zip= cell5.getNumericCellValue();
        String zipValue = Double.toString(zip);

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys(firstName);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys(lastName);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys(zipValue);

    }
    @Test(priority = 10)
    void finishShoping(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();

       //verifying cart price
//        String price1=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
//
//        price1 =price1.replace("$","");
//
//        int priceValue1 = Integer.parseInt(price1.substring(0,price1.indexOf(".")));
//
//
//        String price2=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
//        price2 =price2.replace("$","");
//        int priceValue2 = Integer.parseInt(price2.substring(0,price1.indexOf(".")));
//
//        int totalPrice=priceValue1+priceValue2;
//
//
//        String totalPrice2=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[5]")).getText();
//        price2 =totalPrice2.replace("$","");
//        int totalPriceCheckOut = Integer.parseInt(price2.substring(0,price1.indexOf(".")));
//        if(totalPriceCheckOut==totalPrice){
//            System.out.println("Amount is verified");
//        }


        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]")).click();

        String message=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText();
        if(message.equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("Pass");
        }
        else{
            System.out.println("Failed");
        }

    }





    @AfterTest
    void tearDownTheSite(){


        driver.close();
    }

}

