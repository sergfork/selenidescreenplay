package cucumber.tasks;

import cucumber.questions.ResultsOnThePage;
import cucumber.ui.SearchedResult;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;

public class NextPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Scroll.to(SearchedResult.NEXT_PAGE);
        Integer orderNumber = ResultsOnThePage.currentPageNumber().answeredBy(actor);
        System.out.println("Current page before is: " + orderNumber);
        orderNumber++;
        Click.on(SearchedResult.NEXT_PAGE);
        seeThat(ResultsOnThePage.currentPageNumber(), is(orderNumber.toString()));
    }
}
