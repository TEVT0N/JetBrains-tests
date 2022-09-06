package com.JetBrains.pages;

import com.JetBrains.config.DriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.assertj.core.api.Assertions.assertThat;

// page_url = https://www.jetbrains.com/
public class HomePage {
    @Step("Open home page")
    public HomePage openPage() {
        open("");
        return this;
    }

    @Step("Page title should have header text")
    public HomePage checkHeader() {
        String expectedTitle = "JetBrains: Essential tools for software developers and teams";
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(expectedTitle);
        return this;
    }

    @Step("Console logs should not contain text 'SEVERE'")
    public HomePage checkNoErrorsInLog() {
        String consoleLogs = DriverUtils.getConsoleLogs();
        String errorText = "SEVERE";
        assertThat(consoleLogs).doesNotContain(errorText);
        return this;
    }

    @Step("Open account page")
    public HomePage openAccountPage() {
        $("[aria-label='Navigate to profile']").click();
        return this;
    }

    @Step("Open search")
    public HomePage openSearch() {
        $("[aria-label='Open search']").click();
        return this;
    }

    @Step("Open advanced search")
    public HomePage openAdvancedSearch() {
        $("[aria-label='Open search']").sendKeys(Keys.chord(Keys.CONTROL, "k"));
        return this;
    }

    @Step("Verify advanced search is opened")
    public HomePage verifyAdvancedSearchIsOpened() {
        webdriver().shouldHave(url(baseUrl + "/?s=full"));
        $(byText("Plugin Marketplace")).shouldBe(visible);
        return this;
    }

    @Step("Type a query")
    public HomePage typeAQuery(String value) {
        actions().sendKeys(value).perform();
        return this;
    }

    @Step("Verify search is working")
    public HomePage verifySearch() {
        $(".quick-search__item").should(appear);
        return this;
    }

    @Step("Verify advanced search is working")
    public HomePage verifyAdvancedSearch() {
        $(".full-search__placeholder").shouldNotHave(text("We couldn’t find results"));
        return this;
    }

    @Step("Click plugin marketplace")
    public HomePage clickPluginMarketplace() {
        $(byText("Plugin Marketplace")).click();
        return this;
    }

    @Step("Click on language button")
    public HomePage clickLanguageButton() {
        $("[aria-label='Open language selection']").click();
        $(byText("Русский")).click();
        return this;
    }

    @Step("Choose russian language")
    public HomePage chooseRussianLanguage() {
        $(byText("Русский")).click();
        return this;
    }

    @Step("Verify the language is changed")
    public HomePage verifyLanguageIsChanged() {
        webdriver().shouldHave(url("https://www.jetbrains.com/ru-ru/"));
        $(byText("Русский")).shouldBe(visible);
        return this;
    }
}
