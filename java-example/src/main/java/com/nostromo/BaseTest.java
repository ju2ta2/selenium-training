package com.nostromo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseTest {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return;
        }
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("\"C:\\Program Files\\Firefox Nightly\\firefox.exe\"");
        driver = new ChromeDriver();
//        driver = new FirefoxDriver(options);
//        driver = new EdgeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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

    public void isListOrdered(List actualList) {
        List orderedList = new ArrayList<>(actualList);

        Collections.sort(orderedList);
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(actualList.get(i), orderedList.get(i));
        }
    }
}