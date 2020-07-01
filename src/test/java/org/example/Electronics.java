package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Electronics {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Soft//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();
        String pagetext= driver.findElement(By.xpath("//a[@title=\"Show details for HTC One M8 Android L 5.0 Lollipop\"]")).getText();
        System.out.println(pagetext);
        String text = driver.findElement(By.xpath("//div/a[text()=\"HTC One Mini Blue\"]")).getText();
        System.out.println(text);
        
    }

}
