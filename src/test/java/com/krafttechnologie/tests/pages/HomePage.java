package com.krafttechnologie.tests.pages;

import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy (xpath = "//a[text()=' Signup / Login']")
    public WebElement signUp;

    @FindBy (xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUp;

    @FindBy(css = "[data-qa='signup-name']")
        public WebElement nameUp;

}
