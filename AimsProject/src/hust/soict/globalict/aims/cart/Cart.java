package hust.soict.globalict.aims.cart;
//ex12

import java.util.*;
import javax.naming.LimitExceededException;
import java.util.Collections;
import hust.soict.globalict.aims.media.*;

public class Cart {
  //array list to store items ordered
  private List<Media> itemsOrdered = new ArrayList<Media>(); 
  private static final int MAX_NUMBER_ORDERED = 100;
  
  //return the number of media in cart
  public int getNumberMediaInCart() {
      return itemsOrdered.size();
  }
  
  public ArrayList<Media> getItemsOrdered(){
		return (ArrayList) itemsOrdered;
	}

  //add a media to the cart
  //ex9 lab5 exception
  public void addMedia(Media inputMedia) throws LimitExceededException{
      if (this.getNumberMediaInCart() < MAX_NUMBER_ORDERED) {
    	  if (itemsOrdered.contains(inputMedia)) {
              System.out.println("The media is already ordered");
          }
          else {
              itemsOrdered.add(inputMedia);
              System.out.println("Add media successfully");
          }
      }
      else {
			throw new LimitExceededException("ERROR: The number of" + "media has reached its limit");
      }
  }

  //remove a media from the cart if exist
  public void removeMedia(Media inputMedia) {
      if (!itemsOrdered.contains(inputMedia)) {
          System.out.println("The media has not been ordered");
      }
      else {
          itemsOrdered.remove(inputMedia);
          System.out.println("Remove media successfully");
      }
  }

  //return total cost of all media
  public float totalCost() {
      float sum = 0;
      for (int i = 0; i < itemsOrdered.size(); i++) {
          sum += (itemsOrdered.get(i)).getCost();
      }
      return sum;
  }

  //print a specific media
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

  //print all media in the cart
  public void printAll() {
      for (Media i : itemsOrdered) {
          print1(i);
      }
  }

  //ex17//
  //sort media by cost and title
  public void sortByCostTitle() {
      Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
  } 

  public void sortByTitleCost() {
      Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
  } 

  //clear all media in the current cart
  public void empty () {
      itemsOrdered.clear();
  }

  //search media by title
  public Media searchByTitle(String title) {
      for (Media i : itemsOrdered) {
          if (i.getTitle().equals(title) && i != null) {
              return i;
          }
      }
      return null;
  }

  //search media by id
  public Media searchByID(int id) {
      for (Media i : itemsOrdered) {
          if (i.getId() == id && i != null) {
              return i;
          }
      }
      return null;
  }
  
  public void clearCart() {
		itemsOrdered.clear();
	}

}