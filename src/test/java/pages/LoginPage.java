package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='signInMail']")
    public WebElement txtMail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@name='sign_up_submit']")
    public WebElement btnSignIn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password) {
        txtMail.clear();
        txtMail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnSignIn.click();
    }

    public void verifyValidLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://convay.com/home"));

        Assert.assertTrue(driver.getPageSource().contains("Home"), "Expected text 'Home,' not found on the page.");
    }
}
