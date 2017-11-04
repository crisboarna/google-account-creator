package com.automation.selenium.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleAccountCreator {

    private static final int ITERATIONS = Integer.parseInt(System.getProperty("ITERATIONS"));
    private static final String FIRST_NAME = System.getProperty("FORM_FIRST_NAME");
    private static final String LAST_NAME = System.getProperty("FORM_LAST_NAME");
    private static final String EMAIL_PREFIX = System.getProperty("FORM_EMAIL_PREFIX");
    private static final String PASSWORD = System.getProperty("FORM_PASSWORD");
    private static final String BIRTH_DAY = System.getProperty("FORM_BIRTH_DAY");
    private static final String BIRTH_MONTH = System.getProperty("FORM_BIRTH_MONTH");
    private static final String BIRTH_YEAR = System.getProperty("FORM_BIRTH_YEAR");
    private static final String SEX = System.getProperty("FORM_SEX");
    private static final String RECOVERY_EMAIL = System.getProperty("FORM_RECOVERY");
    private static final String PHONE_NUMBER = System.getProperty("FORM_NUMBER");

    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.gecko.driver","./geckodriver");

        for(int i =10 ;i < ITERATIONS; i++) {
            WebDriver driver = new FirefoxDriver();

            driver.get("https://accounts.google.com/SignUp?");

            driver.manage().window().maximize();

            driver.findElement(By.name("FirstName")).sendKeys(FIRST_NAME);
            driver.findElement(By.name("LastName")).sendKeys(LAST_NAME);

            driver.findElement(By.name("GmailAddress")).sendKeys(EMAIL_PREFIX + i);

            driver.findElement(By.name("Passwd")).sendKeys(PASSWORD);
            driver.findElement(By.name("PasswdAgain")).sendKeys(PASSWORD);

            driver.findElement(By.xpath("//div[@role='listbox']")).sendKeys(BIRTH_MONTH);
            driver.findElement(By.name("BirthDay")).sendKeys(BIRTH_DAY);
            driver.findElement(By.name("BirthYear")).sendKeys(BIRTH_YEAR);

            driver.findElement(By.xpath("//div[@aria-activedescendant=':d']")).sendKeys(SEX);

            driver.findElement(By.name("RecoveryPhoneNumber")).sendKeys();

            driver.findElement(By.name("RecoveryEmailAddress")).sendKeys(RECOVERY_EMAIL);

            driver.findElement(By.name("submitbutton")).click();
            driver.findElement(By.xpath("//div[@id='tos-scroll-button']")).click();
            driver.findElement(By.name("iagreebutton")).click();

            Thread.sleep(500);
            driver.findElement(By.name("deviceAddress")).sendKeys(PHONE_NUMBER);
            driver.findElement(By.name("SendCode")).click();

            Thread.sleep(20000);
            driver.quit();
        }
    }
}