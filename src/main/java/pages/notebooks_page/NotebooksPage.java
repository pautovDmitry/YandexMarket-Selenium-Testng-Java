package pages.notebooks_page;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;


import java.util.List;

import static constants.Constants.Price.*;

public class NotebooksPage extends BasePage {
    public NotebooksPage(WebDriver driver){
        super(driver);
    }
    private final By lenovoDeveloper = By.xpath("//div[@data-filter-value-id='152981']//span[@class='_2XaWK']");
    private final By priceFromField = By.xpath("//span[@data-auto='filter-range-min']//input[@class='_3qxDp']");
    private final By priceToField = By.xpath("//span[@data-auto='filter-range-max']//input[@class='_3qxDp']");
    private final By priceOnCard = By.xpath("//a[@class='_2f75n _3ldWb cia-cs']");
    private final By headerOnCard = By.xpath("//span[@data-tid='2e5bde87']");
    public NotebooksPage setMinPrice(){
        WebElement priceFrom = driver.findElement(priceFromField);
        priceFrom.sendKeys(MIN_PRICE);

        return this;
    }
    public NotebooksPage setMaxPrice(){
        WebElement priceTo = driver.findElement(priceToField);
        priceTo.sendKeys(MAX_PRICE);

        return this;
    }
    public NotebooksPage clickLenovoDevChekbox(){
        WebElement lenovoDevChekbox = driver.findElement(lenovoDeveloper);
        waitElementIsVisible(lenovoDevChekbox).click();

        return this;
    }
    public List<WebElement> getAllHeaderProductCard(){
        List<WebElement> allHeaderProductCard = driver.findElements(headerOnCard);

        return allHeaderProductCard;
    }
    public List<WebElement> getAllPrice(){
        List<WebElement> allPrices = driver.findElements(priceOnCard);

        return allPrices;
    }
}
