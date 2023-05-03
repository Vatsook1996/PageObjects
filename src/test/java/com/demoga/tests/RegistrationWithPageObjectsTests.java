package com.demoga.tests;

import com.demoga.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
public class RegistrationWithPageObjectsTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulPracticeFormTests() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setUserEmail("Ivan@mail.com")
                .setGender("Male")
                .setNumber("9000000000")
                .setBerthDate("02", "April", "1996")
                .setSubjects("English")
                .setHobbies("Sports")
                .setPicture("P-75.png")
                .setAddress("Moscow")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .clickSubmit();

        registrationPage.verifyResult("Student Name", "Ivan Petrov")
                .verifyResult("Student Email", "Ivan@mail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9000000000")
                .verifyResult("Date of Birth", "02 April,1996")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "P-75.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Rajasthan Jaiselmer");
 }
}
