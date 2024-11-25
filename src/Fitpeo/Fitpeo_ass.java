package Fitpeo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fitpeo_ass {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigate to the FitPeo Homepage
		driver.get("https://www.fitpeo.com/");
		
		//Navigate to the Revenue Calculator Page
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("revenue-calculator"));

        // Scroll down to the Slider Section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
        Thread.sleep(Duration.ofSeconds(2));
        
        
        //Adjust the Slider
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions act = new Actions(driver);
        act.clickAndHold(slider).moveByOffset(93, 0).release().perform();
        js.executeScript("window.scrollTo(0, 300)");
        Thread.sleep(Duration.ofSeconds(2));
        
        //Update the Text Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":r0:")));
        WebElement textField = driver.findElement(By.id(":r0:"));
        wait.until(ExpectedConditions.elementToBeClickable(textField));
        textField.sendKeys(Keys.BACK_SPACE);
        textField.sendKeys(Keys.BACK_SPACE);
        textField.sendKeys(Keys.BACK_SPACE);
        textField.sendKeys("560");
        Thread.sleep(Duration.ofSeconds(2));
        
        //Validate the Slider Value
        WebElement updatedSlider = driver.findElement(By.xpath("//input[@type='range']"));
        String sliderValue = updatedSlider.getAttribute("value");
        if (sliderValue.equals("560")) {
            System.out.println("Slider value successfully updated to 560.");
        } else {
            System.out.println("Slider value not updated correctly.");
        } 
        Thread.sleep(Duration.ofSeconds(2));
        
        //Select the CPT Codes checkboxes
        WebElement cpt99091Checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")); 
        WebElement cpt99453Checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement cpt99454Checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        WebElement cpt99474Checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));

        cpt99091Checkbox.click();
        cpt99453Checkbox.click();
        cpt99454Checkbox.click();
        cpt99474Checkbox.click();
        Thread.sleep(Duration.ofSeconds(2));
        
        //Validate Total Recurring Reimbursement
        String totalRecurring = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/header[1]/div[1]/p[4]/p[1]")).getText();
       if(totalRecurring.equals("$110,700"))
       {
    	   System.out.println("Total Recurring Reimbursement is correctly displayed as $110,700.");
       }else {
    	   System.out.println("Total Recurring Reimbursement is not displayed correctly.");
       }
       


	}

}
