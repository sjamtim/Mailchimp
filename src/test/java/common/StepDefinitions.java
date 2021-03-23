package common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StepDefinitions {

    WebDriver driver;

    @Given("User have navigated to the website")
    public void userHaveNavigatedToTheWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
    }
    @Given("Register {int} random user")
    public void registerRandomUser(int randomUser) throws InterruptedException {
        WebElement searchBoxEmail = driver.findElement(By.cssSelector("input[type=email]"));
        searchBoxEmail.sendKeys(Integer.toString(randomUser));
        searchBoxEmail.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }

}

