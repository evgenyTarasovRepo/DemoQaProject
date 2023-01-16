package com.tarasov.demoqaproject.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LaunchPage extends TestBase {

    @AfterEach
    public void turnDown() {
        closeWebDriver();
    }

    @Test
    public void checkForm() {
        String firstName = "TestName";
        String lastName = "TestLastName";
        String userEmail = "testEmail@yahoo.com";
        String gender = "Male";
        String userNumber = "1999888776";
        String birthDate = "14 January,1987";
        String subject = "Math";
        String hobby = "Sports";
        String filePath = "images/File.png";
        String fileName = "File.png";
        String address = "Alicante, Carrer Rafael Terrol, 11";
        String state = "Haryana";
        String city = "Panipat";

//        Map<String, String> data = Map.of(
//                firstName, lastName, userEmail, gender, userNumber,
//                month, subject, hobby, filePath, address,
//                state, city
//        );

        formPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(gender)
                .setUserNumber(userNumber)
                .setDate("January", "1987", "14")
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmitBtn()
                .verifyModal();

        formPage.verifyModalResults("Student Name", firstName + " " + lastName)
                .verifyModalResults("Student Email", userEmail)
                .verifyModalResults("Gender", gender)
                .verifyModalResults("Mobile", userNumber)
                .verifyModalResults("Date of Birth", birthDate)
                .verifyModalResults("Subjects", subject)
                .verifyModalResults("Hobbies", hobby)
                .verifyModalResults("Picture", fileName)
                .verifyModalResults("Address", address)
                .verifyModalResults("State and City", state + " " + city)
                .closeModal();
    }
}
