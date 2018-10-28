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

    @FindBy(how = How.XPATH, using = "//div[@class='form-actions']//button")
    private WebElement addOwnerButton;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstNameField;

    @FindBy(how = How.XPATH, using = "//input[@id='firstName']//following-sibling::span")
    private WebElement firstNameErrorMessage;


    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameField;

    @FindBy(how = How.XPATH, using = "//input[@id='lastName']//following-sibling::span")
    private WebElement lastNameErrorMessage;

    @FindBy(how = How.ID, using = "address")
    private WebElement addressField;

    @FindBy(how = How.ID, using = "city")
    private WebElement cityField;

    @FindBy(how = How.ID, using = "telephone")
    private WebElement telephoneField;

    @FindBy(how = How.XPATH, using = "//input[@id='telephone']//following-sibling::span")
    private WebElement telephoneErrorMessage;

    public AddOwnerPage(WebDriver driver) {
        super(driver);
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

    public void verifyFirstNameError(String expectedText){
        LOGGER.info("Verifying first name error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(firstNameErrorMessage), "Error text is not as expected");
    }

    public void verifyLastNameError(String expectedText){
        LOGGER.info("Verifying last name error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(lastNameErrorMessage), "Error text is not as expected");
    }

    public void verifyTelephoneError(String expectedText){
        LOGGER.info("Verifying telephone error:" + expectedText);
        Assertions.assertEquals(expectedText, getText(telephoneErrorMessage), "Error text is not as expected");
    }
}
