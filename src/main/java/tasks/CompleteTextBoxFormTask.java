package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static pages.TextBoxPage.*;

public class CompleteTextBoxFormTask implements Task {

    public static CompleteTextBoxFormTask completeTextBoxForm(){
        return instrumented(CompleteTextBoxFormTask.class);
    }

    private Map<String, String> userData;

    public CompleteTextBoxFormTask with(Map<String, String> userData){
        this.userData = userData;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FULL_NAME),
                Enter.theValue(userData.get("Full_Name")).into(FULL_NAME),
                Enter.theValue(userData.get("Email")).into(EMAIL),
                Enter.theValue(userData.get("Current_Address")).into(CURRENT_ADDRESS),
                Enter.theValue(userData.get("Permanent_Address")).into(PERMANENT_ADDRESS),
                Click.on(SUBMIT)
        );

        actor.remember("inputData",userData);
    }
}
