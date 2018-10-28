package pages;

import enums.Type;
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
    private static final String PAGE_URL = "/petclinic/owners/new";

    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement headerText;

    @FindBy(how = How.XPATH, using = "//div[@class='form-actions']//button")
    private WebElement addPetButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "birthDate")
    private WebElement birthDateField;

    @FindBy(how = How.XPATH, using = "//table[@class='ui-datepicker-calendar']")
    private WebElement datePickerCalendar;


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

    public void enterName(String name){
        LOGGER.info("Entering name:" + name);
        typeText(nameField, name);
    }

    public void enterBirthDate(String birthDate){
        LOGGER.info("Entering birth date:" + birthDate);
        typeText(birthDateField, birthDate);
        click(birthDateField);
    }

    public void selectDateFromCalendar(String day){
        LOGGER.info("Selecting day from the month:" + day);
        click(birthDateField);
        datePickerCalendar.findElement(By.xpath("//a[text()=" + day + "]")).click();
    }

    public void clickAddPetButton(){
        LOGGER.info("Clicking Add Pet button");
        click(addPetButton);
    }


    /**
     * Adds new pet for specific owner
     * @param name name
     * @param day date in format day/month/year
     * @param type animal type
     */
    public void addNewPet(String name, String day, Type type){
        enterName(name);
        selectDateFromCalendar(day);
        selectType(type);
        clickAddPetButton();
    }
}
