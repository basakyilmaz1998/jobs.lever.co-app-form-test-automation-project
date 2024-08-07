import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("These tests require clicking the submit button.")
public class WithSubmitTests extends BaseTest{

    //region Submit Required Fields
    @Test
    public void submitOnlyRequiredFields() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Name Lastname");
        formPage.setEmail("username@domain.com");
        formPage.setPhone("05555555555");
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application submitted!", isSubmitted, "Although the required elements were provided, the form could not be submitted.");
    }

    //NEGATIVE
    @Test
    public void submitWithoutFullname() {
        FormPage formPage = new FormPage(driver);
        formPage.setEmail("Name Lastname");
        formPage.setPhone("username@domain.com");
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though the required Fullname was not sent.");
    }

    @Test
    public void submitWithoutEmail() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Name Lastname");
        formPage.setPhone("username@domain.com");
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though the required Email was not sent.");
    }

    @Test
    public void submitWithoutPhone() {
        FormPage formPage = new FormPage(driver);
        formPage.setFullName("Name Lastname");
        formPage.setEmail("username@domain.com");
        formPage.clickSubmitButton();
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
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}

    //NEGATIVE
    @Test
    public void sendEmailWithWrongPattern1() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "@domain.com";
        formPage.setAllRequiredFilesWithoutEmail(formPage);
        formPage.setEmail(emailSample);
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}

    @Test
    public void sendEmailWithWrongPattern2() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "username@";
        formPage.setAllRequiredFilesWithoutEmail(formPage);
        formPage.setEmail(emailSample);
        formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}
    //endregion

}
