package com.JetBrains.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UI tests")
public class UITests extends TestBase {

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
    @DisplayName("Login with valid data")
    void validLogin() {
        homePage.openPage()
        .openAccountPage();
        loginPage.enterUsername(login)
                .enterPassword(password)
                .clickSignIn()
                .verifyLogInIsSuccessful(loginJson);
    }

    @Test
    @DisplayName("Verify search is working")
    void verifySearchIsWorking() {
        homePage.openPage()
                .openSearch()
                .typeAQuery(searchQuery)
                .verifySearch();
    }

    @Test
    @DisplayName("Verify advanced search is opening")
    void verifyAdvancedSearch() {
        homePage.openPage()
                .openAdvancedSearch()
                .verifyAdvancedSearchIsOpened();
    }

    @Test
    @DisplayName("Verify search in plugin marketplace is working")
    void verifyPluginSearchIsWorking() {
        homePage.openPage()
                .openAdvancedSearch()
                .verifyAdvancedSearchIsOpened()
                .typeAQuery(searchQuery)
                .clickPluginMarketplace()
                .verifyAdvancedSearch();
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