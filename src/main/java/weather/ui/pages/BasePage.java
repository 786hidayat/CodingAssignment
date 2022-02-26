package weather.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void waitForPageToLoad(WebDriverWait wait, WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public void moveToWebElement(WebDriver driver, WebElement moreProducts){
		
		Actions act = new Actions(driver);
		
		act.moveToElement(moreProducts).click().build().perform();
		
	}
	
	
	public void doubleClick(WebDriver driver, WebElement moreProducts) {
		
		Actions act = new Actions(driver);
		
		act.doubleClick().build().perform();
		
		
	}
}
