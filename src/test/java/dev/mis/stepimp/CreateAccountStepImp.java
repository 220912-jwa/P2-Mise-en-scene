package dev.mis.stepimp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static dev.mis.stepimp.LoginStepImp.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountStepImp {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

        driver.get("http://localhost:8080/register.html");

    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions

        WebElement createAccount=driver.findElement(By.id("newUserRegisterButton"));
        createAccount.click();
    }
    @When("the user inputs {string} into the username field")
    public void the_user_inputs_into_the_username_field(String string) {
        // Write code here that turns the phrase above into concrete actions

        driver.findElement(By.id("newUserName"));
        WebElement username=driver.findElement(By.id("newUserName"));
        username.sendKeys("newAccount");
    }
    @When("the user inputs {string} into the password field")
    public void the_user_inputs_into_the_password_field(String string) {
        // Write code here that turns the phrase above into concrete actions

        driver.findElement(By.id("newUserPass"));
        WebElement password=driver.findElement(By.id("newUserPass"));
        password.sendKeys("passpass");

    }
    @Then("the user should receive an alert with the text {string}")
    public void the_user_should_receive_an_alert_with_the_text(String string) {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

}
