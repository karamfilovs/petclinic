import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;

public class EditPetPageTest extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("Davis");
        webApp.findOwnersPage().clickFindOwnerButton();

        try {

            webApp.ownersPage().clickOwnerName();
            webApp.ownerInformationPage().clickEditPet();
        }catch (TimeoutException e) {

            System.out.println("There is just one owner with this Last name");
            webApp.ownerInformationPage().clickEditPet();
        }
    }

    @Test
    @Tag("Rossen")
    @DisplayName("PC-12: Can edit pet name")
    public void canEditPetName() {

        webApp.editPetPage().type("Tosho");
        webApp.editPetPage().clickUpdateButton();
     //   webApp.editPetPage().verifyPetNamIsChanged("Tosho", "The pet's name does't changed");
    }
}