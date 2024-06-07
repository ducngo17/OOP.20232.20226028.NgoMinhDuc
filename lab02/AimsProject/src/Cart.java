
public class Cart {
    //11
    private int qtyOrdered = 0;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
            //DigitalVideoDisc itemsOrdered[] is also acceptable 

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = disc;
                    //System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
                    break;
                }
            }
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
    }

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

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < itemsOrdered.length; i++) {
            if (itemsOrdered[i] != null) cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}