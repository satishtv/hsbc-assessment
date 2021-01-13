package client;

import exception.InvalidUrlException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;


public class HTTPClient {

    public HttpResponse getResponse(String url) {
        try {
            if(url != null) {
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(url);
                request.addHeader("User-Agent", USER_AGENT);
                return client.execute(request);
            }
        } catch (ClientProtocolException cl) {
            throw new InvalidUrlException(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public StringBuffer getResponseBody(HttpResponse httpResponse) {
        try {
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                BufferedReader responseBody = new BufferedReader(
                        new InputStreamReader(httpResponse.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line;
                while ((line = responseBody.readLine()) != null) {
                    result.append(line);
                }
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
