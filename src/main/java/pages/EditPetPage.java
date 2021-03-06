package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditPetPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(EditPetPage.class);

    public EditPetPage(WebDriver driver) {
        super(driver);
    }

    private String petName;

    @FindBy(how = How.ID, using = "name")
    private WebElement petNameField;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default']")
    private WebElement updateButton;

    public void type(String petName) {
        LOGGER.info("Entering name:" + petName);
        petNameField.clear();
        petNameField.sendKeys(petName);
    }

    public void clickUpdateButton() {
        LOGGER.info("Clicking the update button");
        updateButton.click();
    }

}
