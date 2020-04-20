package pages;


import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageWithFindBy extends BasePage {

    @FindBy(xpath = "//input[@name='EMAIL']")
    WebElement subscribeEmail;

    @FindBy(xpath = "//button[text()='Subscribe']")
    WebElement subscribeButton;

    @FindBy(css = "div.js-errorbox-all.t186__blockinput-errorbox")
    WebElement subscribeValidationErrorNotification;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    WebElement submitEmail;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement submitName;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement submitPhone;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    By emailErrorNotification = By.xpath("(//div[@class='t-form__errorbox-text t-text t-text_md'])[2]");

    public MainPageWithFindBy(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPageWithFindBy open() {
        driver.get(mainPageUrl);
        return this;
    }

    public MainPageWithFindBy inputEmailToSubscribe(String email) {
        subscribeEmail.sendKeys(email);
        return this;
    }

    public MainPageWithFindBy clickSubscribe() {
        subscribeButton.click();
        return this;
    }

    public String getSubscriptionValidationErrorText() {
        return subscribeValidationErrorNotification.getText();
    }

    public MainPageWithFindBy inputEmailToSubmit(String email) {
        submitEmail.sendKeys(email);
        return this;
    }

    public MainPageWithFindBy inputNameToSubmit(String name) {
        submitName.sendKeys(name);
        return this;
    }

    public MainPageWithFindBy inputPhoneToSubmit(String phone) {
        submitPhone.sendKeys(phone);
        return this;
    }

    public MainPageWithFindBy clickSubmit() {
        submitButton.click();
        return this;
    }

    public String getEmailErrorNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement errorNotification = driver.findElement(emailErrorNotification);
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText();
    }

}
