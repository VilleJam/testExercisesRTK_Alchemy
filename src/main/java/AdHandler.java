//import com.codeborne.selenide.appium.SelenideAppium;
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.sleep;
//
//public class AdHandler {
//
//    private final WebDriverWait wait;
//    private final int videoTimeoutSeconds;
//
//    // Common selectors for ad elements across different networks
//    private static final List<By> CLOSE_BUTTON_SELECTORS = Arrays.asList(
//            AppiumBy.id("com.google.android.gms:id/cancel"),      // AdMob close button
//            AppiumBy.id("com.unity3d.ads.android.view.CloseButton"), // Unity Ads
//            AppiumBy.xpath("//android.widget.Button[@text='Close']"),
//            AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Close')]"),
//            AppiumBy.accessibilityId("Close ad"),
//            AppiumBy.id("close_button")
//    );
//
//    private static final List<By> REWARD_SELECTORS = Arrays.asList(
//            AppiumBy.xpath("//*[contains(@text, 'Reward') or contains(@text, 'reward')]"),
//            AppiumBy.id("reward_button"),
//            AppiumBy.xpath("//android.widget.Button[contains(@text, 'Claim')]")
//    );
//
//    private static final List<String> VIDEO_CLASSES = Arrays.asList(
//            "android.widget.VideoView",
//            "android.webkit.WebView",
//            "com.google.android.gms.ads.internal.formats.NativeAppInstallAdView"
//    );
//
//    public AdHandler(int videoTimeoutSeconds) {
//        this.videoTimeoutSeconds = videoTimeoutSeconds;
//        this.wait = new WebDriverWait(SelenideAppium.getDriver(), Duration.ofSeconds(30));
//    }
//
//    /**
//     * Main method to handle rewarded ad and claim reward
//     * @return true if reward was successfully claimed
//     */
//    public boolean handleRewardedAd() {
//        try {
//            if (isAdPresent()) {
//                System.out.println("Ad detected - processing for reward");
//
//                // Wait for and watch the video
//                if (waitForVideoAndWatch()) {
//                    // Close the ad after video completes
//                    closeAdAfterVideo();
//                    // Claim the reward
//                    return claimReward();
//                }
//            }
//            return false;
//        } catch (Exception e) {
//            System.err.println("Error handling rewarded ad: " + e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * Check if any ad is currently displayed
//     */
//    private boolean isAdPresent() {
//        try {
//            // Check for video elements
//            for (String videoClass : VIDEO_CLASSES) {
//                if ($(AppiumBy.className(videoClass)).isDisplayed()) {
//                    return true;
//                }
//            }
//
//            // Check for common ad containers
//            By adContainer = AppiumBy.xpath("//*[contains(@resource-id, 'ad') or contains(@class, 'AdView')]");
//            return $(adContainer).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * Wait for video to complete or skip button to appear
//     */
//    private boolean waitForVideoAndWatch() {
//        System.out.println("Waiting for video ad to complete...");
//
//        long startTime = System.currentTimeMillis();
//        long maxWaitTime = videoTimeoutSeconds * 1000L;
//
//        while ((System.currentTimeMillis() - startTime) < maxWaitTime) {
//            try {
//                // Check for reward claim button (video completed)
//                for (By selector : REWARD_SELECTORS) {
//                    if ($(selector).isDisplayed()) {
//                        System.out.println("Reward available - video completed");
//                        return true;
//                    }
//                }
//
//                // Check for close button with reward (some ads show close after completion)
//                for (By selector : CLOSE_BUTTON_SELECTORS) {
//                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
//                    if (element.isDisplayed() && element.isEnabled()) {
//                        String contentDesc = element.getAttribute("content-desc");
//                        if (contentDesc != null &&
//                                (contentDesc.toLowerCase().contains("close") ||
//                                        contentDesc.toLowerCase().contains("reward"))) {
//                            System.out.println("Close button with reward detected");
//                            return true;
//                        }
//                    }
//                }
//
//                sleep(1000);
//            } catch (Exception e) {
//                // Element not found yet, continue waiting
//            }
//        }
//
//        System.out.println("Video timeout reached");
//        return false;
//    }
//
//    /**
//     * Close the ad after video completes
//     */
//    private void closeAdAfterVideo() {
//        System.out.println("Closing ad after video completion");
//
//        try {
//            // Try all possible close button selectors
//            for (By selector : CLOSE_BUTTON_SELECTORS) {
//                try {
//                    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(selector));
//                    closeButton.click();
//                    System.out.println("Closed ad via: " + selector);
//                    sleep(1000); // Allow time for ad to close
//                    return;
//                } catch (Exception e) {
//                    // Try next selector
//                }
//            }
//
//            // Fallback: press back button
//            SelenideAppium.getDriver().navigate().back();
//            System.out.println("Used back button to close ad");
//            sleep(1000);
//
//        } catch (Exception e) {
//            System.err.println("Failed to close ad: " + e.getMessage());
//        }
//    }