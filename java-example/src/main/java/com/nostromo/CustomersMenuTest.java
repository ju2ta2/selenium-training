package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomersMenuTest extends BaseTest{

    @Test
    public void test01LoginAsAdmin() {
        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys(configFileReader.getAdminUsername());
        driver.findElement(By.name("password")).sendKeys(configFileReader.getAdminPassword());
        driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
    }

    @Test
    public void test02DeleteTestCustomer() {
        driver.findElement(By.cssSelector("[title=Customers]")).click();
        driver.findElement(By.cssSelector("[data-id=customers]")).click();
        WebElement customersList = driver.findElement(By.cssSelector("tbody"));
        int customerListSize = driver.findElements(By.cssSelector("a[class=link]")).size();
        for (int i = 0; i < customerListSize; i++) {
            String email = customersList.findElements(By.cssSelector("a[class=link]")).get(i).getAttribute("textContent");
            if(email.equals(configFileReader.getCustomerEmail())) {
                customersList.findElements(By.cssSelector("input[class=form-check]")).get(i).click();
                driver.findElement(By.cssSelector("[name='delete']")).click();
                return;
            }
        }
    }
}
