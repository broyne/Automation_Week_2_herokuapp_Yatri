package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();  //Launch the chrome driver
        driver.get(baseUrl);  //Open URL into browser
        driver.manage().window().maximize(); //Maximise browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Implicit wait to driver
    }

    public void closeBrowser() {
        driver.quit();
    }
}
