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
    private By resultItems = By.xpath("//div[@id='root']//h6[@class='_name_1pbzy_73']");
    private By notResultItems = By.xpath("//div[@id='root']//p[text()='Axtarışınıza uyğun nəticə tapılmadı']");


    public String getNotResultItemText(){
        return find(notResultItems).getText();
    }

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
    input.click();
    input.clear();
    input.sendKeys(text);
    input.sendKeys(Keys.ENTER);

    // Nəticələrin və ya "nəticə tapılmadı" mesajının görünməsini gözləyin
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.or(
            ExpectedConditions.presenceOfElementLocated(resultItems),
            ExpectedConditions.presenceOfElementLocated(notResultItems)
    ));
}


}
