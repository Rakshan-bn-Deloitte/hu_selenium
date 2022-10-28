import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
      //Click on JavaScript
        driver.findElement(By.xpath("//a[@href='/javascript_alerts']")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
     //Comparing the Text Entered

        String str = "Test";
        driver.switchTo().alert().sendKeys(str);
        driver.switchTo().alert().accept();
        String str1 = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(str);
        if (str.equals("You have entered: " + str)) {
            System.out.println("Similar text entered,pass");
        }


    //senario-4
        //driver.get("https://www.goibibo.com/");
        WebDriver driver4=new ChromeDriver();
        driver4.get( "https://www.goibibo.com/");
        driver4.manage().window().maximize();
        WebElement webElement = driver4.findElement(By.id("sc-giYglK eCwiKJ fswWidgetPlaceholder"));

        Actions action = new Actions(driver4);
        action.moveToElement(webElement).click().perform();





    }
}