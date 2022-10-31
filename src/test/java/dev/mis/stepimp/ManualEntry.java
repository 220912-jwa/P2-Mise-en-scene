package dev.mis.stepimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManualEntry {
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



    @Then("an alert should appear prompting the user to input more information")
    public void anAlertShouldAppearPromptingTheUserToInputMoreInformation() {

        //wait for alert
        //assert alertText
        //accept alert

    }

}
