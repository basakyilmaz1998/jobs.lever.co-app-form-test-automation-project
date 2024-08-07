import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("This test requires clicking the submit button, which will cause data to be sent. If you want to send the data, please remove the \"@Disabled\" annotation from the class.")
public class TestsWithSubmit extends BaseTest{

    //region Submit Required Fields
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

    @Test
    public void sendEmailWithWrongPattern2() {
        FormPage formPage = new FormPage(driver);
        String emailSample = "username@";
        formPage.setAllRequiredFilesWithoutEmail(formPage);
        formPage.setEmail(emailSample);
        //formPage.clickSubmitButton();
        String isSubmitted = formPage.checkFormSubmission(formPage);
        Assertions.assertEquals("Application can not submitted!", isSubmitted, "It was submitted even though wrong pattern:" + emailSample);}
    //endregion

}
