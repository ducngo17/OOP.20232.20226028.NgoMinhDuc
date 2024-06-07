package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.*;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f );
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(dvd3);

        DigitalVideoDisc[] items = store.getItemsInStore();
        
        System.out.println("List of DVDs in the store: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.format("%-5d%-30s%.3f",(i+1), items[i].getTitle(), items[i].getCost());
                System.out.println();
            }
        }

        //remove a dvd
        store.removeDVD(dvd2);

        //print list of dvds after removing
        System.out.println("List of DVDs in the store after removing: ");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.format("%-5d%-30s%.3f",(i+1), items[i].getTitle(), items[i].getCost());
                System.out.println();
            }
        }
    }
}