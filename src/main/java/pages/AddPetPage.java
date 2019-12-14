package pages;

import enums.Type;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddPetPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddPetPage.class);

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement addPetButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.XPATH, using = "//input[@id='name']/following-sibling::span")
    private WebElement nameFieldError;

    @FindBy(how = How.ID, using = "birthDate")
    private WebElement birthDateField;

    @FindBy(how = How.XPATH, using = "//input[@id='birthDate']/following-sibling::span")
    private WebElement birthDateFieldError;


    @FindBy(how = How.ID, using = "type")
    private WebElement typeDropdown;

    @FindBy(how = How.CSS, using = "span.help-inline")
    private WebElement errorMessage;

    public AddPetPage(WebDriver driver) {
        super(driver);
    }

    public void selectType(Type animalType) {
        LOGGER.info("Selecting animal type:" + animalType);
        selectDropDownOptionByVisibleText(typeDropdown, animalType.getType());
    }

    public void enterName(String name) {
        LOGGER.info("Entering name:" + name);
        typeText(nameField, name);
    }

    public void enterBirthDate(String birthDate) {
        LOGGER.info("Entering birth date:" + birthDate);
        typeText(birthDateField, birthDate);
        click(birthDateField);
    }

    public void enterDate(String date) {
        LOGGER.info("Entering date:" + date);

    }

    public void clickAddPetButton() {
        LOGGER.info("Clicking Add Pet button");
        click(addPetButton);
    }


    /**
     * Adds new pet for specific owner
     *
     * @param name name
     * @param date  date in format day/month/year
     * @param type animal type
     */
    public void addNewPet(String name, String date, Type type) {
        enterName(name);
        enterDate(date);
        selectType(type);
        clickAddPetButton();
    }


    public void verifyNameError(String expectedText) {
        LOGGER.info("Verifying name error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(nameFieldError), "Error text is not as expected");
    }

    public void verifyErrorDisplayed() {
        LOGGER.info("Verifying error is displayed");
        Assertions.assertTrue(errorMessage.isDisplayed());
    }



    public void verifyBirthDateError(String expectedText) {
        LOGGER.info("Verifying birth date error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(birthDateFieldError), "Error text is not as expected");
    }
}
