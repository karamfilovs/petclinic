package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.VeterinariansPage;

import java.lang.reflect.Method;
import java.time.LocalTime;


@ExtendWith(CustomParameterResolver.class)
public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    protected WebApp webApp;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup(TestInfo info) {
        webApp = new WebApp();
        webApp.startBrowser(System.getProperty("browser"));
        LOGGER.info("Starting test: " + info.getDisplayName());

    }

    @AfterEach
    public void tearDown(ExtensionContext extensionContext) {
        if (System.getProperty("take.screenshots.enabled").equalsIgnoreCase("true")) {
            Method testMethod = extensionContext.getRequiredTestMethod();
            boolean testFailed = extensionContext.getExecutionException().isPresent();
            if (testFailed) {
                webApp.takeScreenshot(testMethod.getDeclaringClass().getSimpleName(), testMethod.getName(), LocalTime.now());
            }
        }
        webApp.quit();
    }
}
