import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


class CallBackTest{
    @Test
    public void tt(){
        Configuration.headless = true;
        Selenide.open("http://localhost:9999");
        Selenide.$("[data-test-id=name] input").setValue("оксана");
        Selenide.$("[data-test-id=phone] input").setValue("+70000000000");
        Selenide.$("[data-test-id=agreement]").click();
        Selenide.$("button").click();
        Selenide.$("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}