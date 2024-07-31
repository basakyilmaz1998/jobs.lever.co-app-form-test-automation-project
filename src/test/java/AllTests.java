import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AllTests extends BaseTest {

    //region Open Pages
    @Test
    public void openLearnMorePage() {
        FormPage formPage = new FormPage(driver);
        formPage.clickLearnMore();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.linkedin.com/help/linkedin/answer/a507542/", newUrl);
    }

    @Test
    public void openLeverPage() {
        FormPage formPage = new FormPage(driver);
        formPage.clickLever();
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.lever.co/job-seeker-support/", newUrl);
    }
    //endregion

    //region Set Fields
    @Test
    public void setFullame() {
        FormPage formPage = new FormPage(driver);
        String fullNameSample = "Başak Yılmaz";
        formPage.setFullName(fullNameSample);
        Assertions.assertEquals(fullNameSample, formPage.getValueOfFullName(), "Fullname value is not correct!");
    }

    @Test
    public void setEmail() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "emailSample@gmail.com";
        formPage.setEmail(emailSample);
        Assertions.assertEquals(emailSample, formPage.getValueOfEmail(), "Email value is not correct!");
    }

    @Test
    public void setPhone() {
        FormPage formPage = new FormPage(driver);
        String phoneSample = "05555555555";
        formPage.setPhone(phoneSample);
        Assertions.assertEquals(phoneSample, formPage.getValueOfPhone(), "Phone value is not correct!");
    }

    @Test
    public void setCurrentLocation() {
        FormPage formPage = new FormPage(driver);
        String currentLocationSample = "İstanbul";
        formPage.setCurrentLocation(currentLocationSample);
        Assertions.assertEquals(currentLocationSample, formPage.getValueOfCurrentLocation(), "Current Location value is not correct!");
    }

    @Test
    public void setCurrentCompany() {
        FormPage formPage = new FormPage(driver);
        String currentCompanySample = "Selancer Teknoloji";
        formPage.setCurrentCompany(currentCompanySample);
        Assertions.assertEquals(currentCompanySample, formPage.getValueOfCurrentCompany(), "Current Company value is not correct!");
    }

    @Test
    public void setLinkedlnUrl() {
        FormPage formPage = new FormPage(driver);
        String linkedlnUrlSample = "https://www.linkedin.com/in/basakyilmaz9898/";
        formPage.setLinkedlnUrl(linkedlnUrlSample);
        Assertions.assertEquals(linkedlnUrlSample, formPage.getValueOfLinkedlnUrl(), "Linkedln URL value is not correct!");
    }

    @Test
    public void setStackOverflowUrl() {
        FormPage formPage = new FormPage(driver);
        String stackOverflowUrlSample = "https://stackoverflow.com/users/438273/jsejcksn";
        formPage.setStackOverFlowUrl(stackOverflowUrlSample);
        Assertions.assertEquals(stackOverflowUrlSample, formPage.getValueOfStackOverFlowUrl(), "Stack Overflow URL value is not correct!");
    }

    @Test
    public void setGitHubUrl() {
        FormPage formPage = new FormPage(driver);
        String gitHubUrlSample = "https://github.com/basakyilmaz1998";
        formPage.seGitHubUrl(gitHubUrlSample);
        Assertions.assertEquals(gitHubUrlSample, formPage.getValueOfGitHubUrl(), "GitHub URL value is not correct!");
    }

    @Test
    public void setPorfolioUrl() {
        FormPage formPage = new FormPage(driver);
        String portfolioUrlSample = "https://www.awwwards.com/sites/my-portfolio-italo-santorsula";
        formPage.setPortolioUrl(portfolioUrlSample);
        Assertions.assertEquals(portfolioUrlSample, formPage.getValueOfPortfolioUrl(), "Portfolio URL value is not correct!");
    }

    @Test
    public void setAdditionalInformation() {
        FormPage formPage = new FormPage(driver);
        String additionalInformationSample = "//";
        formPage.setAdditionalInformation(additionalInformationSample);
        Assertions.assertEquals(additionalInformationSample, formPage.getValueOfAdditionalInformation(), "Additional information value is not correct!");
    }
    //endregion

    //region Attach Files
    @Test
    public void attachResume() {
        FormPage formPage = new FormPage(driver);
        formPage.attachResume();
        WebElement resumeSuccess = formPage.find(formPage.resumeSuccessLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(resumeSuccess));
        Assertions.assertTrue(formPage.isDisplayedSuccessResume(), "Resume can not attach");
    }
    //endregion

























    //region Submit Required Fields

    //POSITIVE
    @Test
    public void submitOnlyRequiredFields() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Ali Sağlam");
        formPage.setEmail("ali.saglam87@gmail.com");
        formPage.setPhone("05555555555");
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application submitted!", isSubmitted, "Although the required elements were provided, the form could not be submitted.");
    }

    //NEGATIVE
    @Test
    public void submitWithoutFullname() {
        FormPage formPage = new FormPage(driver);
        formPage.setEmail("ali.saglam87@gmail.com");
        formPage.setPhone("05555555555");
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though the required Fullname was not sent.");
    }

    @Test
    public void submitWithoutEmail() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Ali Sağlam");
        formPage.setPhone("05555555555");
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though the required Email was not sent.");
    }

    @Test
    public void submitWithoutPhone() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Ali Sağlam");
        formPage.setEmail("ali.saglam87@gmail.com");
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though the required Phone was not sent.");
    }
    //endregion

    //region Submit with Different Email Types
    //POSITIVE
    @Test
    public void sendEmailWithTruePattern() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "username@domain.com";
        formPage.setAllRequiredFilesWithoutEmail(formPage);
        formPage.setEmail(emailSample);
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}

    //NEGATIVE
    @Test
    public void sendEmailWithWrongPattern1() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "@domain.com";
        formPage.setAllRequiredFilesWithoutEmail(formPage);
        formPage.setEmail(emailSample);
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}
    //endregion
}
