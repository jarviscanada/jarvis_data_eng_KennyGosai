package ca.jrvs.apps.twitter.model;

public class UserMention {
    private String name;
    private int[] indicies;
    private String screenName;
    private long id;
    private String idString;

    public UserMention(String name, int[] indicies, String screenName, long id, String idString) {
        this.name = name;
        this.indicies = indicies;
        this.screenName = screenName;
        this.id = id;
        this.idString = idString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIndicies() {
        return indicies;
    }

    public void setIndicies(int[] indicies) {
        this.indicies = indicies;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
}
