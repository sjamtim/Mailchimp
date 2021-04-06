package common;

import org.openqa.selenium.WebDriver;

public class Generators {

    WebDriver driver;

    public long unixTime() {
        long unixTime = System.currentTimeMillis() / 1000;
        return unixTime;
    }
    public String letter() {
        char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
        return Character.toString(randomLetter);
    }
}

