package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(xpath = "//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement loginEmailField;

    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//h2[contains(text(), 'Welcome back')]")
    WebElement welcomeBackMessage;

    // Chose id since id is unique element in html document
    @FindBy(id = "signup-toggle")
    WebElement signUpButton;

    // Chose css selector because I wanted aria-label attribute "Show password"
    // Chose to filter on button with that aria-label just in case another element is given the same aria label.
    // Drawback is likelihood that element button is changed to a div element with role="button"
    // Chose to go specific, so I catch change in DOM and trust tests, rather than debug duplicate aria-labels.
    @FindBy(css = "button[aria-label='Show password']")
    WebElement showPasswordButton;

    // Chose xpath not because there weren't any better locators.
    // I wanted to practice using the Elements window in the browser.
    // I chose normalize-space() to avoid any issues with extra spaces in the text.
    @FindBy(xpath = "//button[normalize-space()='Forgot Password?']")
    WebElement forgotPasswordLink;

    // Chose xpath just to use contains
    // Learned that . concatenates text from all child elements,
    //     so I can use contains to avoid any issues with extra spaces or emojis in the text.
    @FindBy(xpath = "//h2[contains(.,'Login to Access Learning Materials')]")
    WebElement loginHeading;

    // Chose class name because the homework wanted class name used
    @FindBy(className = "nav-items")
    WebElement navItems;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmailAddress(String email) {
        loginEmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        loginPasswordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        loginSubmitButton.click();
    }

    public void verifyLoginSuccess(String expectedMessage) {
        welcomeBackMessage.isDisplayed();
        String actualMessage = welcomeBackMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public boolean isSignUpVisible() {
        return wait.until(ExpectedConditions.visibilityOf(signUpButton)).isDisplayed();
    }

    public boolean isShowPasswordVisible() {
        return wait.until(ExpectedConditions.visibilityOf(showPasswordButton)).isDisplayed();
    }

    public boolean isForgotPasswordVisible() {
        return wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink)).isDisplayed();
    }

    public boolean isLoginHeadingVisible() {
        return wait.until(ExpectedConditions.visibilityOf(loginHeading)).isDisplayed();
    }

    public boolean isNavigationBarVisible() {
        return wait.until(ExpectedConditions.visibilityOf(navItems)).isDisplayed();
    }

    // Gets content of navigation bar and places them on one line
    public String getNavigationBarText() {
        return wait.until(ExpectedConditions.visibilityOf(navItems)).getText().replace('\n', ' ').trim();
    }
}
