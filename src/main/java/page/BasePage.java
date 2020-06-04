package page;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {


    RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    public void quit() {
        driver.quit();
    }

}
