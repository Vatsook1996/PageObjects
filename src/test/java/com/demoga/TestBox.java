package com.demoga;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBox extends TestBase {
    @Test
    void fullTestBox() {

        String birthDay = "21";


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

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
                text("Rajasthan Jaiselmer")


        );


    }
}

