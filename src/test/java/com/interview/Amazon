package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;

public class AmazonIn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.get("https://omayo.blogspot.com/");
        String title = d.getTitle();
        System.out.println(title);

        String parentWindow = d.getWindowHandle();
        d.findElement(By.linkText("Open a popup window")).click();


        //        Capturing all the windows
        Set<String> childWindow = d.getWindowHandles();

        //         Iterate through 1 by 1 windows and store it in String iterator
        Iterator<String> itr = childWindow.iterator();

        while (itr.hasNext()) {
//           This will capture the first window and store it in string
            String newWindow = itr.next();

//          switch to this new captured window now
            d.switchTo().window(newWindow);

            //         Get title to ensure whether it is a childWindow or Parent window and store it in String str
            String str = d.getTitle();
//          if title matches the child window title, dn close it
            if (str.equals("New Window")) {
                d.close();
            }
        }

        //          switch back the control to main window
//                    for that use "parentWindow" , coz we already captured it
        d.switchTo().window(parentWindow);
        d.findElement(By.xpath("//*[@id=\"ta1\"]")).sendKeys("Hi...!");

//        work on switching between windows


    }
}
