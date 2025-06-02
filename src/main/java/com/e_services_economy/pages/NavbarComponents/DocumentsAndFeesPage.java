package com.e_services_economy.pages.NavbarComponents;

import com.base.BasePage;
import org.openqa.selenium.By;

public class DocumentsAndFeesPage extends BasePage {
    private By documentsAdnFeesHeaderText = By.xpath("//div[@id='root']//h2[text()='Sənədlər və rüsumlar']");

    public String getDocumentsAndFeesHeaderText(){
        return find(documentsAdnFeesHeaderText).getText();
    }
}
