package dev.mis.stepimp;

import dev.mis.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepImp {

    public static WebDriver driver = TestRunner.driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        driver.get("http://localhost:8080/index.html");

    }

    @When("the user inputs {string} into the username field")
    public void the_user_inputs_into_the_username_field(String string) {

        WebElement usernameFieldInput = driver.findElement(By.id("userName"));
        usernameFieldInput.sendKeys(string);

    }

    @When("the user inputs {string} into the password field")
    public void the_user_inputs_into_the_password_field(String string) {

        WebElement userPasswordInput = driver.findElement(By.id("userPass"));
        userPasswordInput.sendKeys(string);

    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

    }

    @Then("the user should be on their {string} page")
    public void the_user_should_be_on_their_page(String string) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.titleContains("Library"));
        assertEquals(string, driver.getTitle());

    }

    @Then("the user should recieve an alert containing the text {string}")
    public void theUserShouldRecieveAnAlertContainingTheText(String arg0) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        assertEquals(arg0, driver.switchTo().alert().getText());

    }

    @Then("the user should receive an alert containing the text {string}")
    public void theUserShouldReceiveAnAlertContainingTheText(String arg0) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        assertEquals(arg0, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

    @When("the user accepts the alert")
    public void theUserAcceptsTheAlert() {

        //accept confirmation alert

    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String arg0) {

        //assertRegistrationPage

    }

}
