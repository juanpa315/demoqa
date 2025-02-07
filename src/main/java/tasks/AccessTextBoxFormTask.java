package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static pages.TextBoxPage.*;

public class AccessTextBoxFormTask implements Task {

    public static AccessTextBoxFormTask accessTextBoxForm(){
     return instrumented(AccessTextBoxFormTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ELEMENTS_CARD),
                Click.on(ELEMENTS_CARD),
                Click.on(TEXT_BOX_OPTION),
                WaitUntil.the(TEXT_BOX_TITLE, isVisible()).forNoMoreThan(30).seconds()
        );

    }
}
