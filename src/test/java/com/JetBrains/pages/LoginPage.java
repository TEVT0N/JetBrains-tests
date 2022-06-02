package com.JetBrains.pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

// page_url = https://account.jetbrains.com/login
public class LoginPage {

    @Step("Open registration page")
    public LoginPage openPage() {
        open("https://account.jetbrains.com/login");
        return this;
    }

    @Step("Enter username")
    public LoginPage enterUsername(String value) {
        $("#username").setValue(value);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String value) {
        $("[name='password']").setValue(value);
        return this;
    }

    @Step("Click Sign in")
    public LoginPage clickSignIn() {
        $(".js-auth-dialog-btn-signin").click();
        return this;
    }

    @Step("Verify log in is successful")
    public LoginPage verifyLogInIsSuccessful(String value) {
        webdriver().shouldHave(url("https://account.jetbrains.com/licenses?" + value));
        return this;
    }


}
