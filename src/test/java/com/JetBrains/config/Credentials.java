package com.JetBrains.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/Credentials.properties")
public interface Credentials extends Config {
    String login();
    String password();
    String loginJson();
}
