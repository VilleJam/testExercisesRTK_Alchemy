import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.conditions.CombinedAttribute;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.appium.SelenideAppium.back;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumCondition.attribute;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdviseTests {
    private static AndroidDriver driver;

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(65));


    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = Alchemy.getDriver();
        Thread.sleep(4000);


    }


    @Test
    public void GetMoreAdvises() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
        WebElement play = elements.stream()
                .filter(e -> e.getText().equals("Play"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element not found"));
        play.click();
        Thread.sleep(2000);

        WebElement hints = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)"));
        String hintsBeforeText = hints.findElement(AppiumBy.className("android.widget.TextView")).getText();
        int hintsBefore = Integer.parseInt(hintsBeforeText);

        WebElement add_adv = driver.findElement(By.xpath("//qo0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]"));
        add_adv.click();
        Thread.sleep(2000);



        Thread.sleep(10000);

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Watch\")")).click();

        System.out.println("Ads videos should be closed manually!");
        Thread.sleep(30000);

//        AdvertismentWrap.skipAd();
//
//        boolean adClosed = closeAdIfPresent();
//
//        assertTrue(adClosed, "Реклама не появилась или не закрылась");
//
//        try {
//            // 2. Поиск по content-desc (часто для крестиков)
//            $(AppiumBy.androidUIAutomator("new UiSelector().descriptionMatches(\"(?i)Close|Skip|Interstitial close button\")"))
//                    .click();
//        } catch (Exception e) {
//
//        }
//        try {
//            // 3. Поиск символа "×" (иногда это ImageView)
//            $(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'close') or contains(@text, '✕')]"))
//                    .click();
//        } catch (Exception e) {
//
//        }
//        try {
//            // 1. Поиск по тексту (независимо от регистра)
//            $(AppiumBy.androidUIAutomator("new UiSelector().textMatches(\"(?i)Skip|Close|Пропустить|Закрыть\")"))
//                    .shouldBe(visible, Duration.ofSeconds(10)).click();
//        } catch (Exception e) {
//
//        }
//        try {
//            $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(3)"))
//                    .shouldBe(visible, Duration.ofSeconds(2)).click();
//
//        } catch (Exception e) {
//
//        }
//        try {
//            $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(2)"))
//                    .shouldBe(visible, Duration.ofSeconds(2)).click();
//        } catch (Exception e) {
//
//        }
//        try {
//            $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(1)"))
//                    .shouldBe(visible, Duration.ofSeconds(2)).click();
//        } catch (Exception e) {
//
//        }
//        try {
//            $(AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-skip')"))
//                    .shouldBe(visible, Duration.ofSeconds(2)).click();
//            Thread.sleep(2000);
//            $(AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-close')"))
//                    .shouldBe(visible, Duration.ofSeconds(15)).click();
//        } catch (Exception e) {
//
//        }
//        try {
//            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.ilyin.alchemy:id/inter_text_countdown"), "00"));
//            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('com.ilyin.alchemy:id/bigo_ad_btn_close')")).click();
//            Thread.sleep(1000);
//            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('com.ilyin.alchemy:id/bigo_ad_btn_close')")).click();
//        } catch (Exception e) {
//
//        }
//        finally {
//            System.out.println("restart test");
//        }
//
//        //first small adver
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(3)")).shouldBe(visible, Duration.ofSeconds(32));
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(3)")).click();
//        //second small adver
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(2)")).shouldBe(visible, Duration.ofSeconds(32));
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(2)")).click();
//
//        //final adver screen
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(1)")).shouldBe(visible, Duration.ofSeconds(32));
//        $(AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(1)")).click();
//
//        //skipable adver
//        $(AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-skip')")).shouldBe(visible, Duration.ofSeconds(32));
//        $(AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-close')")).click();
//        back();
//        back();
//        //big adver
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.ilyin.alchemy:id/inter_text_countdown"), "00"));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('com.ilyin.alchemy:id/bigo_ad_btn_close')")).click();
//        Thread.sleep(1000);
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('com.ilyin.alchemy:id/bigo_ad_btn_close')")).click();
//
//        $(AppiumBy.androidUIAutomator("new UiSelector().text('REWARD COLLECTED')"));
//
//        boolean adClosed2 = closeAdIfPresent();
//
//        assertTrue(adClosed2, "Реклама не появилась или не закрылась2");

        WebElement close_content_menu = $(AppiumBy.androidUIAutomator("new UiSelector().description(\"Close navigation menu\")")).shouldBe(clickable, Duration.ofSeconds(30));
        close_content_menu.click();
        Thread.sleep(1500);

        WebElement hints2 = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)"));
        String hintsAfterText = hints2.findElement(AppiumBy.className("android.widget.TextView")).getText();
        int hintsAfter = Integer.parseInt(hintsAfterText);

        assertTrue(hintsAfter > hintsBefore, "Count of hints after ad isn't bigger");
        assertEquals(4, hintsAfter, "Count of hints isn't equal 4" );
    }

//    private boolean closeAdIfPresent() {
//        By[] closeSelectors = {
//                AppiumBy.id("com.google.android.gms:id/cancel"),
//                AppiumBy.xpath("//*[contains(@text, 'Skip') or contains(@text, 'Закрыть') or contains(@text, 'Пропустить')]"),
//                AppiumBy.accessibilityId("Close"),
//                AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Close')]"),
//                AppiumBy.id("close_button"),
//                AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(3)"),
//                AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(2)"),
//                AppiumBy.androidUIAutomator("new UiSelector().className('android.widget.ImageView').instance(1)"),
//                AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-skip')"),
//                AppiumBy.androidUIAutomator("new UiSelector().resourceId('m-playable-close')"),
//                AppiumBy.androidUIAutomator("new UiSelector().resourceId('com.ilyin.alchemy:id/bigo_ad_btn_close')"),
//                AppiumBy.id("com.yandex.mobile.adsdk:id/close_button"),
//                AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Close')]"),
//                AppiumBy.xpath("//android.widget.Button[contains(@text, 'Skip') or contains(@text, 'Пропустить')]"),
//                AppiumBy.id("com.yandex.mobile.adsdk:id/rewarded_close_button"),
//                AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Close') or contains(@content-desc, 'Закрыть')]")
//        };
//
//        // Ждём появления рекламы (до 15 секунд)
//        try {
//            Thread.sleep(3000); // даём время загрузиться
//        } catch (InterruptedException ignored) {}
//
//        for (By selector : closeSelectors) {
//            try {
//                if ($(selector).isDisplayed()) {
//                    $(selector).click();
//                    return true;
//                }
//            } catch (Exception ignored) {}
//        }
//
//        // fallback: кнопка "Назад"
//        try {
//            back();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @AfterAll
//    public static void fin() {
//        driver.quit();
//    }
}