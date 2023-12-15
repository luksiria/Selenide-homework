import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import java.time.Duration;


class CallBackTest{
    @Test
    public void tt(){
        java.util.Date date = new java.util.Date();
        Configuration.headless = false;
        Selenide.open("http://localhost:9999");
        Selenide.$("[data-test-id=city] input").setValue("Казань");
        Selenide.$("[data-test-id=date] input").setValue(String.valueOf(date));
        Selenide.$("[data-test-id=name] input").setValue("иван");
        Selenide.$("[data-test-id=phone] input").setValue("+71111111111");
        Selenide.$("[data-test-id=agreement]").click();
        Selenide.$("#root > div > form > fieldset > div.grid-row.grid-row_gutter-mobile-s_16.grid-row_gutter-desktop-m_24.grid-row_justify_between.grid-row_theme_alfa-on-white > div.grid-col.grid-col_width_3.grid-col_theme_alfa-on-white.grid-col_gutter-mobile-s_16.grid-col_gutter-desktop-m_24 > div > button").click();
        Selenide.$("#root > div > div > div.notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Успешно!"));

    }
}