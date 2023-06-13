package automationTestNG;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectsAirportTransfer.BookingConfirPage3;
import pageObjectsAirportTransfer.CancelPage3;
import pageObjectsAirportTransfer.Homepage3;
import pageObjectsAirportTransfer.PaymentPage3;
import pageObjectsAirportTransfer.TransferInfo3;
import pageObjectsAirportTransfer.TransfersList3;

public class AirportTransferNG {
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
	     public void hotelBooking() throws InterruptedException {
			PageFactory.initElements(driver, Homepage3.class);
			Homepage3.transfer.click();
			Homepage3.airportName(driver).click();
			Homepage3.airportName(driver);
			Homepage3.selectAirport.click();
			Homepage3.hotelName(driver);
			Homepage3.selectHotel.click();
			Homepage3.clickCalendar(driver);
			Homepage3.month(driver);
			Homepage3.selectDate(driver);
			//Homepage3.done.click();
			Homepage3.clock.click();
			Homepage3.selectTime(driver);
			Homepage3.search.click();
			
			PageFactory.initElements(driver, TransfersList3.class);
			TransfersList3.selectTransfer.click();
			
			PageFactory.initElements(driver, TransferInfo3.class);
			TransferInfo3.book.click();
			
			PageFactory.initElements(driver, BookingConfirPage3.class);
			BookingConfirPage3.firstName(driver).sendKeys("afhdg");
			BookingConfirPage3.lastName.sendKeys("sdgufs");
			BookingConfirPage3.salutation.click();
			BookingConfirPage3.mr.click();
			BookingConfirPage3.age.sendKeys("23");
			BookingConfirPage3.selectAirline.click();
			BookingConfirPage3.americanAirline.click();
			BookingConfirPage3.flightNumber.sendKeys("US-123");	
			BookingConfirPage3.address.sendKeys("5th cross street");
			BookingConfirPage3.country.sendKeys("India");				
			BookingConfirPage3.india.click();	
			BookingConfirPage3.zipcpde.sendKeys("652455");
			BookingConfirPage3.city.sendKeys("salem");
			BookingConfirPage3.email.sendKeys("asnbg23@gmail.com");
			BookingConfirPage3.phoneNo.sendKeys("6549873215");
	        
			PageFactory.initElements(driver, PaymentPage3.class);
			PaymentPage3.cardNo(driver).sendKeys("5555555555554444");
			PaymentPage3.exp.sendKeys("1226");
			PaymentPage3.cvv.sendKeys("432");
			PaymentPage3.proceed(driver).click();
			
			PageFactory.initElements(driver, CancelPage3.class);
			CancelPage3.cancel.click();
			CancelPage3.yes.click();
				 
	 }
	    @AfterClass
	    public void closeBrowser() {
	  	    driver.quit();
	  	  }
	 
}
