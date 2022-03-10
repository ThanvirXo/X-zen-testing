import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteveWebsite {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\thanv\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		String contact="9384687587";
		String cardNo="4111111111111111";
		Actions a=new Actions(driver);
		driver.get("https://xzen.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("headlessui-popover-button-3")).click();
		driver.findElement(By.linkText("Shirts")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//a[@href='/product/61837157f0163f80c7ed07f9']")).isDisplayed());
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='absolute inset-0'])[1]"))).click();
		
		WebElement staticdrop=driver.findElement(By.cssSelector("select[class='form-select form-control']"));
		Select drop=new Select(staticdrop);
		drop.selectByValue("3");
		
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary w-100 btn btn-primary']"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary w-100 btn btn-primary']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("thanvir200@gmail.com");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("thanvir7");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("address")));
		driver.findElement(By.id("address")).sendKeys("address");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("postalCode")).sendKeys("postalCode");
		driver.findElement(By.id("country")).sendKeys("India");
		
		a.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().build().perform();
		
		driver.findElement(By.id("gp")).click();
		a.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().build().perform();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
		String orderConfirmation=w.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
		System.out.println(orderConfirmation);
		
		driver.findElement(By.cssSelector(".btn.btn-primary.w-100.btn.btn-primary")).click();
//		Thread.sleep(2000);
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		System.out.println(w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mchild"))).isDisplayed());
		
		driver.findElement(By.id("contact")).sendKeys(contact);
		driver.findElement(By.xpath("//span[@id='footer-cta']")).click();
		driver.findElement(By.cssSelector("button[class='new-method has-tooltip false svelte-1u727jy']")).click();
		driver.findElement(By.id("card_number")).sendKeys(cardNo);
		driver.findElement(By.id("card_expiry")).sendKeys("03/25");
		driver.findElement(By.id("card_cvv")).sendKeys("088");
		driver.findElement(By.id("footer-cta")).click();
		driver.findElement(By.id("otp-sec")).click();
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parentId=it.next();
		String childId=it.next();
		
		driver.switchTo().window(childId);
		driver.findElement(By.className("success")).click();
		
		
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
//		Alert alert=driver.switchTo().alert();
//		alert.accept();
//		alert.accept();
//		alert.accept();
		
		int retries=3;
		while(retries>0) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
			retries--;
		}
	}
	

}
