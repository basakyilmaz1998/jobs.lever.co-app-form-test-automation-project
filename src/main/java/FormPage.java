import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {

    /*
     * In the constructor method,
     * call the parent class's constructor
     * and ensure that when an object is created from the FormPage class in the tests,
     * the driver opens the specified URL
     */
    public FormPage(WebDriver driver) {
        super(driver);
        driver.get(Url);
    }

    String resumePath = "C:\\Users\\basak\\IdeaProjects\\commenics-test-camp-2024-form-page-automation\\Samples\\CV.pdf";

    //region Locaters
    private final By logoLocator = By.cssSelector("a.main-header-logo");
    private final By linkedlnApplyButtonLocator = By.xpath("//*[@id=\"application-form\"]/div[1]/ul/li[1]/div[2]/div/button");
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

    public void setStackOverFlowUrl(String stackOverFlowUrlTest) {
        type(stackOverflowUrlLocator, stackOverFlowUrlTest);
    }

    public void seGitHubUrl(String githubUrlTest) {
        type(gitHubUrlLocator, githubUrlTest);
    }

    public void setPortolioUrl(String portfolioUrlTest) {
        type(portfolioUrlLocator, portfolioUrlTest);
    }

    public void setAdditionalInformation(String additionalInformationTest) {
        type(additionalInformationLocator, additionalInformationTest);
    }
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

    public void clickLinkedlnApplyButton() {
        click(linkedlnApplyButtonLocator);
    }

    public void clickLearnMore() {
        click(learnMoreLocator);
    }

    public void clickAttachResume() {
        click(attachResumeLocator);
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
    public void attachResume(){type(attachResumeLocator, resumePath);}
    public boolean isDisplayedSuccessResume(){return isDisplayed(resumeSuccessLocator);}
    //endregion


    //region checkFormSubmission
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
    public void setAllRequiredFilesWithoutEmail(FormPage formPage){
        formPage.setFullName("Ali Sağlam");
        formPage.setPhone("05555555555");
    }
    //endregion

}
