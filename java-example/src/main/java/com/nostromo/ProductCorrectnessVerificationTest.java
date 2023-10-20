package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCorrectnessVerificationTest extends BaseTest {

    @Test
    public void test01ProductValues() {
        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart");
        driver.manage().window().maximize();

        // Accept cookies
        if(isElementPresent(By.cssSelector("[name=accept_cookies]"))) {
            driver.findElement(By.cssSelector("[name=accept_cookies]")).click();
        }

        String mainPageProductName = driver.findElement(By.cssSelector("#box-campaign-products [class=product] [class=name]")).getAttribute("textContent");
        String mainPageRegularPrice = driver.findElement(By.cssSelector("#box-campaign-products [class=product] del[class=regular-price]")).getAttribute("textContent");
        String mainPageDiscountPrice = driver.findElement(By.cssSelector("#box-campaign-products [class=product] strong[class=campaign-price]")).getAttribute("textContent");
        String mainPageRegularPriceColor = driver.findElement(By.cssSelector("#box-campaign-products [class=product] del[class=regular-price]")).getCssValue("color");
        String mainPageDiscountPriceColor = driver.findElement(By.cssSelector("#box-campaign-products [class=product] strong[class=campaign-price]")).getCssValue("color");
        String mainPageRegularPriceStripe = driver.findElement(By.cssSelector("#box-campaign-products [class=product] del[class=regular-price]")).getCssValue("text-decoration");
        String mainPageDiscountPriceFontWeight = driver.findElement(By.cssSelector("#box-campaign-products [class=product] strong[class=campaign-price]")).getCssValue("font-weight");
        String mainPageRegularPriceFontSize = driver.findElement(By.cssSelector("#box-campaign-products [class=product] del[class=regular-price]")).getCssValue("font-size");
        String mainPageDiscountPriceFontSize = driver.findElement(By.cssSelector("#box-campaign-products [class=product] strong[class=campaign-price]")).getCssValue("font-size");
        double mainPageRegularPriceFontSizeDouble = Double.parseDouble(mainPageRegularPriceFontSize.substring(0, mainPageRegularPriceFontSize.length() - 2));
        double mainPageDiscountPriceFontSizeDouble = Double.parseDouble(mainPageDiscountPriceFontSize.substring(0, mainPageDiscountPriceFontSize.length() - 2));

        if(isElementPresent(By.cssSelector("#box-campaign-products [class=product]"))) {
            driver.findElement(By.cssSelector("#box-campaign-products [class=product]")).click();
        }

        String productPageProductName = driver.findElement(By.cssSelector("h1[class=title]")).getAttribute("textContent");
        String productPageRegularPrice = driver.findElement(By.cssSelector("del[class=regular-price]")).getAttribute("textContent");
        String productPageDiscountPrice = driver.findElement(By.cssSelector("strong[class=campaign-price]")).getAttribute("textContent");
        String productPageRegularPriceColor = driver.findElement(By.cssSelector("del[class=regular-price]")).getCssValue("color");
        String productPageDiscountPriceColor = driver.findElement(By.cssSelector("strong[class=campaign-price]")).getCssValue("color");
        String productPageRegularPriceStripe = driver.findElement(By.cssSelector("del[class=regular-price]")).getCssValue("text-decoration");
        String productPageDiscountPriceFontWeight = driver.findElement(By.cssSelector("strong[class=campaign-price]")).getCssValue("font-weight");
        String productPageRegularPriceFontSize = driver.findElement(By.cssSelector("del[class=regular-price]")).getCssValue("font-size");
        String productPageDiscountPriceFontSize = driver.findElement(By.cssSelector("strong[class=campaign-price]")).getCssValue("font-size");
        double productPageRegularPriceFontSizeDouble = Double.parseDouble(productPageRegularPriceFontSize.substring(0, productPageRegularPriceFontSize.length() - 2));
        double productPageDiscountPriceFontSizeDouble = Double.parseDouble(productPageDiscountPriceFontSize.substring(0, productPageDiscountPriceFontSize.length() - 2));

        // Product name verification
        assertEquals(mainPageProductName, productPageProductName);

        // Price value verification
        assertEquals(mainPageRegularPrice, productPageRegularPrice);
        assertEquals(mainPageDiscountPrice, productPageDiscountPrice);

        // Price CSS verification
        if(driver instanceof ChromeDriver || driver instanceof EdgeDriver || driver instanceof SafariDriver) {
            assertEquals(mainPageRegularPriceColor, "rgba(34, 34, 34, 1)");
        } else if (driver instanceof FirefoxDriver) {
            assertEquals(mainPageRegularPriceColor, "rgb(34, 34, 34)");
        }
        assertEquals(mainPageRegularPriceColor, productPageRegularPriceColor);

        if(driver instanceof ChromeDriver || driver instanceof EdgeDriver || driver instanceof SafariDriver) {
            assertEquals(mainPageDiscountPriceColor, "rgba(204, 0, 0, 1)");
        } else if (driver instanceof FirefoxDriver) {
            assertEquals(mainPageDiscountPriceColor, "rgb(204, 0, 0)");
        }
        assertEquals(mainPageDiscountPriceColor, productPageDiscountPriceColor);

        if(driver instanceof ChromeDriver || driver instanceof EdgeDriver || driver instanceof SafariDriver) {
            assertEquals(mainPageRegularPriceStripe, "line-through solid rgb(34, 34, 34)");
        } else if (driver instanceof FirefoxDriver) {
            assertEquals(mainPageRegularPriceStripe, "line-through rgb(34, 34, 34)");
        }
        assertEquals(mainPageRegularPriceStripe, productPageRegularPriceStripe);

        assertEquals(mainPageDiscountPriceFontWeight, "700");
        assertEquals(mainPageDiscountPriceFontWeight, productPageDiscountPriceFontWeight);

        assertTrue(mainPageRegularPriceFontSizeDouble < mainPageDiscountPriceFontSizeDouble);
        assertTrue(productPageRegularPriceFontSizeDouble < productPageDiscountPriceFontSizeDouble);
    }

}
