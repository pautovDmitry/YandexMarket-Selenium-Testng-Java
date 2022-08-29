package pages.computers_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class ComputersPage extends BasePage {
    public ComputersPage(WebDriver driver){
        super(driver);
    }
    private final By notebooks = By.xpath("//div[@class='_2jsCq _1qPMc']");
    public void clickNotebooksBtn(){
        WebElement notebooksBtn = driver.findElement(notebooks);
        waitElementIsVisible(notebooksBtn).click();
    }
}
