package questions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.ArrayList;
import java.util.List;

import static pages.TextBoxPage.RECORDS;

public class RecordQuestion implements Question<List<String>> {

    public static RecordQuestion recordRegistered(){
        return new RecordQuestion();
    }
    @Override
    public List<String> answeredBy(Actor actor) {

        ListOfWebElementFacades listOfElements = RECORDS.resolveAllFor(actor);
        List<String> savedRecord = new ArrayList<>();

        for (WebElementFacade element: listOfElements){
            String userData = element.getText();
            savedRecord.add(userData);
        }
       return savedRecord;
    }
}

