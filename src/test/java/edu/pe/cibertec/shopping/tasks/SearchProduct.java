package edu.pe.cibertec.shopping.tasks;

import edu.pe.cibertec.shopping.ui.SearchProductScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchProduct implements Task {

    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    public static SearchProduct searchProduct(String productName) {
        return new SearchProduct(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
               Enter.theValue(productName).into(SearchProductScreen.SEARCH_INPUT)

        );
    }

}
