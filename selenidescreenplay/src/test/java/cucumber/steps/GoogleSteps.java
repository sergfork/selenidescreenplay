package cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.questions.ResultsOnThePage;
import cucumber.tasks.OpenTheApplication;
import cucumber.tasks.Search;
import cucumber.ui.SearchedResult;
import cucumber.utils.Utils;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import java.util.List;
import java.util.Optional;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class GoogleSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the Google page")
    public void serge_is_on_the_Search_page(String actorName) {
        theActorCalled(actorName).wasAbleTo(instrumented(OpenTheApplication.class));
    }

    @When("^(.*) searches by (.*)$")
    public void he_searches_by(String actorName, String searchTerm) {
        theActorCalled(actorName).wasAbleTo(Search.forTheTerm(searchTerm));
    }

    @Then("^(.*) opens the first link on search results page$")
    public void he_opens_the_first_link_on_search_results_page(String actorName) {
        theActorCalled(actorName).wasAbleTo(Click.on(SearchedResult.SEARCHED_RESULT_CAPTION));
    }

    @Then("^(.*) can see that title contains (.*) searched word$")
    public void title_contains_automation_searched_word(String actorName, String searchedWord) {
        seeThat(TheWebPage.title(), containsString(searchedWord));
    }

    @Then("^(.*) can see that (.*) domain is shown on searched results pages. Verify from 1 to (\\d+)$")
    public void verify_that_there_is_testautomationday_com_domain_on_search_results_pages(
            String actorName, String lookingForDomain, int toPage) {
        int currentPage = 1;
        Optional<String> result = Optional.empty();
        System.out.println(" ==== 1");
//        while (currentPage < toPage && !result.isPresent()) {
        List<String> pageResult = ResultsOnThePage.allResults().answeredBy(theActorCalled(actorName));
        System.out.println(" ==== 2");
        System.out.println(pageResult.toString());
        result = Utils.searchOnThePage(pageResult, lookingForDomain);
        System.out.println(" ==== 3 " + result.isPresent());
        if (result.isPresent()) {
            System.out.println("page is: " + currentPage);
            System.out.println(result.toString());
        }
////            NextPage
        Scroll.to(SearchedResult.NEXT_PAGE);
        System.out.println(" ==== 4");

        Integer orderNumber = ResultsOnThePage.currentPageNumber().answeredBy(theActorCalled(actorName));
        System.out.println("Current page before is: " + orderNumber);
        orderNumber++;
        Click.on(SearchedResult.NEXT_PAGE);
        System.out.println("============!!!!!!!!!!!!!!!!!!!!!!!!");
        seeThat(ResultsOnThePage.currentPageNumber(), is(orderNumber.toString()));
        currentPage = ResultsOnThePage.currentPageNumber().answeredBy(theActorCalled(actorName));
        System.out.println("=========+++++ " + currentPage);
//        }
//        return result;
//        seeThat(lookingForDomain + " on " + currentPage, is())
    }

}
