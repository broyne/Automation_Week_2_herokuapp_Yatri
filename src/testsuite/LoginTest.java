package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //Enter username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Enter password
        driver.findElement(By.className("fa-sign-in")).click();
        String expectedLoginText = "Secure Area"; //expected Result
        String actualLoginText = driver.findElement(By.xpath("//h2")).getText(); //Actual Result
        Assert.assertEquals("Invalid Details", expectedLoginText, actualLoginText); //Compare both Result
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith1"); //Enter username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Enter password
        driver.findElement(By.className("fa-sign-in")).click();
        String expectedErrorText = "Your username is invalid!\n×"; //expected Result
        String actualErrorText = driver.findElement(By.id("flash")).getText(); //Actual Result
        Assert.assertEquals("Invalid Username", expectedErrorText, actualErrorText); //Compare both Result

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //Enter username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword"); //Enter password
        driver.findElement(By.className("fa-sign-in")).click();
        String expectedPasswordErrorText = "Your password is invalid!\n" + "×"; //expected Result
        String actualPasswordErrorText = driver.findElement(By.id("flash")).getText(); //Actual Result
        Assert.assertEquals("Invalid password", expectedPasswordErrorText, actualPasswordErrorText); //Compare both Result
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
