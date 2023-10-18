package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewUserSignUpTest extends BaseTest {
    @Test
    public void test01NewUserCreation() {

        WebElement accountBtn;
        WebElement registerNowBtn;
        WebElement companyNameField;
        WebElement taxIdField;
        WebElement firstNameField;
        WebElement lastNameField;
        WebElement address1Field;
        WebElement address2Field;
        WebElement postalCodeField;
        WebElement cityField;
        WebElement countryDropdown;
        WebElement zoneStateProvinceDropdown;
        WebElement userEmailField;
        WebElement userPhoneField;
        WebElement desiredPasswordField;
        WebElement confirmPasswordField;
        WebElement privacyPolicyConsentCheckbox;
        WebElement emailOffersCheckbox;
        WebElement createAccountBtn;


        driver.navigate().to(configFileReader.getApplicationEndpoint() + "litecart");
        driver.manage().window().maximize();

        // Accept cookies
        if(isElementPresent(By.cssSelector("[name=accept_cookies]"))) {
            driver.findElement(By.cssSelector("[name=accept_cookies]")).click();
        }

        accountBtn = driver.findElement(By.cssSelector("a[class='account text-center']"));
        accountBtn.click();

        registerNowBtn = driver.findElement(By.cssSelector(".btn-default[href='http://localhost/litecart/create_account']"));
        registerNowBtn.click();

        companyNameField = driver.findElement(By.cssSelector("[name='company'][type='text']"));
        companyNameField.sendKeys("SunPower");

        taxIdField = driver.findElement(By.cssSelector("[name='tax_id'][type='text']"));
        taxIdField.sendKeys("TAX12345");

        firstNameField = driver.findElement(By.cssSelector("[name='firstname'][type='text']"));
        firstNameField.sendKeys("userFirstName1");

        lastNameField = driver.findElement(By.cssSelector("[name='lastname'][type='text']"));
        lastNameField.sendKeys("userLastName1");

        address1Field = driver.findElement(By.cssSelector("[name='address1'][type='text']"));
        address1Field.sendKeys("address 1");

        address2Field = driver.findElement(By.cssSelector("[name='address2'][type='text']"));
        address2Field.sendKeys("address 2");

        postalCodeField = driver.findElement(By.cssSelector("[name='postcode'][type='text']"));
        postalCodeField.sendKeys("12345");

        cityField = driver.findElement(By.cssSelector("[name='city'][type='text']"));
        cityField.sendKeys("San-Diego");

        countryDropdown = driver.findElement(By.cssSelector("[name='country_code']"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("United States");

        zoneStateProvinceDropdown = driver.findElement(By.cssSelector("[name='zone_code']"));
        Select selectZone = new Select(zoneStateProvinceDropdown);
        selectZone.selectByVisibleText("California");

        userEmailField = driver.findElement(By.cssSelector("[name='customer_form'] [name='email']"));
        userEmailField.sendKeys(configFileReader.getCustomerEmail());

        userPhoneField = driver.findElement(By.cssSelector("[name='phone']"));
        userPhoneField.sendKeys("5555555");

        desiredPasswordField = driver.findElement(By.cssSelector("[name='customer_form'] [name='password']"));
        desiredPasswordField.sendKeys(configFileReader.getCustomerPassword());

        confirmPasswordField = driver.findElement(By.cssSelector("[name='confirmed_password']"));
        confirmPasswordField.sendKeys(configFileReader.getCustomerPassword());

        privacyPolicyConsentCheckbox = driver.findElement(By.cssSelector("[name='terms_agreed'][type='checkbox']"));
        privacyPolicyConsentCheckbox.click();

        emailOffersCheckbox = driver.findElement(By.cssSelector("[name='newsletter'][type='checkbox']"));
        emailOffersCheckbox.click();

        createAccountBtn = driver.findElement(By.cssSelector("[name='create_account'][type='submit']"));
        createAccountBtn.click();
    }

    @Test
    public void test02LogOut() {
        WebElement accountDropdown;
        WebElement logoutDropdownElement;

        accountDropdown = driver.findElement(By.cssSelector((".account.dropdown")));
        accountDropdown.click();

        logoutDropdownElement = driver.findElement(By.cssSelector((".dropdown-menu [href='http://localhost/litecart/logout']")));
        logoutDropdownElement.click();
    }

    @Test
    public void test03Login() {
        WebElement accountDropdown;
        WebElement emailField;
        WebElement passwordField;
        WebElement signInBtn;

        accountDropdown = driver.findElement(By.cssSelector((".account.dropdown")));
        accountDropdown.click();

        emailField = driver.findElement(By.cssSelector((".navbar-form [name='email']")));
        emailField.sendKeys(configFileReader.getCustomerEmail());

        passwordField = driver.findElement(By.cssSelector((".navbar-form [name='password']")));
        passwordField.sendKeys(configFileReader.getCustomerPassword());

        signInBtn = driver.findElement(By.cssSelector(("[name='login'][value='Sign In']")));
        signInBtn.click();

        test02LogOut();
    }
}
