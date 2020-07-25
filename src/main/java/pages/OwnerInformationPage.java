package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnerInformationPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerInformationPage.class);

    @FindBy(how = How.XPATH, using = "//h2[1]")
    private WebElement firstHeader;

    @FindBy(how = How.XPATH, using = "//h2[2]")
    private WebElement secondHeader;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Edit Owner']")
    private WebElement editOwnerButton;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Add New Pet']")
    private WebElement addPetButton;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Edit Pet']")
    private WebElement editPetButton;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Add Visit']")
    private WebElement addPetVisitButton;

    @FindBy(how = How.XPATH, using = "//td[preceding-sibling::*='Name']")
    private WebElement nameInfoOwner;

    @FindBy(how = How.XPATH, using = "//td[preceding-sibling::*='Address']")
    private WebElement addressInfo;

    @FindBy(how = How.XPATH, using = "//td[preceding-sibling::*='City']")
    private WebElement cityInfo;

    @FindBy(how = How.XPATH, using = "//td[preceding-sibling::*='Telephone']")
    private WebElement telephoneInfo;

    @FindBy(how = How.XPATH, using = "//dd[preceding-sibling::*[1]='Name']")
    private WebElement nameInfoPet;

    @FindBy(how = How.XPATH, using = "//dd[preceding-sibling::*[1]='Birth Date']")
    private WebElement birthDateInfo;

    @FindBy(how = How.XPATH, using = "//dd[preceding-sibling::*[1]='Type']")
    private WebElement typeInfo;

//    @FindBy(how = How.XPATH, using = "")
//    private WebElement visitDate;
//
//    @FindBy(how = How.XPATH, using = "")
//    private WebElement description;

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
     * This method checks if the new visit has been added
     */
    public void verifyAddedNewVisit() {
        WebElement newvisit = driver.findElement(By.cssSelector("table.table:nth-of-type(2) table.table-condensed td"));
        Assertions.assertTrue(newvisit.isDisplayed());
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
        click(editPetButton);
    }
}
