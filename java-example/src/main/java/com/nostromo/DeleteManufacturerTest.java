package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteManufacturerTest extends BaseTest{

    @Test
    public void test01Login() {
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
    public void test02DeleteManufacturer() {
        WebElement catalogBtn;
        WebElement manufacturersBtn;
        WebElement deleteBtn;

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            catalogBtn = driver.findElement(By.cssSelector("[title=Catalog]"));
            catalogBtn.click();
        }

        if(isElementPresent(By.cssSelector("[data-id=manufacturers]"))) {
            manufacturersBtn = driver.findElement(By.cssSelector("[data-id=manufacturers]"));
            manufacturersBtn.click();
        }

        if(isElementPresent(By.cssSelector("tbody tr"))) {
            int manufacturerListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            for (int i = 0; i < manufacturerListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                if(element.getAttribute("outerText").contains("Nintendo")) {
                    element.findElement(By.cssSelector("a[class='btn btn-default btn-sm']")).click();
                }
            }
        }

        if(isElementPresent(By.name("delete"))) {
            deleteBtn = driver.findElement(By.name("delete"));
            deleteBtn.click();
        }

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
