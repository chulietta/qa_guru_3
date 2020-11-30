package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {

    @Test
    @DisplayName("Fill Form")
    void fillForm() {
        String firstName = "Yuliya",
                lastName = "Koronkevich",
                email = "9757975@gmail.com",
                gender = "Female",
                phoneNumber = "9099757975",
                month = "April",
                year = "1993",
                date = "06 April,1993",
                subjects = "computer",
                chosenSubject = "Computer Science",
                hobby = "Sports",
                address = "Moscow",
                state = "NCR",
                city = "Delhi",
                pictureName = "pic.jpg";
        File picture = new File("src/test/java/resources/pic.jpg");

        // Открыть страницу с формой
        open("https://demoqa.com/automation-practice-form");

        // Ввести данные в форму
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--006").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFile(picture);
        $("#currentAddress").scrollTo().setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").scrollTo().click();
        // Проверить данные
        $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text(firstName + " " + lastName));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text(email));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(text(gender));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(text(phoneNumber));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(text(date));
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(text(chosenSubject));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(text(hobby));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(text(pictureName));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(text(address));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(text(state + " " + city));
    }
};