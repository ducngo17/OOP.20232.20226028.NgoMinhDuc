public class Aims {
    //12, 13
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f );
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc[] items = anOrder.getItemsOrdered();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.format("%-5d%-30s%.3f",(i+1), items[i].getTitle(), items[i].getCost());
                System.out.println();
            }
        }

        System.out.println("The total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.format("%-5d%-30s%.3f",(i+1), items[i].getTitle(), items[i].getCost());
                System.out.println();
            }
        }
        
        System.out.println("The total cost is: ");
        System.out.println(anOrder.totalCost());
    }
}