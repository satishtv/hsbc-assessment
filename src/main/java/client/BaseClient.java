package client;

import util.CommonLibs;

import java.io.IOException;

public class BaseClient {

    CommonLibs commonLibs = new CommonLibs();

    private String getProperty(String propertyName) {
        String property = null;
        try {
            property = commonLibs.readPropertyFromFile("src/main/resources/config.properties", propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }

    public String getLatestRatesHost() {
        return getProperty("LATEST_RATES_HOST");
    }

    public String getPastRatesHost() {
        return getProperty("PAST_RATES_HOST");
    }
}
