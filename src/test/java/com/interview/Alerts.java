package com.interview;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://omayo.blogspot.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='GetConfirmation']")));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        actions.moveToElement(element).click().perform();
        Alert pro=driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        pro.sendKeys("a");
        Thread.sleep(2000);
//        confirmPromo.accept();
    }

}
