package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class Search {

    private SelenideElement cityFrom = $x("//input[@placeholder=\"Откуда\"]");

    private SelenideElement cityTo = $x("//input[@placeholder=\"Куда\"]");

    private SelenideElement searchButton = $x("//button[@type=\"submit\"] [text()=\"Поиск\"]");

    @Step("Получение элемента с городом отправления")
    public SelenideElement getCityFrom() {
        return cityFrom;
    }

    @Step("Получение элемента с городом прибытия")
    public SelenideElement getCityTo() {
        return cityTo;
    }

    @Step("Присвоение города отправления - {enterCityFrom}")
    public void setCityFrom(String enterCityFrom) {
        cityFrom.hover();
        cityFrom.setValue(enterCityFrom);
        cityFrom.contextClick();
        cityFrom.sendKeys(Keys.ARROW_DOWN);
        cityFrom.sendKeys(Keys.ENTER);
    }

    @Step("Присвоение города прибытия - {enterCityTo}")
    public void setCityTo(String enterCityTo) {
        cityTo.hover();
        cityTo.setValue(enterCityTo);
        cityTo.sendKeys(Keys.ARROW_DOWN);
        cityTo.sendKeys(Keys.ENTER);
    }

    @Step("Клик по кнопке поиска")
    public void clickSearchButton() {
        searchButton.hover();
        searchButton.click();
        searchButton.pressEnter();
    }

}