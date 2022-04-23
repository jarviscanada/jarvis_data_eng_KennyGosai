package ca.jrvs.apps.twitter.model;

public class Hashtag {

    private String text;
    private int[] indices;

    public Hashtag() {
        this.text = text;
        this.indices = indices;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
