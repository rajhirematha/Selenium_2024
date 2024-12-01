package com.interview;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class AmazongetWindowhandles {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.irctc.co.in/nget/train-search");
        String parentHandle = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='https://equery.irctc.co.in/'])[2]")));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        element.click();

        Set<String> childHandle = driver.getWindowHandles();
        for (String child : childHandle) {
            if (!child.equals(parentHandle)) {
                driver.switchTo().window(child);
                driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("283748932");
                Thread.sleep(2000);
//                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-autocomplete[@id='origin']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
        Actions actions=new Actions(driver);
        actions.moveToElement(ele).sendKeys("Gulbarga").perform();


        Thread.sleep(5000);
//        driver.quit();
    }

}
