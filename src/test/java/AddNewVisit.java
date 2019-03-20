import core.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddNewVisit extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("Estaban");
        webApp.findOwnersPage().clickFindOwnerButton();
    }
    @Test
    @DisplayName("PC-20: Can add new visit for a pet")
    public void addNewVisit() {
        webApp.visitPage().addPetVisit();
        webApp.visitPage().verifyNewVisitTitle();
        webApp.visitPage().pickDateForVisitFromCalendar("3");
        webApp.visitPage().fillDescriptionfield("This is a test");
        webApp.visitPage().addPetVisitButtonClick();
        webApp.ownerInformationPage().verifyAddedNewVisit();
    }

    @Test
    @Tag("negative")
    @DisplayName("PC-21: Can't add new visit for a pet with blank description field")
    public void cannotAddNewVisit() {
        webApp.visitPage().addPetVisit();
        webApp.visitPage().verifyNewVisitTitle();
        webApp.visitPage().pickDateForVisitFromCalendar("13");
        webApp.visitPage().fillDescriptionfield("");
        webApp.visitPage().addPetVisitButtonClick();
        webApp.visitPage().verifyErrorMessage();
    }
}
