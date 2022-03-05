import Pages.Login;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
   public WebDriver driver;
   Login login;
    @Given("^users visit to the HRM Portal$")
    public void users_visit_to_the_HRM_Portal() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions( );
        ops.addArguments("--headed"); //uncomment if you want to run in headless mode
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("^users input invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void users_input_invalid_username_and_password(String username ,String password) throws Exception {
        // Write code here that turns the phrase above into concrete actions
         login = new Login(driver);
        login.doLogin(username,password);

    }

    @Then("^user can not log in$")
    public void user_can_not_log_in() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        login = new Login(driver);
       String text =  login.getErrorMessage();
        Assert.assertEquals(text,"Invalid credentials");


    }
    @After
    public void finish(){
        driver.close();
    }

    }



