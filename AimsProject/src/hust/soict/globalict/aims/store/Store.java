package hust.soict.globalict.aims.store;
//ex13
import java.util.ArrayList;
import hust.soict.globalict.aims.media.*;

public class Store {
  //array list to store items in store
  private ArrayList<Media> itemsInStore = new ArrayList<Media>(); 

  //add a media to the store
  public void addMedia(Media inputMedia) {
      if (itemsInStore.contains(inputMedia)) {
          System.out.println("The media is already in store");
      }
      else {
          itemsInStore.add(inputMedia);
          System.out.println("Add media successfully");
      }
  }

  //remove a media from the store
  public void removeMedia(Media inputMedia) {
      if (!itemsInStore.contains(inputMedia)) {
          System.out.println("The media is not in store");
      }
      else {
           itemsInStore.remove(inputMedia);
          System.out.println("Remove media successfully");
      }
  }

  //print a specific media in the store
  public void print1(Media i) {
      if (i instanceof Book) {
          System.out.format("%-2d - %-20s - %-20s : %.3f$ \n",
              i.getId(), i.getTitle(), i.getCategory(), i.getCost());
      }
      else if (i instanceof CompactDisc) {
          System.out.format("%-2d - %-20s - %-20s - %-20s - %2d : %.3f$ \n",
              i.getId(), i.getTitle(), i.getCategory(), ((CompactDisc)i).getDirector(), ((CompactDisc)i).getLength(), i.getCost());
      }

      else if (i instanceof DigitalVideoDisc) {
          System.out.format("%-2d - %-20s - %-20s - %-20s - %2d : %.3f$ \n",
              i.getId(), i.getTitle(), i.getCategory(), ((DigitalVideoDisc)i).getDirector(), ((DigitalVideoDisc)i).getLength(), i.getCost());
      }
      else System.out.println("No media found");
  }

  //print all media in the store
  public void printAll() {
      for (Media i : itemsInStore) {
          print1(i);
      }
  }

  //search media by title
  public Media search(String title) {
      for (Media i : this.itemsInStore) {
          if (i.getTitle().equals(title) && i != null) {
              return i;
          }
      }
      return null;
  }
}