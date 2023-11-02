package cawProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CAWassessment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		
		driver.manage().window().maximize();
		
		String S1 = driver.getTitle();
		
		System.out.println("The Title of the page is " + S1);
		
		driver.findElement(By.xpath("/html/body/div/div[3]/details/summary")).click();
		
		WebElement E =driver.findElement(By.xpath("//*[@id=\"jsondata\"]"));
		E.clear();		
		String jsonArray = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
                "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
                "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
                "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
                "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
		E.sendKeys(jsonArray);
		
		driver.findElement(By.xpath("//*[@id=\"refreshtable\"]")).click();
		
		//Asserting The Data
		WebElement E1 =driver.findElement(By.xpath("//*[@id=\"jsondata\"]"));
		String S2 = E1.getAttribute("value");
		WebElement S3 = driver.findElement(By.id("dynamictable"));
		String dataTable = S3.getText();
			
		if (S2.equals(dataTable))
		{
			System.out.println("Entered data and Table data are same");
		}
		else
		{
			System.out.println(" Entered data and table data are different");
		}
		
		
		
}





	}


