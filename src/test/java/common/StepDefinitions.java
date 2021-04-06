package common;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    private Generators gen;

    @Given("user have navigated to the website")
    public void userHaveNavigatedToTheWebsite() {
        Browsers web = new Browsers();
        gen = new Generators();
        driver = web.getBrowser("chrome");
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
    }
    @Given("user writes an email")
    public void userWritesAnEmail() {
        WebElement emailBox = driver.findElement(By.cssSelector("input[type=email]"));
        emailBox.sendKeys(gen.letter() + gen.unixTime() + "@mail.com");
    }
    @Given("user writes an no email")
    public void user_writes_an_no_email() {
    }
    @And("user writes a username")
    public void userWritesAUsername() {
        WebElement userBox = driver.findElement(By.cssSelector("input[type=text]"));
        userBox.sendKeys(gen.letter() + gen.unixTime());
    }
    @And("user writes a password")
    public void userWritesAPassword() {
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type=password]"));
        passwordBox.sendKeys("HejHej123@!");
    }
    @When("user clicks on Sign Up button")
    public void userClicksOnButton() {
        WebElement regButton = driver.findElement(By.cssSelector("button[id=create-account]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(regButton)).click();
    }
    @Then("user should see the text {string}")
    public void userShouldSeeTheText(String checkEmail) {
        WebElement checkText = driver.findElement(By.cssSelector("h1[class='!margin-bottom--lv3 no-transform center-on-medium']"));
        assertEquals(checkEmail, checkText.getText());
    }
    @And("user writes a username with over hundred characters")
    public void userWritesAUsernameWithOverHundredCharacters() {
        WebElement userBox = driver.findElement(By.cssSelector("input[type=text]"));
        userBox.sendKeys(gen.letter().repeat(101) + gen.unixTime());
    }
    @And("user writes a used username")
    public void userWritesAUsedUsername() {
        WebElement userBox = driver.findElement(By.cssSelector("input[type=text]"));
        userBox.sendKeys("s1616686091");
    }
    @Then("user should see the text {string} error message.")
    public void userShouldSeeErrorMessage(String errorMsgUsedUsername) {
        WebElement checkText = driver.findElement(By.cssSelector("span[class='invalid-error']"));
        assertEquals(errorMsgUsedUsername, checkText.getText());
    }
    @After
    public void closeDriver() {
        driver.quit();
    }
}

