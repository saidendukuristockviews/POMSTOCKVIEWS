import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RoughWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","\\home\\saidendukuri\\Documents\\Selenium\\chromedriver_linux64\\chromedriver");
		System.setProperty("webdriver.chrome.driver", "/home/saidendukuri/Documents/Selenium/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/users/sign_in");
		String username = "saidendukuri@stockviews.com";
		String password = "12345678";
		driver.findElement(By.name("user[email]")).sendKeys(username);
		driver.findElement(By.name("user[password]")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
		List<WebElement> stockNames = driver.findElements(By.xpath("/div[@class='dfb-top-box']/a"));
		List<WebElement> rating = driver.findElements(By.xpath("//div[@class='dfb-stock-rating']/span[@class='neutral-rating ng-binding']"));
		int count = stockNames.size();
		for(int i=0;i<count;i++) 
		{
			String s1=stockNames.get(i).getText().toString();
			String s2=stockNames.get(i+1).getText().toString();
			System.out.println(s1);
			System.out.println(s2);
			if(s1.equals(s2)) 
			{
				String r1=rating.get(i).getText().toString();
				String r2=rating.get(i+1).getText().toString();
				if(!r1.equals(r2)) 
				{
					System.out.println("Comparing Ratings");
					String str;
					if(r1.equalsIgnoreCase("Initiation")) 
					{
						str =r1;
						System.out.println(str);
					}
					else if(r2.equalsIgnoreCase("Initiation")) 
					{
						str =r2;
						System.out.println(str);
					}
				}
			}
		}
		driver.quit();
	}

}
