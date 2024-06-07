package hust.soict.globalict.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    //attribute
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    //get method
    public String getArtist() {
        return artist;
    }

    //constructor
    public CompactDisc() {
        super();
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }


    //add and remove track
    public void addTrack(Track inputTrack) {
        if (tracks.contains(inputTrack)) {
            System.out.println("The track is already in the list");
        }
        else {
            tracks.add(inputTrack);
            System.out.println("Add track successfully");
        }
    }

    public void removeTrack(Track inputTrack) {
        if (!tracks.contains(inputTrack)) {
            System.out.println("The track is not in the list");
        }
        else {
            tracks.remove(inputTrack);
            System.out.println("Remove track successfully");
        }
    }

    //the length of a CD = sum of length of all tracks
    public int getLength() {
        int sumLength = 0;
        for (int i = 0; i < tracks.size(); i++) {
            sumLength += (tracks.get(i)).getLength();
        }
        return sumLength;
    }
    
    //constructor
    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, cost);
        this.length = length;
    }

    @Override
    public void play() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("Track" + (i+1));
            (tracks.get(i)).play();
            System.out.println();
        }
    }
}