package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerCreationTest extends BaseTest {
    @Test
    public void test01NewUserCreation() {
        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart");
        driver.manage().window().maximize();

        // Accept cookies
        if(isElementPresent(By.cssSelector("[name=accept_cookies]"))) {
            driver.findElement(By.cssSelector("[name=accept_cookies]")).click();
        }

        if(isElementPresent(By.cssSelector("a[class='account text-center']"))) {
            driver.findElement(By.cssSelector("a[class='account text-center']")).click();
        }

        if(isElementPresent(By.cssSelector(".btn-default[href='http://localhost/litecart/create_account']"))) {
            driver.findElement(By.cssSelector(".btn-default[href='http://localhost/litecart/create_account']")).click();
        }

        if(isElementPresent(By.cssSelector("[name='company'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='company'][type='text']")).sendKeys("SunPower");
        }

        if(isElementPresent(By.cssSelector("[name='tax_id'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='tax_id'][type='text']")).sendKeys("TAX12345");
        }

        if(isElementPresent(By.cssSelector("[name='firstname'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='firstname'][type='text']")).sendKeys("userFirstName1");
        }

        if(isElementPresent(By.cssSelector("[name='lastname'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='lastname'][type='text']")).sendKeys("userLastName1");
        }

        if(isElementPresent(By.cssSelector("[name='address1'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='address1'][type='text']")).sendKeys("address 1");
        }

        if(isElementPresent(By.cssSelector("[name='address2'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='address2'][type='text']")).sendKeys("address 2");
        }

        if(isElementPresent(By.cssSelector("[name='postcode'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='postcode'][type='text']")).sendKeys("12345");
        }

        if(isElementPresent(By.cssSelector("[name='city'][type='text']"))) {
            driver.findElement(By.cssSelector("[name='city'][type='text']")).sendKeys("San-Diego");
        }

        if(isElementPresent(By.cssSelector("[name='country_code']"))) {
            new Select(driver.findElement(By.cssSelector("[name='country_code']"))).selectByVisibleText("United States");
        }

        if(isElementPresent(By.cssSelector("[name='zone_code']"))) {
            new Select(driver.findElement(By.cssSelector("[name='zone_code']"))).selectByVisibleText("California");
        }

        if(isElementPresent(By.cssSelector("[name='customer_form'] [name='email']"))) {
            driver.findElement(By.cssSelector("[name='customer_form'] [name='email']")).sendKeys(configFileReader.getCustomerEmail());
        }

        if(isElementPresent(By.cssSelector("[name='phone']"))) {
            driver.findElement(By.cssSelector("[name='phone']")).sendKeys("5555555");
        }

        if(isElementPresent(By.cssSelector("[name='customer_form'] [name='password']"))) {
            driver.findElement(By.cssSelector("[name='customer_form'] [name='password']")).sendKeys(configFileReader.getCustomerPassword());
        }

        if(isElementPresent(By.cssSelector("[name='confirmed_password']"))) {
            driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys(configFileReader.getCustomerPassword());
        }

        if(isElementPresent(By.cssSelector("[name='terms_agreed'][type='checkbox']"))) {
            driver.findElement(By.cssSelector("[name='terms_agreed'][type='checkbox']")).click();
        }

        if(isElementPresent(By.cssSelector("[name='newsletter'][type='checkbox']"))) {
            driver.findElement(By.cssSelector("[name='newsletter'][type='checkbox']")).click();
        }

        if(isElementPresent(By.cssSelector("[name='create_account'][type='submit']"))) {
            driver.findElement(By.cssSelector("[name='create_account'][type='submit']")).click();
        }
    }

    @Test
    public void test02LogOut() {
        if(isElementPresent(By.cssSelector(".account.dropdown"))) {
            driver.findElement(By.cssSelector(".account.dropdown")).click();
        }

        if(isElementPresent(By.cssSelector((".dropdown-menu [href='http://localhost/litecart/logout']")))) {
            driver.findElement(By.cssSelector((".dropdown-menu [href='http://localhost/litecart/logout']"))).click();
        }
    }

    @Test
    public void test03Login() {
        if(isElementPresent(By.cssSelector(".account.dropdown"))) {
            driver.findElement(By.cssSelector(".account.dropdown")).click();
        }

        if(isElementPresent(By.cssSelector(".navbar-form [name='email']"))) {
            driver.findElement(By.cssSelector(".navbar-form [name='email']")).sendKeys(configFileReader.getCustomerEmail());
        }

        if(isElementPresent(By.cssSelector(".navbar-form [name='password']"))) {
            driver.findElement(By.cssSelector(".navbar-form [name='password']")).sendKeys(configFileReader.getCustomerPassword());
        }

        if(isElementPresent(By.cssSelector("[name='login'][value='Sign In']"))) {
            driver.findElement(By.cssSelector("[name='login'][value='Sign In']")).click();
        }

        test02LogOut();
    }
}
