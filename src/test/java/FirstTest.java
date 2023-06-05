import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    WebDriver wd;
    String browser = "Chrome";
    @Test
    public void searchWebDriverTest(){
        if(browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            wd = new FirefoxDriver();
        }
        if(browser.equals("Chrome")){
   //         WebDriverManager.chromedriver().setup();
            wd = new ChromeDriver();
        }
        if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            wd = new EdgeDriver();
        }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://www.google.com");
        wd.findElement(By.name("q")).sendKeys("Webdriver"+ Keys.ENTER);
        System.out.println(wd.getCurrentUrl());
        wd.navigate().to("https://www.saucedemo.com/");
        wd.findElement(By.name("user-name")).sendKeys("standard_user");
        wd.findElement(By.name("password")).sendKeys("secret_sauce");
        wd.findElement(By.id("login-button")).click();
    }
}
