package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static questions.VerifyRecordQuestion.recordRegisteredSuccessfully;
import static tasks.AccessTextBoxFormTask.accessTextBoxForm;
import static tasks.CompleteTextBoxFormTask.completeTextBoxForm;
import static tasks.OpenBrowserTask.openBrowser;

public class textBoxFormStepDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @Given("{actor} access to text box page")
    public void juan_access_to_text_box_page(Actor actor) {
        actor.attemptsTo(
                openBrowser(),
                accessTextBoxForm()
        );
    }
    @When("{actor} registers a user")
    public void juan_registers_a_user(Actor actor, List<Map<String, String>> testData) {
        actor.attemptsTo(
                completeTextBoxForm().with(testData.get(0))
        );
    }
    @Then("{actor} can see the registered user")
    public void juan_can_see_the_registered_user(Actor actor) {
            actor.attemptsTo(
                    Ensure.that(recordRegisteredSuccessfully()).isTrue()
            );



    }
}
