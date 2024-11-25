package com.interview;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.ElementScanner8;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Irctc {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        WebDriverWait wait = null;
        try {
            driver.navigate().to("https://www.irctc.co.in/nget/train-search");
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Actions actions = new Actions(driver);

            WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//p-autocomplete[@id='origin']")));
            actions.moveToElement(element1).click().sendKeys("hyderabad").perform();

            WebElement element2 = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//span[@class='ng-star-inserted']//span[1]")));
            element2.click();
            Thread.sleep(2000);

            WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//p-autocomplete[@id='destination']//input")));
            actions.moveToElement(element3).click().sendKeys("Bengaluru").perform();

            WebElement element4 = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//span[contains(text(), 'KSR BENGALURU')]")));
            element4.click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//p-dropdown[@id='journeyClass']")).click();
            WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//span[contains(text(),'AC First Class (1A)')]")));
            actions.moveToElement(element5).click().perform();

            driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
            WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'30')]")));
            actions.moveToElement(element6).click().perform();

            driver.findElement(By.xpath("//div[normalize-space()='GENERAL']")).click();
            WebElement element7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='LADIES']")));
            actions.moveToElement(element7).click().perform();

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

                WebElement element8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'AC First Class (1A) ')][1]")));
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element8);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//strong[contains(text(),'AC First Class (1A) ')][1]")).click();

            } catch (Exception e) {
                e.printStackTrace();
            }

/*
     ((TakesScreenshot) driver): This part of the code is typecasting the driver object
     to the TakesScreenshot interface. This is necessary because
     the WebDriver interface does not include the getScreenshotAs method,
     but the TakesScreenshot interface does.
*/
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File target = new File("NEW_SCREENsHOT.jpg");

        /* utility class from the Apache Commons IO library
        that provides various methods for file operations,
        such as copying, moving, reading, writing, and deleting files.
        */
            try {
                FileUtils.copyFile(source, target);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("IRCTC application Opened successfully");

            Thread.sleep(2000);
       driver.close();
        }

    }
