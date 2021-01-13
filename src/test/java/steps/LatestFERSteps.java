package steps;

import client.LatestRatesClient;
import entity.response.LatestRatesResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LatestFERSteps extends BaseSteps {

    LatestRatesClient latestRatesClient;
    LatestRatesResponse latestRatesResponse;

    @When("^rates API is available$")
    public void initializeLatestRatesClient() throws Throwable {
        latestRatesClient = new LatestRatesClient();
    }

    @When("^the response status should be (\\d+)$")
    public void verifyResponse(int status) throws Throwable {
        Assert.assertEquals(latestRatesClient.getLatestRates().getHttpStatusCode(), status);
    }

    @Then("^user hits an invalid URL")
    public void hitWithInvalidURL() throws Throwable {
        latestRatesResponse = latestRatesClient.getLatestRates("https://api.ratesapi.io/api/");
    }

    @Then("^user should get error message")
    public void verifyErrorForInvalidURL() throws Throwable {
        Assert.assertEquals(latestRatesResponse.error, "time data 'api' does not match format '%Y-%m-%d'");
    }

    @Then("^the response for rates API (\\w+) should match$")
    public void verifyResponsBody(String symbol) throws Throwable {
        LatestRatesResponse latestRatesResponse = latestRatesClient.getLatestRatesForSymbol(symbol);

        Assert.assertEquals(latestRatesResponse.base, "EUR");
        Assert.assertEquals(latestRatesResponse.rates.USD, "1.2166");
    }
}
