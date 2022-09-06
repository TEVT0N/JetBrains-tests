package com.JetBrains.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UI tests")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page console log should not have errors")
    void noErrorsInLog() {
        homePage.openPage()
                .checkNoErrorsInLog();
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        homePage.openPage()
                .checkHeader();
    }


    @Test
    @DisplayName("Verify change language is working")
    void verifyChangeLanguage() {
        homePage.openPage()
                .clickLanguageButton()
                .chooseRussianLanguage()
                .verifyLanguageIsChanged();
    }
}