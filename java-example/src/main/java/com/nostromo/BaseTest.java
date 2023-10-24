package com.nostromo;

import com.nostromo.dataProviders.ConfigFileReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.Assert.assertEquals;

public class BaseTest {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return;
        }
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("\"C:\\Program Files\\Firefox Nightly\\firefox.exe\"");
        driver = new ChromeDriver();
//        driver = new FirefoxDriver(options);
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> { driver.quit(); driver = null;} )
//        );
    }

    @After
    public void stop() {
//        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        try {
            wait.until(d -> d.findElement(locator));
//            driver.findElement(locator);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public void clickWhenClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void clickWhenClickable(WebElement webElement) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }

    public void isClickable(By locator) {
        wait.until(d -> ExpectedConditions.elementToBeClickable(locator));
    }

    public void isListOrdered(List actualList) {
        ArrayList orderedList = new ArrayList<>(actualList);

        sort(orderedList);
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(actualList.get(i), orderedList.get(i));
            if(actualList.get(i).equals("")) {
                System.out.printf("Element %d has empty value\n", i);
            } else if(actualList.get(i) == null) {
                System.out.printf("Element %d has value null\n", i);
            }
        }
    }
}
