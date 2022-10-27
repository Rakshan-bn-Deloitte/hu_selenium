package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.phptravels.net/hotels");

        if(driver.findElement(By.xpath("//div[@class='logo']")).isDisplayed()){
            System.out.println("Relative xpath for PHPTRAVLES Logo");
        }
        if(driver.findElement(By.xpath("//a[@title='flights']")).isDisplayed()){
            System.out.println("Relative xpath for Flights");

        }
        if(driver.findElement(By.xpath("//a[@title='tours']")).isDisplayed()){
            System.out.println("Relative xpath for Tours");

        }
        if(driver.findElement(By.xpath("//a[@href='company']")).isDisplayed()){
            System.out.println("Relative xpath for company");

        }
        if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed()){
            System.out.println("Relative xpath for login button");

        }
        if(driver.findElement(By.xpath("/html/body/header/div/div/div/div/div/div/div/div/nav/ul/li/a[@title='flights']")).isDisplayed()){
            System.out.println("absolute  xpath for flights");

        }

        //xpath-axes
        if(driver.findElement(By.xpath("//i[@class='la la-minus']/parent::div")).isDisplayed()){
            System.out.println(" xpath -axes“- ” for Adults");

        }
        if(driver.findElement(By.xpath("//input[@id = 'checkin']//self::*")).isDisplayed()){
            System.out.println(" xpath -axes“- ” Check in - Calendar Icon");

        }
        if(driver.findElement(By.xpath("//div[@class='form-group']/child::input[@name='checkout']")).isDisplayed()){
            System.out.println(" xpath -axes“- ” Check out - Calendar Icon");

        }
        if(driver.findElement(By.xpath("//div/child::i[@class='la la-plus']")).isDisplayed()){
            System.out.println(" xpath -axes “- ” for Adults");

        }









    }
}