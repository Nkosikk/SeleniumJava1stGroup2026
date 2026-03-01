package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginWithValidDetails() throws InterruptedException {

        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.enterEmailAddress("ngomakhanyi88@gmail.com");
        loginPage.enterPassword("Khanyisile@21");
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(3000);
        loginPage.verifyLoginSuccess("Welcome back, Khanyisile! \uD83D\uDC4B");

        //1. Click on My Learning button
        locatorTask.clickMyLearningButton();
        Thread.sleep(2000);

        //2. Click on My Courses button
        locatorTask.clickMyCoursesButton();
        Thread.sleep(2000);

        //3. Click on My Enrolments button
        // Verify My Enrolments header appears
        locatorTask.verifyMyEnrolmentsDisplayed("\uD83C\uDF93 My Enrollments");

        //4.Click on Testimonials button
        locatorTask.clicktestimonialsButton();
        Thread.sleep(2000);

        //5. Verify Testimonials header appears
        locatorTask.verifytestimonialsButton("Real stories");

    }
}
