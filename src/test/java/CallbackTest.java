import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byText;


class CallBackTest{
    @Test
    public void tt(){
        java.util.Date date = new java.util.Date();
        String planningDate = generateDate(4);
        Selenide.open("http://localhost:9999");
        Selenide.$("[data-test-id=city] input").setValue("Казань");
        Selenide.$("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        Selenide.$("[data-test-id=date] input").setValue(planningDate);
        Selenide.$("[data-test-id=name] input").setValue("иван");
        Selenide.$("[data-test-id=phone] input").setValue("+71111111111");
        Selenide.$("[data-test-id=agreement]").click();
        Selenide.$(byText("Забронировать")).click();
        Selenide.$(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }
    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}