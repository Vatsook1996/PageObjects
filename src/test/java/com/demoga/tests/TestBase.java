package com.demoga.tests;

import com.codeborne.selenide.Configuration;
import com.demoga.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
public class TestBase {


    @BeforeAll
    static void beforeALL() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
}
}
