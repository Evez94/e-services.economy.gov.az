package com.e_services_economy.pages.NavbarComponents;

import Utitlities.JavaScriptUtility;
import com.e_services_economy.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private By aboutAgenciesLink = By.xpath("(//div[@id='root']//div[@class='_corps_5ekyk_35']//div[@class='_corp_5ekyk_35']//a)[1]");
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

//    public  AboutAgenciesPage goToAboutAgenciesPage(){
//        // JavaScriptUtility istifadəsi
//        JavaScriptUtility.setDriver(driver);
//        JavaScriptUtility.scrollToElementJS(aboutAgenciesLink);
//        JavaScriptUtility.safeClick(aboutAgenciesLink);
//        JavaScriptUtility.waitForPageLoad(10);
//
//        return new AboutAgenciesPage();
//
//


    public AboutAgenciesPage goToAboutAgenciesPage() {
        try {
            // 1. Elementin görünənə qədər gözlə
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(aboutAgenciesLink));

            // 2. JavaScript ilə scroll et və klik et
            JavaScriptUtility.scrollToElementJS(aboutAgenciesLink);
            JavaScriptUtility.safeClick(aboutAgenciesLink);

            // 3. Yeni kontentin yüklənməsini gözlə
            waitForPageContentLoad();

            // 4. URL dəyişikliyini yoxla (əgər varsa)
            if (!isUrlChanged()) {
                throw new RuntimeException("Səhifə keçidi baş vermədi");
            }

            return new AboutAgenciesPage();
        } catch (Exception e) {
//            takeScreensho("goToAboutAgenciesPage_error");
            throw new RuntimeException("'Qurum məlumatları' səhifəsinə keçid edilərkən xəta: " + e.getMessage());
        }
    }

    private void waitForPageContentLoad() {
        try {
            // Xüsusi elementin görünməsini gözlə
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(@class, 'text-xl font-[500]')]")));

            // Və ya JavaScript ilə səhifə hazırlığını yoxla
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(d -> ((JavascriptExecutor) d)
                            .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
//            takeScreenshot("waitForPageContentLoad_error");
            throw e;
        }
    }

    private boolean isUrlChanged() {
        // Əvvəlki URL-i saxla
        String currentUrl = driver.getCurrentUrl();

        // Kiçik gözləmə
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        // URL dəyişibsə true qaytar
        return !currentUrl.equals(driver.getCurrentUrl());
    }

    public String getAgencyTitleText(){
        return find(aboutAgenciesTitle).getText();
    }
}
