import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.get("https://www.saucedemo.com/");
        return driver;

    }
    @Test
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






    }

}

