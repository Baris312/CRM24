package BarisTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login
    {
        WebDriver driver;

        @BeforeClass
        public void setUp()
    {
      WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();



    }
       // Task1 ;  Given user is on Activity Stream .
     @Test
     public void login() throws InterruptedException
         {


            String url="https://login2.nextbasecrm.com/company/personal/user/729/tasks/task/view/163/?EVENT_TYPE=UPDATE&EVENT_TASK_ID=163&EVENT_OPTIONS[STAY_AT_PAGE]=";
            driver.get(url);
             driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement loginBox= driver.findElement(By.xpath("//input[@class='login-inp'][1]"));
        loginBox.click();
        loginBox.sendKeys("helpdesk39@cybertekschool.com");
             Thread.sleep(2000);

             WebElement passwordBox= driver.findElement(By.xpath("//input[@type='password']"));
            passwordBox.click();
            passwordBox.sendKeys("UserUser");

             Thread.sleep(2000);


             WebElement log_In = driver.findElement(By.xpath("//input[@type='submit']"));
             log_In.click();
         }

      //  Task2 ;When user clicks on Poll tab

@Test
public void poll(){

    WebElement ActivityStream = driver.findElement(By.xpath("//span[@class='menu-item-link-text']"));
     ActivityStream.click();





    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement poll= driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
            poll.click();



}
 @Test
 public void textInPoll() throws InterruptedException
     {


         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


            WebElement QuestionBox= driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][0][QUESTION]']"));


           QuestionBox.click();

           QuestionBox.sendKeys("test  complete ?");

         WebElement AnswerBox1= driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][0][ANSWERS][0][MESSAGE]']"));
         AnswerBox1.click();
         AnswerBox1.sendKeys("YES");
         Thread.sleep(2000);
         WebElement AnswerBox2= driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][0][ANSWERS][1][MESSAGE]']"));
         AnswerBox2.click();
         AnswerBox2.sendKeys("NO");




     }



        @AfterClass
        public void close() throws InterruptedException
            {
            Thread.sleep(2000);
          driver.close();
        }


    }
