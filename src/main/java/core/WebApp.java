package core;

import components.Components;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

import java.io.File;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class WebApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebApp.class);
    private WebDriver driver;

    //Drivers paths
    private final String WINDOWS_CHROME_DRIVER_PATH = "src\\test\\resources\\chromedriver.exe";
    private final String WINDOWS_FIREFOX_DRIVER_PATH = "src\\test\\resources\\geckodriver.exe";
    private final String LINUX_CHROME_DRIVER_PATH = "src/test/resources/linux-chromedriver-v2.42";
    private final String LINUX_FIREFOX_DRIVER_PATH = "src/test/resources/linux-geckodriver-v0.22.0";

    //pages
    private HomePage homePage;
    private FindOwnersPage findOwnersPage;
    private Components components;
    private OwnersPage ownersPage;
    private VeterinariansPage veterinariansPage;
    private AddOwnerPage addOwnerPage;
    private OwnerInformationPage ownerInformationPage;
    private AddPetPage addPetPage;
    private ErrorPage errorPage;
    private AddVisitPage addVisitPage;


    public void startBrowser(String browser) {
        if (SystemUtils.IS_OS_LINUX) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", LINUX_CHROME_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(isHeadless());
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", LINUX_FIREFOX_DRIVER_PATH);
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-width=1920");
                options.addArguments("-height=1080");
                options.setHeadless(isHeadless());
                driver = new FirefoxDriver(options);
            } else {
                throw new RuntimeException("Not supported browser");
            }
        } else {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", WINDOWS_CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", WINDOWS_FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                throw new RuntimeException("Not supported browser");
            }


            LOGGER.info("******************************************************************");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        }
    }

    private boolean isHeadless() {
        return System.getProperty("headless").equalsIgnoreCase("on") ? true : false;
    }

    public void quit() {
        driver.quit();
    }


    //lazy instantiating methods
    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
            return homePage;
        } else {
            return homePage;
        }
    }

    public FindOwnersPage findOwnersPage() {
        if (findOwnersPage == null) {
            findOwnersPage = new FindOwnersPage(driver);
            return findOwnersPage;
        } else {
            return findOwnersPage;
        }
    }

    public OwnerInformationPage ownerInformationPage() {
        if (ownerInformationPage == null) {
            ownerInformationPage = new OwnerInformationPage(driver);
            return ownerInformationPage;
        } else {
            return ownerInformationPage;
        }
    }

    public ErrorPage errorPage() {
        if (errorPage == null) {
            errorPage = new ErrorPage(driver);
            return errorPage;
        } else {
            return errorPage;
        }
    }

    public AddOwnerPage addOwnerPage() {
        if (addOwnerPage == null) {
            addOwnerPage = new AddOwnerPage(driver);
            return addOwnerPage;
        } else {
            return addOwnerPage;
        }
    }

    public AddPetPage addPetPage() {
        if (addPetPage == null) {
            addPetPage = new AddPetPage(driver);
            return addPetPage;
        } else {
            return addPetPage;
        }
    }

    public AddVisitPage addVisitPage() {
        if (addVisitPage == null) {
            addVisitPage = new AddVisitPage(driver);
            return addVisitPage;
        } else {
            return addVisitPage;
        }
    }



    public OwnersPage ownersPage() {
        if (ownersPage == null) {
            ownersPage = new OwnersPage(driver);
            return ownersPage;
        } else {
            return ownersPage;
        }
    }

    public VeterinariansPage veterinariansPage() {
        if (veterinariansPage == null) {
            veterinariansPage = new VeterinariansPage(driver);
            return veterinariansPage;
        } else {
            return veterinariansPage;
        }
    }

    public Components components() {
        if (components == null) {
            components = new Components(driver);
            return components;
        } else {
            return components;
        }
    }


    /**
     * Takes screenshot of the current screen
     *
     * @param className Name of the class from which it was invoked
     * @param method    Test method name
     * @param timestamp Current time stamp
     */
    public void takeScreenshot(String className, String method, LocalTime timestamp) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotTakingDriver = (TakesScreenshot) driver;
            try {
                File localScreenshots = new File(new File("target"), "screenshots");
                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                    localScreenshots.mkdirs();
                }
                File screenshot = new File(localScreenshots, className + "_" + method + "_" + timestamp.getHour() + "." + timestamp.getMinute() + "." + timestamp.getSecond() + ".png");
                FileUtils.copyFile(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
                LOGGER.info("Screenshot for class={} method={} saved in: {}", className, method, screenshot.getAbsolutePath());
            } catch (Exception e1) {
                LOGGER.error("Unable to take screenshot", e1);
            }
        } else {
            LOGGER.info("Driver '{}' can't take screenshots so skipping it.", driver.getClass());
        }
    }

}
