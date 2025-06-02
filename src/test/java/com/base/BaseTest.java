package com.base;

import com.e_services_economy.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static Utitlities.Utility.setUtilityDriver;
import static com.base.BasePage.delay;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String E_SERVICE_ECONOMY_URL = "https://e-services.economy.gov.az/";


    @BeforeClass

    public void setUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(E_SERVICE_ECONOMY_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();

    }

    @AfterClass
    public void tearDown(){
        delay(3000);
        driver.quit();
    }

}
