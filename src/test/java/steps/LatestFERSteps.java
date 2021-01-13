package steps;

import client.LatestRatesClient;
import entity.response.LatestRatesResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LatestFERSteps extends BaseSteps {

    LatestRatesClient latestRatesClient;

    @When("^rates API is available$")
    public void initializeLatestRatesClient() throws Throwable {
        latestRatesClient = new LatestRatesClient();
    }

    @When("^the response status should be (\\d+)")
    public void verifyResponse(int status) throws Throwable {
        Assert.assertEquals(latestRatesClient.getLatestRates().getHttpStatusCode(), status);
    }

    @Then("^the response for rates API (\\w+) should match")
    public void verifyResponse(String symbol) throws Throwable {
        LatestRatesResponse latestRatesResponse = latestRatesClient.getLatestRatesForSymbol(symbol);

        Assert.assertEquals(latestRatesResponse.base, "EUR");
        Assert.assertEquals(latestRatesResponse.rates.USD, "1.2166");
    }
}
