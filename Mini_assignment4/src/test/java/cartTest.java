import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class cartTest {
    @BeforeTest
    WebDriver setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //maximaize the window
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        return driver;

    }
    @Test(priority = 1)
    void login() throws IOException {
        WebDriver driver=setup();
        driver.get("https://www.saucedemo.com/");

        String excelpath="C:\\Users\\rakbn\\Desktop\\git\\hu_selenium\\Mini_assignment4\\src\\dataFiles\\loginData.xlsx";
        FileInputStream fs = new FileInputStream(excelpath);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        String userName=cell.getStringCellValue();
//        String userName="Rakshan";
//        String Password="12344";

        Cell cell2 = row.getCell(1);
        String Password=cell2.getStringCellValue();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input")).sendKeys(userName);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input")).click();

        //Add to cart

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
        //*[@class="inventory_item"][1]/div/div[2]/div

        //finding the element with lesser price
//        for(Integer i=1;i<=6;i++){
//            String val=i.toString();
//            Integer price1;
//
//
//            String xpath="//*[@class=\"inventory_item\"]"+"["+val+"]"+"/div/div[2]/div";
//            String price=driver.findElement(By.xpath(xpath)).getText();
//            price.substring(1, price.length() - 1);
//            price1=Integer.valueOf(price);
//            Integer larger=price1;
//            if(price1<100){
//
//            }
//
//            System.out.println(price);
//        }
        //clicking the remove button
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();

       //clicking on the cart icon
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();

        //clicking on the continue shoping

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]")).click();



        //clicking on the another element

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button")).click();

        //checking on the countof cart is increased or not
        String cartCount=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        Integer count=Integer.valueOf(cartCount);
        if(count>1){
            System.out.print("cart count is incresed");
        }
        //verifieing the cart count is mathched or not

        int iCount = 0;
        iCount = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[@class=\"cart_item\"]")).size();
        System.out.print("cart count is"+iCount);
      //clicking the checout button
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();

    //filing the data to the checkout information

        String excelpath2="C:\\Users\\rakbn\\Desktop\\git\\hu_selenium\\Mini_assignment4\\src\\dataFiles\\loginData.xlsx";
        FileInputStream fs2 = new FileInputStream(excelpath2);
        //Creating a workbook
        XSSFWorkbook workbook1 = new XSSFWorkbook(fs2);
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        Row row1 = sheet.getRow(1);
        Cell cell3 = row.getCell(2);
        String firstName=cell.getStringCellValue();

        Cell cell4 = row.getCell(3);
        String lastName=cell.getStringCellValue();

        Cell cell5 = row.getCell(4);
        String zip=cell.getStringCellValue();

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys(firstName);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys(lastName);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys(lastName);

        //clicking the finish option
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]")).click();

        String message=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText();
        if(message.equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("Pass");
        }
        else{
            System.out.println("Failed");
        }

        //*[@id="continue-shopping"]
        
    }

//    @Test(priority = 2)
//    void addToCart(){
//        WebDriver driver=setup();
//        d
//        //*[@id="add-to-cart-sauce-labs-backpack"]
//
//
//
//    }

    @AfterTest
    void tearDownTheSite(){
        WebDriver driver=setup();
        driver.close();
    }

}

