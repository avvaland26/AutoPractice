package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class Register {
    static WebDriver driver;
    @BeforeMethod
    public static void setBrowser() {
        //setting up Chrome driver path
        System.setProperty("webdriver.chrome.driver", "C://Soft//chromedriver_win32//chromedriver.exe");
        //creating Chrome driver object to open google chrome browser
        driver = new ChromeDriver();
        //Maximising screen
        driver.manage().window().maximize();
        //applying implicitly wait of 10 second to the driver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open the URL
        driver.get("http://demo.nopcommerce.com");}

      @AfterMethod
      public static void CloseBrowser() {
        driver.close(); }

    public static void waitUntilElementIsClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));}

    public static void sleep1(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
    }
    public static void clickonElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }
    public static String GetTextFromElements(By by) {
        return driver.findElement(by).getText();
    }
    public static long timestamp(){
        return (System.currentTimeMillis());

    }
    public static void selectfromDropDownByVisibleText(By by,String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
@Test
public void UserEntersRegistrationDetails(){
        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));//click register page
        clickonElement(By.xpath("//input[@id=\"gender-female\"]"));//click on gender
        typeText(By.xpath("//input[@id=\"FirstName\"]"),"Anjana");//Enter a name
        typeText(By.xpath("//input[@id=\"LastName\"]"),"Valand");//Enter a surname
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"15");//enter birthdate
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"March");//enter birth month
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"2000");//enter birth year
        typeText((By.xpath("//input[@id=\"Email\"]")), "kavyanjali2614+"+timestamp()+"@gmail.com");//Enter email id
        typeText((By.xpath("//input[@id=\"Company\"]")),"Unique");//enter company name
        clickonElement(By.xpath("//input[@id=\"Newsletter\"]"));//select newsletter
        typeText(By.xpath("//input[@id=\"Password\"]"),"Anju123");//Enter password
        typeText(By.xpath("//input[@id=\"ConfirmPassword\"]"),"Anju123");//enter confirm password
        clickonElement(By.xpath("//input[@id=\"register-button\"]"));//click on register button
        String expectedText = "Your registration completed";//actual text from the website
        String actualText = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();//actual text
        Assert.assertEquals(actualText,expectedText,"text not match");//comparing both text
        System.out.println(actualText);//printing actual text
    }
    @Test
    public void RegisterUserShouldBeAbleToReferAProductToAFriendSuccessfully(){
        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));//click register page
        clickonElement(By.xpath("//input[@id=\"gender-female\"]"));//click on gender
        typeText(By.xpath("//input[@id=\"FirstName\"]"),"Anjana");//Enter a name
        typeText(By.xpath("//input[@id=\"LastName\"]"),"Valand");//Enter a surname
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"15");//enter birthdate
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"March");//enter birth month
        selectfromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"2000");//enter birth year
        typeText(By.xpath("//input[@id=\"Email\"]"),"kavyanjali2614+"+timestamp()+"@gmail.com");//Enter email id
        typeText(By.xpath("//input[@id=\"Company\"]"),"Unique");//enter company name
        clickonElement(By.xpath("//input[@id=\"Newsletter\"]"));//select newsletter
        typeText(By.xpath("//input[@id=\"Password\"]"),"Anju123");//Enter password
        typeText(By.xpath("//input[@id=\"ConfirmPassword\"]"),"Anju123");//enter confirm password
        clickonElement(By.xpath("//input[@id=\"register-button\"]"));//click on register button
        clickonElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a"));//click on computer
        clickonElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/h2/a"));//click on desktop
        clickonElement(By.xpath("//a[text()='Lenovo IdeaCentre 600 All-in-One PC']"));//click on lenovo product
        clickonElement(By.xpath("//input[@value=\"Email a friend\"]"));//click on email friend
        typeText(By.xpath("//input[@id=\"FriendEmail\"]"),"anjalivishal09@gmail.com");//Enter friend mail id
        typeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "hi anjali how are you");//type message
        clickonElement(By.xpath("//input[@class=\"button-1 send-email-a-friend-button\"]"));//click on send button
        String expectedText = "Your message has been sent.";//actual message from website
        String actualText = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();//actual text
        Assert.assertEquals(actualText,expectedText,"not match");//compare message
        System.out.println(actualText);//printing message
}
     @Test
    public void UserShouldBeAbleToAddProductToBasketSuccessfully(){
         clickonElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a"));//click on Books
         String expectedText = driver.findElement(By.xpath("//h2/a[text()='Fahrenheit 451 by Ray Bradbury']")).getText();
         clickonElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Add to cart first book product
         sleep1(3000);//put slee
         String expected2 = driver.findElement(By.xpath("//h2/a[text()='First Prize Pies']")).getText();
         sleep1(3000);
         clickonElement(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Add to cart second book
         sleep1(3000);//put sleep
         clickonElement(By.xpath("//span[@class=\"cart-label\"]"));//click on add to cart button
         String actualText = driver.findElement(By.xpath("//tr[1]/td[4]/a[@class=\"product-name\"]")).getText();//first actual message
         Assert.assertEquals(actualText,expectedText,"both not match");//comparing message
         System.out.println(actualText);//printing out actual text
         String actualText2 = driver.findElement(By.xpath("//tr[2]/td[4]/a[@class=\"product-name\"]")).getText();//second actual mess
         Assert.assertEquals(actualText2,expected2,"both not match");//comparing both message
         System.out.println(actualText2);//printing message

     }
}