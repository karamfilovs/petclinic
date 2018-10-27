package core;

import core.WebApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected WebApp webApp;

    @BeforeEach
    public void setup(){
        webApp = new WebApp();
        webApp.startBrowser(System.getProperty("browser"));
    }

    @AfterEach
    public void tearDown() {
        webApp.quit();
    }
}
