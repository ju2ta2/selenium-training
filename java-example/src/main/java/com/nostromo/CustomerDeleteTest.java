package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDeleteTest extends BaseTest{

    @Test
    public void test01LoginAsAdmin() {
        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart/admin");
        driver.manage().window().maximize();
        if(isElementPresent(By.name("username"))) {
            driver.findElement(By.name("username")).sendKeys(configFileReader.getAdminUsername());
        }

        if(isElementPresent(By.name("password"))) {
            driver.findElement(By.name("password")).sendKeys(configFileReader.getAdminPassword());
        }

        if(isElementPresent(By.cssSelector("[class=card-footer] [name=login]"))) {
            driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
        }
    }

    @Test
    public void test02DeleteTestCustomer() {
        if(isElementPresent(By.cssSelector("[title=Customers]"))) {
            driver.findElement(By.cssSelector("[title=Customers]")).click();
        }

        if(isElementPresent(By.cssSelector("[data-id=customers]"))) {
            driver.findElement(By.cssSelector("[data-id=customers]")).click();
        }

        WebElement customersList = driver.findElement(By.cssSelector("tbody"));
        int customerListSize = driver.findElements(By.cssSelector("a[class=link]")).size();
        for (int i = 0; i < customerListSize; i++) {
            String email = customersList.findElements(By.cssSelector("a[class=link]")).get(i).getAttribute("textContent");
            if(email.equals(configFileReader.getCustomerEmail())) {
                customersList.findElements(By.cssSelector("input[class=form-check]")).get(i).click();
                if(isElementPresent(By.cssSelector("[name='delete']"))) {
                    driver.findElement(By.cssSelector("[name='delete']")).click();
                }
                break;
            }
        }
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
