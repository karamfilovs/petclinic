import core.BaseTest;
import enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
        webApp.addOwnerPage().verifyHeaderText("Owner");
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
        webApp.addOwnerPage().verifyFirstNameError("must not be empty");
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
        webApp.addOwnerPage().verifyLastNameError("must not be empty");
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
        // works in Intellij run
        webApp.addOwnerPage().verifyTelephoneError("numeric value out of bounds (<10 digits>.<0 digits> expected)\nmust not be empty");
        // works in Terminal run
//        webApp.addOwnerPage().verifyTelephoneError("must not be empty\nnumeric value out of bounds (<10 digits>.<0 digits> expected)");
    }

    @Test
    @DisplayName("PC-06: Cant add owner with multiple blank fields")
    public void cantAddOwnerWithMultipleBlankFields() {
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterAddress("Student city");
        webApp.addOwnerPage().enterCity("Sofia");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyFirstNameError("must not be empty");
        webApp.addOwnerPage().verifyLastNameError("must not be empty");
        // works in Intellij run
//        webApp.addOwnerPage().verifyTelephoneError("must not be empty\nnumeric value out of bounds (<10 digits>.<0 digits> expected)");
        // works in Terminal run
        webApp.addOwnerPage().verifyTelephoneError("numeric value out of bounds (<10 digits>.<0 digits> expected)\nmust not be empty");
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
        webApp.addPetPage().addNewPet("Sarah", "2010-12-12", Type.DOG);
        webApp.ownerInformationPage().verifySecondHeaderText("Pets and Visits");
    }

    @Test
    @Tag("bug") //bug - no error message is shown, should be fixed
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
        webApp.addOwnerPage().verifyTelephoneError("Error in invalid size number enter 10 digits field!!!");
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
        webApp.addPetPage().addNewPet("Dr@gonF#y99", "2000-12-13", Type.LIZARD);
        webApp.ownerInformationPage().verifySecondHeaderText("Pets and Visits");
    }
    @Test
    @Tag("bug") //but - no error messages shown, should be fixed
    @Tag("negative")
    @DisplayName("PC-26 Cannot add owner with space white space")
/*
The text fields have to trim white spaces on submit. If it's done on the following test if we send a space character
the fields have to be empty
when the Add user button is clicked and the proper error message has to be displayed for every empty field
 */
    public void cantAddOwnerWithSpaceName(){
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName(" ");
        webApp.addOwnerPage().enterLastName(" ");
        webApp.addOwnerPage().enterAddress(" ");
        webApp.addOwnerPage().enterCity(" ");
        webApp.addOwnerPage().enterTelephone("088888888");
        webApp.addOwnerPage().clickAddOwnerButton();
        webApp.addOwnerPage().verifyFirstNameError("must not be empty");
        webApp.addOwnerPage().verifyLastNameError("must not be empty");
        webApp.addOwnerPage().verifyAddressErrorMessage("must not be empty");
        webApp.addOwnerPage().verifyCityErrorMessage("must not be empty");
    }
}
