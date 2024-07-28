package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestingBrowser {
    public static void main(String[] args) throws InterruptedException {

//      Open chrome in incognito mode
        ChromeOptions co = new ChromeOptions();

//      add the argument "--incognito" to enable incognito mode.
        co.addArguments("--incognito");

//      Launch the Chrome browser
        WebDriver d = new ChromeDriver(co);

        d.manage().window().maximize();
        d.get("https://www.naveenautomationlabs.com");
        System.out.println(d.getCurrentUrl());
        System.out.println(d.getTitle());
        Thread.sleep(3000);
        d.navigate().refresh();
//        d.quit();

    }
}
