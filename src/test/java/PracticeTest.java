import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeTest {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alina");
        $("#lastName").setValue("Kovrigina");
        $("#userEmail").setValue("alina885@mail.ru");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("1122334455");
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__year-select").selectOption("1905");
        $("select.react-datepicker__month-select").selectOption("April");
        $("div.react-datepicker__day--005").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath(("picture.png"));
        $("#currentAddress").setValue("Moscow55");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $("div.table-responsive").shouldHave(
                text("Alina Kovrigina"),
                text("alina885@mail.ru"),
                text("Female"),
                text("1122334455"),
                text("05 April,1905"),
                text("Maths"),
                text("Sports"),
                text("picture.png"),
                text("Moscow55"),
                text("Haryana Karnal"));
    }

    @Test
    void fillFormTestNegative() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alina");
        $("#lastName").setValue("Kovrigina");
        $("#userEmail").setValue("alina885@mail.ru");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("1122334455");
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__year-select").selectOption("1905");
        $("select.react-datepicker__month-select").selectOption("April");
        $("div.react-datepicker__day--005").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath(("picture.png"));
        $("#currentAddress").setValue("Moscow55");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $("div.table-responsive").shouldHave(
                text("Alina Kovrigina1"),
                text("alina885@mail.ru"),
                text("Female"),
                text("1122334455"),
                text("05 April,1905"),
                text("Maths"),
                text("Sports"),
                text("picture.png"),
                text("Moscow55"),
                text("Haryana Karnal"));
    }


}
