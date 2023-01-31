package com.tarasov.demoqaproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.tarasov.demoqaproject.pages.components.CalendarComponent;
import com.tarasov.demoqaproject.pages.components.ModalComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalComponent modalComponent = new ModalComponent();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userGender = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbyPicker = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement userState = $("#state");
    private final SelenideElement userCity = $("#city");
    private final SelenideElement submitBtn = $("#submit");


    @Step("Open form page")
    public FormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set first name {firstName}")
    public FormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Set lastname {lastName}")
    public FormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Set user email {userEmail}")
    public FormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Set user gender {value}")
    public FormPage setUserGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    @Step("Set user number {number}")
    public FormPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    @Step("Set date")
    public FormPage setDate(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    @Step("Set subject {subject}")
    public FormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Set hobby {hobby}")
    public FormPage setHobby(String hobby) {
        hobbyPicker.$(byText(hobby)).click();
        return this;
    }

    @Step("Set picture")
    public FormPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    @Step("Set address {address}")
    public FormPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    @Step("Set state {state}")
    public FormPage setState(String state) {
        userState.click();
        userState.$(byText(state)).click();
        return this;
    }

    @Step("Set city {city}")
    public FormPage setCity(String city) {
        userCity.click();
        userCity.$(byText(city)).click();
        return this;
    }

    @Step("Press submit")
    public FormPage pressSubmitBtn() {
        submitBtn.click();
        return this;
    }

    @Step("Verify modal")
    public FormPage verifyModal() {
        modalComponent.verifyModal();
        return this;
    }

    @Step("Verify modal results")
    public FormPage verifyModalResults(String key, String value) {
        modalComponent.verifyModalResults(key, value);
        return this;
    }

    @Step("Close modal")
    public FormPage closeModal() {
        modalComponent.closeModal();
        return this;
    }

    public void formValidation() {
        $("#closeLargeModal").click();
    }
}
