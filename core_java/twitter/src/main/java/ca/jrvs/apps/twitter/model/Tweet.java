package ca.jrvs.apps.twitter.model;

import javax.json.bind.annotation.JsonbProperty;

public class Tweet {

    @JsonbProperty("created_at")
    String createdAt;

    @JsonbProperty("id")
    Long tweetId;

    @JsonbProperty("id_str")
    String idStr;

    @JsonbProperty("text")
    String text;

    @JsonbProperty("source")
    String source;

    @JsonbProperty("coordinates")
    Coordinates coordinates;

    @JsonbProperty("entities")
    Entities entities;

    @JsonbProperty("retweet_count")
    int retweetCount;

    @JsonbProperty("favorite_count")
    int favoriteCount;

    @JsonbProperty("favorited")
    boolean favorited;

    @JsonbProperty("retweeted")
    boolean retweeted;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }
}
//    public Tweet(String createdAt, long id, String idStr, String text, Entities entities, Coordinates coordinates, int retweetCount, int favoriteCount, boolean favorited, boolean retweeted) {
//        this.createdAt = createdAt;
//        this.id = id;
//        this.idStr = idStr;
//        this.text = text;
//        this.entities = entities;
//        this.coordinates = coordinates;
//        this.retweetCount = retweetCount;
//        this.favoriteCount = favoriteCount;
//        this.favorited = favorited;
//        this.retweeted = retweeted;
//    }

