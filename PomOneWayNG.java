package automationTestNG;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectsOneWay.BookingConfirPage1;
import pageObjectsOneWay.CancelPage1;
import pageObjectsOneWay.FlightsListPage1;
import pageObjectsOneWay.HomePage1;
import pageObjectsOneWay.PaymentPage1;
import pageObjectsOneWay.TripSummaryPage1;

public class PomOneWayNG {
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
		PageFactory.initElements(driver, HomePage1.class);
		HomePage1.flights.click();
		HomePage1.oneWay.click();
		HomePage1.from(driver);
		HomePage1.selectSource.click();
		HomePage1.to(driver);
		HomePage1.selectDestination.click();
		HomePage1.calendar(driver);
		HomePage1.journeyDate(driver);	
		HomePage1.done.click();
		HomePage1.search.click();
		
		PageFactory.initElements(driver, FlightsListPage1.class);
		FlightsListPage1.chooseFlight.click();
		
		TripSummaryPage1.checkOut(driver).click();
		
		PageFactory.initElements(driver, BookingConfirPage1.class);
		BookingConfirPage1.firstName.sendKeys("afhdg");
		BookingConfirPage1.lastName.sendKeys("nhdgc");
		BookingConfirPage1.birthDate(driver);
		BookingConfirPage1.countrySelect(driver);
		BookingConfirPage1.genderSelect(driver);
		BookingConfirPage1.address.sendKeys("5th street");	
		BookingConfirPage1.country.sendKeys("India");				
		BookingConfirPage1.india.click();	
		BookingConfirPage1.zipcpde.sendKeys("652455");
		BookingConfirPage1.city.sendKeys("salem");
		BookingConfirPage1.email.sendKeys("asnbg23@gmail.com");
		BookingConfirPage1.phoneNo.sendKeys("6549873215");
		
		PageFactory.initElements(driver, PaymentPage1.class);
		PaymentPage1.cardNo(driver).sendKeys("5555555555554444");
		PaymentPage1.exp.sendKeys("1226");
		PaymentPage1.cvv.sendKeys("432");
		PaymentPage1.proceed(driver).click();
		
		PageFactory.initElements(driver, CancelPage1.class);
		CancelPage1.cancel.click();
		CancelPage1.yes.click();
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
}
