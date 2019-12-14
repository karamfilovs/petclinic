import core.BaseTest;
import enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddPetPageTest extends BaseTest {
    @BeforeEach
    public void loadAddPetScreen() {
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

    @Test
    @Tag("negative")
    @DisplayName("PC-11: Cant add pet with blank type")
    public void cantAddPetWithBlankType() {
        webApp.addPetPage().enterName("Sarah");
        webApp.addPetPage().selectDateFromCalendar("10");
        webApp.addPetPage().clickAddPetButton();
        webApp.addPetPage().verifyTypeError("is required");
    }

    @Test
    @Tag("negative")
    @DisplayName("PC-21: Cant add pet with futire bith date")
    public void cantAddPetWithFutureBirthDate() {
        webApp.addPetPage().enterName("Suzana");
        webApp.addPetPage().enterBirthDate("2030/03/14");
        webApp.addPetPage().selectType(Type.BIRD);
        webApp.addPetPage().clickAddPetButton();
        webApp.addPetPage().verifyBirthDateError("Can't register pet with fututre date");

    }

    @Test
    @Tag("negative")
    @DisplayName("PC-22: Cant add pet with invalid bith date")
    public void cantAddPetWithInvalidBirthDate() {
        webApp.addPetPage().enterName("Suzanaa");
        webApp.addPetPage().enterBirthDate("2030/03/50");
        webApp.addPetPage().selectType(Type.BIRD);
        webApp.addPetPage().clickAddPetButton();
        webApp.addPetPage().verifyBirthDateError("invalid date");

    }
}
