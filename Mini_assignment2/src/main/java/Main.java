import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //maximaize the window
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        Actions actions = new Actions(driver);

       //comparing the title of the page
        String title="PHPTRAVELS";
        String title2=driver.getTitle();
        if(title.equals(title2)){
            System.out.print("pass");
        }
        else{
            System.out.print("Fail");
        }

        driver.findElement(By.xpath("//a[text()='Login']")).click();
        //WebElement btnElement=driver.findElement(By.xpath("a[text()='Login']"));
        //actions.contextClick(btnElement).perform();

        String title_login=driver.getTitle();
        System.out.println(title_login);


        //switching back to the previous window

        String parentWindow=driver.getWindowHandle();
        driver.switchTo().window(parentWindow);

        //geting the url of the current page
        String url;
        url = driver. getCurrentUrl();
        System.out.println(url);

        //to click the pricing option
        WebElement btnElement_pricing=driver.findElement(By.xpath("//a[text()='Pricing']"));
        actions.contextClick(btnElement_pricing).perform();

        //navigating back to the home page

        driver.navigate().back();

        //refresing the page
       driver.navigate().refresh();


      //code to close the brower
        driver.quit();

    }
}