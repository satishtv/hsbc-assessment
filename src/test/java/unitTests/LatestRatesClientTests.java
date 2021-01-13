package unitTests;

import client.LatestRatesClient;
import constants.TestCategories;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LatestRatesClientTests {

    @Test(groups = {TestCategories.SMOKE})
    public void healthCheckForRatesClient() {

        LatestRatesClient latestRatesClient = new LatestRatesClient();
        Assert.assertEquals(latestRatesClient.getLatestRates().getHttpStatusCode(), 200,
                "Response status doesn't match");
    }
}
