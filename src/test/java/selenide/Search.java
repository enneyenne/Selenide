package selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class Search {

    private SelenideElement cityFrom = $x("//input[@placeholder=\"Откуда\"]");

    private SelenideElement cityTo = $x("//input[@placeholder=\"Куда\"]");

    private SelenideElement searchButton = $x("//button[@type=\"submit\"] [text()=\"Поиск\"]");

    public SelenideElement getCityFrom() {
        return cityFrom;
    }

    public SelenideElement getCityTo() {
        return cityTo;
    }

    public void setCityFrom(String enterCityFrom) {
        cityFrom.hover();
        cityFrom.setValue(enterCityFrom);
        cityFrom.contextClick();
        cityFrom.sendKeys(Keys.ARROW_DOWN);
        cityFrom.sendKeys(Keys.ENTER);
    }

    public void setCityTo(String enterCityTo) {
        cityTo.hover();
        cityTo.setValue(enterCityTo);
        cityTo.sendKeys(Keys.ARROW_DOWN);
        cityTo.sendKeys(Keys.ENTER);
    }

    public void clickSearchButton() {
        searchButton.hover();
        searchButton.click();
        searchButton.pressEnter();
    }

}