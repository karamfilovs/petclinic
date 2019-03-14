import core.BaseTest;
import enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddPetPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("");
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().clickOwnerName();
        webApp.ownerInformationPage().clickAddPetButton();

    }

    @Test
    @Tag("negative")
    @DisplayName("PC-09: Cant add pet with blank name")
    public void cantAddPetWithBlankName() {
        webApp.addPetPage().enterName("");
        webApp.addPetPage().selectDateFromCalendar("10");
        webApp.addPetPage().selectType(Type.BIRD);
        webApp.addPetPage().clickAddPetButton();
        webApp.addPetPage().verifyNameError("is required");
    }

    @Test
    @Tag("negative")
    @DisplayName("PC-10: Cant add pet with blank birth date")
    public void cantAddPetWithBlankBirthDate() {
        webApp.addPetPage().enterName("Sarah");
        webApp.addPetPage().selectType(Type.BIRD);
        webApp.addPetPage().clickAddPetButton();
        webApp.addPetPage().verifyBirthDateError("is required");
    }

}


