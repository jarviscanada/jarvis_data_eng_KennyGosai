package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class TwitterDaoTest {
    private TwitterDao dao;
    @Before
    public void setup(){
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey + " | " + consumerSecret + " | " + accessToken + " | " + tokenSecret);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);

        this.dao = new TwitterDao(httpHelper);
    }

    @Test
    public void create() throws UnsupportedEncodingException {
        String hashTag = "#goat";
//        String text = "@GeorgesStPierre Hey " + hashTag + " " + System.currentTimeMillis();
        String text = URLEncoder.encode("@GeorgesStPierre Hey " + hashTag + " " + System.currentTimeMillis(), StandardCharsets.UTF_8.toString());

        double lat = 43;
        double lon = -79;
        Tweet postTweet = new Tweet();
        Coordinates coord = new Coordinates();
        coord.setLatitude(lat);
        coord.setLongitude(lon);
        coord.setType("Point");
        postTweet.setText(text);
        postTweet.setCoordinates(coord);
        Tweet tweet = dao.create(postTweet);
        assertEquals(text, tweet.getText());

        assertNotNull(tweet.getCoordinates());
        assertEquals(lat, tweet.getCoordinates().getLatitude());
        assertEquals(lon, tweet.getCoordinates().getLongitude());


    }
}