public class CD implements ToBeStored {

    private static final double WEIGHT = 0.1;
    private String artist;
    private String title;
    private int publishingYear;

    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.publishingYear = publishingYear;
        this.title = title;
    }

    @Override
    public double weight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return artist + ": " + title + " (" + publishingYear +")";
    }

}