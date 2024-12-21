package hust.soict.dsai.aims.media;

public class media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;


    // CONSTRUCTORS
    public media() {
    }

    public media(String title) {
        this.title = title;
    }

    public media(String title, float cost) {
        this(title);
        this.cost = cost;
    }

    public media(String title, String category, float cost) {
        this(title, cost);
        this.category = category;
    }


     // GETTERS & SETTERS
     public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

}
