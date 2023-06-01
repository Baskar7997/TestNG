package automationTestNG;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectsRoundTrip.BookingConfirPage2;
import pageObjectsRoundTrip.CancelPage2;
import pageObjectsRoundTrip.FlightsListPage2;
import pageObjectsRoundTrip.HomePage2;
import pageObjectsRoundTrip.PaymentPage2;
import pageObjectsRoundTrip.TripSummaryPage2;

public class PomRoundtripNG {
	ChromeDriver driver;
	@BeforeClass
	public void openBrowser() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get("https://qa.travelfika.com/");
	Thread.sleep(1000);
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test
	public void booking() throws InterruptedException {
	PageFactory.initElements(driver, HomePage2.class);
	HomePage2.flights.click();
	HomePage2.from(driver);
	HomePage2.selectSource.click();
	HomePage2.to(driver);
	HomePage2.selectDestination.click();
	HomePage2.calendar(driver);
	HomePage2.fromDate(driver);
	HomePage2.toDate(driver);	
	HomePage2.done.click();
	HomePage2.search.click();
	
	PageFactory.initElements(driver, FlightsListPage2.class);
	FlightsListPage2.chooseFlight.click();
	
	PageFactory.initElements(driver, TripSummaryPage2.class);
	TripSummaryPage2.checkOut(driver).click();
	TripSummaryPage2.skip.click();
	
	PageFactory.initElements(driver, BookingConfirPage2.class);
	BookingConfirPage2.firstName.sendKeys("afhdg");
	BookingConfirPage2.lastName.sendKeys("nhdgc");
	BookingConfirPage2.birthDate(driver);
	BookingConfirPage2.countrySelect(driver);
	BookingConfirPage2.genderSelect(driver);
	BookingConfirPage2.address.sendKeys("5th street");	
	BookingConfirPage2.country.sendKeys("India");				
	BookingConfirPage2.india.click();	
	BookingConfirPage2.zipcpde.sendKeys("652455");
	BookingConfirPage2.city.sendKeys("salem");
	BookingConfirPage2.email.sendKeys("asnbg23@gmail.com");
	BookingConfirPage2.phoneNo.sendKeys("6549873215");
	
	PageFactory.initElements(driver, PaymentPage2.class);
	PaymentPage2.cardNo(driver).sendKeys("5555555555554444");
	PaymentPage2.exp.sendKeys("1226");
	PaymentPage2.cvv.sendKeys("432");
	PaymentPage2.proceed(driver).click();
	
	PageFactory.initElements(driver, CancelPage2.class);
	CancelPage2.cancel.click();
	CancelPage2.yes.click();
	}
	
	@AfterClass
	public void quit() {
		//driver.quit();
	}
}
