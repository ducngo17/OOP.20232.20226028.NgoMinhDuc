package hust.soict.globalict.aims.media;
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

    @Override
    public void play() { 
        System.out.println("Playing DVD: " + this.getTitle()); 
        System.out.println("DVD length: " + this.getLength()); 
    }

}