package hust.soict.globalict.aims.media;

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

    public void play() { 
        System.out.println("Playing track: " + this.getTitle()); 
        System.out.println("Track length: " + this.getLength()); 
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