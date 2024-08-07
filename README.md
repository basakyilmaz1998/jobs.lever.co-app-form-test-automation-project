

# Commencis Test Camp 2024 Application Form Test Automation Project

This is a software test automation for the application form of the Commencis Test Camp 2024, created via the Lever company. <br>
The page will remain open until August 15, 2024.
 
### Prerequisites

- chromedriver.exe

Make sure 'chromedriver.exe' version:127.0.6533.99, compatible with your Chrome browser.<br>
You can find your current Chrome version under Settings > About Chrome <br>
Update the path to 'chromedriver.exe' in the value parameter of the property with the key webdriver.chrome.driver located in 'src/test/java/BaseTest.java'

## Test Classes

- **'src/test/java/WithoutSubmitTests.java'**
  
This class contains tests that do not require clicking the submit button. <br><br>
Content: Tests for opening linked pages, setting inputs, and attaching files.
  
- **'src/test/java/WithSubmitTests.java'**
  
This class contains tests that require clicking the submit button.<br>
The class is annotated with @Disabled to prevent data pollution, as the site is live and accepts data entries.<br>
Additionally, human verification is required due to reCAPTCHA.<br>
Therefore, the tests in this class are not intended to be run, but are created to demonstrate the algorithm.<br><br>
Content: Positive and negative tests for filling required fields, and positive and negative pattern tests for email input.

## Built With
* Programming Languages: Java
* Environment: JDK 17.0.10
* Maven 2.22.0
* Log4j 1.2.17
* JUnit 5.10.1
* Selenium 4.23.0


