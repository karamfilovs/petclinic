package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.lang.reflect.Method;
import java.time.LocalTime;


@ExtendWith(CustomParameterResolver.class)
public class BaseTest {
    protected WebApp webApp;

    @BeforeEach
    public void setup() {
        webApp = new WebApp();
        webApp.startBrowser(System.getProperty("browser"));
    }


}
