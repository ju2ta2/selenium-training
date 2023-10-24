package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteProductTest extends BaseTest{

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
    public void test02AddNewProduct() {

        if (isElementPresent(By.cssSelector("[title=Catalog]"))) {
            clickWhenClickable(By.cssSelector("[title=Catalog]"));
        }

        if(isElementPresent(By.cssSelector("tbody tr"))) {
            int trListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            for (int i = 0; i < trListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                int tdListSize = element.findElements(By.cssSelector("td")).size();
                for (int j = 0; j < tdListSize; j++) {
                    if(element.findElements(By.cssSelector("td")).get(j).getAttribute("textContent").contains("Games")) {
                        clickWhenClickable(element.findElements(By.cssSelector("td")).get(j).findElement(By.cssSelector("a")));
                        break;
                    }
                }
            }

            trListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            for (int i = 0; i < trListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                int tdListSize = element.findElements(By.cssSelector("td")).size();
                for (int j = 0; j < tdListSize; j++) {
                    if(element.findElements(By.cssSelector("td")).get(j).getAttribute("textContent").contains("Nintendo")) {
                        clickWhenClickable(element.findElements(By.cssSelector("td")).get(j).findElement(By.cssSelector("a")));
                        break;
                    }
                }
            }

            trListSize = driver.findElements(By.cssSelector("tbody tr")).size();
            outerloop:
            for (int i = 0; i < trListSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("tbody tr")).get(i);
                int tdListSize = element.findElements(By.cssSelector("td")).size();
                for (int j = 0; j < tdListSize; j++) {
                    if(element.findElements(By.cssSelector("td")).get(j).getAttribute("textContent").contains("The Legend of Zelda: Breath of the Wild")) {
                        clickWhenClickable(element.findElements(By.cssSelector("td")).get(j).findElement(By.cssSelector("a")));
                        break outerloop;
                    }
                }
            }
        }

        if (isElementPresent(By.cssSelector(".btn-danger[name='delete']"))) {
            clickWhenClickable(By.cssSelector(".btn-danger[name='delete']"));
        }

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
