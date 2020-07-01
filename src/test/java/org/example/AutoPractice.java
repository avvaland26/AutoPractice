package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoPractice {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Soft//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a")).click();
        driver.findElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a")).click();
        String pagetext=driver.findElement(By.xpath("//a[text()='Build your own computer']")).getText();
        System.out.println(pagetext);
    }
}
