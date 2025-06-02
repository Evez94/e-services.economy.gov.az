package com.e_services_economy.pages.NavbarComponents;

import com.e_services_economy.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utitlities.WaitUtility.waitForVisibility;


public class ServicesPage extends HomePage {
    private By servicesHeaderText = By.xpath("//div[@id='root']//h2[text()='Xidmətlər']");
    private By searchInput = By.xpath("//div[@id='root']//input[@name='searchText']");
        private By resultItems = By.xpath("//div[@id='root']//form[contains(@class,'_searchWrap')]//a[contains(@href,'')]");


    public String getServicesHeaderText() {
        return find(servicesHeaderText).getText();
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(resultItems);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='root']//input[@name='searchText']")));

    public void enterSearchText(String text) {
        WebElement input = driver.findElement(searchInput);
        input.click(); // Fokuslanmaq üçün klikləyin
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER); // "Enter" düyməsini simulyasiya edin
        waitForVisibility(driver, resultItems, 10); // Nəticələrin görünməsini gözləyin
    }
//    public void setSearchText(String text) {
//        find(searchInput).sendKeys(text + Keys.ENTER);
//    }

}
