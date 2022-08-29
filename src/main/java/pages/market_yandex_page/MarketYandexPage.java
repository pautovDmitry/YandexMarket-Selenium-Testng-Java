package pages.market_yandex_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MarketYandexPage extends BasePage {
    public MarketYandexPage(WebDriver driver){
        super(driver);
    }
    private final By catalogBtn = By.xpath("//span[text()='Каталог']");
    private final By computersOnCatalogBtn = By.xpath("//span[text()='Компьютеры']");

    public MarketYandexPage clickCatalogBtn(){
        WebElement catalogButton = driver.findElement(catalogBtn);
        waitElementIsVisible(catalogButton).click();

        return this;
    }
    public void clickComputersOnCatalogBtn(){
        WebElement computersBtn = driver.findElement(computersOnCatalogBtn);
        waitElementIsVisible(computersBtn).click();
    }
}
