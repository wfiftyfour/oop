package hust.soict.dsai.aims.media;

public class Disc extends media {
    private int length;
    private String director;

    // CONSTRUCTORS
    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost, String director, int length) {
        this(title, category, cost, director);
        this.length = length;
    }

    // SETTER AND GETTER
    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        super.setTitle(title);
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return super.getTitle();
    }
}
