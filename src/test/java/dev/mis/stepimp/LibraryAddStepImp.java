package dev.mis.stepimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibraryAddStepImp {

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

    @When("the user enters {string} into the IMDB ID field")
    public void the_user_enters_into_the_imdb_id_field(String string) {

        //findIMDBID Field
        //sendkeys

    }

    @When("the user clicks the Get Movie Information button")
    public void the_user_clicks_the_get_movie_information_button() {

        //findGetMovieInformationButton
        //click

    }

    @Then("the movie's information should be input into the correct fields")
    public void the_movie_s_information_should_be_input_into_the_correct_fields() {

        //wait
        //assert movie information was populated

    }

    @When("the user checks the box for Watched")
    public void the_user_checks_the_box_for_watched() {

        //find watchedcheckbox
        //click watched checkbox

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

    @When("the user enters {string} into the User Comments input")
    public void theUserEntersIntoTheUserCommentsInput(String arg0) {

    }
}
