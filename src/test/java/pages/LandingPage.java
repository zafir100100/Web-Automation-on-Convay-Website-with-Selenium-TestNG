package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class LandingPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/sign-in']")
    public WebElement btnSignIn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLandingPage() {
        driver.get("https://convay.com");
    }

    public void navigateToSignInPage() {
        btnSignIn.click();
    }
}
