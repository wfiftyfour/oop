package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc  implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Constructor
    public CompactDisc() {
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, float cost) {
        super(title, cost);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public CompactDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, director, length);
    }

    // GETTER
    public String getArtist() {
        return artist;
    }

    // METHODS
    public void addTrack(Track newTrack) {
        if (tracks.contains(newTrack)) {
            System.out.println("This track is already in the list");
            return;
        }
        tracks.add(newTrack);
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("This track is not in the list");
            return;
        }
        tracks.remove(track);
    }

     public int getLength() {
        int sum = 0;
        for (int i = 0; i < tracks.size(); i++) {
            sum += tracks.get(i).getLength();
        }
        return sum;
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        for (Track track : tracks) {
           track.play(); 
        }
        
    }
}
