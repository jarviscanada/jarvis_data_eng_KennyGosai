package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TwitterServiceTest {
    @Mock
    CrdDao dao;

    @InjectMocks
    TwitterService service;

    @Test
    public void postTweet() {
        when(dao.create(any())).thenReturn(new Tweet());
        Tweet test = new Tweet();
        Coordinates coord = new Coordinates();
        coord.setLatitude(50);
        coord.setLongitude(0);
        coord.setType("Point");
        test.setText("test");
        test.setCoordinates(coord);
        service.postTweet(test);
    }
}