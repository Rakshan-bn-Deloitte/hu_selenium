import org.openqa.selenium.Alert;
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
        // Scenario 1 in miniassignment-3
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement s = driver.findElement(By.xpath("//html/body"));
        String text=s.getText();
        System.out.println(text);
        //driver.close();

      //senario-2 in miniassignment3
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions act = new Actions(driver);
        act.dragAndDrop(from,to).build().perform();

        //senario-3

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[29]/a")).click();
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        String currentUrl = driver. getCurrentUrl();
        driver.get(currentUrl);
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert al = driver.switchTo().alert();
        al.sendKeys("Test");
        System.out.println(al.getText());
        al.accept();

    //senario-4
        //driver.get("https://www.goibibo.com/");





    }
}