package com.example.demo2;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyTest {

    @Test
    public void myTest() {
        // Переходим на страницу авторизации

        open("https://account.mail.ru/login");

        // Заполняем поле имя аккаунта

        $x("//div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[1]/div/div/div/div/div/div[1]/div/input")
                .setValue("test@mail.ru")
                .shouldBe(Condition.value("test@mail.ru"));

        // Нажимаем кнопку ввести пароль

        $x("//div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[3]/div/div/div[1]/div/button/span")
                .shouldBe(Condition.visible).click();

        // Вводим пароль

        $x("//div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div/input")
                .setValue("password")
                .shouldBe(Condition.value("password"));

        // Нажимаем кнопку войти

        $x("//div[1]/div[2]/div[2]/div/div/div/div/div/form/div[2]/div/div[3]/div/div/div[1]/div/div/button/span")
                .shouldBe(Condition.visible).click();

        $(byText("Написать письмо")).click();

        $x("//div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
                .setValue("mail@mail.ru");// Адрес отправления

        $x("//div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
                .setValue("Автотест"); // тема письма

        $x("//div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")
                .setValue("Текст письма "); // Текст письма

        $(byText("Отправить")).click();
    }
}
