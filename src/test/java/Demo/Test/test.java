package Demo.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.netty.handler.timeout.TimeoutException;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;

public class test {
public static WebDriver driver;
public static WebDriverWait wait;
	@BeforeMethod
	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\L-51\\eclipse-workspace\\Test\\src\\main\\java\\Demo\\Test\\chromedriver.exe");
		ChromeOptions options =  new ChromeOptions();
		//options.addArguments("--headless");
		driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testriq.com/contact-us");
		
	}
	
	@Test
	public void demoTest() {
   Actions act = new Actions(driver);
   act.moveByOffset(300, 400).perform();
		driver.findElement(By.xpath("(//input[@class='mf-input mf-conditional-input'])[1]")).sendKeys("Test");
		driver.findElement(By.xpath("(//input[@class='mf-input mf-conditional-input'])[2]")).sendKeys("pranav.patil@testriq.com");
		driver.findElement(By.xpath("(//label[@class='mf-input-label'])[3]/following-sibling::input")).sendKeys("Test message");
		driver.findElement(By.xpath("//div[@class='mf_select__control css-yk16xz-control']")).click();
		driver.findElement(By.xpath("(//div[@class='mf_select__menu-list css-11unzgr']/div)[3]")).click();
		driver.findElement(By.xpath("//textarea[@class='mf-input mf-textarea mf-conditional-input']")).sendKeys("This is a test mail");
		WebElement w= driver.findElement(By.xpath("//div[@class='mf_select__control css-yk16xz-control']"));
		w.click();
		driver.findElement(By.xpath("(//div[@class='mf_select__menu-list css-11unzgr']/div)[2]")).click();
		WebElement sendbutton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		sendbutton.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement thankyouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mf-response-msg']/p[text()='Thank you! We will get back soon.']")));

	   String actualMessage = thankyouMessage.getText();
	   String expectedMessage = "Thank you! We will get back soon.";
	   Assert.assertEquals(actualMessage, expectedMessage,"Submit Message does not match!");
		driver.quit();
	
		 
	}
}
