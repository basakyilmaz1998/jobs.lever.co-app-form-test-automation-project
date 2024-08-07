import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class WithoutSubmitTests extends BaseTest {

    //region Open Pages
    @Test
    public void openJobOpportunitiesPage() {
        FormPage formPage = new FormPage(driver);
        formPage.clickLogo();
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://jobs.lever.co/commencis", newUrl);
    }
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
        WebElement resumeSuccess = formPage.getResumeSuccessElement();
        formPage.wait(resumeSuccess, 10L);
        Assertions.assertTrue(formPage.isDisplayedSuccessResume(), "Resume can not attach");
    }
    //endregion

}
