package tests.search_computer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.List;

import static constants.Constants.Urls.MARKET_YANDEX_PAGE;

public class SearchComputerTest extends BaseTest {
    public void assertHeaders(){
        List<WebElement> allHeaders = notebooksPage.getAllHeaderProductCard();
        for (int i = 0; i < allHeaders.size(); i++){
            System.out.println(allHeaders.get(i).getText());
            String header = allHeaders.get(i).getText();
            boolean realHeader;
            if (header.contains("Lenovo")){
                realHeader = true;
            }
            else{
                realHeader = false;
            }
            Assert.assertEquals(realHeader, true);
        }
    }
    public void assertPrice(){
        List<WebElement> allPrices = notebooksPage.getAllPrice();
        for (int i = 0; i < allPrices.size(); i++){
            System.out.println(allPrices.get(i).getText());
            String priceStr = allPrices.get(i).getText();
            String priceStrSub = priceStr.substring(0,6).replace(" ","");
            int priceInt = Integer.parseInt(priceStrSub);
            boolean realPrice;
            if (priceInt > 25000 && priceInt < 30000 ){
                realPrice = true;
            }
            else {
                realPrice = false;
            }
            Assert.assertEquals(realPrice, true);
        }
    }
    @Test
    public void checkLenovoFilter() throws InterruptedException {
        basePage.open(MARKET_YANDEX_PAGE);

        marketYandexPage
                .clickCatalogBtn()
                .clickComputersOnCatalogBtn();
        basePage.waitPageToLoad();
        computersPage
                .clickNotebooksBtn();
        basePage.waitPageToLoad();
        notebooksPage
                .setMinPrice()
                .setMaxPrice()
                .clickLenovoDevChekbox();
        basePage.waitUntilFilterAccept();
        assertHeaders();
        assertPrice();
    }
}
