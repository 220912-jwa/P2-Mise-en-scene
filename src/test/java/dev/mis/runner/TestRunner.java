package dev.mis.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = {"src/test/resources/features/libraryAdd.feature", "src/test/resources/features/libraryEdit.feature",
            "src/test/resources/features/manualEntry.feature","src/test/resources/features/login.feature","src/test/resources/features/zcreateAccount.feature"}, glue={"dev.mis.stepimp"})
    public class TestRunner {
        public static ChromeDriver driver;

        @BeforeClass
        public static void setup(){
            File chrome = new File("src/test/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        @AfterClass
        public static void teardown(){driver.quit();}
    }
