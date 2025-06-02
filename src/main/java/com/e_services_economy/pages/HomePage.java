package com.e_services_economy.pages;

import com.base.BasePage;
import com.e_services_economy.pages.NavbarComponents.*;
import org.openqa.selenium.By;

import static Utitlities.GetUtility.getText;
import static Utitlities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {
    private By servicesMenuItem = By.xpath("//div[@id='root']//a[text()='Xidmətlər']");
    private By agenciesMenuItem = By.xpath("//div[@id='root']//a[text()='Qurumlar']");
    private By questionsMenuItem = By.xpath("//div[@id='root']//a[text()='Suallar']");
    private By documentsAdnFeesMenuItem = By.xpath("//div[@id='root']//a[text()='Sənədlər və rüsumlar']");


    public  ServicesPage goToServicesPage(){
        scrollToElementJS(servicesMenuItem);
        click(servicesMenuItem);
        return new ServicesPage();
    }
    public  AgenciesPage goToAgenciesPage(){
        scrollToElementJS(agenciesMenuItem);
        click(agenciesMenuItem);
        return new AgenciesPage();
    }

    public  QuestionsPage goToQuestionsPage(){
        scrollToElementJS(questionsMenuItem);
        click(questionsMenuItem);
        return new QuestionsPage();
    }

    public DocumentsAndFeesPage goToDocumentsAndFeesPage(){
        scrollToElementJS(documentsAdnFeesMenuItem);
        click(documentsAdnFeesMenuItem);
        return new DocumentsAndFeesPage();
    }
}
