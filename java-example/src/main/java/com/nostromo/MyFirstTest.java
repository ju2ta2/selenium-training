package com.nostromo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;

public class MyFirstTest extends BaseTest {

    @Test
    public void waitTest() {
        driver.navigate().to("https://www.google.com");
        if(!driver.findElements(By.id("L2AGLb")).isEmpty()) {
            driver.findElement(By.id("L2AGLb")).click();
        }
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.RETURN);
        assertTrue(isElementPresent(By.className("yuRUbf")));
    }
    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.google.com");
        if(!driver.findElements(By.id("L2AGLb")).isEmpty()) {
            driver.findElement(By.id("L2AGLb")).click();
        }
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.RETURN);
        assertTrue(isElementPresent(By.cssSelector(".rc")));
        wait.until(d -> ExpectedConditions.titleIs("webdriver - Google searching"));
    }

    @Test
    public void mySecondTest() {
        driver.navigate().to("https://www.google.com");
        if(!driver.findElements(By.id("L2AGLb")).isEmpty()) {
            driver.findElement(By.id("L2AGLb")).click();
        }
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.RETURN);
        wait.until(d -> ExpectedConditions.titleIs("webdriver - Google searching"));
    }

    @Test
    public void myThirdTest() {
        driver.navigate().to("https://www.google.com");
        if(!driver.findElements(By.id("L2AGLb")).isEmpty()) {
            driver.findElement(By.id("L2AGLb")).click();
        }
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.RETURN);
        wait.until(d -> ExpectedConditions.titleIs("webdriver - Google searching"));
    }
}