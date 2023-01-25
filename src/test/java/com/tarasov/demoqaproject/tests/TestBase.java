package com.tarasov.demoqaproject.tests;

import com.codeborne.selenide.Configuration;
import com.tarasov.demoqaproject.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {
    FormPage formPage = new FormPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1020";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
    }
}
