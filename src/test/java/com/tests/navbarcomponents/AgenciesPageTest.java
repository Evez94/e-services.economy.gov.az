package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AgenciesPageTest extends BaseTest {
    // Test Agencies Page Loading
    @Test
    public void testAgenciesPageLoad() {
        var agenciesPage = homePage.goToAgenciesPage();
        String actualResult = agenciesPage.getAgenciesHeaderText();
        String expectedResult = "Qurumlar";
        assertEquals(actualResult, expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");
    }

    // Test Agencies Page Search Filter with availabe Item
    @Test
    public void testAgenciesPageSearchFilterAvailableItemWorks() {
        String searchTerm = "ver";
        var agenciesPage = homePage.goToAgenciesPage();
        agenciesPage.enterSearchText(searchTerm);
        List<WebElement> results = agenciesPage.getSearchResults();
        assertTrue(results.size() > 0, "Nəticə tapılmadı!");

        for (WebElement result : results) {
            String elementText = result.getAttribute("textContent").toLowerCase(new Locale("az"));
            assertTrue(elementText.contains(searchTerm.toLowerCase(new Locale("az"))),
                    "Nəticə uyğunsuzdur: " + elementText);
        }
    }

    // Test Agencies Page Search Filter with unavailabe Item
    @Test
    public void testAgenciesPageSearchFilterUnAvailableItemWorks() {
        String searchTerm = "herrac";
        var agenciesPage = homePage.goToAgenciesPage();
        agenciesPage.enterSearchBadText(searchTerm);
        List<WebElement> results = agenciesPage.getSearchResults();
        Assert.assertEquals(results.size(), 0, "Axtarış nəticəsi tapılmadıqda nəticələrin sayı 0 olmalıdır.");
    }

    // Test Agencies Page clicking About Agency and load right page and items
    @Test
    public void testAboudAgenciesLoadRight(){
        var aboutAgenciesPage = homePage.goToAgenciesPage().goToAboutAgenciesPage();
        var agenciesPage = homePage.goToAgenciesPage();
            String actualResult = aboutAgenciesPage.getAgencyTitleText();
            String expectedResult = agenciesPage.getAgencyTitleText();
            Assert.assertEquals(actualResult,expectedResult,
                    "\n Actual Result & Ecpected Result Do not Match \n");
    }

}
