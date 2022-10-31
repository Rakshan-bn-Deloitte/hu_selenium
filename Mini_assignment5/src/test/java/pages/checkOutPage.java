package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class checkOutPage {
    WebDriver driver;
    public checkOutPage(WebDriver driver){
        this.driver=driver;

    }



    public void clickingCheckOutButton(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();

        //driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[1]")).click();

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();

    }

    public void fllingCheckOutInformation() throws IOException {

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

   public  void finishShoping(){
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


}
