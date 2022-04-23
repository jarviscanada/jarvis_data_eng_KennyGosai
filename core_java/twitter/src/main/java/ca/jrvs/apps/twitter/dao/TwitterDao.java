package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.JsonUtil;
import ca.jrvs.apps.twitter.model.Tweet;
//import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TwitterDao implements CrdDao<Tweet, String>{
    //URI constants
    private static final String API_BASE_URI = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";

    //URI symbols
    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    //Response code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;

    @Autowired
    public TwitterDao(HttpHelper httpHelper) {this.httpHelper = httpHelper;}

    @Override
    public Tweet create(Tweet tweet){
        URI uri;
        try {
            uri = getPostUri(tweet);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Invalid tweet input", e);
        }

        HttpResponse response = httpHelper.httpPost(uri);

        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet findById(String s) {
        return null;
    }

    @Override
    public Tweet deleteById(String s) {
        return null;
    }

    private URI getPostUri(Tweet tweet) throws URISyntaxException, UnsupportedEncodingException {
        StringBuilder uri = new StringBuilder();
        uri.append(API_BASE_URI);
        uri.append(POST_PATH);
        uri.append("?status=" + URLEncoder.encode(tweet.getText(), StandardCharsets.UTF_8.toString()));
        uri.append("&display_coodinates=true");
        uri.append("&lat=" + tweet.getCoordinates().getLatitude());
        uri.append("&long=" + tweet.getCoordinates().getLongitude());

        return new URI(uri.toString());
    }

    private Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
        Tweet tweet = null;

        int status = response.getStatusLine().getStatusCode();
        if(status != expectedStatusCode) {
            try {
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                System.out.println("Response has no entity");
            }
            throw new RuntimeException("Unexpected HTTP status: " + status);
        }
        if(response.getEntity() == null){
            throw new RuntimeException("Empty response body");
        }

        String jsonStr;
        try {
            jsonStr = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Unable to convert JSON str to object");
        }

        try {
            tweet = JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
        } catch (IOException e){
            throw  new RuntimeException("Unable to convert JSON str to object");
        }
        return tweet;
    }
}
