package com.tests.navbarcomponents;

import com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuestionsPageTest extends BaseTest {
    @Test

    public void testQuestionsPageLoad(){
        var questionsPage= homePage.goToQuestionsPage();
        String actualResult = questionsPage.getQuestionsHeaderText();
        String expectedResult = "Suallar";
        Assert.assertEquals(actualResult,expectedResult,
                "\n Actual Text & Expected Text Do Not Match \n");

    }
}
