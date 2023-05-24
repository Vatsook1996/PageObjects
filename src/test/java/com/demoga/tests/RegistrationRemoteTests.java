package com.demoga.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends RemoteTestBase {
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void fullTestBox() {

        String birthDay = "21";

        step("Open form", () -> {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        });
        step("Fill form", () -> {
        $("#firstName").setValue("Ivanov");
        $("#lastName").setValue("Ivan");
        $("#userEmail").setValue("Ivan@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__day--0" + birthDay).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/resources/P-75.png"));
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaiselmer")).click();
        $("#submit").click();
        });
        step("Verify results", () -> {
        $(".table").shouldHave(
                text("Ivanov Ivan"),
                text("Ivan@mail.com"),
                text("Male"),
                text("9000000000"),
                text("21 April,1996"),
                text("English"),
                text("Sports"),
                text("P-75.png"),
                text("Moscow"),
                text("Rajasthan Jaiselmer"));
        });
    }

}

