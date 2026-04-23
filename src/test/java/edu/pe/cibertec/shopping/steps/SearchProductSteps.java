package edu.pe.cibertec.shopping.steps;

import edu.pe.cibertec.shopping.tasks.Login;
import edu.pe.cibertec.shopping.tasks.SearchProduct;
import edu.pe.cibertec.shopping.ui.SearchProductScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class SearchProductSteps {

    @Given("Andrea is logged into the Shopping Cart application")
    public void andrea_is_logged_into_the_app() {
        OnStage.theActorCalled("Andrea").attemptsTo(
                Login.withCredentials("user1@test.com", "password1")
        );
    }

    @When("she searches for the product {string}")
    public void she_searches_for_the_product(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchProduct.searchProduct(product)
        );
    }

    @Then("she should see results related to {string}")
    public void she_should_see_results_related_to(String product) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        Text.of(SearchProductScreen.PRODUCT_NAME.of(product)),
                        containsString(product)
                )
        );
    }
}
