package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    //constructor
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    //lab05 ex10.2
    @Override
    public String play() throws PlayerException { 
    	if (this.getLength() > 0) {
    		String output = "Playing DVD: " + this.getTitle() 
    			+ "DVD length: " + this.getLength();
			return output;
    	}
    	else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
    }

    public boolean isMatch(String title) {
		if(this.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		return false;
	}
}