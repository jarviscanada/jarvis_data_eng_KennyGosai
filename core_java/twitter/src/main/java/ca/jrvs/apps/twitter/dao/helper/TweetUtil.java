package ca.jrvs.apps.twitter.dao.helper;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;

public class TweetUtil {
    /**
     * create a new tweet with text and coordinates
     *
     * @param text status
     * @param lon longitude
     * @param lat latitude
     * @return a new tweet
     */
    public static Tweet createTweet(String text, double lon, double lat) {
        Tweet tweet = new Tweet();
        Coordinates coordinatesObj = new Coordinates();
        coordinatesObj.setLongitude(lon);
        coordinatesObj.setLatitude(lat);
//        List<Double> coordniatesList = new ArrayList<>();
//        coordniatesList.add(Double.valueOf(lat));
//        coordniatesList.add(Double.valueOf(lon));
        tweet.setText(text);
//        coordinatesObj.setCoordinates(coordniatesList);
        tweet.setCoordinates(coordinatesObj);
        return tweet;
    }
}
