package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountriesPageTest extends BaseTest {

    @Test
    public void test01Login() {
        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys(configFileReader.getAdminUsername());
        driver.findElement(By.name("password")).sendKeys(configFileReader.getAdminPassword());
        driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
    }

    @Test
    public void test02CountriesCount() {
        driver.findElement(By.cssSelector("[title=Countries]")).click();
        String countriesListSize = "Countries: " + driver.findElements(By.cssSelector("[class=link]")).size();
        String countriesCount = driver.findElement(By.cssSelector("tfoot")).getAttribute("innerText");
        assertEquals(countriesListSize, countriesCount);
    }

    @Test
    public void test03ZonesListAlphabeticallyOrder() {
        for (int i = 0; i < driver.findElements(By.cssSelector("[class=link]")).size(); i++) {
            WebElement listElement = driver.findElements(By.cssSelector("[class=link]")).get(i);
            String zoneValue = listElement.findElement(By.cssSelector("[a class=text-center]")).getAttribute("textContent");
            if(Integer.valueOf(zoneValue) != 0) {
                String country = driver.findElements(By.cssSelector("[class=link]")).get(i).getAttribute("textContent");
                driver.findElement(By.linkText(country)).click();
                driver.findElement(By.xpath(".//*[@id='myTable']//td[contains(.,'You have transferred')]"));
//                countriesWithZonesList.add(driver.findElements(By.cssSelector("[class=link]")).get(i).getAttribute("textContent"));
            }
        }
    }

    @Test
    public void test04ListAlphabeticallyOrder() {
        List allCountriesList = new ArrayList<>();
        for (int i = 0; i < driver.findElements(By.cssSelector("[class=link]")).size(); i++) {
            allCountriesList.add(driver.findElements(By.cssSelector("[class=link]")).get(i).getAttribute("textContent"));
        }
        isListOrdered(allCountriesList);
    }
}
