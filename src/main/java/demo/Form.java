package demo;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class Form {

    ChromeDriver driver;

    public Form(ChromeDriver driver)
    {
        this.driver = driver;   
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    @FindBy(xpath = "//div[@id='i1']/ancestor::div[@class = 'z12JJ']/following-sibling::div[1]//input")
    WebElement name;

    @FindBy(xpath = "//div[@id='i5']/ancestor::div[@class = 'z12JJ']/following-sibling::div//textarea")
    WebElement description;

    @FindBy(xpath = "//label[@for='i13']")
    WebElement exp;

    @FindBy(xpath = "//div[@class = 'eBFwI']")
    List<WebElement> checkboxes;

    @FindBy(xpath = "//div[@class = 'ry3kXd']")
    WebElement addr;

    @FindBy(xpath = "//div[@role='option'][3]")
    WebElement miss;

    @FindBy(xpath = "//input[@type = 'date']")
    WebElement dte;

    @FindBy(xpath = "(//input[@role = 'combobox'])[1]")
    WebElement hrs;

    @FindBy(xpath = "(//input[@role = 'combobox'])[2]")
    WebElement mins;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div/div[3]")
    WebElement msg1;

    @FindBy(xpath = "//div[@class = 'vHW8K']/following-sibling:: div")
    WebElement msg2;

    // @FindBys({
    //     @FindBy(xpath="//body/div[1]/div[2]/div[1]/div/div[3]"),
    //     @FindBy(xpath="//div[@class = 'vHW8K']/following-sibling:: div")
    // })
    // List<WebElement> msg;

    
    public void fillForm() throws InterruptedException
    {
        SeleniumWrapper.clickElement(name, driver);
        SeleniumWrapper.sendKeysToBox(name, "Poonam");
        Thread.sleep(2000);
        SeleniumWrapper.clickElement(description, driver);
        SeleniumWrapper.sendKeysToBox(description, "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.");
        SeleniumWrapper.clickElement(exp, driver);

        for(WebElement ele : checkboxes)
        {
            if(!ele.getText().equals("Springboot"))
            {
                SeleniumWrapper.clickElement(ele, driver);
            }
            
        }

        SeleniumWrapper.clickElement(addr, driver);
        Thread.sleep(2000);
        SeleniumWrapper.clickElement(miss, driver);
        Thread.sleep(5000);
        SeleniumWrapper.sendKeysToBox(dte, "20-03-2024");
        SeleniumWrapper.sendKeysToBox(hrs, "12");
        SeleniumWrapper.sendKeysToBox(mins, "30");


    }

    public void changeurl(ChromeDriver driver) throws InterruptedException
    {
        driver.get("https://www.amazon.in");
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void submitForm()
    {
        SeleniumWrapper.clickElement(submitButton, driver);
    }

    public void displayMsg()
    {
        // System.out.println(msg.size());
        // for(WebElement ele2 : msg)
        // {
        //     System.out.println(ele2.getText());
        // }
       System.out.println(msg1.getText());
       System.out.println(msg2.getText());
    }

    
}
