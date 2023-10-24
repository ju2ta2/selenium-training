package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddNewCategoryTest extends BaseTest{

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
    public void test02CreateCategory() {

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            clickWhenClickable(By.cssSelector("[title=Catalog]"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='Create New Category']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Create New Category']"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='General']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='General']"));
        }

        if(isElementPresent(By.xpath("//label[normalize-space()='Enabled']"))) {
            clickWhenClickable(By.xpath("//label[normalize-space()='Enabled']"));
        }

        if(isElementPresent(By.name("name[en]"))) {
            driver.findElement(By.name("name[en]")).sendKeys("Games");
        }

        if(isElementPresent(By.cssSelector("input[name='code']"))) {
            driver.findElement(By.cssSelector("input[name='code']")).sendKeys("GM");
        }

        if (isElementPresent(By.xpath("//a[normalize-space()='Change']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Change']"));
        }

        if(isElementPresent(By.cssSelector("li.nav-item"))) {
            int categoriesListSize = driver.findElements(By.cssSelector("li.nav-item")).size();
            for (int i = 0; i < categoriesListSize; i++) {
                if(isElementPresent(By.cssSelector(String.format("li.nav-item [href='http://localhost/litecart/admin/?app=catalog&doc=category_picker&parent_id=%d']", i)))) {
                    WebElement categoriesListElement = driver.findElements(By.cssSelector("li.nav-item")).get(i);
                    if(categoriesListElement.getAttribute("textContent").contains("[Root]")) {
                        categoriesListElement.click();
                        break;
                    }
                }
            }
        }

        if(isElementPresent(By.xpath("//button[normalize-space()='Select']"))) {
            clickWhenClickable(By.xpath("//button[normalize-space()='Select']"));
        }

        if(isElementPresent(By.cssSelector("button[value='Save']"))) {
            clickWhenClickable(By.cssSelector("button[value='Save']"));
        }
    }

    @Test
    public void test03CreateSubCategory() {

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            clickWhenClickable(By.cssSelector("[title=Catalog]"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='Create New Category']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Create New Category']"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='General']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='General']"));
        }

        if(isElementPresent(By.xpath("//label[normalize-space()='Enabled']"))) {
            clickWhenClickable(By.xpath("//label[normalize-space()='Enabled']"));
        }

        if(isElementPresent(By.name("name[en]"))) {
            driver.findElement(By.name("name[en]")).sendKeys("Nintendo");
        }

        if(isElementPresent(By.cssSelector("input[name='code']"))) {
            driver.findElement(By.cssSelector("input[name='code']")).sendKeys("ND");
        }

        if (isElementPresent(By.xpath("//a[normalize-space()='Change']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Change']"));
        }

        if(isElementPresent(By.cssSelector("li.nav-item"))) {
            int categoriesListSize = driver.findElements(By.cssSelector("li.nav-item")).size();
            for (int i = 0; i < categoriesListSize; i++) {
                if(isElementPresent(By.cssSelector(String.format("li.nav-item [href='http://localhost/litecart/admin/?app=catalog&doc=category_picker&parent_id=%d']", i)))) {
                    WebElement categoriesListElement = driver.findElements(By.cssSelector("li.nav-item")).get(i);
                    if(categoriesListElement.getAttribute("textContent").contains("Games")) {
                        categoriesListElement.click();
                        break;
                    }
                }
            }
        }

        if(isElementPresent(By.cssSelector("button[name='select']"))) {
            clickWhenClickable(By.cssSelector("button[name='select']"));
        }

        if(isElementPresent(By.cssSelector("button[value='Save']"))) {
            clickWhenClickable(By.cssSelector("button[value='Save']"));
        }
    }
}
