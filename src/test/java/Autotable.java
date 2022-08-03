import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;

public class Autotable {

    public WebDriver driver ;


    @BeforeTest
    public void launch(){
        System.out.println("launch the browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiruthika.B\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
                driver.get("http://the-internet.herokuapp.com/tables");
    };

    @Test
    public void test1(){
    String titleofpageactual=driver.getTitle();
        System.out.println(titleofpageactual);
        Assert.assertEquals(titleofpageactual,"The Internet");
    String titleonpageactual=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        System.out.println(titleonpageactual);
        Assert.assertEquals(titleonpageactual,"Data Tables");
    String title2onpageactual=driver.findElement(By.xpath("//*[@id='content']/div/h4[1]")).getText();
        System.out.println(title2onpageactual);
        Assert.assertEquals(title2onpageactual,"Example 1");
    String title3onpageactual=driver.findElement(By.xpath("//*[@id='content']/div/h4[2]")).getText();
        System.out.println(title3onpageactual);
        Assert.assertEquals(title3onpageactual,"Example 2");
    }

    @Test
    public void test2(){
        int i=1;
        int Due2=0;
        int j=0;
        int k=0;

        while(i<=4) {

            String Due1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[4]")).getText();
            String Due=Due1.replace("$","");
            Due2=Integer.parseInt (Due.replace(".00",""));
            System.out.println(Due2);
            if (i==1){
                j=Due2;
                k=i;
            }
            else if (j>Due2)
            {
                 j=Due2;
                  k=i;
                System.out.println("The minimum is " + j);
                System.out.println("The index " + k);
            }
            else if (j==Due2)
            {
                int firstmin=k;
                System.out.println("The first min index " + firstmin);
                String Lastname1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + firstmin + "]/td[1]")).getText();
                System.out.println("Lastname of minimum due " + Lastname1);
                String Firstname1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + firstmin + "]/td[2]")).getText();
                System.out.println("Firstname of minimum due " + Firstname1);
                String Email1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + firstmin + "]/td[3]")).getText();
                System.out.println("Firstname of minimum due " + Email1);
                j=Due2;
                k=i;
                System.out.println("The second min index " + k);
                System.out.println("The minimum is " + j);
                String Lastname2 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + k + "]/td[1]")).getText();
                System.out.println("Lastname of minimum due " + Lastname2);
                String Firstname2 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + k + "]/td[2]")).getText();
                System.out.println("Firstname of minimum due " + Firstname2);
                String Email2 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + k + "]/td[3]")).getText();
                System.out.println("Firstname of minimum due " + Email2);

            }
           // }
            i++;
            }
        Assert.assertEquals(j,50);

        }

    @Test
    public void test3(){
        int i=1;
        int Due2=0;
        int j=0;
        int k=0;

        while(i<=4) {
            String Due1 = driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[" + i + "]/td[4]")).getText();
            String Due=Due1.replace("$","");
            Due2=Integer.parseInt (Due.replace(".00",""));
            System.out.println(Due2);
            if (i==1){
                j=Due2;
                k=i;
            }
            else if (j>Due2)
            {
                j=Due2;
                k=i;
            }

            // }
            i++;
        }
        System.out.println("The index " + k);
        System.out.println("The minimum is " + j);
        Assert.assertEquals(j,50);
        String Lastname=driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[" + k + "]/td[1]")).getText();
        System.out.println("Lastname of minimum due " +Lastname);
        String Firstname=driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[" + k + "]/td[2]")).getText();
        System.out.println("Firstname of minimum due " + Firstname);
        String Email=driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[" + k + "]/td[3]")).getText();
        System.out.println("email of minimum due " + Email);
    }
    @Test
    public void test4(){
        int i=1;
       // int k=0;
        while (i<=4) {
            int j=1;
           while (j <= 4) {
                String row = driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(row);
                j++;
            }
            i++;

        }

    }
   @AfterTest
    public void browserclose(){
        driver.close();
   }

}

