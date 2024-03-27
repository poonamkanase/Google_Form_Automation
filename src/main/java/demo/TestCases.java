package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        //driver.get("https://www.google.com");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        //driver.get("https://www.amazon.in");
        Form form = new Form(driver);
        form.fillForm();

        form.changeurl(driver);

        form.submitForm();

        form.displayMsg();


        Thread.sleep(5000);
        System.out.println("end Test case: testCase01");
    }


}
