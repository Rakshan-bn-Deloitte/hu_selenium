package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class loginPage {
    WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver=driver;
    }
    public void login(WebDriver driver) throws IOException {

        driver.get("https://www.saucedemo.com/");

        String excelpath="C:\\Users\\rakbn\\Desktop\\git\\hu_selenium\\Mini_assignment5\\src\\dataFiles\\loginData.xlsx";
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


}
