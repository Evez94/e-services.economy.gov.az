package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AgenciesPageTest extends BaseTest {
    @Test

    public void testAgenciesPageLoad(){
        var agenciesPage = homePage.goToAgenciesPage();
        String actualResult = agenciesPage.getAgenciesHeaderText();
        String expectedResult ="Qurumlar";
        Assert.assertEquals(actualResult,expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");
    }

}
