package steps;

import client.SpecificDateRatesClient;
import entity.response.LatestRatesResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SpecifiDatedFERSteps extends BaseSteps {

    SpecificDateRatesClient specificDateRatesClient;
    LatestRatesResponse latestRatesResponse;

    @When("^specific date rates API is available$")
    public void initializeSpecificDateRatesClient() throws Throwable {
        specificDateRatesClient = new SpecificDateRatesClient();
    }

    @Then("^specific date rates response status should be (\\w+)$")
    public void verifySpecificDateRateStatus(String status) throws Throwable {
        Assert.assertEquals(specificDateRatesClient.getResponseForDate("2010-01-12").getHttpStatusCode(), status);
    }
}
