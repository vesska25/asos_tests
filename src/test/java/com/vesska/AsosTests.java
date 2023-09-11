package com.vesska;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AsosTests extends TestBase {


    @Test
    @Tag("prod")
    @Owner("s.savich")
    @DisplayName("Switch website language to German")
    void switchLanguageToGermanTest() {

        step("Open asos.com", () -> {
            open("https://www.asos.com/");
            //for accepting cookies
            $("#onetrust-accept-btn-handler").click();
        });
        step("Click on Preferences button" , () -> {
            $("[data-testid=country-selector-btn]").click();
        });
        step("Choose German language and save changes", () -> {
            $("#country").selectOption("Germany");
            $("[data-testid=save-country-button]").click();
        });
        step("Check that Welcome text switched to German", () -> {
            $(".highlight").shouldHave(text("Willkommen bei ASOS"));
        });

    }

    @Test
    @Tag("prod")
    @Owner("s.savich")
    @DisplayName("Add new item to Saved Items")
    void addNewSavedItemTest() {

        step("Open asos.com", () -> {
            open("https://www.asos.com/");
            //for accepting cookies
            $("#onetrust-accept-btn-handler").click();
        });
        step("Type product name in search field and press enter", () ->{
            $("#chrome-search").setValue("Tommy Hilfiger backpack").pressEnter();
        });
        step("Find a product and press 'Save for later' button", () -> {
            $("#product-204068317").$(".saveForLater_mm1gc").click();
        });
        step("Go to Saved items page", () -> {
            $("[data-testid=savedItemsIcon]").click();
        });
        step("Check that the item is added on the page", () -> {
            $(".productTilesWrapper_LkXSW").shouldHave(text("Tommy Hilfiger horizon backpack in black"));
        });

    }

    @Test
    @Tag("prod")
    @Owner("s.savich")
    @DisplayName("Check that Returns & Refunds page has all Topics in FAQ section")
    void checkReturnsAndRefundsFAQTopicsTest() {

        step("Open asos.com", () -> {
            open("https://www.asos.com/");
            //for accepting cookies
            $("#onetrust-accept-btn-handler").click();
        });
        step("Go to 'Returns & Refunds' page", () -> {
            $("[data-testid=myAccountIcon]").click();
            $("[data-testid=returnsinformation-link]").click();
        });
        step("Check that 'FAQ TOPICS' has all the topics", () -> {
            $$("[class=HelpTopics_topicList]").shouldHave(CollectionCondition.texts("Delivery " +
                    "Returns & Refunds " + "Order issues " + "Product & Stock " + "Payment, Promos & Gift Vouchers " +
                    "Technical"));
        });

    }

    @Test
    @Tag("prod")
    @Owner("s.savich")
    @DisplayName("Check that Fit Assistant recommends the proper size")
    void checkFitAssistantSizeTest() {

        step("Open the product page", () -> {
            open("/asos-design/asos-design-pleated-skirt-in-brown/prd/202923922");
            //for accepting cookies
            $("#onetrust-accept-btn-handler").click();
        });
        step("Click on Fit Assistant button", () -> {
            sleep(5000);
            $("[data-testid=fitAssistantLink]").click();
        });
        step("Switch Height to cm and set a value", () -> {
            $("[role=radiogroup]").click();
            $("#uclw_form_height").setValue("180");
        });
        step("Switch Weight to kg, set a value", () -> {
            $("[aria-labelledby=uclw_aria_label_weight]").click();
            $("#uclw_form_weight").setValue("60");
            $("#uclw_save_info_button").click();
        });
        step("Choose flatter tummy shape", () -> {
            $("#uclw_item_buttons_1").click();
            $("#uclw_save_info_button").click();
        });
        step("Set the age and press 'Continue'", () -> {
            $("[data-ref=input]").setValue("27");
            $("#uclw_save_info_button").click();
        });
        step("Choose fit preference 'on the tight side'", () -> {
            $(byText("« Tighter")).click();
            $("#uclw_save_info_button").click();
        });
        step("Choose 'Ralph Lauren' brand", () -> {
            $("[class=id_ralph-lauren]").click();
        });
        step("Choose the Trousers type 'Chinos'", () -> {
            $(byText("Select")).click();
            $(".uclw_items").find(byText("Chinos")).click();
        });
        step("Choose size 'S'", () -> {
            $(byText("S")).click();
        });
        step("Choose Tighter fit", () -> {
            $(byText("Tighter")).click();
            $("#uclw_save_info_button").click();
        });
        step("Check that Fit Assistant recommends size W30", () -> {
            $$("[class=uclw_subheadline]").shouldHave(itemWithText("Your Fit Assistant recommended size, W30, is out of stock"));
        });
    }

    @Test
    @Tag("prod")
    @Owner("s.savich")
    @DisplayName("Check that Women's products has all sections on menu bar")
    void checkWomensCategoriesTest() {

        step("Open asos.com", () -> {
            open("https://www.asos.com/");
            //for accepting cookies
            $("#onetrust-accept-btn-handler").click();
        });
        step("Click on Women's products", () -> {
            $("[data-testid=women-floor]").click();
        });
        step("Check that Women's products has all sections", () -> {
            $("[data-testid=primarynav-large]").shouldHave(text("Sale " + "New in " +"Clothing "
                    + "Dresses " + "Shoes " + "Accessories " + "Face + Body " + "Topshop " + "Sportswear "
                    + "Late Summer " + "Denim " +  "Brands " + "Marketplace"));
        });
    }
}
