package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ServicesPageTest extends BaseTest {
  @Test

    public void testServicesPageLoad(){
        var servicePage= homePage.goToServicesPage();
        String actualResult = servicePage.getServicesHeaderText();
        String expectedResult = "Xidmətlər";
        assertEquals(actualResult,expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");

    }


    @Test

//    public void testServicePageSearchFilterWorks() {
//        String searchTerm = "herrac";
//        var servicePage = homePage.goToServicesPage();
//        servicePage.enterSearchText(searchTerm);
//        var notResultText = servicePage.getNotResultItemText();
//        List<WebElement> results = servicePage.getSearchResults();
//        assertTrue(results.size() > 0, "Nəticə tapılmadı!");
//
//        if(!notResultText.equals("Axtarışınıza uyğun nəticə tapılmadı")){
//            System.out.println("Nəticə tapılmadı ");
//        }else {
//            for (WebElement result : results) {
//                String elementText = result.getAttribute("textContent").toLowerCase(new Locale("az"));
//                assertTrue(elementText.contains(searchTerm.toLowerCase(new Locale("az"))),
//                        "Nəticə uyğunsuzdur: " + elementText);
//            }
//        }
//
//
//    }
//    @Test
    public void testServicePageSearchFilterWorks() {
        String searchTerm = "herrac";
        var servicePage = homePage.goToServicesPage();
        servicePage.enterSearchText(searchTerm);

        List<WebElement> results = servicePage.getSearchResults();

        if (results.isEmpty()) {
            String notResultText = servicePage.getNotResultItemText();
            assertEquals(notResultText, "Axtarışınıza uyğun nəticə tapılmadı", "Gözlənilən nəticə mesajı tapılmadı.");
        } else {
            for (WebElement result : results) {
                String elementText = result.getAttribute("textContent").toLowerCase(new Locale("az"));
                assertTrue(elementText.contains(searchTerm.toLowerCase(new Locale("az"))),
                        "Nəticə uyğunsuzdur: " + elementText);
            }
        }
    }


}
