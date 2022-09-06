package com.JetBrains.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {
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
}
