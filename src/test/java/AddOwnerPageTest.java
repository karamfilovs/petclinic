import core.BaseTest;
import enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddOwnerPageTest extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-01: Can go to New Owner page")
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

    @Test
    @DisplayName("PC-03: Cant add owner with blank first name")
    public void cantAddOwnerWithBlankFirstName() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterLastName("Ivanov");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().enterTelephone("088888888");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyFirstNameError("may not be empty");
    }

    @Test
    @DisplayName("PC-04: Cant add owner with blank last name")
    public void cantAddOwnerWithBlankLastName() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("Ivan");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().enterTelephone("088888888");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyLastNameError("may not be empty");
    }

    @Test
    @DisplayName("PC-05: Cant add owner with blank telephone number")
    public void cantAddOwnerWithBlankTelephoneNumber() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("Ivan");
        webApp.addOwnerPage().enterLastName("Ivanov");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyTelephoneError("may not be empty");
    }

    @Test
    @DisplayName("PC-06: Cant add owner with multiple blank fields")
    public void cantAddOwnerWithMultipleBlankFields() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyFirstNameError("may not be empty");
        webApp.addOwnerPage().verifyLastNameError("may not be empty");
        webApp.addOwnerPage().verifyTelephoneError("numeric value out of bounds (<10 digits>.<0 digits> expected)");
    }

    @Test
    @DisplayName("PC-07: Cant add owner with invalid telephone number")
    public void cantAddOwnerWithInvalidTelephoneNumber() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("Ivan");
        webApp.addOwnerPage().enterLastName("Ivanov");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().enterTelephone("aaaa");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyTelephoneError("numeric value out of bounds (<10 digits>.<0 digits> expected)");
    }

    @Test
    @DisplayName("PC-08: Can add owner and an animal")
    public void canAddOwnerAndAnimal() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("Dragan");
        webApp.addOwnerPage().enterLastName("Draganov");
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().enterTelephone("088888888");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.ownerInformationPage().verifyHeaderText("Owner Information");
        webApp.ownerInformationPage().clickAddPetButton();
        webApp.addPetPage().addNewPet("Sarah", "10", Type.DOG);
        webApp.ownerInformationPage().verifySecondHeaderText("Pets and Visits");
    }

    @Test
    @DisplayName("PC-24: Cant add owner with special characters and numbers mixed in all fields without telephone")
    public void canAddOwnerWithSpecialCharactersAndNumbersMixedInAllFieldsWithoutTelephone() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("@nton098");
        webApp.addOwnerPage().enterLastName("$hehov123");
        webApp.addOwnerPage().enterAddress("123#^&ABV\n");
        webApp.addOwnerPage().enterCity("*![]<yooohoho>{}123/\\\n");
        webApp.addOwnerPage().enterTelephone("0000");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyFirstNameWithMixedCharsError("Error text invalid data please enter string text for First Name field!!!");
        webApp.addOwnerPage().verifyLastNameWithMixedCharsError("Error text invalid data please enter string text for Last Name field!!!");
        webApp.addOwnerPage().verifyAddressWithMixedCharsError("Error text invalid data please enter string text and numbers for Address field!!!");
        webApp.addOwnerPage().verifyCityNameWithMixedCharsError("Error text invalid data please enter string text for City field!!!");
        webApp.addOwnerPage().verifyTelephoneSeveralNumbersError("Error in invalid size number enter 10 digits field!!!");
    }

    @Test
    @DisplayName("PC-25: Can add owner and an animal with special characters and numbers mixed in all fields without telephone")
    public void canAddOwnerAndAnAnimalWithSpecialCharactersAndNumbersMixedInAllFieldsWithoutTelephone() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName("@ntoniq123#");
        webApp.addOwnerPage().enterLastName("Dr@g0v@666");
        webApp.addOwnerPage().enterAddress("0ut 0F $pace #{2020}");
        webApp.addOwnerPage().enterCity("S0fiy!2019");
        webApp.addOwnerPage().enterTelephone("000000000000");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.ownerInformationPage().verifyHeaderText("Owner Information");
        webApp.ownerInformationPage().clickAddPetButton();
        webApp.addPetPage().addNewPet("Dr@gonF#y99", "3", Type.LIZARD);
        webApp.ownerInformationPage().verifySecondHeaderText("Pets and Visits");
    }
}
