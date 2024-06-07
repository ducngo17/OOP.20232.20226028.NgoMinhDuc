package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Store {
    private int qty = 0; 
    public static final int MAX_NUMBERS_INSTORE = 40;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_INSTORE];; //array of DVDs available in the store

    public DigitalVideoDisc[] getItemsInStore() {
        return itemsInStore;
    }

    //method to add a DVD
    public void addDVD (DigitalVideoDisc disc) {
        if (qty == 40) System.out.println("The store is full");
        else {
            for (int i = 0; i < itemsInStore.length; i++) {
                if (itemsInStore[i] == null) {
                    itemsInStore[i] = disc;
                    break;
                }
            }
            qty += 1;
            System.out.println("The disc has been added");
        }
    }

    //method to remove an item from the list
    public void removeDVD(DigitalVideoDisc disc) {
        if (qty == 0) System.out.println("The store is empty");
        else {
            for (int i = 0; i < itemsInStore.length; i++) {
                if (itemsInStore[i] == disc) {
                    itemsInStore[i] = null;
                    for (int j = i; j < itemsInStore.length - 1; j++) {
                        itemsInStore[j] = itemsInStore[j + 1];
                    }
                    itemsInStore[MAX_NUMBERS_INSTORE - 1] = null;
                    break;
                }
            }
            qty -= 1;
            System.out.println("The disc has been removed");
        }
    }    
}