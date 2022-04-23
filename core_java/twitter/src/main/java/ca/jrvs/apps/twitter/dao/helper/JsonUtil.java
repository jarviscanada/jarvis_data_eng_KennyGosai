package ca.jrvs.apps.twitter.dao.helper;

import ca.jrvs.apps.twitter.model.Tweet;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

public class JsonUtil {
    public static Tweet toObjectFromJson(String jsonStr, Class<Tweet> tweetClass) throws IOException {
        Jsonb jsonb = JsonbBuilder.create();
        Tweet tw = jsonb.fromJson(jsonStr,tweetClass);
        return tw;
    }

    public static String toStringFromJson(Tweet tweet){
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(tweet);
    }
}
