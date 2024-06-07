
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

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int listLength = dvdList.length;
        int j = 0;
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else if (qtyOrdered + listLength > 20) System.out.println("You can only buy at most 20 DVDs at a time");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvdList[j++];
                    //System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
                }
                if (j == listLength) break;
            }
            qtyOrdered += listLength;
            System.out.println("The DVD list has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered == 20) System.out.println("The cart is full");
        else if (qtyOrdered + 3 > 20) System.out.println("You can only buy at most 20 DVDs at a time");
        else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvd1;
                    //System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
                    break;
                }
            }
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvd2;
                    //System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
                    break;
                }
            }

            qtyOrdered += 2;
            System.out.println("The DVDs have been added");
        }
    }
}