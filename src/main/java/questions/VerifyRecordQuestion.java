package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static questions.RecordQuestion.recordRegistered;

public class VerifyRecordQuestion implements Question<Boolean> {

    public static VerifyRecordQuestion recordRegisteredSuccessfully(){
        return new VerifyRecordQuestion();
    }
    @Override
    public Boolean answeredBy(Actor actor) {

        Map<String, String> inputRecord = actor.recall("inputData");
        List<String> valuesList = inputRecord.values().stream()
                .filter(Objects::nonNull).toList();
        List<String> savedRecord = actor.asksFor(recordRegistered());


        for (int i = 0; i < valuesList.size(); i++) {
            String inputValue = valuesList.get(i);
            if (!savedRecord.get(i).contains(inputValue)) {
                System.out.println("the value " + inputValue + " is not in " + savedRecord.get(i));
                return false;
            }
        }
        return true;
    }
}
