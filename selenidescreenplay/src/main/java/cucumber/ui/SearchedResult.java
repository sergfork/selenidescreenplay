package cucumber.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchedResult {
    public static Target SEARCHED_RESULT_CAPTION = Target.the("search field").located(By.cssSelector("#rso div.ellip"));
    public static Target SEARCHED_RESULT = Target.the("search field").located(By.cssSelector("#rso div.g"));
    public static Target CURRENT_NUMBER_OF_PAGE = Target.the("current page").located(By.cssSelector("#foot #nav td.cur"));
    public static Target NEXT_PAGE = Target.the("next page").located(By.cssSelector("#foot #nav #pnnext"));

}
