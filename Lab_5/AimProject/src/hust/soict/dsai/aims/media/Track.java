package hust.soict.dsai.aims.media;

/**
 * Track
 */
public class Track {
    private int length;
    private String title;

    // GETTER
    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    // Constructor
    public Track(int length, String title) {
        this.length = length;
        this.title = title;
    }
    public void play() throws PlayerException
    {  if(this.getLength()>0)
            {
                System.out.println("Playing Track: " + this.getTitle());
                System.out.println("Track length: " + this.getLength());
            }else
            {
                throw new PlayerException("ERROR: Track length is non-positive!");
            }
    }

}
