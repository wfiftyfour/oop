package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{   
    private String director;
    private float length;

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {
        super(); 
        this.director = "";
        this.length = 0;
        this.id = ++nbDigitalVideoDiscs;

    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category,
            String director, float length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.length = length;
        this.director = director;
        this.id = ++nbDigitalVideoDiscs;
    }
    public void play() throws PlayerException
    {
        if(this.getLength()>0)
        {  
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        }
        else
        {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCost() {
        return this.cost;
    }

    public String getDirector() {
        return this.director;
    }

    public float getLength() {
        return this.length;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return id + ". " + title + " - " + category + " - " + director + " - " + length + " : " + Math.round(cost*100.0)/100.0 + " $ ";
    }

    public void setTitle(String title){
        this.title = title;
    }
}

