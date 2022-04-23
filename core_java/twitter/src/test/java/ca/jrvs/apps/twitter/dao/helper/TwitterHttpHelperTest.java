package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import static org.junit.Assert.*;

public class TwitterHttpHelperTest {

    @org.junit.Test
    public void httpPost() throws Exception{
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey + " | " + consumerSecret + " | " + accessToken + " | " + tokenSecret);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status=Hello_World&display_coordinates=true&lat=37.0&long=-115.0"));
//        HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/destroy/1513572475975737346.json"));

//        HttpResponse response = httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=kenkenspam"));

        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}