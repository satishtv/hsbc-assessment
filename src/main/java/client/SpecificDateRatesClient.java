package client;

import entity.response.LatestRatesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SpecificDateRatesClient extends BaseClient {


    public LatestRatesResponse getResponseForDate(String date) {
        String latestRatesURL = getLatestRatesHost() + "/" + date;

        Response response = given()
                .contentType(ContentType.JSON)
                .get(latestRatesURL);

        LatestRatesResponse latestRatesResponse = response.as(LatestRatesResponse.class);
        latestRatesResponse.setHttpStatusCode(response.getStatusCode());

        return latestRatesResponse;
    }
}
