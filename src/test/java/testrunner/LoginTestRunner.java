package testrunner;

import io.qameta.allure.Allure;
import models.ApplicationConfiguration;
import org.testng.annotations.Test;
import pages.*;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LandingPage landingPage;
    LoginPage loginPage;

    @Test(priority = 1, description = "Verify valid login functionality with correct credentials")
    public void verifyValidLogin() throws InterruptedException {
        landingPage=new LandingPage(driver);
        landingPage.navigateToLandingPage();
        landingPage.navigateToSignInPage();
        loginPage=new LoginPage(driver);
        loginPage.doLogin(config.getAdminEmail(),config.getAdminPassword());
        loginPage.verifyValidLogin();
        Allure.description("Valid login functionality with correct credentials");
    }
}
