package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.*;
public class Cart {
    //11
    private int qtyOrdered = 0; 
    public static final int MAX_NUMBERS_ORDERED = 20;

    //an array to store list of dvds
    private DigitalVideoDisc[] itemsOrdered =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
            //DigitalVideoDisc itemsOrdered[] is also acceptable  

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }
    
    //method to add an item to the list
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = disc;
                    break;
                }
            }
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
    }

    //method to remove an item from the list
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) System.out.println("The cart is empty");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == disc) {
                    itemsOrdered[i] = null;
                    for (int j = i; j < itemsOrdered.length - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    itemsOrdered[MAX_NUMBERS_ORDERED - 1] = null;
                    break;
                }
            }
            qtyOrdered -= 1;
            System.out.println("The disc has been removed");
        }
    }

    //method to return the total cost
    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < itemsOrdered.length; i++) {
            if (itemsOrdered[i] != null) cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
    
    //14 overloading method -- array parameter
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int listLength = dvdList.length;
        int j = 0;
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else if (qtyOrdered + listLength > 20) System.out.println("You can only buy at most 20 DVDs at a time");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvdList[j++];
                }
                if (j == listLength) break;
            }
            qtyOrdered += listLength;
            System.out.println("The DVD list has been added");
        }
    }
    
    
    /* varargs parameter -- cannot overload array and varargs
    public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
        int listLength = dvdList.length;
        int j = 0;
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else if (qtyOrdered + listLength > 20) System.out.println("You can only buy at most 20 DVDs at a time");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvdList[j++];
                }
                if (j == listLength) break;
            }
            qtyOrdered += listLength;
            System.out.println("The DVD list has been added");
        }
    }
    */

    //overloading -- differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else if (qtyOrdered + 3 > 20) System.out.println("You can only buy at most 20 DVDs at a time");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvd1;
                    break;
                }
            }
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvd2;
                    break;
                }
            }

            qtyOrdered += 2;
            System.out.println("The DVDs have been added");
        }
    }

    //method to print list of ordered dvds
    public void print(DigitalVideoDisc[] items) {
        double sum = 0;
        System.out.println("******************************************CART*************************************");
        System.out.println("Ordered Items: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.format("%-2d - %-20s - %-20s - %-20s - %-3d : %.3f$ \n",
                    (i+1), items[i].getTitle(), items[i].getCategory(), items[i].getDirector(), items[i].getLength(), items[i].getCost());
                sum += items[i].getCost();
            }
        }
        System.out.println("Total cost: " + sum);
        System.out.println("***********************************************************************************");
    }

    //method to search dvd by id
    public void isMatch(DigitalVideoDisc[] items, int id) {
        for (int i = 0; i < items.length; i++) {
            if (i + 1 == id && items[i] != null) {
                System.out.format("%-2d - %-20s - %-20s - %-20s - %-3d : %.3f$ \n",
                    (i+1), items[i].getTitle(), items[i].getCategory(), items[i].getDirector(), items[i].getLength(), items[i].getCost());
                return;
            }
        }
        System.out.println("No matching disk is found");
    }

    //method to search dvd by title
    public void isMatch(DigitalVideoDisc[] items, String title) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getTitle().equals(title) && items[i] != null) {
                System.out.format("%-2d - %-20s - %-20s - %-20s - %-3d : %.3f$ \n",
                    (i+1), items[i].getTitle(), items[i].getCategory(), items[i].getDirector(), items[i].getLength(), items[i].getCost());
                return;
            }
        }
        System.out.println("No matching disk is found");
    }
}