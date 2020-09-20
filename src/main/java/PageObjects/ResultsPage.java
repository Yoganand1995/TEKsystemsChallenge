package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {
    public WebDriver Driver;

    public ResultsPage(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Non stop']//preceding::span[contains(@class,'button')]")
    WebElement NonStopCheckBox;

    @FindBy(xpath = "//div[@class='result-col outr']//div[contains(@class,'c-price')]")
    List<WebElement> ListingPrice;

    @FindBy(xpath = "//div[@class='result-col outr']//div[@class='u-text-ellipsis']")
    List<WebElement> AirLineNumber;

    @FindBy(xpath = "//div[@class='result-col outr']//div[@class='time'][2]")
    List<WebElement> DepartureTime;

    @FindBy(xpath = "//div[text()='Set alert']")
    WebElement Alert;

    public List<WebElement> getAirLineNumber() {
        return AirLineNumber;
    }

    public List<WebElement> getDepartureTime() {
        return DepartureTime;
    }

    public WebElement getAlert() {
        return Alert;
    }

    public WebElement getNonStopCheckBox() {
        return NonStopCheckBox;
    }

    public List<WebElement> getListingPrice() {
        return ListingPrice;
    }


}
