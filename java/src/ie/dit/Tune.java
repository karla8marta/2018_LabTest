package ie.dit;

public class Tune implements Player {
    private int x;
    private String title;
    private String notation;
    private String altTitle;

    public void play() {
        System.err.println(notation);
    }

    public int getX() {
        return x;
    }

    public String getTitle() {
        return title;
    }

    public String getNotation() {
        return notation;
    }

    public String getaltTitle() {
        return altTitle;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public void setaltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public String toString() {
        return "" + x + ", " + title + " ," + (altTitle != null ? ", " + altTitle : "");
    }

}