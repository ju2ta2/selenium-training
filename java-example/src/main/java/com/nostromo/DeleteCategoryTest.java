package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteCategoryTest extends BaseTest{

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
    public void test02DeleteCategories() {
        WebElement catalogBtn;
        WebElement gamesCatalog;
        WebElement deleteBtn;

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            clickWhenClickable(By.cssSelector("[title=Catalog]"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='Games']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Games']"));
        }

        if(isElementPresent(By.cssSelector("tbody tr"))) {
            int categoriesListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            for (int i = 0; i < categoriesListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                if(element.getAttribute("textContent").contains("Nintendo")) {
                    element.findElement(By.cssSelector("input[class='form-check']")).click();
                    break;
                }
            }

            if(isElementPresent(By.cssSelector("button[value='Delete']"))) {
                clickWhenClickable(By.cssSelector("button[value='Delete']"));
            }

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            categoriesListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            for (int i = 0; i < categoriesListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                if(element.getAttribute("textContent").contains("Games")) {
                    element.findElement(By.cssSelector("input[class='form-check']")).click();
                    break;
                }
            }

            if(isElementPresent(By.cssSelector("button[value='Delete']"))) {
                clickWhenClickable(By.cssSelector("button[value='Delete']"));
            }

            wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            alert.accept();
        }
    }
}
