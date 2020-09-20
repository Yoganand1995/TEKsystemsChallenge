package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public WebDriver Driver;

    public HomePage(WebDriver driver) {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'orgn')]//child::input")
    WebElement Origin;

    @FindBy(xpath = "//div[contains(@class,'dstn')]//child::input")
    WebElement Destination;

    @FindBy(xpath = "//div[contains(@class,'search')]")
    WebElement SearchButton;

    @FindBy(xpath = "//div[text()='Adult']//following::span[@data-val='2'][1]")
    WebElement AdultSeatCount;

    @FindBy(xpath="//div[contains(@class,'passenger')]//child::input")
    WebElement PassengerOptions;

    @FindBy(xpath = "//div[@class='day has-info']")
    List<WebElement> Dates;

    @FindBy(xpath = "//input[@placeholder='Depart']")
    WebElement DepartureField;

    @FindBy(xpath = "//input[@placeholder='Return']")
    WebElement ReturnField;

    public WebElement getOrigin() {
        return Origin;
    }

    public WebElement getDestination() {
        return Destination;
    }

    public WebElement getSearchButton() {
        return SearchButton;
    }

    public WebElement getAdultSeatCount() {
        return AdultSeatCount;
    }

    public WebElement getPassengerOptions() {
        return PassengerOptions;
    }

    public List<WebElement> getDates() {
        return Dates;
    }

    public WebElement getDepartureField() {
        return DepartureField;
    }

    public WebElement getReturnField() {
        return ReturnField;
    }

    public void setDate(String Date) {
        for (int i = 0; i <Dates.size() ; i++) {
            String PickDate = Dates.get(i).getText();
            if(PickDate.contains(Date)){
                Dates.get(i).click();
                break;
            }
        }
    }
}
