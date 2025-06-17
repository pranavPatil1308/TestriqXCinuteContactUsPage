package Demo.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@BeforeMethod
	public void setup() {
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options) ;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://cinutedigital.com/contact-us/");
	}
	@Test (priority =1)
	public void demoTesttwo() throws InterruptedException{
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Test");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("1234567890");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("pranav.patil@testriq.com");
		WebElement pincode = driver.findElement(By.id("pinCode"));
		pincode.sendKeys("400102");
		WebElement dropdown = driver.findElement(By.id("goal"));
		Select s = new Select(dropdown);
		s.selectByIndex(3);
		
		WebElement pinCodeElement = driver.findElement(By.id("pinCode"));
		Actions actions = new Actions(driver);
        actions.moveToElement(pinCodeElement).perform();
		
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));		 
		 WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Next'])[1]")));
		    element1.click();
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("education")));
		    Select w = new Select (element);
		 w.selectByVisibleText("Graduate");
		
		WebElement certificate = driver.findElement(By.id("certifications"));
		certificate.sendKeys("Java, C++");
		WebElement checkbox = driver.findElement(By.xpath("(//input[@class='form-check-input course-checkbox'])[5]"));
		checkbox.click();
		Actions act = new Actions(driver);
		WebElement next1 = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-next'])[2]"));
		act.moveToElement(next1).click().perform();
		
		WebElement startCourse = driver.findElement(By.id("startDay"));
		Select d = new Select (startCourse);
		d.selectByIndex(2);
		
		WebElement timeSlot = driver.findElement(By.id("time-slot"));
		Select e = new Select (timeSlot);
		e.selectByIndex(2);

		WebElement language = driver.findElement(By.id("preferredLanguage"));
		Select f = new Select (language);
		f.selectByIndex(3);

		WebElement comments = driver.findElement(By.xpath("//textarea[@id='questions']"));
		comments.sendKeys("Thank you");
		
		WebElement pinCodeElement1 = driver.findElement(By.xpath("//textarea[@id='questions']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(pinCodeElement1).perform();
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-success btn-submit']"));
		submitButton.click();
		driver.quit();
	
}
}

