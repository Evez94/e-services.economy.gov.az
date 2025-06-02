package com.e_services_economy.pages.NavbarComponents;

import com.base.BasePage;
import org.openqa.selenium.By;

public class QuestionsPage extends BasePage {
    private By questionsHeaderText = By.xpath("//div[@id='root']//h2[text()='Suallar']");

    public String getQuestionsHeaderText(){
        return find(questionsHeaderText).getText();
    }
}
