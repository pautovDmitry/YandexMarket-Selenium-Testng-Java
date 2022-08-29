package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.computers_page.ComputersPage;
import pages.market_yandex_page.MarketYandexPage;
import pages.notebooks_page.NotebooksPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constants.Urls.MARKET_YANDEX_PAGE;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MarketYandexPage marketYandexPage = new MarketYandexPage(driver);
    protected ComputersPage computersPage = new ComputersPage(driver);
    protected NotebooksPage notebooksPage = new NotebooksPage(driver);

    //@AfterTest
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    //@AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
