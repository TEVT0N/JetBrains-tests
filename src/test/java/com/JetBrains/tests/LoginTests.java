package com.JetBrains.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
    @Test
    @DisplayName("Log in with valid credentials")
    void validLogin() {
        homePage.openPage()
                .openAccountPage();
        loginPage.enterUsername(login)
                .enterPassword(password)
                .clickSignIn()
                .verifyLogInIsSuccessful(loginJson);
    }
}
