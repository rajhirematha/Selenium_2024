package org;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.time.Duration;


public class Testing {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver","C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Selenium\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.navigate().to("https://tutorialsninja.com/demo/");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,800)");

            Thread.sleep(2000);
            File file = driver.findElement(By.xpath("//a[normalize-space()='Apple Cinema 30\"']")).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(file, new File(System.getProperty("user.dir") + "\\Pic.png"));
            Thread.sleep(2000);
            jse.executeScript("alert('Homepage')");
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.accept();

        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            driver.quit();
        }
    }
}

