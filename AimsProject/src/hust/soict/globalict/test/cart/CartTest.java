package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.disc.*;

public class CartTest {
    public static void main(String[] args) {
        //create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f );
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc[] items = cart.getItemsOrdered();
        
        //test the print method
        cart.print(items);

        //test searching by id
        System.out.println("test searching by id");
        cart.isMatch(items, 2);
        
        //test searching by title
        System.out.println("test searching by title");
        cart.isMatch(items, "Aladin");

    }
}