import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddOwnerPageTest extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-02: Can go to New Owner page")
    public void canGoToNewOwnerPage() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().verifyHeaderText("New Owner");
    }


    @Test
    @DisplayName("PC-02: Can add owner with valid data")
    public void canAddOwnerWithValidData() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("Ivan");
        webApp.addOwnerPage().enterLastName("Ivanov");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().enterTelephone("088888888");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.ownerInformationPage().verifyHeaderText("Owner Information");
    }
}
