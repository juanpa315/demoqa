package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")
public class TextBoxPage extends PageObject {

    public static final Target ELEMENTS_CARD = Target.the("card elements")
            .located(By.xpath("//*[@viewBox='0 0 448 512' and contains(@xmlns, 'http://www.w3.org/2000/svg')]"));

    public static final Target TEXT_BOX_OPTION = Target.the("text box form")
            .located(By.xpath("//span[text()='Text Box']"));

    public static final Target TEXT_BOX_TITLE = Target.the("title text box form")
            .located(By.xpath("//h1[text()='Text Box']"));

    public static final Target FULL_NAME = Target.the("name of person")
            .located(By.id("userName"));

    public static final Target EMAIL = Target.the("email")
            .located(By.id("userEmail"));

    public static final Target CURRENT_ADDRESS = Target.the("current address")
            .located(By.id("currentAddress"));

    public static final Target PERMANENT_ADDRESS = Target.the("permanent address")
            .located(By.id("permanentAddress"));

    public static final Target SUBMIT = Target.the("submit button")
            .located(By.id("submit"));

    public static final Target RECORDS = Target.the("recorded fields")
            .locatedBy("//*[@class='mb-1']");
}
