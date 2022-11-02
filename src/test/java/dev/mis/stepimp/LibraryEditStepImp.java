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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class LibraryEditStepImp {
    public static WebDriver driver = TestRunner.driver;

    @When("the user clicks the Save Changes button")
    public void the_user_clicks_the_save_changes_button() {
        WebElement save = driver.findElement(By.id("'tt5108870'_save"));
        save.click();

    }

    @Then("the movie's information should have been updated")
    public void the_movie_s_information_should_have_been_updated() {
        driver.get("http://localhost:8080/library.html");
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("'tt5108870'_isWatched")));
        WebElement watchedCheck = driver.findElement(By.id("'tt5108870'_isWatched"));
        Assertions.assertTrue(watchedCheck.isSelected());

    }

    @When("the user checks the box to mark a movie as Favorite")
    public void theUserChecksTheBoxToMarkAMovieAsFavorite() {
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("'tt5108870'_isFavorite")));
        WebElement favoriteCheck = driver.findElement(By.id("'tt5108870'_isFavorite"));
        favoriteCheck.click();

    }

    @When("the user checks the box to mark a movie as Watched")
    public void theUserChecksTheBoxToMarkAMovieAsWatched() {
        WebElement watchedCheck = driver.findElement(By.id("'tt5108870'_isWatched"));
        watchedCheck.click();
    }



}
