package com.JetBrains.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${config}.properties")
public interface DriverConfig extends Config {
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserVersion();
    @DefaultValue("https://www.jetbrains.com")
    String baseUrl();
    String selenoidUrl();

}