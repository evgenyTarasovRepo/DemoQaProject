package com.tarasov.demoqaproject.pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.tagName;

public class FormPage {

    private final String firstName = "TestName";
    private final String lastName = "TestLastName";
    private final String userEmail = "testEmail@yahoo.com";
    private final String sex = "Male";
    private final String userNumber = "1999888776";
    private final String birthDate = "14 January,1987";
    private final String subj = "Math";
    private final String file = "File.png";
    private final String hobbies = "Music";
    private final String address = "Alicante, Carrer Rafael Terrol, 11";
    private final String state = "Haryana";
    private final String city = "Panipat";

    public FormPage checkPage() {
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public void formValidation() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(sex)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput")
                .setValue(Keys.chord(Keys.CONTROL + "a" + " "))
                .setValue(birthDate)
                .pressEscape();
        $("#subjectsInput").setValue(subj).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath("images/File.png");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text(sex), text(userNumber),
                text(birthDate), text(subj), text(hobbies),
                text(file), text(address), text(state + " " + city));

        $("#closeLargeModal").click();
    }
}
