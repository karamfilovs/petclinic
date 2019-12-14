package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnerInformationPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerInformationPage.class);

    @FindBy(how = How.XPATH, using = "//h2[2]")
    private WebElement secondHeader;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'New Pet')]")
    private WebElement addPetButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Edit Owner']")
    private WebElement editOwnerButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/table[2]/tbody/tr/td[1]/dl/dd[1]")
    public static WebElement verifyEditedPet;

    @FindBy(how = How.XPATH, using = "/html/body/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/a")
    public static WebElement editPetLink;


    public OwnerInformationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies second h2 text
     *
     * @param expectedText page header text
     */
    public void verifySecondHeaderText(String expectedText) {
        LOGGER.info("Verifying second h2 text is:" + expectedText);
        Assertions.assertEquals(expectedText, getText(secondHeader), "Header text is not as expected");
    }


    /**
     * Clicks Edit Owner button
     */
    public void clickEditOwnerButton() {
        LOGGER.info("Clicking Edit Owner button");
        click(editOwnerButton);
    }

    /**
     * Clicks Add Pet button
     */
    public void clickAddPetButton() {
        LOGGER.info("Clicking Add Pet button");
        click(addPetButton);
    }


    public void clickEditPet() {
        LOGGER.info("Open the pet edid page");
        click(editPetLink);
    }
}
