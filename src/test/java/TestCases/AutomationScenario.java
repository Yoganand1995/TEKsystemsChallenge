package TestCases;

import PageObjects.HomePage;
import PageObjects.ResultsPage;
import Resources.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


public class AutomationScenario extends BaseClass {
    public WebDriver Driver;

    @BeforeMethod()
    public void Initialize() throws IOException {
        Driver = InitializeBrowser();
        Driver = getURL();
    }

    @Test
    public void search() throws InterruptedException {
        HomePage homePage = new HomePage(Driver);
        Actions Move = new Actions(Driver);
        Assert.assertEquals(Driver.getTitle(),"ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking");
        homePage.getOrigin().clear();
        homePage.getOrigin().click();
        homePage.getOrigin().sendKeys("PUNE");
        Thread.sleep(2000);
        homePage.getOrigin().sendKeys(Keys.ENTER);
        homePage.getDestination().sendKeys("HYDERABAD");
        Thread.sleep(2000);
        homePage.getDestination().sendKeys(Keys.ENTER);
        Move.moveToElement(homePage.getDepartureField());
        homePage.getDepartureField().click();
        homePage.setDate("22");
        Move.moveToElement(homePage.getReturnField());
        homePage.getReturnField().click();
        homePage.setDate("24");
        Move.moveToElement(homePage.getPassengerOptions());
        homePage.getPassengerOptions().click();
        homePage.getAdultSeatCount().click();
        homePage.getSearchButton().click();
        ResultsPage resultsPagePage = new ResultsPage(Driver);
        try {
            WebDriverWait wait = new WebDriverWait(Driver,10);
            wait.until(ExpectedConditions.visibilityOf(resultsPagePage.getAlert()));
        }catch (TimeoutException e){
            System.out.println("WebDriver couldn’t load the element");
            e.printStackTrace(); // Log if necessary
        }
        Assert.assertTrue(resultsPagePage.getNonStopCheckBox().isDisplayed());
        resultsPagePage.getNonStopCheckBox().click();
        List<WebElement> DepTime = resultsPagePage.getDepartureTime();
        List<WebElement> ALNumber = resultsPagePage.getAirLineNumber();
        List<WebElement> LPrice = resultsPagePage.getListingPrice();
        for (int i = 0; i <LPrice.size() ; i++) {
            int Value = Integer.parseInt(LPrice.get(i).getText());
            if(Value < 5000){
                System.out.println(ALNumber.get(i).getText()+" "+ DepTime.get(i).getText()+" "+ Value);
            }
        }
    }

    @AfterMethod
    public void closeBrowser(){
        Driver.quit();
    }

}
