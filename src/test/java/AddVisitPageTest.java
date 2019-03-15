import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddVisitPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("");
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownersPage().clickOwnerName();
    }

    @Test
    @DisplayName("PC-28: Can add new visit")
    public void canAddNewVisit() {
        webApp.addVisitPage().clickAddVisitLink();
        webApp.addVisitPage().addDate("2019/03/24");
        webApp.addVisitPage().addDescription("Sick, can't sleep");
        webApp.addVisitPage().clickRandom();
        webApp.addVisitPage().clickAddVisitButton();
        webApp.addVisitPage().verifyVisitTextContains("2019/03/24");
    }
}
