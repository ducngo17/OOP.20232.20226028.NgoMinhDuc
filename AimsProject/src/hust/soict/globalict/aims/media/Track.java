package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track() {

    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    //lab05 ex10.3
    public String play() throws PlayerException { 
    	if (this.getLength() > 0) {
    		String output = "Playing track: " + this.getTitle() 
    			+ "\nTrack length: " + this.getLength();
			return output;
    	}
    	else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
    }

    //ex15
    @Override
    public boolean equals(Object o) {
        if (o instanceof Track) {
            return ((Track)o).title == this.title && ((Track)o).length == this.length;
        }
        return false;
    }

}