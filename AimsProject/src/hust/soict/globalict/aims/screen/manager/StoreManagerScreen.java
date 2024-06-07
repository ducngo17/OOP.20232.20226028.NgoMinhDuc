package hust.soict.globalict.aims.screen.manager;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;


public class StoreManagerScreen extends JFrame {
    private Store store;

    //create menu bar and header
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        ButtonListener btnListener = new ButtonListener();

        JMenuItem viewStore = new JMenuItem("View Store");
        menu.add(viewStore);
        viewStore.addActionListener(btnListener);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(btnListener);

        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(btnListener);
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(btnListener);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        
        return header;
    }

    //create center component
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    //constructor
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        //create an instance of store class
        Store theStore = new Store();
        CompactDisc cd1 = new CompactDisc(1, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3, "Aladin", "Animation", "Guy Ritchie", 128, 25f);
        Book book1 = new Book(4, "Harry Potter", "novel", 20f);
        Book book2 = new Book(5, "The Alchemist", "self-help", 18.86f);
        Book book3= new Book(6, "Doraemon", "Kid", 16f);
        Book book4= new Book(6, "Atomic Habits", "self-help", 19f);
        // Book book5= new Book(6, "Di tim le song", "self-help", 14.5f);
        // CompactDisc cd2 = new CompactDisc(7, "Conan", "Anime", "Aoyama", 100, 22.95f); 

        theStore.addMedia(cd1);
        theStore.addMedia(dvd1);
        theStore.addMedia(dvd2);
        theStore.addMedia(book1);
        theStore.addMedia(book2);
        theStore.addMedia(book3);
        theStore.addMedia(book4);
        // theStore.addMedia(book5);
        // theStore.addMedia(cd2);


        new StoreManagerScreen(theStore);

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View Store")) {
                dispose();
                new StoreManagerScreen(store);
            }
            else if (button.equals("Add Book")){
                dispose();
                new AddBookToStoreScreen(store);
            }
            else if (button.equals("Add CD")){
                dispose();
                new AddCompactDiscToStoreScreen(store);
            }
            else if (button.equals("Add DVD")){
                dispose();
                new AddDigitalVideoDiscToStoreScreen(store);
            }
        }
    }
}