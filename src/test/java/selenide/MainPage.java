package selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

//    private SelenideElement pobedaImg = $x("//img[contains(@src, \"logo-rus\") " +
//            "and contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]");

    private SelenideElement pobedaImg = $(By.xpath("//img[contains(@src, \"logo-rus\") " +
            "and contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]"));

    @Step("Получение заголовка страницы")
    public String getPageTitle() {
        return Selenide.title();
    }

    @Step("Получение изображения")
    public SelenideElement getPobedaImg() {
        return pobedaImg;
    }

}

