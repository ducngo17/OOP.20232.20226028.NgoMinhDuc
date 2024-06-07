package hust.soict.globalict.aims.media;
import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public void addAuthor(String authorName) {
        boolean check = authors.contains(authorName);
        if (check) System.out.println("The author has already been added");
        else {
            authors.add(authorName);
            System.out.println("Add authors successfully");
        }
    }

    public void removeAuthor(String authorName) {
        boolean check = authors.contains(authorName);
        if (!check) System.out.println("The author is not in the list");
        else {
            authors.remove(authorName);
            System.out.println("Remove authors successfully");
        }
    }

    public static void main(String[] args) {
        
    }
}