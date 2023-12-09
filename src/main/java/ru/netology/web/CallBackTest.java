package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;



public class CallBackTest {
    @Test
    public void tt(){
        Selenide.open("http://localhost:9999");
        Selenide.$("[data-test-id=name] input").setValue("оксана");
        Selenide.$("[data-test-id=phone] input").setValue("+70000000000");
        Selenide.$("[data-test-id=agreement]").click();
        Selenide.$("button").click();
        Selenide.$("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
