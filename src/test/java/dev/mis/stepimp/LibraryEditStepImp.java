package dev.mis.stepimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibraryEditStepImp {

    @When("the user clicks the Edit button for a movie")
    public void the_user_clicks_the_edit_button_for_a_movie() {

        //findEditButton
        //clickEditButton

    }

    @When("the user checks the modal box for Favorite")
    public void the_user_checks_the_modal_box_for_favorite() {

        //waitForModal
        //switchtoModal
        //assertFavorites

    }

    @When("the user checks the modal box for Watched")
    public void the_user_checks_the_modal_box_for_watched() {

        //assertWatched

    }

    @When("the user enters {string} into the modal User Comments box")
    public void the_user_enters_into_the_modal_user_comments_box(String string) {

        //findUserCommentsBox
        //sendkeys

    }

    @When("the user clicks the Save Changes button")
    public void the_user_clicks_the_save_changes_button() {

        //find save changes button
        //sendkeys

    }

    @Then("the movie's information should have been updated")
    public void the_movie_s_information_should_have_been_updated() {

        //wait for update to be visible
        //assert that update is visible

    }

    @When("the user checks the box to mark a movie as Favorite")
    public void theUserChecksTheBoxToMarkAMovieAsFavorite() {

    }

    @When("the user checks the box to mark a movie as Watched")
    public void theUserChecksTheBoxToMarkAMovieAsWatched() {

    }

    @When("the user clicks the Edit button to edit User Comments")
    public void theUserClicksTheEditButtonToEditUserComments() {
    }

}
