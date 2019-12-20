import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VeterinariansPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-17: Can go to veterinarians page")
    public void canGoToVeterinariansPage() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().verifyHeaderText("Veterinarians");
    }

}
