package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class ServicesPageTest extends BaseTest {
//    @Test

    public void testServicesPageLoad(){
        var servicePage= homePage.goToServicesPage();
        String actualResult = servicePage.getServicesHeaderText();
        String expectedResult = "Xidmətlər";
        Assert.assertEquals(actualResult,expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");

    }


    @Test
    public void testSearchFilterWorks() {
        String searchTerm = "vergi";
        var servicePage = homePage.goToServicesPage();
        servicePage.enterSearchText(searchTerm);
        List<WebElement> results = servicePage.getSearchResults();
        assertTrue(results.size() > 0, "Nəticə tapılmadı!");

        for (WebElement result : results) {
            assertTrue(result.getText().toLowerCase().contains(searchTerm),
                    "Nəticə uyğunsuzdur: " + result.getText());
        }
    }

//    public void testSearchFilterWorks(){
//        String searchTerm = "vergi";
//        var servicePage = homePage.goToServicesPage();
//        servicePage.setSearchText(searchTerm);
//        List<WebElement> results = servicePage.getSearchResults();
//        assertTrue(results.size() > 0, "Nəticə tapılmadı!");
//
//        for (WebElement result : results) {
//            assertTrue(result.getText().toLowerCase().contains(searchTerm),
//                    "Nəticə uyğunsuzdur: " + result.getText());
//        }
//    }
}
