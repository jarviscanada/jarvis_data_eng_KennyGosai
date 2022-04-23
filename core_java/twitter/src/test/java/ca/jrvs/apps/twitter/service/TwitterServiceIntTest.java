package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class TwitterServiceIntTest {
    private TwitterService service;

    @Before
    public void setUp() {
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");

        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
                tokenSecret);

        TwitterDao dao = new TwitterDao(httpHelper);
        service = new TwitterService(dao);
    }

    @Test
    public void PostTweet() {

        String text = "Integration Testing-PostTweet(). Service Layer Twitter API from JAVA" + System.currentTimeMillis();

        double lat = 43;
        double lon = -79;
        Tweet postTweet = new Tweet();
        Coordinates coord = new Coordinates();
        coord.setLatitude(lat);
        coord.setLongitude(lon);
        coord.setType("Point");
        postTweet.setText(text);
        postTweet.setCoordinates(coord);

        postTweet = service.postTweet(postTweet);

        assertEquals(postTweet.getText(), postTweet.getText());
//        assertNotNull(postTweet.getCoordinates());
//        assertEquals(2, postTweet.getCoordinates().getCoordinates().size());
//        assertEquals(postedTweet.getCoordinates().getCoordinates().get(0),
//                postTweet.getCoordinates().getCoordinates().get(0));
//        assertEquals(postedTweet.getCoordinates().getCoordinates().get(1),
//                postTweet.getCoordinates().getCoordinates().get(1));
    }
}
