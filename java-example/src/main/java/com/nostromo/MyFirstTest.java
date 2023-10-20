package com.nostromo;

import org.junit.Test;
import org.openqa.selenium.*;
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

    @Test
    public void myAlertTest() {
        driver.navigate().to("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        driver.manage().window().maximize();

        //Click the link to activate the alert
        WebElement link = driver.findElement(By.linkText("See a sample confirm"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", link);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", link);

        //Wait for the alert to be displayed
        wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert in a variable
        Alert alert = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text = alert.getText();
        System.out.println(text);

        //Press the Cancel button
        alert.dismiss();
    }
}