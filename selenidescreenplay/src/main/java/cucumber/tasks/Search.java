package cucumber.tasks;

import cucumber.ui.SearchBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Search implements Task {
    private final String searchTerm;

    protected Search(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                        .into(SearchBox.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }

    public static Search forTheTerm(String searchTerm) {
        return instrumented(Search.class, searchTerm);
    }
}
