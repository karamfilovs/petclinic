package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOwnersPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindOwnersPage.class);
    private static final String PAGE_URL = "/petclinic/owners/find";

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameField;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Add Owner']")
    private WebElement addOwnerLink;

    @FindBy(how = How.XPATH, using = "//button[normalize-space(text())='Find Owner']")
    private WebElement findOwnerButton;


    public FindOwnersPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Navigates to current page
     */
    public void gotoPage() {
        LOGGER.info("Navigate to: " + BASE_URL + PAGE_URL);
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
    public void clickAddOwnerLink() {
        LOGGER.info("Clicking Add Owner link");
        click(addOwnerLink);
    }
}
