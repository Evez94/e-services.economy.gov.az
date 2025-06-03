package com.e_services_economy.pages.NavbarComponents;

import org.openqa.selenium.By;

public class AboutAgenciesPage extends AgenciesPage{
    private By agencyTitle = By.xpath("/div[@id='root']//div[contains(@class, 'text-xl font-[500]')]");

    public String getAgencyTitleText(){
        return find(agencyTitle).getText();
    }
}
