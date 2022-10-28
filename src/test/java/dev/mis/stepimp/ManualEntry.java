package dev.mis.stepimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManualEntry {

    @Given("the user is logged in and on their {string} page")
    public void the_user_is_logged_in_and_on_their_page(String string) {

        //get login
        //find usernameInput
        //sendkeys
        //find userpassInput
        //sendkeys
        //click login
        //explicit wait for "Library View"

    }

    @When("the user clicks {string}")
    public void the_user_clicks(String string) {
        //find "Manual Entry"
        //click Manual Entry
        //wait

    }

    @When("the user enters {string} into the Title field")
    public void the_user_enters_into_the_title_field(String string) {

        //findTitleField
        //sendKeys

    }

    @When("the user enters {string} into the Year field")
    public void the_user_enters_into_the_year_field(String string) {

        //find year field
        //sendkeys

    }

    @When("the user enters {string} into the Language field")
    public void the_user_enters_into_the_language_field(String string) {

        //find language field
        //sendkeys

    }

    @When("the user checks the box for Watched")
    public void the_user_checks_the_box_for_watched() {

        //find watchedcheckbox
        //click watched checkbox

    }

    @When("the user enters {string} into the User Rating field")
    public void the_user_enters_into_the_user_rating_field(String string) {

        //find user rating field
        //sendkeys user rating field

    }

    @When("the user checks the box for Favorite")
    public void the_user_checks_the_box_for_favorite() {

        //find favorite check box
        //click favorite check box

    }

    @When("the user enters {string} into the User Notes box")
    public void the_user_enters_into_the_user_notes_box(String string) {

        //find user notes field
        //send keys

    }

    @When("the user clicks the Submit button")
    public void the_user_clicks_the_submit_button() {

        //find submitButton
        //click submit button

    }

    @Then("the new entry should appear on the user's Library View")
    public void the_new_entry_should_appear_on_the_user_s_library_view() {

        //wait for new entry to appear
        //assert new entry is displayed

    }

    @Then("an alert should appear prompting the user to input more information")
    public void anAlertShouldAppearPromptingTheUserToInputMoreInformation() {

        //wait for alert
        //assert alertText
        //accept alert

    }

}
