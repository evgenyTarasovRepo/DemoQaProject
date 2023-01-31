package com.tarasov.demoqaproject.tests;

import com.tarasov.demoqaproject.testdata.TestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LaunchPage extends TestBase {
    TestData testData = new TestData();

    @Test
    @Tag("JenkinsTest")
    @Feature("Check modal")
    @Story("Fill form and verify results")
    @Owner("eatarasov")
    @DisplayName("Check form test")
    public void checkForm() {

        formPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.userGender)
                .setUserNumber(testData.userCellNumber)
                .setDate(testData.dayMonthYear[1], testData.dayMonthYear[2], testData.dayMonthYear[0])
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .setPicture(testData.filePath)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmitBtn()
                .verifyModal();

        formPage.verifyModalResults("Student Name", testData.firstName + " " + testData.lastName)
                .verifyModalResults("Student Email", testData.userEmail)
                .verifyModalResults("Gender", testData.userGender)
                .verifyModalResults("Mobile", testData.userCellNumber)
                .verifyModalResults("Date of Birth", testData.dateOfBirth)
                .verifyModalResults("Subjects", testData.subject)
                .verifyModalResults("Hobbies", testData.hobby)
                .verifyModalResults("Picture", testData.fileName)
                .verifyModalResults("Address", testData.address)
                .verifyModalResults("State and City", testData.state + " " + testData.city);
    }
}
