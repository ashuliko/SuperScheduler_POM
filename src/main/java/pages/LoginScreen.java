package pages;

import dto.Credentials;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseScreen{
    //после ввода все красным, надо нажать  Alt+Enter и создать конструктор сперкласса

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(emailEditText));
        type (emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password){
        type (passwordEditText, password);
        return this;
    }

    public WizardScreen clickLoginButton(){
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);

    }

}
