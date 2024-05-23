package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Booking {

    private SelenideElement bookingManagementItem =
            $(By.xpath("//button[contains(@type, \"button\")] " +
                    "/following::div[contains(text(), \"Управление бронированием\")]"));

    private SelenideElement ticketNumber =
            $(By.xpath("//input[@placeholder=\"Номер бронирования или билета\"]"));

    private SelenideElement surname =
            $(By.xpath("//input[@placeholder=\"Фамилия клиента\"]"));

    private SelenideElement searchButton =
            $(By.xpath("//button[@type=\"submit\"] [text()=\"Поиск\"]"));

    private SelenideElement searchErrorText =
            $(By.xpath("//div[@class=\"message_error\"] " +
                    "[text()=\"Заказ с указанными параметрами не найден\"]"));

    @Step("Получение элемента с бронированием")
    public SelenideElement getbookingManagementItem() {
        return bookingManagementItem;
    }

    @Step("Получение элемента со вводом номера билета")
    public SelenideElement getTicketNumber() {
        return ticketNumber;
    }

    @Step("Получение элемента со вводом фамилии")
    public SelenideElement getSurname() {
        return surname;
    }

    @Step("Получение кнопки поиска")
    public SelenideElement getSearchButton() {
        return searchButton;
    }

    @Step("Получение текста с ошибкой")
    public SelenideElement getSearchErrorText() {
        return searchErrorText;
    }

    @Step("Ввод номера билета {enterTicketNumber}")
    public void setTicketNumber(String enterTicketNumber) {
        ticketNumber.hover();
        ticketNumber.pressEnter();
        ticketNumber.setValue(enterTicketNumber);
    }

    @Step("Ввод фамилии {enterSurname}")
    public void setSurname(String enterSurname) {
        surname.hover();
        ticketNumber.pressEnter();
        surname.setValue(enterSurname);
    }

    @Step("Клик по кнопке поиска")
    public void clickSearchButton() {
        searchButton.hover();
        searchButton.click();
    }

}
