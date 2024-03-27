package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWrapper {
    
    ChromeDriver driver;

    public static void clickElement(WebElement elementToClick, ChromeDriver driver)
    {

            if(elementToClick.isDisplayed())
            {
                elementToClick.click();
            }

    }

    public static void sendKeysToBox(WebElement inputBox, String textToSend) throws InterruptedException
    {
        inputBox.clear();
        Thread.sleep(1000);
        inputBox.sendKeys(textToSend);
        Thread.sleep(1000);

    }


}
