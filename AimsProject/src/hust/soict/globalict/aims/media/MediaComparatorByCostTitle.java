package hust.soict.globalict.aims.media;
//ex17
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare (Media a, Media b) {
        int compareTitle = a.getTitle().compareTo(b.getTitle());
        int compareCost = (int)(a.getCost() - b.getCost());
        return (compareCost == 0) ? compareTitle : compareCost;
    }
}