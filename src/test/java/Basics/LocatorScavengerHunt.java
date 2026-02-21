package Basics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorScavengerHunt {

    //used Id locator because its the most unique and least likely to change
    @FindBy (id="name")
    WebElement nameField;

    //We can use the class locator because it is unique to the email field and is unlikely to change
    @FindBy(xpath = "//input[@data-testid='email-input' ]")
    WebElement emailField;

    //We can use the name locator because it is unique to the password field and is unlikely to change
    @FindBy (css = "#age")
    WebElement ageField;

    //We can use the tag name locator because there is only one button element on the page and it is unlikely to change
    @FindBy(xpath = "//select[contains(@id,'gender')]")
    WebElement genderDropDown;

    //we use starts-with function in xpath because the id of the country dropdown starts with "cou" and it is unlikely to change
    @FindBy(xpath = "//select[starts-with(@id,'cou')]")
    WebElement countryDropdown;


}
