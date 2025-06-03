//package Utitlities;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class WaitUtility extends Utility{
//    public static void explicitWaitUntilVisible(int seconds, By locator){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//    public static void waitForVisibility(WebDriver driver, By locator, int seconds) {
//        new WebDriverWait(driver, Duration.ofSeconds(seconds))
//                .until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public static void waitForInVisibility(WebDriver driver, By locator, int seconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//    }
//
//
//
//    public static void waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//
//
//    }
//
//
//
//}


/// ////////////////////////////////////////////
package Utitlities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    // Daha çox istifadə edilən metodları üstə qoyun
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForInvisibility(WebDriver driver, By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageLoad(WebDriver driver, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete"));
    }

    // JavaScript ilə scroll etmə üçün köməkçi metod
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                element
        );
    }
}
