package selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

//    private SelenideElement pobedaImg = $x("//img[contains(@src, \"logo-rus\") " +
//            "and contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]");

    private SelenideElement pobedaImg = $(By.xpath("//img[contains(@src, \"logo-rus\") " +
            "and contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]"));

    public String getPageTitle() {
        return Selenide.title();
    }

    public SelenideElement getPobedaImg() {
        return pobedaImg;
    }

}

