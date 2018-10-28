package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeterinariansPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(VeterinariansPage.class);

    @FindBy(how = How.XPATH, using = "//div[@id='vets_filter']//input")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "vets")
    private WebElement vetsTable;

    public VeterinariansPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Searches for veterinarians by text
     *
     * @param text text
     */
    public void search(String text) {
        LOGGER.info("Searching for veterinarians by:" + text);
        typeText(searchField, text);
    }

    /**
     * Verifies table rows count
     *
     * @param expectedRowCount number of rows
     */
    public void verifyTableTotalRows(int expectedRowCount) {
        LOGGER.info("Verifying table rows count excluding title row is:" + expectedRowCount);
        Assertions.assertEquals(expectedRowCount, getTableRows(vetsTable).size() - 1, "Expected rows count does not match");
    }

    /**
     * Verifying table contains text
     * @param expectedText text
     */
    public void verifyTableTextContains(String expectedText) {
        LOGGER.info("Verifying table contains text:" + expectedText);
        Assertions.assertTrue(vetsTable.getText().contains(expectedText), "Table does not contain expected text");
    }

}
