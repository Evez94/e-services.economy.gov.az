package com.e_services_economy.pages.NavbarComponents;

import Utitlities.JavaScriptUtility;
import com.e_services_economy.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utitlities.JavaScriptUtility.scrollToElementJS;
import static Utitlities.WaitUtility.*;

public class AgenciesPage extends HomePage {
    private By agenciesHeaderText = By.xpath("//div[@id='root']//h2[text()='Qurumlar']");
    private By searchInput = By.xpath("//div[@id='root']//input[@name='text']");
    private By resultItems = By.xpath("//div[@id='root']//span[@class='_title_5ekyk_45']");
    private By aboutAgenciesLink = By.cssSelector("(//div[@id='root']//a[contains(text(),'Qurum məlumatları')])[1]");
    private By aboutAgenciesTitle = By.xpath("//div[@id='root']//div[@class='_top_5ekyk_42']//span[1]");


    // Page loading
    public String getAgenciesHeaderText(){
        return find(agenciesHeaderText).getText();
    }

    // Search Availabe item filtering
    public List<WebElement> getSearchResults() {
        return driver.findElements(resultItems);
    }

    public void enterSearchText(String text) {
        WebElement input = driver.findElement(searchInput);
        input.click(); // Fokuslanmaq üçün klikləmek
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER); // "Enter" düyməsini simulyasiya etmek
        waitForVisibility(driver,resultItems,10);

    }

    // Search UnAvailabe item filtering
    public void enterSearchBadText(String text) {
        WebElement input = driver.findElement(searchInput);
        input.click(); // Fokuslanmaq üçün klikləmek
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER); // "Enter" düyməsini simulyasiya etmek
        waitForInvisibility(driver,resultItems,10);

    }

    // About Agencies

    public  AboutAgenciesPage goToAboutAgenciesPage(){
        // JavaScriptUtility istifadəsi
        JavaScriptUtility.setDriver(driver);
        JavaScriptUtility.scrollToElementJS(aboutAgenciesLink);
        JavaScriptUtility.safeClick(aboutAgenciesLink);
        JavaScriptUtility.waitForPageLoad(10);

        return new AboutAgenciesPage();

    }

    public String getAgencyTitleText(){
        return find(aboutAgenciesTitle).getText();
    }
}
