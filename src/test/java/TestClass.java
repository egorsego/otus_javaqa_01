import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TestClass.class);

    @BeforeClass
    public static void wdSetup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void instantiateDriver(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openSite(){
        driver.get("https://otus.ru/");
        String pageTitle = driver.getTitle();
        logger.info(pageTitle + " page is open");
        logger.info("Sample INFO log entry");
        logger.debug("Sample DEBUG log entry");
        logger.error("Sample ERROR log entry");
        logger.fatal("Sample FATAL log entry");
        logger.warn("Sample WARNING log entry");
        assert pageTitle.contains("OTUS");
    }
}
