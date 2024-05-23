package selenide;

import com.codeborne.selenide.SelenideElement;
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

    public SelenideElement getbookingManagementItem() {
        return bookingManagementItem;
    }

    public SelenideElement getTicketNumber() {
        return ticketNumber;
    }

    public SelenideElement getSurname() {
        return surname;
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }

    public SelenideElement getSearchErrorText() {
        return searchErrorText;
    }

    public void setTicketNumber(String enterTicketNumber) {
        ticketNumber.hover();
        ticketNumber.setValue(enterTicketNumber);
        ticketNumber.pressEnter();
    }

    public void setSurname(String enterSurname) {
        surname.hover();
        surname.setValue(enterSurname);
        surname.pressEnter();
    }

    public void clickSearchButton() {
        searchButton.hover();
        searchButton.click();
    }

}
