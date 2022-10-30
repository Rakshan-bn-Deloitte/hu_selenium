import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class setUp {
    @BeforeTest
    WebDriver setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //maximaize the window
        driver.manage().window().maximize();
        return driver;

    }


}
