package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.nio.file.Paths;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddNewManufacturerTest extends BaseTest{

    private static final String MANUFACTURER_NAME = "Nintendo";
    private static final String CODE_VALUE = "Nintendo";

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
    public void test02CreateNewManufacturer() {

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            driver.findElement(By.cssSelector("[title=Catalog]")).click();
        }

        if(isElementPresent(By.cssSelector("[data-id=manufacturers]"))) {
            driver.findElement(By.cssSelector("[data-id=manufacturers]")).click();
        }

        if(isElementPresent(By.cssSelector("i[class='fa fa-plus']"))) {
            driver.findElement(By.cssSelector("i[class='fa fa-plus']")).click();
        }

        if(isElementPresent(By.cssSelector("[href='#tab-general']"))) {
            driver.findElement(By.cssSelector("[href='#tab-general']")).click();
        }

        if(isElementPresent(By.xpath("//label[normalize-space()='Enabled']"))) {
            driver.findElement(By.xpath("//label[normalize-space()='Enabled']")).click();
        }

        if(isElementPresent(By.xpath("//label[normalize-space()='Yes']"))) {
            driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
        }

        if(isElementPresent(By.name("name"))) {
            driver.findElement(By.name("name")).sendKeys(MANUFACTURER_NAME);
        }

        if(isElementPresent(By.name("code"))) {
            driver.findElement(By.name("code")).sendKeys(CODE_VALUE);
        }

        if(isElementPresent(By.name("image"))) {
            driver.findElement(By.name("image")).sendKeys(Paths.get("image\\nintendo.jpg").toAbsolutePath().toString());
        }

        if(isElementPresent(By.cssSelector("[class='btn btn-success']"))) {
            driver.findElement(By.cssSelector("[class='btn btn-success']")).click();
        }
    }
}
