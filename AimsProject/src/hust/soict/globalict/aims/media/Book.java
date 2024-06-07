package hust.soict.globalict.aims.media;
import java.util.ArrayList;

public class Book extends Media {
    //attribute
    private ArrayList<String> authors = new ArrayList<String>();

    //constructor
    public Book (String title) {
        super(title);
    }

    public Book (String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book (int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    //add author method
    public void addAuthor(String authorName) {
        boolean check = authors.contains(authorName);
        if (check) System.out.println("The author has already been added");
        else {
            authors.add(authorName);
            System.out.println("Add authors successfully");
        }
    }

    //remove author method
    public void removeAuthor(String authorName) {
        boolean check = authors.contains(authorName);
        if (!check) System.out.println("The author is not in the list");
        else {
            authors.remove(authorName);
            System.out.println("Remove authors successfully");
        }
    }

}