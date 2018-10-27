package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddOwnerPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddOwnerPage.class);
    private static final String PAGE_URL = "/petclinic/owners/new";

    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement headerText;

    @FindBy(how = How.XPATH, using = "//div[@class='form-actions']//button")
    private WebElement addOwnerButton;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "address")
    private WebElement addressField;

    @FindBy(how = How.ID, using = "city")
    private WebElement cityField;

    @FindBy(how = How.ID, using = "telephone")
    private WebElement telephoneField;

    public AddOwnerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verifies h2 text
     *
     * @param expectedText page header text
     */
    public void verifyHeaderText(String expectedText) {
        LOGGER.info("Verifying h2 text is:" + expectedText);
        Assertions.assertEquals(expectedText, getText(headerText), "Header text is not as expected");
    }

    public void enterFirstName(String firstName){
        LOGGER.info("Entering first name:" + firstName);
        typeText(firstNameField, firstName);
    }

    public void enterLastName(String lastName){
        LOGGER.info("Entering last name:" + lastName);
        typeText(lastNameField, lastName);
    }

    public void enterAddress(String address){
        LOGGER.info("Entering address:" + address);
        typeText(addressField, address);
    }

    public void enterCity(String city){
        LOGGER.info("Entering city:" + city);
        typeText(cityField, city);
    }

    public void enterTelephone(String telephone){
        LOGGER.info("Entering telephone:" + telephone);
        typeText(telephoneField, telephone);
    }

    public void clickAddOwnerButton(){
        LOGGER.info("Clicking Add Owner button");
        click(addOwnerButton);
    }
}
