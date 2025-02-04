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
    public void the_user_clicks_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("submitButton")) {
            loginFormPage.clickOnSubmitButton();
        } else {
            throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }
    @Then("the user should see {string}")
    public void the_user_should_see(String string) {
       loginFormPage.getLoginMessage();
    }

}
