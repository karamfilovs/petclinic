import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-20: Can go to error page")
    public void canGoToErrorPage() {
        webApp.components().mainMenu().clickErrorLink();
        webApp.errorPage().verifyHeaderText("Something happened...");
    }
}
