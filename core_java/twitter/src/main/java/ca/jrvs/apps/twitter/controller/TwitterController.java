package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.helper.TweetUtil;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;

import java.util.List;

public class TwitterController implements Controller{
    private static final String COORD_SEP = ":";
    private static final String COMMA = ",";

    private Service service;

    public TwitterController(Service service) {
        this.service = service;
    }

    @Override
    public Tweet postTweet(String[] args) {
        if(args.length != 3){
            throw new IllegalArgumentException("USAGE: TwitterCLIApp post \"tweet_text\' \"latitude:longitude\'");
        }

        String tweet_txt = args[1];
        String coord = args[2];
        String[] coordArray = coord.split(COORD_SEP);
        if(coordArray.length != 2 || tweet_txt.isEmpty()){
            throw new IllegalArgumentException("Invalid location format\nUSAGE: TwitterCLIApp post \"tweet_text\' \"latitude:longitude\'");
        }
        Double lat = null;
        Double lon = null;
        try {
            lat = Double.parseDouble(coordArray[0]);
            lon = Double.parseDouble(coordArray[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid location format\nUSAGE: TwitterCLIApp post \"tweet_text\' \"latitude:longitude\'", e);
        }
        Tweet postTweet = TweetUtil.createTweet(tweet_txt, lon, lat);
        return service.postTweet(postTweet);
    }

    @Override
    public Tweet showTweet(String[] args) {
        return null;
    }

    @Override
    public List<Tweet> deleteTweet(String[] args) {
        return null;
    }
}
