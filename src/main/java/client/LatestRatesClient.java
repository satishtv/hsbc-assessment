package client;

import entity.response.LatestRatesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LatestRatesClient extends BaseClient {

    public LatestRatesResponse getLatestRates() {
        String latestRatesURL = getLatestRatesHost();

        Response response = given()
                .contentType(ContentType.JSON)
                .get(latestRatesURL);

        LatestRatesResponse latestRatesResponse = response.as(LatestRatesResponse.class);
        latestRatesResponse.setHttpStatusCode(response.getStatusCode());

        return latestRatesResponse;
    }

    public LatestRatesResponse getLatestRatesForSymbol(String symbol) {
        String latestRatesURL = getLatestRatesHost();

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("symbol", symbol)
                .get(latestRatesURL);

        LatestRatesResponse latestRatesResponse = response.as(LatestRatesResponse.class);
        latestRatesResponse.setHttpStatusCode(response.getStatusCode());

        return latestRatesResponse;
    }
}
