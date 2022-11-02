package dev.mis.stepimp;

import dev.mis.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static dev.mis.stepimp.LoginStepImp.driver;

public class CreateAccountStepImp {


    public static WebDriver driver = TestRunner.driver;

    @Then("the user should receive an alert with the text {string}")
    public void the_user_should_receive_an_alert_with_the_text(String string) {
        // Write code here that turns the phrase above into concrete actions
        String alertText = driver.switchTo().alert().getText();
        Assertions.assertEquals("Account Created!",alertText);
        driver.switchTo().alert().accept();

    }
    @When("the user clicks the Create Account button")
    public void theUserClicksTheCreateAccountButton() {
        WebElement createAccount=driver.findElement(By.id("newUserRegisterButton"));
        createAccount.click();
    }
    @When("the user clicks the Create a New Account button")
    public void theUserClicksTheCreateANewAccountButton() {
        WebElement newAccount = driver.findElement(By.id("createNewAccountLinkAnchor"));
        newAccount.click();
    }
}
