package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\NemanjaPecic\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Maximize the chrome window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.automationpractice.pl/index.php");

        // Generate a random email address
        String randomEmail = "test" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        //Click on Sign in
        driver.findElement(By.className("login")).click();

        //Fills in the email address
        driver.findElement(By.cssSelector("#email_create")).sendKeys(randomEmail);

        //Click on Create an account
        driver.findElement(By.id("SubmitCreate")).click();

        //Waits for 2 seconds
        Thread.sleep(2000);

        //We select the radio button Mr.
        driver.findElement(By.id("id_gender1")).click();



        //We enter the First Name
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Jessie");

        //We enter the Last Name
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Jamess");

        //We clear the old email address
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(2000);



        //We enter the new email address
        driver.findElement(By.id("email")).sendKeys(randomEmail);

        //We enter the password
        driver.findElement(By.id("passwd")).sendKeys("Test123");

        //Select value
        // First dropdown
        Select select1 = new Select(driver.findElement(By.id("days")));
        select1.selectByIndex(5);

        // Second dropdown
        Select select2 = new Select(driver.findElement(By.id("months")));
        select2.selectByIndex(6);

        // Third dropdown
        Select select3 = new Select(driver.findElement(By.id("years")));
        select3.selectByValue("1985");

        //Select Register
        driver.findElement(By.id("submitAccount")).click();

      //  Thread.sleep(5000);

        // Get text after registration (you might want to adjust the locator)
        WebElement successMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        String successMessage = successMessageElement.getText();
        System.out.println("Success Message: " + successMessage);

        Thread.sleep(2000);
        //Clicks on ADD my first Address button
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[1]/a")).click();

        //we add Company name
        driver.findElement(By.id("company")).sendKeys("Test123");

        //We add Address into the field
        driver.findElement(By.id("address1")).sendKeys("33 Orchard Dr UNIT 33");

        //We add Address2 into the field
        driver.findElement(By.id("address2")).sendKeys("33");

        //We add City into the field
        driver.findElement(By.id("city")).sendKeys("Stow");

        //Pravimo select za State
        Select select4 = new Select(driver.findElement(By.id("id_state")));
        select4.selectByVisibleText("Massachusetts");

        //We add ZIP code
        driver.findElement(By.id("postcode")).sendKeys("01775");

        //We add home phone
        driver.findElement(By.id("phone")).sendKeys("0305467845");

        //We add mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys("0305467845");

        //We add additional information
        driver.findElement(By.id("other")).sendKeys("Test by Nemanja");

        //We clear the address tittle
        driver.findElement(By.name("alias")).clear();

        //We add tittle for my home address
        driver.findElement(By.name("alias")).sendKeys("Moja Adresa");

        //Save the information button
        driver.findElement(By.cssSelector("#submitAddress")).click();

        //We get the First name
        WebElement addressNameMessageElement = driver.findElement(By.className("address_name"));
        String addressMessage = addressNameMessageElement.getText();
        System.out.print("Name: " + addressMessage + " ");

        //We get the Last name
        WebElement addressLastMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[2]"));
        String addressLastMessage = addressLastMessageElement.getText();
        System.out.println("Last: " + addressLastMessage);

        //We get the Company name
        WebElement addressCompanyMessageElement = driver.findElement(By.className("address_company"));
        String addressCompanyMessage = addressCompanyMessageElement.getText();
        System.out.println("Company: " + addressCompanyMessage);

        //We get the Address
        WebElement address1MessageElement = driver.findElement(By.className("address_address1"));
        String address1Message = address1MessageElement.getText();
        System.out.println("Address: " + address1Message + " ");

        //We get the City
        WebElement CityMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]"));
        String CityMessage = CityMessageElement.getText();
        System.out.print("City: " + CityMessage + " ");

        //We get the State
        WebElement StateMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]"));
        String StateMessage = StateMessageElement.getText();
        System.out.print("State: " + StateMessage+ " ");

        //We get the ZIP code
        WebElement ZIPMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]"));
        String ZIPMessage = ZIPMessageElement.getText();
        System.out.println("ZIP: " + ZIPMessage+ " ");

        //We get the Country
        WebElement CountryMessageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[6]/span"));
        String CountryMessage = CountryMessageElement.getText();
        System.out.println("Country: " + CountryMessage+ " ");

        //We get the Number
        WebElement NumberMessageElement = driver.findElement(By.className("address_phone"));
        String NumberMessage = NumberMessageElement.getText();
        System.out.println("Number: " + NumberMessage+ " ");

        //We go back to account page
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a/span")).click();

        //We go to My account page
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[4]/a/i")).click();

        //We get the email address used for the registration
        WebElement emailMessageElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        String emailMessage = emailMessageElement.getAttribute("value");
        System.out.println("Email: " + emailMessage);

        Thread.sleep(3000);

        driver.quit();


    }
}
