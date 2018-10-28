package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnerInformationPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerInformationPage.class);

    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement headerText;

    @FindBy(how = How.XPATH, using = "//h2[2]")
    private WebElement secondHeader;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-success']")
    private WebElement addPetButton;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-info']")
    private WebElement editOwnerButton;

    public OwnerInformationPage(WebDriver driver) {
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
    public void clickEditOwnerButton(){
        LOGGER.info("Clicking Edit Owner button");
        click(editOwnerButton);
    }

    /**
     * Clicks Add Pet button
     */
    public void clickAddPetButton(){
        LOGGER.info("Clicking Add Pet button");
        click(addPetButton);
    }
}
