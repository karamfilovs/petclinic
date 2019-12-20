package pages;

import enums.Type;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddPetPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddPetPage.class);
    private static final String PAGE_URL = "/petclinic/owners/new";

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.XPATH, using = "//input[@id='name']/..//following-sibling::span[last()]")
    private WebElement nameFieldError;

    @FindBy(how = How.ID, using = "birthDate")
    private WebElement birthDateField;

    @FindBy(how = How.XPATH, using = "//input[@id='birthDate']/..//following-sibling::span[last()]")
    private WebElement birthDateFieldError;

    @FindBy(how = How.ID, using = "type")
    private WebElement typeDropdown;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default']")
    private WebElement addPetButton;

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

    public void clickAddPetButton() {
        LOGGER.info("Clicking Add Pet button");
        click(addPetButton);
    }


    /**
     * Adds new pet for specific owner
     *
     * @param name name
     * @param day  date in format YYYY-MM-DD
     * @param type animal type
     */
    public void addNewPet(String name, String day, Type type) {
        enterName(name);
        enterBirthDate(day);
        selectType(type);
        clickAddPetButton();
    }


    public void verifyNameError(String expectedText) {
        LOGGER.info("Verifying name error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(nameFieldError), "Error text is not as expected");
    }

    public void verifyBirthDateError(String expectedText) {
        LOGGER.info("Verifying birth date error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(birthDateFieldError), "Error text is not as expected");
    }
}
