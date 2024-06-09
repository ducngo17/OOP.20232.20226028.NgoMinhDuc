package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;
import javax.swing.JOptionPane;
import java.util.*;

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

    //lab05 ex10.4
    @Override
    public String play() throws PlayerException{
		if(this.getLength() > 0) {
			String output =  "Playing CD: " + this.getTitle() + "\n" + 
                    "CD length: " + this.getLength() + "\n";
						
			java.util.Iterator iter = tracks.iterator();
			
			Track nextTrack;
			
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch(PlayerException e) {
					throw e;
				}
			}
			
			for (Track track : tracks) {
                try {
                    output += track.play() + "\n";
                } catch (PlayerException e) {
                    output += track.getTitle() + "\n" + e.getMessage();
                }
            }
			output += "\nCD finished playing";
			return output;
		}
		else {
			throw new PlayerException("ERROR: DVD Length is non-positive");
		}
		
		
	}
    
    public boolean isMatch(String title) {
		if(this.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		return false;
	}
}