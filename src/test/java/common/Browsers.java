package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {

    public WebDriver getBrowser(String brows) {
        WebDriver driver = null;

        if (brows.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (brows.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (brows.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        return driver;
    }
}
