package com.nostromo;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @Test
    public void test01CheckThatEachProductHasSticker() {
        driver.navigate().to("http://localhost/litecart");
        driver.manage().window().maximize();

        // Accept cookies
        if(isElementPresent(By.cssSelector("[name=accept_cookies]"))) {
            driver.findElement(By.cssSelector("[name=accept_cookies]")).click();
        }

        for (int i = 0; i < driver.findElements(By.className("product")).size(); i++) {
            assertEquals(driver.findElements(By.className("product")).get(i).findElements(By.cssSelector("[class*=sticker]")).size(), 1);
        }
    }
}
