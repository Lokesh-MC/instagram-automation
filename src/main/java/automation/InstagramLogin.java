package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class InstagramLogin {
    public static WebDriver login() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/config.properties"));

        System.setProperty("webdriver.chrome.driver", prop.getProperty("CHROMEDRIVER_PATH"));
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/accounts/login/");
        Thread.sleep(5000); // Let the page load

        driver.findElement(By.name("username")).sendKeys(prop.getProperty("INSTAGRAM_USERNAME"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("INSTAGRAM_PASSWORD"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000); // Wait to complete login
        return driver;
    }

    public static void main(String[] args) throws Exception {
        WebDriver driver = login();
        System.out.println("Logged in successfully!");
        Thread.sleep(10000); // So you can see it worked
        driver.quit(); // Or comment out to stay logged in
    }
}
