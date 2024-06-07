package hust.soict.globalict.aims;
//////////////ex18//////////////////

import java.util.Scanner;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;


public class Aims {
public static void showMenu() {
System.out.println("AIMS: "); 
System.out.println("--------------------------------"); 
System.out.println("1. View store"); 
System.out.println("2. Update store"); 
System.out.println("3. See current cart"); 
System.out.println("0. Exit"); 
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2-3"); 
}

public static void storeMenu() { 
System.out.println("Options: "); 
System.out.println("--------------------------------"); 
System.out.println("1. See a media details"); 
System.out.println("2. Add a media to cart"); 
System.out.println("3. Play a media"); 
System.out.println("4. See current cart"); 
System.out.println("0. Back"); 
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2-3-4"); 
}

public static void mediaDetailsMenu() { 
System.out.println("Options: "); 
System.out.println("--------------------------------"); 
System.out.println("1. Add to cart"); 
System.out.println("2. Play"); 
System.out.println("0. Back"); 
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2"); 
}

public static void cartMenu() { 
System.out.println("Options: "); 
System.out.println("--------------------------------"); 
System.out.println("1. Filter media in cart"); 
System.out.println("2. Sort media in cart"); 
System.out.println("3. Remove media from cart"); 
System.out.println("4. Play a media"); 
System.out.println("5. Place order"); 
System.out.println("0. Back"); 
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2-3-4-5"); 
}

public static void UpdateStoreMenu(){
System.out.println("Options: ");
System.out.println("--------------------------------");
System.out.println("1. Add a media"); 
System.out.println("2. Remove a media"); 
System.out.println("0. Back");
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2"); 
}

public static void ChooseType() {
System.out.println("Choose type of media: ");
System.out.println("--------------------------------");
System.out.println("1. Book"); 
System.out.println("2. DigitalVideoDisc"); 
System.out.println("3. CompactDisc");
System.out.println("0. Back");
System.out.println("--------------------------------"); 
System.out.println("Please choose a number: 0-1-2-3");
}

public static void main(String[] args) {

//create an instance of store class
Store theStore = new Store();
CompactDisc cd = new CompactDisc(1, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
DigitalVideoDisc dvd2 = new DigitalVideoDisc(3, "Aladin", "Animation", "Guy Ritchie", 128, 25f);
Book book1 = new Book(4, "Harry Potter", "novel", 20f);
Book book2 = new Book(5, "The Alchemist", "self-help", 18.86f);

theStore.addMedia(cd);
theStore.addMedia(dvd1);
theStore.addMedia(dvd2);
theStore.addMedia(book1);
theStore.addMedia(book2);

//create an instance of cart
Cart myCart = new Cart();

Scanner input = new Scanner(System.in);

boolean exit = false;

while (!exit) {
//main menu
showMenu();

int Case = input.nextInt();
input.nextLine();

switch (Case) {
  //back
  case 0 :
      exit = true;
      break;
  
  //view store
  case 1 :
      boolean back = false;

      while (!back) {
          storeMenu();
          int subCase = input.nextInt();
          input.nextLine();
          switch (subCase) {
              case 0 :
                  back = true;
                  break;

              //See a media’s details
              case 1 :
                  System.out.println("Enter a media title: ");
                  String title = input.nextLine();
                  Media FoundMedia = theStore.search(title);
                  theStore.print1(FoundMedia);
                  boolean subBack = false;

                  if (FoundMedia != null) {
                      while (!subBack) {
                          mediaDetailsMenu();
                          int subsubCase = input.nextInt();
                          input.nextLine();
                          switch (subsubCase) {
                              case 0 : 
                                  subBack = true;
                                  break;
  
                              //add to cart    
                              case 1 :
                                  myCart.addMedia(FoundMedia);
                                  break;
  
                              //play
                              case 2 :
                                  if (FoundMedia instanceof DigitalVideoDisc) {
                                      ((DigitalVideoDisc)FoundMedia).play();
                                  }
                                  else if (FoundMedia instanceof CompactDisc) {
                                      ((CompactDisc)FoundMedia).play();
                                  }
                                  else {
                                      System.out.println("Cannot play since it's neither CD or DVD");
                                  }
                                  break;

                              default :
                                  System.out.println("Invalid choice, please choose again");
                                  break;
                          }
                      }
                  }
                  
                  break;
                  
              
              //Add a media to cart
              case 2 : 
                  System.out.println("Please enter the title of the media you want to add to the cart");
                  title = input.nextLine();
                  FoundMedia = theStore.search(title);
                  if (FoundMedia != null) 
                      myCart.addMedia(FoundMedia);
                  else System.out.println("The media is not found");
                  System.out.println("The number of media in the current cart is: " + myCart.getNumberMediaInCart());
                  break;
              
              //Play a media
              case 3 :
                  System.out.println("Please enter the title of the media you want to play");
                  title = input.nextLine();
                  FoundMedia = theStore.search(title);
                  if (FoundMedia instanceof DigitalVideoDisc) {
                      ((DigitalVideoDisc)FoundMedia).play();
                  }
                  else if (FoundMedia instanceof CompactDisc) {
                      ((CompactDisc)FoundMedia).play();
                  }
                  else {
                      System.out.println("Cannot play since it's neither CD or DVD");
                  }
                  break;
              
              //See current cart    
              case 4 :
                  System.out.println("The current cart: ");
                  myCart.printAll();
                  break;
                  
              default :
                  System.out.println("Invalid choice, please choose again");
                  break;

          }        
      }
      break;
      
      
  //Update store
  case 2 : 
      boolean subBack = false;

      while (!subBack) {
          UpdateStoreMenu();
          int subCase = input.nextInt();
          input.nextLine();
          switch (subCase) {
              case 0 :
                  subBack = true;
                  break;
              
              //add media to store
              case 1 :
                  ChooseType();
                  int type = input.nextInt();
                  input.nextLine();
                  if (type == 1) {
                      System.out.println("Please enter the id");
                      int idBook = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleBook = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryBook = input.nextLine();
                      System.out.println("Please enter the cost");
                      float costBook = input.nextFloat();
                      input.nextLine();
                      Book newMedia = new Book(idBook, titleBook, categoryBook, costBook);
                      theStore.addMedia(newMedia);
                  }
                  else if (type == 2) {
                      System.out.println("Please enter the id");
                      int idDVD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleDVD = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryDVD = input.nextLine();
                      System.out.println("Please enter the director");
                      String directorDVD = input.nextLine();
                      System.out.println("Please enter the cost");
                      float costDVD = input.nextFloat();
                      input.nextLine();
                      System.out.println("Please enter the length");
                      int lengthDVD = input.nextInt();
                      input.nextLine();
                      DigitalVideoDisc newMedia = new DigitalVideoDisc(idDVD, titleDVD, categoryDVD, directorDVD, lengthDVD, costDVD);
                      theStore.addMedia(newMedia);
                  }
                  else if (type == 3) {
                      System.out.println("Please enter the id");
                      int idCD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleCD = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryCD = input.nextLine();
                      System.out.println("Please enter the director");
                      String directorCD = input.nextLine();
                      System.out.println("Please enter the length");
                      int lengthCD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the cost");
                      float costCD = input.nextFloat();
                      input.nextLine();
                      CompactDisc newMedia = new CompactDisc(idCD, titleCD, categoryCD, directorCD, lengthCD, costCD);
                      theStore.addMedia(newMedia);
                  }
                  break;

              //remove media to store
              case 2 :
                  ChooseType();
                  type = input.nextInt();
                  input.nextLine();
                  if (type == 1) {
                      System.out.println("Please enter the id");
                      int idBook = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleBook = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryBook = input.nextLine();
                      System.out.println("Please enter the cost");
                      float costBook = input.nextFloat();
                      input.nextLine();
                      Book newMedia = new Book(idBook, titleBook, categoryBook, costBook);
                      theStore.removeMedia(newMedia);
                  }
                  else if (type == 2) {
                      System.out.println("Please enter the id");
                      int idDVD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleDVD = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryDVD = input.nextLine();
                      System.out.println("Please enter the director");
                      String directorDVD = input.nextLine();
                      System.out.println("Please enter the cost");
                      float costDVD = input.nextFloat();
                      input.nextLine();
                      System.out.println("Please enter the length");
                      int lengthDVD = input.nextInt();
                      input.nextLine();
                      DigitalVideoDisc newMedia = new DigitalVideoDisc(idDVD, titleDVD, categoryDVD, directorDVD, lengthDVD, costDVD);
                      theStore.removeMedia(newMedia);
                  }
                  else if (type == 3) {
                      System.out.println("Please enter the id");
                      int idCD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the title");
                      String titleCD = input.nextLine();
                      System.out.println("Please enter the category");
                      String categoryCD = input.nextLine();
                      System.out.println("Please enter the director");
                      String directorCD = input.nextLine();
                      System.out.println("Please enter the length");
                      int lengthCD = input.nextInt();
                      input.nextLine();
                      System.out.println("Please enter the cost");
                      float costCD = input.nextFloat();
                      input.nextLine();
                      CompactDisc newMedia = new CompactDisc(idCD, titleCD, categoryCD, directorCD, lengthCD, costCD);
                      theStore.removeMedia(newMedia);
                  }
                  break;

              default :
                  System.out.println("Invalid choice. Please choose again");
                  break;
          }        
      }
      break;
      
  //See current cart
  case 3 :
      System.out.println("The current cart: ");
      myCart.printAll();
      subBack = false;

      while(!subBack) {
          cartMenu();
          int subCase = input.nextInt();
          input.nextLine();
          switch (subCase) {
              case 0 : 
                  subBack = true;
                  break;

              case 1 :
                  System.out.println("Enter the filter option: ");
                  System.out.println("1. Filter by id ");
                  System.out.println("2. Filter by title");
                  int c = input.nextInt();
                  input.nextLine();
                  if (c == 1) {
                      System.out.println("Enter the id: ");
                      int filerID = input.nextInt();
                      Media filterMedia = myCart.searchByID(filerID);
                      myCart.print1(filterMedia);
                  }
                  else if (c == 2) {
                      System.out.println("Enter the title: ");
                      String filerTitle = input.nextLine();
                      Media filterMedia = myCart.searchByTitle(filerTitle);
                      myCart.print1(filterMedia);
                  }
                  break;

              case 2 :
                  System.out.println("Please choose:  ");
                  System.out.println("1. Sort by title");
                  System.out.println("2. Sort by cost");
                  int sort = input.nextInt();
                  input.nextLine();
                  if (sort == 1) {
                      myCart.sortByTitleCost();
                      System.out.println("The cart after sorting: ");
                      myCart.printAll();
                  }
                  if (sort == 2) {
                      myCart.sortByCostTitle();
                      System.out.println("The cart after sorting: ");
                      myCart.printAll();
                  }
                  break;

              case 3 :
                  System.out.println("Enter the title of the media you want to remove: ");
                  String title = input.nextLine();
                  Media found = myCart.searchByTitle(title);
                  myCart.removeMedia(found);
                  break;
              
              case 4 : 
                  System.out.println("Please enter the title of the media you want to play");
                  title = input.nextLine();
                  Media FoundMedia = theStore.search(title);
                  if (FoundMedia instanceof DigitalVideoDisc) {
                      ((DigitalVideoDisc)FoundMedia).play();
                  }
                  else if (FoundMedia instanceof CompactDisc) {
                      ((CompactDisc)FoundMedia).play();
                  }
                  else {
                      System.out.println("Cannot play since it's neither CD or DVD");
                  }
                  break;
              
              case 5 : 
                  System.out.println("An order is created");
                  myCart.empty();
                  break;

              default :
                  System.out.println("Invalid choice. Please choose again");
                  break;
          }
      }
      break;
      
}
}

input.close();
}
}