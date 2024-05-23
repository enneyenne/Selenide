package selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FindAndCheckInfo {

    private SelenideElement informationItem = $(By.xpath("//a[@href=\"/information\"]"));

    private SelenideElement preparingFlight = $(By.xpath("//a[@href=\"/information#flight\"]"));

    private SelenideElement helpfulInfo = $(By.xpath("//a[@href=\"/information#useful\"]"));

    private SelenideElement aboutCompany = $(By.xpath("//a[@href=\"/information#company\"]"));

    public SelenideElement getInformationItem() {
        return informationItem;
    }

    public SelenideElement getPreparingFlight() {
        return preparingFlight;
    }

    public SelenideElement getHelpfulInfo() {
        return helpfulInfo;
    }

    public SelenideElement getAboutCompany() {
        return aboutCompany;
    }

}
