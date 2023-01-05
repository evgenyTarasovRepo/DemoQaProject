package com.tarasov.demoqaproject.tests;

import com.codeborne.selenide.Configuration;
import com.tarasov.demoqaproject.pages.FormPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class LaunchPage {

    FormPage formPage = new FormPage();
    public static final String BASE_URL = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1020";
        Configuration.headless = false;
    }

    @BeforeEach
    public void setUp() {

        open(BASE_URL);
    }

    @AfterEach
    public void turnDown() {
        closeWebDriver();
    }

    @Test
    public void checkForm() {
        formPage
                .checkPage()
                .formValidation();
    }


}
