package com.nostromo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddNewProductTest extends BaseTest{

    private static final String PRODUCT_NAME = "The Legend of Zelda: Breath of the Wild";
    private static final String SHORT_DESCRIPTION = "\"The Legend of Zelda: Breath of the Wild\" is a 2017 action-adventure game developed and published by Nintendo for the Nintendo Switch and Wii U.";
    private static final String DESCRIPTION = "Breath of the Wild is an open world action-adventure game. Players are tasked with exploring the kingdom of Hyrule while controlling Link. Breath of the Wild encourages nonlinear gameplay, which is illustrated by the game's lack of defined entrances or exits to areas, scant instruction given to the player, and encouragement to explore freely. Breath of the Wild introduces a consistent physics engine to the Zelda series, letting players approach problems in different ways rather than trying to find a single solution.";
    private static final String TECHNICAL_DATA = "Options\n[Switch Download Code]";
    
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

        if(isElementPresent(By.cssSelector("[title=Catalog]"))) {
            clickWhenClickable(By.cssSelector("[title=Catalog]"));
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='Create New Product']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Create New Product']"));
        }

        if(isElementPresent(By.cssSelector("[href='#tab-general']"))) {
            clickWhenClickable(By.cssSelector("[href='#tab-general']"));
        }

        if(isElementPresent(By.xpath("//label[normalize-space()='Enabled']"))) {
            clickWhenClickable(By.xpath("//label[normalize-space()='Enabled']"));
        }

        if(isElementPresent(By.name("name[en]"))) {
            driver.findElement(By.name("name[en]")).sendKeys(PRODUCT_NAME);
        }

        if(isElementPresent(By.xpath("//a[normalize-space()='Add Image']"))) {
            clickWhenClickable(By.xpath("//a[normalize-space()='Add Image']"));
        }

        if(isElementPresent(By.name("new_images[]"))) {
            driver.findElement(By.name("new_images[]")).sendKeys(Paths.get("image\\LoZBoW.jpg").toAbsolutePath().toString());
        }

        if(isElementPresent(By.cssSelector("select[name='manufacturer_id']"))) {
            new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']"))).selectByVisibleText("Nintendo");
        }

        if(isElementPresent(By.name("prices[USD]"))) {
            driver.findElement(By.name("prices[USD]")).sendKeys("69");
        }

        if(isElementPresent(By.cssSelector(".dropdown .input-group .form-control"))) {
            clickWhenClickable(By.cssSelector(".dropdown .input-group .form-control"));

            if(isElementPresent(By.cssSelector("li.list-item"))) {
                int listSize = driver.findElements(By.cssSelector("li.list-item")).size();
                for (int i = 0; i < listSize; i++) {
                    WebElement element = driver.findElements(By.cssSelector("li.list-item")).get(i);
                    if(element.getAttribute("outerText").contains("Games")) {
                        clickWhenClickable(element);
                    }
                }

                listSize = driver.findElements(By.cssSelector("li.list-item")).size();
                for (int i = 0; i < listSize; i++) {
                    WebElement element = driver.findElements(By.cssSelector("li.list-item")).get(i);
                    if(element.getAttribute("outerText").contains("Nintendo")) {
                        clickWhenClickable(element.findElement(By.cssSelector("button.add")));
                    }
                }
            }
        }

        if(isElementPresent(By.cssSelector("[href='#tab-information']"))) {
            clickWhenClickable(By.cssSelector("[href='#tab-information']"));
        }

        if(isElementPresent(By.cssSelector("#en .form-group"))) {
            int listSize = driver.findElements(By.cssSelector("#en .form-group")).size();
            for (int i = 0; i < listSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("#en .form-group")).get(i);
                if(element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Name")) {
                    element.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.chord(Keys.CONTROL, "a"), PRODUCT_NAME);
                } else if (element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Short Description")) {
                    element.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.chord(Keys.CONTROL, "a"), SHORT_DESCRIPTION);
                } else if (element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Description")) {
                    element.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(Keys.chord(Keys.CONTROL, "a"), DESCRIPTION);
                } else if (element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Technical Data ")) {
                    element.findElement(By.cssSelector("textarea.form-control")).sendKeys(Keys.chord(Keys.CONTROL, "a"), TECHNICAL_DATA);
                }
            }
        }

        if(isElementPresent(By.cssSelector("[href='#tab-information']"))) {
            clickWhenClickable(By.cssSelector("[href='#tab-prices']"));
        }

        if(isElementPresent(By.cssSelector("#prices .form-group"))) {
            int listSize = driver.findElements(By.cssSelector("#prices .form-group")).size();
            for (int i = 0; i < listSize; i++) {
                WebElement element = driver.findElements(By.cssSelector("#prices .form-group")).get(i);
                if(element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Purchase Price")) {
                    element.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "69");
                    new Select(element.findElement(By.cssSelector("select.form-control"))).selectByVisibleText("US Dollars");
                } else if (element.findElement(By.cssSelector("label")).getAttribute("textContent").equals("Recommended Price / MSRP")) {
                    element.findElement(By.cssSelector("input.form-control")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "60");
                }
            }
        }

        if(isElementPresent(By.cssSelector(".btn-success[name='save']"))) {
            clickWhenClickable(By.cssSelector(".btn-success[name='save']"));
        }
    }
}
