package com.nostromo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminPageTest extends BaseTest {

    @Test
    public void test01SuccessScenario() {
        driver.navigate().to("http://localhost/litecart/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("SunPower");
        driver.findElement(By.cssSelector("[class=card-footer] [name=login]")).click();
    }

    @Test
    public void test02CheckAdminPageLeftMenu() {
        //Verification of Appearance menu items clickable
        driver.findElement(By.cssSelector("[title=Appearance]")).click();
        driver.findElement(By.cssSelector("[data-id=template]")).click();
        driver.findElement(By.cssSelector("[data-id=favicon]")).click();
        driver.findElement(By.cssSelector("[data-id=logotype]")).click();
        driver.findElement(By.cssSelector("[data-id=edit_styling]")).click();

        //Verification of Catalog menu items clickable
        driver.findElement(By.cssSelector("[title=Catalog]")).click();
        driver.findElement(By.cssSelector("[data-id=catalog]")).click();
        driver.findElement(By.cssSelector("[data-id=attribute_groups]")).click();
        driver.findElement(By.cssSelector("[data-id=manufacturers]")).click();
        driver.findElement(By.cssSelector("[data-id=suppliers]")).click();
        driver.findElement(By.cssSelector("[data-id=delivery_statuses]")).click();
        driver.findElement(By.cssSelector("[data-id=sold_out_statuses]")).click();
        driver.findElement(By.cssSelector("[data-id=quantity_units]")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=catalog&doc=csv']")).click();

        //Verification of Countries menu items clickable
        driver.findElement(By.cssSelector("[title=Countries]")).click();

        //Verification of Currencies menu items clickable
        driver.findElement(By.cssSelector("[title=Currencies]")).click();

        //Verification of Customers menu items clickable
        driver.findElement(By.cssSelector("[title=Customers]")).click();
        driver.findElement(By.cssSelector("[data-id=customers]")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=customers&doc=csv']")).click();
        driver.findElement(By.cssSelector("[data-id=newsletter_recipients]")).click();

        //Verification of Geo Zones menu items clickable
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']")).click();

        //Verification of Languages menu items clickable
        driver.findElement(By.cssSelector("[title=Languages]")).click();
        driver.findElement(By.cssSelector("[data-id=languages]")).click();
        driver.findElement(By.cssSelector("[data-id=storage_encoding]")).click();

        //Verification of Modules menu items clickable
        driver.findElement(By.cssSelector("[title=Modules]")).click();
        driver.findElement(By.cssSelector("[data-id=customer]")).click();
        driver.findElement(By.cssSelector("[data-id=shipping]")).click();
        driver.findElement(By.cssSelector("[data-id=payment]")).click();
        driver.findElement(By.cssSelector("[data-id=order]")).click();
        driver.findElement(By.cssSelector("[data-id=order_total]")).click();
        driver.findElement(By.cssSelector("[data-id=jobs]")).click();

        //Verification of Orders menu items clickable
        driver.findElement(By.cssSelector("[title=Orders]")).click();
        driver.findElement(By.cssSelector("[data-id=orders]")).click();
        driver.findElement(By.cssSelector("[data-id=order_statuses]")).click();

        //Verification of Pages menu items clickable
        driver.findElement(By.cssSelector("[title=Pages]")).click();
        driver.findElement(By.cssSelector("[data-id=pages]")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=pages&doc=csv']")).click();

        //Verification of Reports menu items clickable
        driver.findElement(By.cssSelector("[title=Reports]")).click();
        driver.findElement(By.cssSelector("[data-id=monthly_sales]")).click();
        driver.findElement(By.cssSelector("[data-id=most_sold_products]")).click();
        driver.findElement(By.cssSelector("[data-id=most_shopping_customers]")).click();

        //Verification of Settings menu items clickable
        driver.findElement(By.cssSelector("[title=Settings]")).click();
        driver.findElement(By.cssSelector("[data-id=store_info]")).click();
        driver.findElement(By.cssSelector("[data-id=defaults]")).click();
        driver.findElement(By.cssSelector("[data-id=email]")).click();
        driver.findElement(By.cssSelector("[data-id=listings]")).click();
        driver.findElement(By.cssSelector("[data-id=customer_details]")).click();
        driver.findElement(By.cssSelector("[data-id=legal]")).click();
        driver.findElement(By.cssSelector("[data-id=images]")).click();
        driver.findElement(By.cssSelector("[data-id=checkout]")).click();
        driver.findElement(By.cssSelector("[data-id=advanced]")).click();
        driver.findElement(By.cssSelector("[data-id=security]")).click();

        //Verification of Slides menu items clickable
        driver.findElement(By.cssSelector("[title=Slides]")).click();

        //Verification of Tax menu items clickable
        driver.findElement(By.cssSelector("[title=Tax]")).click();
        driver.findElement(By.cssSelector("[data-id=tax_rates]")).click();
        driver.findElement(By.cssSelector("[data-id=tax_classes]")).click();

        //Verification of Translations menu items clickable
        driver.findElement(By.cssSelector("[title=Translations]")).click();
        driver.findElement(By.cssSelector("[data-id=search]")).click();
        driver.findElement(By.cssSelector("[data-id=scan]")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=translations&doc=csv']")).click();

        //Verification of Users menu items clickable
        driver.findElement(By.cssSelector("[title=Users]")).click();

        //Verification of vMods™ menu items clickable
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/admin/?app=vmods&doc=vmods']")).click();
    }
}
