import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
    private int statusCode;

    @Before
    public void setUp() {
        statusCode = -1;
    }

    @When("^I send a GET request for (.*)$")
    public void sendGetRequest(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestMethod("GET");
        connection.connect();
        statusCode = connection.getResponseCode();
    }

    @Then("^I should get a (\\d+) response$")
    public void checkResponseCode(int response) {
        assertThat(statusCode, is(response));
    }
}
