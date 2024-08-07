package hust.soict.globalict.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    
    public Disc() {
        
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, float cost){
        super(title, category, cost);
        this.director = director;
    }

    public Disc (int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public boolean isMatch(String title) {
		return true;
	}
}