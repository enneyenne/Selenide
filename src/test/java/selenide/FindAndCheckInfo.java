package selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FindAndCheckInfo {

    private SelenideElement informationItem = $(By.xpath("//a[@href=\"/information\"]"));

    private SelenideElement preparingFlight = $(By.xpath("//a[@href=\"/information#flight\"]"));

    private SelenideElement helpfulInfo = $(By.xpath("//a[@href=\"/information#useful\"]"));

    private SelenideElement aboutCompany = $(By.xpath("//a[@href=\"/information#company\"]"));

    @Step("Получение элемента \"Информация\"")
    public SelenideElement getInformationItem() {
        return informationItem;
    }

    @Step("Получение элемента \"Подготовка к полёту\"")
    public SelenideElement getPreparingFlight() {
        return preparingFlight;
    }

    @Step("Получение элемента \"Полезная информация\"")
    public SelenideElement getHelpfulInfo() {
        return helpfulInfo;
    }

    @Step("Получение элемента \"О компании\"")
    public SelenideElement getAboutCompany() {
        return aboutCompany;
    }

}
