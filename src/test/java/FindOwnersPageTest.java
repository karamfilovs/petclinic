import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FindOwnersPageTest extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }


    @Test
    @DisplayName("PC-12: Can go to find owners page")
    public void canGoToFindOwnersPage() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.homePage().verifyHeaderText("Find Owners");
    }

    @Test
    @Tag("only")
    @DisplayName("PC-13: Can search for not existing owners")
    public void canSearchForNotExistingOwners() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("helen");
        webApp.findOwnersPage().clickFindOwnerButton();
      //  webApp.findOwnersPage().verifyErrorMessage("has not been found");
    }

    @Test
    @DisplayName("PC-14: Can search for existing owners")
    public void canSearchForExistingOwners() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("Davis");
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().verifyHeaderText("Owners");
        webApp.ownersPage().verifyTableTotalRows(2);
    }

    @Test
    @DisplayName("PC-26: Can search for existing owners by partial match")
    public void canSearchForExistingOwnersByPartialMatch() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("e");
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().verifyHeaderText("Owners");
        webApp.ownersPage().verifyTableTotalRows(2);
    }
}
