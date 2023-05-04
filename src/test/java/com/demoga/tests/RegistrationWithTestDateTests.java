package com.demoga.tests;

import com.demoga.pages.RegistrationPage;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;

import static com.demoga.tests.TestData.*;
import static com.demoga.utils.RandomUtils.getRandomCity;
import static com.demoga.utils.RandomUtils.getRandomInt;
import static com.demoqa.utils.RandomUtils.*;
public class RegistrationWithTestDateTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(TestData.gender),
            userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
            monthOfBirth = faker.options().option(months),
            yearOfBirth = String.valueOf(getRandomInt(1956, 2004)),
            subject = faker.options().option(subjects),
            hobbies = faker.options().option(hobbiess),
            currentAddress = faker.address().streetAddress(),
            randomState = faker.options().option(states),
            randomCity = getRandomCity(randomState);

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
