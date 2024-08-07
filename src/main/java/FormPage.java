import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class represents the elements and specialized functionality of the Form Page.
 * @author Başak Yılmaz
 * @version 1.0
 * @since 2024-08-03
 */
public class FormPage extends BasePage {

    /**
     * Constructs a new instance of the {@code FormPage} class.
     * This constructor initializes the page by calling the parent class's constructor and
     * navigating the provided {@code WebDriver} to the specified URL.
     *
     * @param driver the {@code WebDriver} instance used to interact with the browser
     * @see #Url
     */
    public FormPage(WebDriver driver) {
        super(driver);
        driver.get(Url);
    }

    /**
     * resumePath the path to the resume to be attached.
     */
    String resumePath = "C:\\Users\\basak\\IdeaProjects\\commenics-test-camp-2024-form-page-automation\\Samples\\CV.pdf";

    //region Locators
    private final By logoLocator = By.cssSelector("a.main-header-logo");
    private final By learnMoreLocator = By.cssSelector("a.learn-more-link");
    private final By attachResumeLocator = By.cssSelector("input[data-qa='input-resume']");
    private final By fullNameLocator = By.cssSelector("input[data-qa='name-input']");
    private final By emailLocator = By.cssSelector("input[data-qa='email-input']");
    private final By phoneLocator = By.cssSelector("input[data-qa='phone-input']");
    private final By currentLocationLocator = By.cssSelector("input[data-qa='location-input']");
    private final By currentCompanyLocator = By.cssSelector("input[data-qa='org-input']");
    private final By linkedlnUrlLocator = By.cssSelector("input[name='urls[LinkedIn]']");
    private final By stackOverflowUrlLocator = By.cssSelector("input[name='urls[Stack Overflow]']");
    private final By gitHubUrlLocator = By.cssSelector("input[name='urls[GitHub]']");
    private final By portfolioUrlLocator = By.cssSelector("input[name='urls[Portfolio]']");
    private final By additionalInformationLocator = By.id("additional-information");
    private final By submitButtonLocator = By.cssSelector("button[data-qa='btn-submit']");
    private final By leverLocator = By.cssSelector("a[href='https://www.lever.co/job-seeker-support/']");
    private final By submitSuccessLocator = By.cssSelector("h3[data-qa='msg-submit-success']");
    public final By resumeSuccessLocator = By.xpath("//*[@id=\"application-form\"]/div[1]/ul/li[2]/label/div[2]/span[3]/div[2]");
    //endregion

    //region Set Elements
    public void setFullName(String fullNameTest) {
        type(fullNameLocator, fullNameTest);
    }

    public void setEmail(String emailTest) {
        type(emailLocator, emailTest);
    }

    public void setPhone(String phoneTest) {
        type(phoneLocator, phoneTest);
    }

    public void setCurrentLocation(String locationTest) {
        type(currentLocationLocator, locationTest);
    }

    public void setCurrentCompany(String companyTest) {
        type(currentCompanyLocator, companyTest);
    }

    public void setLinkedlnUrl(String linkedlnUrlTest) {
        type(linkedlnUrlLocator, linkedlnUrlTest);
    }

    public void setStackOverFlowUrl(String stackOverFlowUrlTest) {type(stackOverflowUrlLocator, stackOverFlowUrlTest);}

    public void seGitHubUrl(String githubUrlTest) {
        type(gitHubUrlLocator, githubUrlTest);
    }

    public void setPortolioUrl(String portfolioUrlTest) {
        type(portfolioUrlLocator, portfolioUrlTest);
    }

    public void setAdditionalInformation(String additionalInformationTest) {type(additionalInformationLocator, additionalInformationTest);}
    //endregion

    //region Get Value of Elements
    public String getValueOfFullName() {
        return getValue(fullNameLocator);
    }

    public String getValueOfEmail() {
        return getValue(emailLocator);
    }

    public String getValueOfPhone() {
        return getValue(phoneLocator);
    }

    public String getValueOfCurrentLocation() {
        return getValue(currentLocationLocator);
    }

    public String getValueOfCurrentCompany() {
        return getValue(currentCompanyLocator);
    }

    public String getValueOfLinkedlnUrl() {
        return getValue(linkedlnUrlLocator);
    }

    public String getValueOfStackOverFlowUrl() {
        return getValue(stackOverflowUrlLocator);
    }

    public String getValueOfGitHubUrl() {
        return getValue(gitHubUrlLocator);
    }

    public String getValueOfPortfolioUrl() {
        return getValue(portfolioUrlLocator);
    }

    public String getValueOfAdditionalInformation() {
        return getValue(additionalInformationLocator);
    }
    //endregion

    //region Click on the Elements
    public void clickLogo() {
        click(logoLocator);
    }

    public void clickLearnMore() {
        click(learnMoreLocator);
    }

    public void clickSubmitButton() {
        click(submitButtonLocator);
    }

    public void clickLever() {
        click(leverLocator);
    }
    //endregion

    //region Get Text of Elements
    public String getTextSubmitSuccess() {
        return getText(submitSuccessLocator);
    }
    //endregion

    //region attachResume Methods
    public void attachResume() {type(attachResumeLocator, resumePath);}

    public boolean isDisplayedSuccessResume() {return isDisplayed(resumeSuccessLocator);}
    //endregion

    //region checkFormSubmission
    /**
     * Checks if the form was successfully submitted on the given {@code FormPage}.
     * Retrieves the success message text and compares it to the expected message.
     * If the success message element is not found, it indicates that the page may not have loaded.
     * The {@code NoSuchElementException} is caught if the element is missing.
     *
     * @param formPage the {@code FormPage} instance
     * @return a message indicating the result of the form submission:
     *         "Application submitted!" if successful,
     *         or "Application can not submitted!" if the success message is not found
     */
    public String checkFormSubmission(FormPage formPage) {
        String message = null;
        try {
            String submitSuccessText = formPage.getTextSubmitSuccess();
            if (submitSuccessText.equals("\"Application submitted!\"")) {
                message = "Application submitted!";
            }
        } catch (NoSuchElementException e) {
            message = "Application can not submitted!";
        }
        return message;
    }
    //endregion

    //region setAllRequiredFilesWithoutEmail
    public void setAllRequiredFilesWithoutEmail(FormPage formPage) {
        formPage.setFullName("Name Lastname");
        formPage.setPhone("05555555555");
    }
    //endregion

    //region Get Elements
    public WebElement getResumeSuccessElement() {
        try {
            return find(resumeSuccessLocator);
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    //endregion

}
