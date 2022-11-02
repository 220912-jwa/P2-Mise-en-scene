package dev.mis.stepimp;

import dev.mis.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LibraryAddStepImp {
    public static WebDriver driver = TestRunner.driver;

    @Given("the user is logged in and on their {string} page")
    public void the_user_is_logged_in_and_on_their_page(String string) {

        driver.get("http://localhost:8080/");
        WebElement usernameFieldInput = driver.findElement(By.id("userName"));
        usernameFieldInput.sendKeys("griffy");
        WebElement userPasswordInput = driver.findElement(By.id("userPass"));
        userPasswordInput.sendKeys("hunter2");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.titleContains("Library"));
        Assertions.assertEquals(string, driver.getTitle());

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
