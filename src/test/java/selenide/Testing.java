package selenide;

import java.time.Duration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Testing {

    MainPage mainPage;
    FindAndCheckInfo findAndCheckInfo;
    Search search;
    Booking booking;

    @BeforeEach
    @Test
    public void test_settings() {
        Selenide.open("https://pobeda.aero");
    }

    @BeforeEach
    @Test
    public void test_checkTitleAndLogo() {

        mainPage = new MainPage();

        // Проверка заголовка
        String currentPageTitle = mainPage.getPageTitle();

        Assertions.assertTrue(currentPageTitle
                .contains("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками"));

        // Проверка изображения
        SelenideElement pobedaImg = mainPage.getPobedaImg();
        pobedaImg.shouldBe(visible, Duration.ofSeconds(10));
        pobedaImg.shouldBe(exist, Duration.ofSeconds(10));

        Assertions.assertEquals(pobedaImg.getAttribute("alt"), "«Авиакомпания «Победа», Группа «Аэрофлот»");
    }

    @Test
    public void test_findAndCheckInfo() {

        findAndCheckInfo = new FindAndCheckInfo();

        // Проверка пункта "Информация"
        SelenideElement informationItem = findAndCheckInfo.getInformationItem();
        Assertions.assertEquals(informationItem.getText(), "Информация");

        // Наведение на пункт "Информация"
        informationItem.hover();

        // Проверка отображения элементов
        SelenideElement preparingFlight = findAndCheckInfo.getPreparingFlight();
        SelenideElement helpfulInfo = findAndCheckInfo.getHelpfulInfo();
        SelenideElement aboutCompany = findAndCheckInfo.getAboutCompany();

        preparingFlight.shouldBe(visible, Duration.ofSeconds(10));
        helpfulInfo.shouldBe(visible, Duration.ofSeconds(10));
        aboutCompany.shouldBe(visible, Duration.ofSeconds(10));

        Assertions.assertTrue(helpfulInfo.isDisplayed());
        Assertions.assertTrue(preparingFlight.isDisplayed());
        Assertions.assertTrue(aboutCompany.isDisplayed());
    }

    @Test
    public void test_searchTickets() {

        search = new Search();

        // Проверка отображения элементов
        SelenideElement cityFrom = search.getCityFrom();
        SelenideElement cityTo = search.getCityTo();

        cityFrom.shouldBe(clickable);
        cityTo.shouldBe(clickable);

        Assertions.assertTrue(cityFrom.isDisplayed());
        Assertions.assertTrue(cityTo.isDisplayed());

        // Ввод даннных
        search.setCityFrom("Москва");
        search.setCityTo("Санкт-Петербург");

        // Поиск
        search.clickSearchButton();
    }

    @Test
    public void test_booking() {

        booking = new Booking();

        // Переход в пункт "Управление бронированием"
        SelenideElement bookingManagementItem = booking.getbookingManagementItem();
        bookingManagementItem.hover();
        bookingManagementItem.click();

        // Проверка отображения элементов
        SelenideElement ticketNumber = booking.getTicketNumber();
        SelenideElement surname = booking.getSurname();
        SelenideElement searchButton = booking.getSearchButton();

        ticketNumber.shouldBe(visible, Duration.ofSeconds(10));
        surname.shouldBe(visible, Duration.ofSeconds(10));
        searchButton.shouldBe(visible, Duration.ofSeconds(10));

        Assertions.assertTrue(ticketNumber.isDisplayed());
        Assertions.assertTrue(surname.isDisplayed());
        Assertions.assertTrue(searchButton.isDisplayed());

        // Ввод данных
        booking.setTicketNumber("XXXXXX");
        booking.setSurname("Qwerty");

        // Поиск
        booking.clickSearchButton();

        // Переключение фокуса на новое открытое окно
        switchTo().window(1);

        // Проверка наличия текста с ошибкой
        SelenideElement errorText = booking.getSearchErrorText();
        Assertions.assertEquals(errorText.getAttribute("outerText"), "Заказ с указанными параметрами не найден");
    }

    @AfterAll
    public static void test_closeBrowser() throws InterruptedException {

        // Завершенеие работы браузера
        Thread.sleep(5000);
        Selenide.closeWebDriver();
    }
}
