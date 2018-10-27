package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOwnersPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindOwnersPage.class);
    private static final String PAGE_URL = "/petclinic/owners/find";

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameField;

    @FindBy(how = How.XPATH, using = "//a[@href='/petclinic/owners/new']")
    private WebElement addOwnerLink;

    @FindBy(how = How.XPATH, using = "//div[@class='form-actions']/button")
    private WebElement findOwnerButton;

    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement headerText;

    @FindBy(how = How.ID, using = "owner.errors")
    private WebElement errorMessage;

    public FindOwnersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    /**
     * Navigates to current page
     */
    public void gotoPage() {
        LOGGER.info("Navigate to:" + BASE_URL + PAGE_URL);
        navigateTo(PAGE_URL);
    }

    /**
     * Entering last name
     *
     * @param lastName last name
     */
    public void enterLastName(String lastName) {
        LOGGER.info("Entering last name:" + lastName);
        typeTextWithActionsBuilder(lastNameField, lastName);
    }

    /**
     * Click Find Owner button
     */
    public void clickFindOwnerButton() {
        LOGGER.info("Clicking Find Owner button");
        click(findOwnerButton);
    }

    /**
     * Verifies h2 text
     *
     * @param expectedText page header text
     */
    public void verifyHeaderText(String expectedText) {
        Assertions.assertEquals(expectedText, getText(headerText), "Header text is not as expected");
    }

    /**
     * Verifies search error message text
     *
     * @param expectedText page header text
     */
    public void verifyErrorMessage(String expectedText) {
        Assertions.assertEquals(expectedText, getText(errorMessage), "Error message text is not as expected");
    }

    /**
     * Searches for owner by last name
     *
     * @param lastName last name
     */
    public void findOwner(String lastName) {
        enterLastName(lastName);
        clickFindOwnerButton();
    }

    /**
     * Clicks Add Owner link at the bottom
     */
    public void clickAddOwnerLink(){
        LOGGER.info("Clicking Add Owner link");
        click(addOwnerLink);
    }
}
