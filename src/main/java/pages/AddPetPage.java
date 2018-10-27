package pages;

import enums.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddPetPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddPetPage.class);
    private static final String PAGE_URL = "/petclinic/owners/new";

    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement headerText;

    @FindBy(how = How.XPATH, using = "//div[@class='form-actions']//button")
    private WebElement addOwnerButton;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "type")
    private WebElement typeDropdown;

    public AddPetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectType(Type animalType){
        LOGGER.info("Selecting animal type:" + animalType);
        selectDropDownOptionByVisibleText(typeDropdown, animalType.getType());
    }
}
