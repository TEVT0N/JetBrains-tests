package com.JetBrains.tests;

import com.JetBrains.config.Credentials;
import com.JetBrains.config.DriverConfig;
import com.JetBrains.config.DriverUtils;
import com.JetBrains.pages.HomePage;
import com.JetBrains.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Credentials credentials = ConfigFactory.create(Credentials.class);
    String login = credentials.login(),
            password = credentials.password(),
            loginJson = credentials.loginJson(),
            searchQuery = "csv";

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
        Configuration.browser = driverConfig.browser();
        Configuration.browserVersion =  driverConfig.browserVersion();
        Configuration.browserSize =  driverConfig.browserSize();
        Configuration.baseUrl =  driverConfig.baseUrl();
        Configuration.remote = driverConfig.selenoidUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        DriverUtils.screenshotAs("Last screenshot");
        DriverUtils.pageSource();
        DriverUtils.addBrowserConsoleLogs();
        DriverUtils.addVideo();
        closeWebDriver();
    }

}
