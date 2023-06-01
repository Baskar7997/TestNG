package automationTestNG;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BookingConfirPage;
import pageObjects.BookingPage;
import pageObjects.CancelPage;
import pageObjects.HomePage;
import pageObjects.HotelsPage;
import pageObjects.Paymentpage;

public class HotelNG {
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
		    PageFactory.initElements(driver, HomePage.class);
			HomePage.searchHotels.sendKeys("LAX, Los Angeles - CA,");
			HomePage.searchHotels.click();
			Thread.sleep(1000);
			HomePage.selectHotels.click();
			Thread.sleep(500);
			HomePage.calendar(driver);
			HomePage.inDate(driver);
			Thread.sleep(1000);
			HomePage.outDate(driver);
			Thread.sleep(1000);
			HomePage.submit.click();
			
			PageFactory.initElements(driver, HotelsPage.class);
			HotelsPage.chooseHotel.click();
			
			PageFactory.initElements(driver, BookingPage.class);
			BookingPage.roomOptions(driver).click();
			BookingPage.selectRoom.click();
			BookingPage.checkOut.click();	
			
			PageFactory.initElements(driver, BookingConfirPage.class);
			BookingConfirPage.firstName.sendKeys("afhdg");
			BookingConfirPage.lastName.sendKeys("nhdgc");
			BookingConfirPage.age.sendKeys("25");
			BookingConfirPage.gender.click();
			Thread.sleep(1000);
			BookingConfirPage.male.click();
			Thread.sleep(500);
			BookingConfirPage.address.sendKeys("5th street");	
			BookingConfirPage.country.sendKeys("India");
			Thread.sleep(1000);
			BookingConfirPage.india.click();
			Thread.sleep(500);
			BookingConfirPage.zipcpde.sendKeys("652455");
			BookingConfirPage.city.sendKeys("salem");
			BookingConfirPage.email.sendKeys("asnbg23@gmail.com");
			BookingConfirPage.phoneNo.sendKeys("6549873215");
			
			PageFactory.initElements(driver, Paymentpage.class);
			Paymentpage.cardNo(driver).sendKeys("5555555555554444");
			Paymentpage.exp.sendKeys("1226");
			Paymentpage.cvv.sendKeys("432");
			Paymentpage.proceed(driver).click();
			
			PageFactory.initElements(driver, CancelPage.class);
			CancelPage.cancel.click();
			Thread.sleep(500);
			CancelPage.yes.click();
	   }
	    
	    @AfterTest
	    public void closeBrowser() {
	  //  driver.quit();
	  }
	 
}
