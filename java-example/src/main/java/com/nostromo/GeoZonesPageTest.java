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
public class GeoZonesPageTest extends BaseTest{
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
    public void test02GeoZonesCount() {
        driver.findElement(By.cssSelector("[href*='litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
        String zonesListSize = "Geo Zones: " + driver.findElements(By.cssSelector("[class=link]")).size();
        String zonesCount = driver.findElement(By.cssSelector("tfoot")).getAttribute("innerText");
        assertEquals(zonesListSize, zonesCount);
    }

    @Test
    public void test03ListAlphabeticallyOrder() {
        driver.findElement(By.cssSelector("[href*='litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
        List allGeoZonesList = new ArrayList<>();
        WebElement zonesTable = driver.findElement(By.cssSelector("table[class='table table-striped table-hover data-table']"));
        int zonesSize =  zonesTable.findElements(By.cssSelector("a[class='link']")).size();
        for (int i = 0; i < zonesSize; i++) {
            allGeoZonesList.add(driver.findElements(By.cssSelector("[class=link]")).get(i).getAttribute("textContent"));
        }
        isListOrdered(allGeoZonesList);
    }

    @Test
    public void test04CountryListAlphabeticallyOrder() {
        driver.findElement(By.cssSelector("[href*='litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
        WebElement zonesTable = driver.findElement(By.cssSelector("table[class='table table-striped table-hover data-table']"));
        int zonesSize =  zonesTable.findElements(By.cssSelector("a[class='link']")).size();
        for (int i = 0; i < zonesSize; i++) {
            zonesTable.findElements(By.xpath("//a[@class='link']")).get(i).click();
            WebElement countryTable = driver.findElement(By.cssSelector("table[class='table table-striped table-hover data-table']"));
            int countrySize =countryTable.findElements(By.cssSelector("td input[name$='[country_code]']")).size();
            List countriesList = new ArrayList<String>();
            for (int j = 0; j < countrySize; j++) {
                //TODO get country name
                WebElement country = countryTable.findElements(By.cssSelector("td input[name$='[country_code]']")).get(j);
                countriesList.add(country.getText());
            }
            isListOrdered(countriesList);
        }
    }
}
