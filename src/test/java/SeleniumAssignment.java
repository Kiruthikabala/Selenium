import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumAssignment {

    public WebDriver driver ;
    @Test
    public void test1() {

    System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiruthika.B\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        if(driver.findElement(By.id("checkBoxOption1")).isSelected()) {
            driver.findElement(By.id("checkBoxOption1")).click();        }

        List<WebElement> checksize=driver.findElements(By.xpath("//div[@class='right-align']//input[@type='checkbox']"));
        Assert.assertEquals(checksize.size(),3);
    }
@Test
    public void test2() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiruthika.B\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        String name="KK";
        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("KK@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");

       WebElement genders= driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
       Select gender=new Select(genders);
       gender.selectByVisibleText("Female");
        driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("20071996");

        driver.findElement(By.xpath("//input[@value='Submit']")).click();
       System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
    System.out.println(driver.findElement(By.xpath("//h4//input[@name='name']")).getText());

    }

    @Test
    public void test3() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiruthika.B\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']")).click();
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        WebElement dropDown=driver.findElement(By.xpath("//select[@class='form-control']"));
        Select user= new Select(dropDown);
        user.selectByVisibleText("Consultant");
        driver.findElement(By.xpath("//span[@class='text-white termsText']")).click();
        WebDriverWait e= new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-lg-3']//h1")));
        List<WebElement> productList=driver.findElements(By.xpath("//h4[@class='card-title']"));
        for(int i=0;i<productList.size();i++)
        {
        driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
        }
        String checkOut=driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText();

        if(Integer.parseInt(checkOut.split(" ")[2])==(productList.size()))
        {
            driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        }
        e.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
    }
}
