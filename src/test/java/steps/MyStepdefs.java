package steps;

import core.WebApp;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    WebApp webApp = new WebApp();

    @Given("^I am at Petclinic Owners page$")
    public void iAmAtPetclinicOwnersPage() {
        webApp.startBrowser(System.getProperty("browser"));
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
    }

    @When("^I create owner with name \"([^\"]*)\" address \"([^\"]*)\"$")
    public void iCreateOwnerWithNameAddress(String arg0, String arg1) {
        webApp.findOwnersPage().clickAddOwnerLink();
        webApp.addOwnerPage().enterFirstName(arg0);
        webApp.addOwnerPage().enterAddress(arg1);
    }

    @Then("^user should be add Owner Information page$")
    public void userShouldBeAddOwnerInformationPage() {
        webApp.ownerInformationPage().verifySecondHeaderText("Owner Information");
    }
}
