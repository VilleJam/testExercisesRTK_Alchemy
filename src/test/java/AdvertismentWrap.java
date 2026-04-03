//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import java.time.Duration;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Condition.*;
//
//public class AdvertismentWrap {
//
//    // Common close/skip selectors
//    private static final By[] SELECTORS = {
//            // Standard Android close buttons
//            AppiumBy.id("com.google.android.gms:id/cancel"),
//            AppiumBy.id("com.android.chrome:id/close_button"),
//            AppiumBy.id("close_button"),
//            AppiumBy.id("iv_close"),
//            AppiumBy.id("btn_close"),
//
//            // X button variants
//            AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Close')]"),
//            AppiumBy.xpath("//android.widget.ImageButton[contains(@content-desc, 'Close')]"),
//            AppiumBy.xpath("//android.widget.Button[contains(@text, '✕') or contains(@text, 'X')]"),
//
//            // Skip buttons
//            AppiumBy.xpath("//android.widget.Button[contains(@text, 'Skip')]"),
//            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Skip')]"),
//            AppiumBy.id("skip_button"),
//            AppiumBy.accessibilityId("Skip ad"),
//
//            // After video complete
//            AppiumBy.xpath("//android.widget.Button[contains(@text, 'Close')]"),
//            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'CLOSE')]"),
//            AppiumBy.id("closeButton"),
//
//            // Back arrow
//            AppiumBy.xpath("//android.widget.ImageButton[contains(@content-desc, 'Navigate up')]"),
//            AppiumBy.accessibilityId("Back")
//    };
//
//    public static void skipAd() {
//        for (By selector : SELECTORS) {
//            try {
//                $(selector).shouldBe(visible, Duration.ofSeconds(30)).click();
//                System.out.println("Ad closed!");
//                return;
//            } catch (Exception ignored) {}
//        }
//        // Fallback to back button
//        back();
//    }
//}