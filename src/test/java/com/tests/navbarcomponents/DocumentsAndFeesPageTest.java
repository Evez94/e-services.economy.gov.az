package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DocumentsAndFeesPageTest extends BaseTest {

    @Test
    public void testDocumentsAndFeesPageLoad(){
        var documentAndFeesPage = homePage.goToDocumentsAndFeesPage();
        String actualResult = documentAndFeesPage.getDocumentsAndFeesHeaderText();
        String expectedResult = "Sənədlər və rüsumlar";
        Assert.assertEquals(actualResult,expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");
    }
}
