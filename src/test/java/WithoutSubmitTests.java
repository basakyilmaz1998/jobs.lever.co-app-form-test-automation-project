import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class WithoutSubmitTests extends BaseTest {
    FormPage formPage;

    //region Open Pages
    @Test
    public void openJobOpportunitiesPage() {
        formPage = new FormPage(driver);
        formPage.clickLogo();
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://jobs.lever.co/commencis", newUrl);
    }

    @Test
    public void openLearnMorePage() {
        formPage = new FormPage(driver);
        formPage.clickLearnMore();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.linkedin.com/help/linkedin/answer/a507542/", newUrl);
    }

    @Test
    public void openLeverPage() {
        formPage = new FormPage(driver);
        formPage.clickLever();
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.lever.co/job-seeker-support/", newUrl);
    }
    //endregion

    //region Set Fields
    @Test
    public void setFullame() {
        formPage = new FormPage(driver);
        String fullNameSample = "Name Lastname";
        formPage.setFullName(fullNameSample);
        Assertions.assertEquals(fullNameSample, formPage.getValueOfFullName(), "Fullname value is not correct!");
    }

    @Test
    public void setEmail() {
        formPage = new FormPage(driver);
        String emailSample = "username@domain.com";
        formPage.setEmail(emailSample);
        Assertions.assertEquals(emailSample, formPage.getValueOfEmail(), "Email value is not correct!");
    }

    @Test
    public void setPhone() {
        formPage = new FormPage(driver);
        String phoneSample = "05555555555";
        formPage.setPhone(phoneSample);
        Assertions.assertEquals(phoneSample, formPage.getValueOfPhone(), "Phone value is not correct!");
    }

    @Test
    public void setCurrentLocation() {
        formPage = new FormPage(driver);
        String currentLocationSample = "Location";
        formPage.setCurrentLocation(currentLocationSample);
        Assertions.assertEquals(currentLocationSample, formPage.getValueOfCurrentLocation(), "Current Location value is not correct!");
    }

    @Test
    public void setCurrentCompany() {
        formPage = new FormPage(driver);
        String currentCompanySample = "The Company";
        formPage.setCurrentCompany(currentCompanySample);
        Assertions.assertEquals(currentCompanySample, formPage.getValueOfCurrentCompany(), "Current Company value is not correct!");
    }

    @Test
    public void setLinkedlnUrl() {
        formPage = new FormPage(driver);
        String linkedlnUrlSample = "https://www.linkedin.com/in/";
        formPage.setLinkedlnUrl(linkedlnUrlSample);
        Assertions.assertEquals(linkedlnUrlSample, formPage.getValueOfLinkedlnUrl(), "Linkedln URL value is not correct!");
    }

    @Test
    public void setStackOverflowUrl() {
        formPage = new FormPage(driver);
        String stackOverflowUrlSample = "https://stackoverflow.com/";
        formPage.setStackOverFlowUrl(stackOverflowUrlSample);
        Assertions.assertEquals(stackOverflowUrlSample, formPage.getValueOfStackOverFlowUrl(), "Stack Overflow URL value is not correct!");
    }

    @Test
    public void setGitHubUrl() {
        formPage = new FormPage(driver);
        String gitHubUrlSample = "https://github.com/";
        formPage.seGitHubUrl(gitHubUrlSample);
        Assertions.assertEquals(gitHubUrlSample, formPage.getValueOfGitHubUrl(), "GitHub URL value is not correct!");
    }

    @Test
    public void setPorfolioUrl() {
        formPage = new FormPage(driver);
        String portfolioUrlSample = "https://portfolio.adobe.com/examples/";
        formPage.setPortolioUrl(portfolioUrlSample);
        Assertions.assertEquals(portfolioUrlSample, formPage.getValueOfPortfolioUrl(), "Portfolio URL value is not correct!");
    }

    @Test
    public void setAdditionalInformation() {
        formPage = new FormPage(driver);
        String additionalInformationSample = "Lorem ipsum dolor sit amet, consectetur adipisicing elit.";
        formPage.setAdditionalInformation(additionalInformationSample);
        Assertions.assertEquals(additionalInformationSample, formPage.getValueOfAdditionalInformation(), "Additional information value is not correct!");
    }
    //endregion

    //region Attach Files
    @Test
    public void attachResume() {
        formPage = new FormPage(driver);
        formPage.attachResume();
        WebElement resumeSuccess = formPage.getResumeSuccessElement();
        formPage.wait(resumeSuccess, 10L);
        Assertions.assertTrue(formPage.isDisplayedSuccessResume(), "Resume can not attach");
    }
    //endregion

}
