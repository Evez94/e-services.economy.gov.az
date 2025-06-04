//package Utitlities;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//
//public class JavaScriptUtility extends Utility{
//    public static void scrollToElementJS(By locator){
//        WebElement element = driver.findElement(locator);
//        String jsScript = "arguments[0].scrollIntoView();";
//        ((JavascriptExecutor)driver).executeScript(jsScript,element);
//    }
//    public static void clickJS(By locator){
//        WebElement element = driver.findElement(locator);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();",element);
//
//    }
//}


package Utitlities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptUtility {
    private static WebDriver driver;

    // Driver-i set etmək üçün metod
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    // Elementə scroll etmək üçün təkmilləşdirilmiş metod
//    public static void scrollToElementJS(By locator) {
//        WebElement element = driver.findElement(locator);
//        String scrollScript = "arguments[0].scrollIntoView({"
//                + "behavior: 'smooth', "
//                + "block: 'center', "
//                + "inline: 'center'"
//                + "});";
//        ((JavascriptExecutor) driver).executeScript(scrollScript, element);
//        wait(300); // Kiçik gözləmə
//    }
//
//    // Təhlükəsiz klik üçün metod
//    public static void safeClick(By locator) {
//        WebElement element = driver.findElement(locator);
//        scrollToElementJS(locator);
//
//        try {
//            // 1. Normal klik
//            element.click();
//        } catch (Exception e1) {
//            try {
//                // 2. Action zənciri ilə klik
//                new Actions(driver)
//                        .moveToElement(element)
//                        .pause(Duration.ofMillis(300))
//                        .click()
//                        .perform();
//            } catch (Exception e2) {
//                // 3. JavaScript ilə klik
//                clickWithJS(element);
//            }
//        }
//    }
    public static void scrollToElementJS(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            String scrollScript = "arguments[0].scrollIntoView({"
                    + "behavior: 'smooth', "
                    + "block: 'center', "
                    + "inline: 'center'"
                    + "});";
            ((JavascriptExecutor) driver).executeScript(scrollScript, element);
            wait(300);
        } catch (Exception e) {
            throw new RuntimeException("Element scroll edilərkən xəta baş verdi: " + locator, e);
        }
    }

    public static void safeClick(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            // Elementin görünənə qədər scroll et
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                    element
            );

            // 3 cür klik cəhdi
            try {
                element.click();
            } catch (Exception e1) {
                try {
                    new Actions(driver)
                            .moveToElement(element)
                            .pause(Duration.ofMillis(500))
                            .click()
                            .perform();
                } catch (Exception e2) {
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].click();",
                            element
                    );
                }
            }

            // Kiçik gözləmə əlavə et
            Thread.sleep(300);
        } catch (Exception e) {
            throw new RuntimeException("Element klik edilərkən xəta: " + locator, e);
        }
    }
    // JavaScript ilə klik üçün metod
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Səhifənin yüklənməsini gözləmək üçün metod
    public static void waitForPageLoad(int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete"));
    }

    // Elementin görünüb-görünmədiyini yoxlamaq
    public static boolean isElementVisible(By locator) {
        String script =
                "var elem = arguments[0];"
                        + "var rect = elem.getBoundingClientRect();"
                        + "return ("
                        + "rect.top >= 0 && "
                        + "rect.left >= 0 && "
                        + "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && "
                        + "rect.right <= (window.innerWidth || document.documentElement.clientWidth)"
                        + ");";

        WebElement element = driver.findElement(locator);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(script, element);
    }

    // Kiçik gözləmə üçün köməkçi metod
    private static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}