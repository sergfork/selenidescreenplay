package cucumber.questions;

import cucumber.ui.SearchedResult;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class ResultsOnThePage {

    public static Question<List<String>> allResults() {
        return actor -> Text.of(SearchedResult.SEARCHED_RESULT)
                .viewedBy(actor)
                .asList();
    }

    public static Question<Integer> currentPageNumber() {
        return actor -> Text.of(SearchedResult.CURRENT_NUMBER_OF_PAGE)
                .viewedBy(actor)
                .asInteger();
    }
}
