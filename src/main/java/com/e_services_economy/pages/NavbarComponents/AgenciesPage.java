package com.e_services_economy.pages.NavbarComponents;

import com.e_services_economy.pages.HomePage;
import org.openqa.selenium.By;

public class AgenciesPage extends HomePage {
    private By agenciesHeaderText = By.xpath("//div[@id='root']//h2[text()='Qurumlar']");

    public String getAgenciesHeaderText(){
        return find(agenciesHeaderText).getText();
    }
}
