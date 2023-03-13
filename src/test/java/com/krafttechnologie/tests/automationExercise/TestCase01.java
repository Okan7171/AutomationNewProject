package com.krafttechnologie.tests.automationExercise;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.tests.pages.HomePage;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    HomePage homePage=new HomePage();

    @Test
    public void test1() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        homePage.signUp.click();
        Assert.assertTrue(homePage.newUserSignUp.isDisplayed());
        actions.click(homePage.nameUp)
                .sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(faker.internet().emailAddress()+Keys.TAB+Keys.ENTER).perform();
        WebElement accountInf = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInf.isDisplayed());
        driver.findElement(By.id("id_gender1")).click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.idNumber().valid());
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        WebElement days = driver.findElement(By.id("days"));
        Select select=new Select(days);
        select.selectByValue("7");
        select.getFirstSelectedOption().click();
        WebElement months = driver.findElement(By.id("months"));
        Select select1=new Select(months);
        select1.selectByIndex(5);
        select1.getFirstSelectedOption().click();
        WebElement years = driver.findElement(By.id("years"));
        Select select2=new Select(years);
        select2.selectByVisibleText("2017");
        select2.getFirstSelectedOption().click();

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        WebElement country = driver.findElement(By.id("country"));
        Select select3=new Select(country);
        select3.selectByIndex(2);
        select3.getFirstSelectedOption().click();

        WebElement first_name = driver.findElement(By.id("first_name"));
        wait.until(ExpectedConditions.visibilityOf(first_name));
        actions.click(first_name)
                //.sendKeys(faker.idNumber().valid()+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB)
                .sendKeys(faker.name().firstName()+Keys.TAB)
                .sendKeys(faker.name().lastName()+Keys.TAB)
                .sendKeys(faker.company().name()+Keys.TAB)
                .sendKeys(faker.address().fullAddress()+Keys.TAB)
                .sendKeys(faker.address().secondaryAddress()+Keys.TAB+Keys.TAB)
                .sendKeys(faker.address().state()+Keys.TAB)
                .sendKeys(faker.address().city()+Keys.TAB)
                .sendKeys(faker.address().zipCode()+Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()+Keys.TAB+Keys.ENTER).perform();
        WebElement accountElement = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertEquals(accountElement.getText(), "ACCOUNT CREATED!");
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame("ad_iframe");

        driver.findElement(By.xpath("//span[@class='ns-3bkki-e-7']")).click();

    }
}
