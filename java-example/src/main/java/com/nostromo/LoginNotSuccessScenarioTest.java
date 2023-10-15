package com.nostromo;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class LoginNotSuccessScenarioTest extends BaseTest {

    @Test
    public void test01AlertForInvalidUserName() {
        String invalidUser = "invalidUser";
        String validPassword = "SunPower";

        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart/admin");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys(invalidUser);
        driver.findElement(By.name("password")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
        String userAlert = driver.findElement(By.id("notices")).getAttribute("textContent");
        assertTrue(userAlert.contains("The user could not be found in our database"));
    }

    @Test
    public void test02AlertForInvalidPassword() {

        String validUser = "admin";
        String invalidPassword = "invalidPassword";

        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart/admin");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys(validUser);
        driver.findElement(By.name("password")).sendKeys(invalidPassword);
        driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
        String userAlert = driver.findElement(By.id("notices")).getAttribute("textContent");
        assertTrue(userAlert.contains("You have 2 login attempts left until your account is temporarily blocked"));
    }
}
