import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakbn\\Desktop\\webdriver_basics\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //maximaize the window
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement s = driver.findElement(By.xpath("//html/body"));
        String text=s.getText();




        System.out.println(text);
    }
}