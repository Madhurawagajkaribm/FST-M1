package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Google Home Page$")
	public void funtion() throws Throwable{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
		driver.get("https://www.google.com");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void whenFunctionName() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
		
	}

	@Then("^Show how many search results were shown$")
	public void thenFunctionName() throws Throwable{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
	}
	
	@And ("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}
