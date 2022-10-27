import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //maximaize the window
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");


       //comparing the title of the page
        String title="PHPTRAVELS";
        String title2=driver.getTitle();
        if(title.equals(title2)){
            System.out.println("pass");
        }
        else{
            System.out.println("Fail");
        }

        //driver.findElement(By.linkText("Login"));


        driver.get("https://phptravels.net/login");

        String title_login=driver.getTitle();
        if(title2.equals(title_login)){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }

        //codes to navigating back to the home page

        driver.navigate().back();

        // geting the url of the current page
        String url;
        url = driver. getCurrentUrl();
        System.out.println("Current url of the page is "+url);
       //click the pricing option
        driver.findElement(By.linkText("Pricing")).click();

        String url_login;
        url_login = driver. getCurrentUrl();
        System.out.println("Current url of the page is "+url_login);
        System.out.println("pricing menu is clicked");
        driver.navigate().back();


        // refresh the page
        driver.navigate().refresh();;
        //close the browser window
        driver.close();
    }
}