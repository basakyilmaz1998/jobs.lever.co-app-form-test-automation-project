import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
        protected static WebDriver driver;

        @BeforeAll
        public void setUp(){

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            System.out.println("Started!");
        }

        @BeforeEach
        public void beforeMethod(){
            driver = new ChromeDriver();
        }

        @AfterEach
        public void afterMethod(){
            driver.quit();
        }

        @AfterAll
        public void tearDown() {
            System.out.println("Done!");
        }


    }

