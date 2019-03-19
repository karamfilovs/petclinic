import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OwnersPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-16: Can go to owners page")
    public void canGoToOwnersPage() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("");
        webApp.findOwnersPage().clickFindOwnerButton();
    }
    @Test
    @DisplayName("PC-22: Can search by existing first name")
    public void canSearchByFirstName() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().search("Betty");
        webApp.ownersPage().verifyTableTextContains("Betty");
    }

    @Test
    @DisplayName("PC-23: Can search by not existing first name")
    public void canSearchByNotExistingFirstName(){
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().search("Yavor");
        webApp.ownersPage().verifyTableTextContains("No matching records found");
    }
}
