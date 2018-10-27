package components;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Components extends BasePage {
    private MainMenu mainMenu;

    public Components(WebDriver driver) {
        super(driver);
    }


    public MainMenu mainMenu() {
        if (mainMenu == null) {
            mainMenu = new MainMenu(driver);
            return mainMenu;
        } else {
            return mainMenu;
        }
    }
}
