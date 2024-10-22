package Demo.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
public class test2 {
	@BeforeMethod

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\L-51\\Downloads\\chrome-win64\\chrome-win64.exe");
		WebDriver driver = new ChromeDriver();
	}

}
