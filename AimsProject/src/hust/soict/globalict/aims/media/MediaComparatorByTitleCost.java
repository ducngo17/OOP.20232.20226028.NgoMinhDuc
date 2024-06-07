package hust.soict.globalict.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    @Override
    public int compare (Media a, Media b) {
        int compareTitle = a.getTitle().compareTo(b.getTitle());
        int compareCost = (int)(a.getCost() - b.getCost());
        return (compareTitle == 0) ? compareCost : compareTitle;
    }
}