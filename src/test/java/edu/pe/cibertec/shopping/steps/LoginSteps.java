package edu.pe.cibertec.shopping.steps;

import edu.pe.cibertec.shopping.tasks.Login;
import edu.pe.cibertec.shopping.ui.TheMainScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {

    private String email;
    private String password;

    @Given("Andrea opens the Shopping Cart application")
    public void open_the_Shopping_Cart_application() {
        Actor andrea = OnStage.theActorCalled("Andrea");
    }

    @When("she enters her email {string} and password {string}")
    public void enters_her_email_and_password(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @And("she taps the Login button")
    public void taps_the_Login_button() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withCredentials(email, password));
    }

    @Then("she should see the main screen of the application")
    public void checks_the_main_screen_of_the_application() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheMainScreen.isVisible(), equalTo(true)));
    }
}
