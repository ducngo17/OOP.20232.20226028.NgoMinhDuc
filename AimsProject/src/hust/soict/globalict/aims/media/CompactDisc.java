package hust.soict.globalict.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public String getArtist() {
        return artist;
    }

    public CompactDisc() {
        super();
    }

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

    public int getLength() {
        int sumLength = 0;
        for (int i = 0; i < tracks.size(); i++) {
            sumLength += (tracks.get(i)).getLength();
        }
        return sumLength;
    }

    public void play() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println("Track" + (i+1));
            (tracks.get(i)).play();
            System.out.println();
        }
    }
}