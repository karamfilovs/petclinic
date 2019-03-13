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

    @Test
    @DisplayName("PC-18: Can search for existing veterinarians")
    public void canSearchForExistingVeterinarians() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("Helen");
        webApp.veterinariansPage().verifyTableTotalRows(1);
        webApp.veterinariansPage().verifyTableTextContains("Helen Leary");
    }

    @Test
    @DisplayName("PC-19: Can search for not existing veterinarians")
    public void canSearchForNotExistingVeterinarians() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("Helenaaaa");
        webApp.veterinariansPage().verifyTableTextContains("No matching records found");
    }

    @Test
    @DisplayName("PC-20: Can search veterinarian by specialty")
    public void canSearchVeterinariansBySpecialty() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("radiology");
        webApp.veterinariansPage().verifyTableTextContains("radiology");
    }

    @Test
    @DisplayName("PC-21: Can search for not existing veterinarian specialty")
    public void canSearchForNotExistingVeterinarianSpeialty() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("cardiology");
        webApp.veterinariansPage().verifyTableTextContains("No matching records found");
    }

}
