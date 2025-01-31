package steps.pageobjectmodel;

import core.pages.pageobjectmodel.LoginFormPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFormStepDefinitions {

    final private LoginFormPage loginFormPage;

    public LoginFormStepDefinitions() {
        loginFormPage = new LoginFormPage();
    }

    @When("the user enters {string} in the username field")
    public void the_user_enters_in_the_username_field(String userName) {
        loginFormPage.enterUsername(userName);

    }
    @When("the user enters {string} in the password field")
    public void the_user_enters_in_the_password_field(String password) {
        loginFormPage.enterPassword(password);
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see {string}")
    public void the_user_should_see(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
